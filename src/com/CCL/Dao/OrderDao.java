package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.OpeUser;
import com.CCL.beans.Order;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface OrderDao  {

	Order get(int id);
	
	List<Order> queryAll();
	
	void remove(int id);
	
	void add(Order order);
	
	void update(Order order);
	
	//ͨ�������ѯ
			List<Order> queryByExample(Order instance);
	
}
