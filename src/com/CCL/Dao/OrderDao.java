package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface OrderDao  {

	Order get(int id);
	
	List<Order> queryAll();
	
	List<Order> queryByState(OrderState bicycleState);
	
	void remove(int id);
	
	void add(Order order);
	
	void update(Order order);
	
	//ͨ�������ѯ
	List<Order> queryByExample(Order instance);
	
}
