package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface OrderDao  {

	Order get(int id);
	
	List<Order> queryAll();
	
	List<Order> queryByState(OrderState bicycleState);
	
	void remove(int id);
	
	void add(Order order);
	
	void update(Order order);
	
	//通过对象查询
	List<Order> queryByExample(Order instance);
	
}
