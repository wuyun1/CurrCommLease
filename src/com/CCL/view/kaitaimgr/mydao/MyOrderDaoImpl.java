package com.CCL.view.kaitaimgr.mydao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.CCL.Dao.OrderDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;
import com.CCL.util.ApplicationContext;

public class MyOrderDaoImpl implements OrderDao {
	

	static List<Order> orders= new ArrayList<Order>();
	
	
	public MyOrderDaoImpl() {
		
		CustomerState cs1 = new CustomerState("����", "�Ѽ���");
	
		CustomerType ct1 = new CustomerType("�׽�", "", 3.2f);
		
		
		
		Customer c1= new Customer(null, ct1, "����", null, new Date(), "520", null, null, null,30,12f );

		BicycleState bs1 = new BicycleState("A","A ״̬");
		
		
		BicycleType bt3 = new BicycleType("C","C ����",0.9f);
		

		Bicycle b1 = new Bicycle(bs1, bt3, "��������", "��������������", 8, 20, "���", 1, 1, 9,5 ,10);
		
		b1.setId(1);
	
		
		Bicycle currentBicycle = b1; 
		OrderState ostate = new OrderState("׼������", null);
		Order newOrder = new Order(c1, ApplicationContext.currOpeUser, currentBicycle.getId()+"1", ostate, new Date(),null,null, 200f);
		newOrder.setId(32);
		orders.add(newOrder);
		
		newOrder = new Order(c1, ApplicationContext.currOpeUser, currentBicycle.getId()+"1", ostate, new Date(),null,null, 200f);
		newOrder.setId(31);
		orders.add(newOrder);
		
	}

	@Override
	public Order get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryAll() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Order bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Order bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> queryByExample(Order instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> queryByState(OrderState bicycleState) {
		// TODO Auto-generated method stub
		return null;
	}

}
