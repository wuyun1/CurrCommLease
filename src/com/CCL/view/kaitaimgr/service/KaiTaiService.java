package com.CCL.view.kaitaimgr.service;

import java.util.Date;
import java.util.List;

import com.CCL.Dao.OrderDao;
import com.CCL.Dao.OrderStateDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;
import com.CCL.util.ApplicationContext;
import com.CCL.view.kaitaimgr.mydao.MyOrderDaoImpl;
import com.CCL.view.kaitaimgr.mydao.MyOrderStateDaoImpl;

public class KaiTaiService {

	static OrderDao od = new MyOrderDaoImpl();
	static OrderStateDao osd = new MyOrderStateDaoImpl();

	public static boolean rentCar(Customer currentCustomer, Bicycle currentBicycle) {

		Order newOrder = new Order(currentCustomer, ApplicationContext.currOpeUser, currentBicycle, getStateByName("×¼±¸¾ÍÐ÷"), new Date(),null,null, 200f);
		od.add(newOrder);
		return od.add(newOrder);

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

}
