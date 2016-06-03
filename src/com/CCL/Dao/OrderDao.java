package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.OpeUser;
import com.CCL.beans.Order;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface OrderDao  {

	Order get(int id);
	
	List<Order> queryAll();
	
	void remove(int id);
	
	void add(Order order);
	
	void update(Order order);
	
	//通过对象查询
			List<Order> queryByExample(Order instance);
	
}
