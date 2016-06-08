package com.CCL.view.kaitaimgr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.OrderDaoImpl;
import com.CCL.Dao.impl.OrderStateDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;
import com.CCL.util.ApplicationContext;

public class KaiTaiService {

	static OrderDao od = new OrderDaoImpl();
	static OrderStateDao osd = new OrderStateDaoImpl();
	static BillDao bd = new BillDaoImpl();
	static BicycleDao bicycleDao = new BicycleDaoImpl();

	public static Order rentCar(Customer currentCustomer, Map<Bicycle,Integer> bicycles) {
		
		if(bicycles == null){
			return null;
		}
		
		boolean isCanRent= true;
		for(Entry<Bicycle,Integer> bicycleEntry : bicycles.entrySet()){
			if(bicycleEntry.getKey().getInventory()<bicycleEntry.getValue()){
				isCanRent = false;
			}
		}
		if(isCanRent==false){
			return null;
		}
		Order newOrder = new Order(currentCustomer, ApplicationContext.currOpeUser, converyBicycles2String(bicycles), getStateByName("准备就绪"), new Date(),null,null, 200f);
		if( od.add(newOrder)){
			return newOrder;
		}else{
			return null;
		}

	}

	public static OrderState getStateByName(String state) {
		List<OrderState> queryByUseLikeAndPage = osd.queryByUseLikeAndPage("name", state, 10, 0);
		OrderState cst=null;
		if (queryByUseLikeAndPage!=null&&queryByUseLikeAndPage.size()>0) {
			cst = queryByUseLikeAndPage.get(0);
		}else{
			OrderState newState = new OrderState(state, null);
			osd.add(newState);
			cst = newState;
		}
		return cst;
	}
	
	
	public static List<Order> getAllOrder(){
		
		List<Order> allOrder = od.queryAll();
		
		return allOrder;
	}



	public static boolean startOrder(Order corder) {
		
		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();
		
		if(bicyclesMap==null){
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}
		for(Entry<Bicycle,Integer> entry : bicyclesMap.entrySet()){
			if(entry.getKey().getInventory()<entry.getValue()){
				return false;
			}
		}
		
		for(Entry<Bicycle,Integer> entry : bicyclesMap.entrySet()){
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory()-num);
			bicycleDao.update(bicyc);
		}
		
		corder.setStartTime(new Date());
		corder.setOrderState(getStateByName("正在进行"));
		return od.update(corder);
	}
	public static void writebicycleMap(Order corder) {
		
		Map<Bicycle, Integer> bicyclesMap = new HashMap<Bicycle, Integer>();
		String[] entryStrs = corder.getBicycles().split(";");
		
		for (String string : entryStrs) {
			String[] entry = string.split(":");
			int bicycleId = Integer.parseInt( entry[0]);
			Bicycle bicycle = bicycleDao.get(bicycleId);
			int num = entry.length==2?Integer.parseInt(entry[1]):1;
			bicyclesMap.put(bicycle, num);
		}
		corder.setBicyclesMap(bicyclesMap);
		
	}

	public static Bill accountsOrder(Order corder){
		corder.setStopTime(new Date());
		float spendTime = (float) ((corder.getStopTime().getTime()-corder.getStartTime().getTime())/1000/60);
		
		
		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();
		
		if(bicyclesMap==null){
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}
		
//		for(Entry<Bicycle,Integer> entry : bicyclesMap.entrySet()){
//			if(entry.getKey().getInventory()<entry.getValue()){
//				return null;
//			}
//		}
		
		float originalCost = 0;
		
		for(Entry<Bicycle,Integer> entry : bicyclesMap.entrySet()){
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory()+num);
			originalCost+= bicyc.getType().getDiscount()*bicyc.getPrice()*num;
			bicycleDao.update(bicyc);
		}
		
		float huafei = originalCost*corder.getCustomer().getCustomerType().getDiscount();
		
		corder.setOrderState(getStateByName("订单完成"));
		Bill newBill = new Bill(new Date(), (long) spendTime, corder, corder.getCustomer().getName(), corder.getCustomer().getId(), "zfb", huafei);
		
		od.update(corder);
		bd.add(newBill);
		return newBill;
	}

	public static boolean delOrder(Order corder) {
		boolean remove = od.remove(corder.getId());
		return remove;
	}
	
	
	public static String converyBicycles2String(Map<Bicycle,Integer> bicycles){
		
		StringBuilder str = new StringBuilder();
		
		for (Entry<Bicycle, Integer> bicycleEntry : bicycles.entrySet()) {
			str.append(bicycleEntry.getKey().getId()+":"+bicycleEntry.getValue()+";");
		}
		
		if(str.charAt(str.length()-1)==';'){
			str.deleteCharAt(str.length()-1);
		}
		return str.toString();
	}
	
	
	
}
