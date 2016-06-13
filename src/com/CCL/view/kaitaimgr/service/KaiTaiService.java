package com.CCL.view.kaitaimgr.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.Dao.impl.OrderDaoImpl;
import com.CCL.Dao.impl.OrderStateDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;
import com.CCL.util.ApplicationContext;
import com.CCL.util.mlf.PublicDate;

public class KaiTaiService {
	
	//加载数据库访问层的对象
	static OrderDao orderDao = new OrderDaoImpl();
	static OrderStateDao orderStateDao = new OrderStateDaoImpl();
	static BillDao billDao = new BillDaoImpl();
	static BicycleDao bicycleDao = new BicycleDaoImpl();
	static CustomerDao customerDao = new CustomerDaoImpl();

	public static Order rentCar(Customer currentCustomer, Map<Bicycle, Integer> bicycles) {

		if (bicycles == null) {
			return null;
		}

		boolean isCanRent = true;
		for (Entry<Bicycle, Integer> bicycleEntry : bicycles.entrySet()) {
			if (bicycleEntry.getKey().getInventory() < bicycleEntry.getValue()) {
				isCanRent = false;
			}
		}
		if (isCanRent == false) {
			return null;
		}
		Order newOrder = new Order(currentCustomer, PublicDate.getOuser(), converyBicycles2String(bicycles),
				getStateByName("准备就绪"), new Date(), null, null, 200f);
		if (orderDao.add(newOrder)) {
			return newOrder;
		} else {
			return null;
		}

	}

	public static OrderState getStateByName(String state) {
		List<OrderState> queryByUseLikeAndPage = orderStateDao.queryByUseLikeAndPage("name", state, 10, 0);
		OrderState cst = null;
		if (queryByUseLikeAndPage != null && queryByUseLikeAndPage.size() > 0) {
			cst = queryByUseLikeAndPage.get(0);
		} else {
			OrderState newState = new OrderState(state, null);
			orderStateDao.add(newState);
			cst = newState;
		}
		return cst;
	}

	public static List<Order> getAllOrder() {

		List<Order> allOrder = orderDao.queryAll();

		return allOrder;
	}

	public static boolean startOrder(Order corder) {

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}
		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			if (entry.getKey().getInventory() < entry.getValue()) {
				return false;
			}
		}

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory() - num);
			bicycleDao.update(bicyc);
		}

		corder.setStartTime(new Date());
		corder.setOrderState(getStateByName("正在进行"));
		return orderDao.update(corder);
	}

	public static void writebicycleMap(Order corder) {

		Map<Bicycle, Integer> bicyclesMap = new HashMap<Bicycle, Integer>();
		String[] entryStrs = corder.getBicycles().split(";");

		for (String string : entryStrs) {
			String[] entry = string.split(":");
			int bicycleId = Integer.parseInt(entry[0]);
			Bicycle bicycle = bicycleDao.get(bicycleId);
			int num = entry.length == 2 ? Integer.parseInt(entry[1]) : 1;
			bicyclesMap.put(bicycle, num);
		}
		corder.setBicyclesMap(bicyclesMap);

	}

	public static Bill accountsOrder(Order corder) {
		corder.setStopTime(new Date());
		float spendTime = (int) ((corder.getStopTime().getTime() - corder.getStartTime().getTime()) / 1000.0 / 60);

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}

		float originalCost = 0;

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory() + num);
			originalCost += bicyc.getType().getDiscount() * bicyc.getPrice() * num;
			bicycleDao.update(bicyc);
		}

		float huafei = originalCost * corder.getCustomer().getCustomerType().getDiscount() * spendTime;

		corder.setOrderState(getStateByName("订单完成"));
		Bill newBill = new Bill(new Date(), (long) spendTime, corder, corder.getCustomer().getName(),
				corder.getCustomer().getId(), "zfb", huafei);

		orderDao.update(corder);
		billDao.add(newBill);

		Customer customer = corder.getCustomer();
		customer.setIntegral((int) (customer.getIntegral() + (huafei / 10)));
		customerDao.update(customer);

		return newBill;
	}

	public static boolean delOrder(Order corder) {
		boolean remove = orderDao.remove(corder.getId());
		return remove;
	}

	public static String converyBicycles2String(Map<Bicycle, Integer> bicycles) {

		StringBuilder str = new StringBuilder();

		for (Entry<Bicycle, Integer> bicycleEntry : bicycles.entrySet()) {
			str.append(bicycleEntry.getKey().getId() + ":" + bicycleEntry.getValue() + ";");
		}

		if (str.charAt(str.length() - 1) == ';') {
			str.deleteCharAt(str.length() - 1);
		}
		return str.toString();
	}

	public static float calcPrice(Order corder) {
		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}

		// for(Entry<Bicycle,Integer> entry : bicyclesMap.entrySet()){
		// if(entry.getKey().getInventory()<entry.getValue()){
		// return null;
		// }
		// }

		float originalCost = 0;

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			originalCost += bicyc.getType().getDiscount() * bicyc.getPrice() * num;
		}
		return originalCost * corder.getCustomer().getCustomerType().getDiscount();

	}

	public static Collection<? extends Order> getAllPreOrder() {

		OrderState bicycleState = getStateByName("准备就绪");
		return orderDao.queryByState(bicycleState);
	}

	public static void updateOrder(Order currentOrder) {
		orderDao.update(currentOrder);
	}

}
