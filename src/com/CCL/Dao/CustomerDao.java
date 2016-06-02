package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Customer;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface CustomerDao  {

	Customer get(int id);
	
	List<Customer> queryAll();
	
	void remove(int id);
	
	void add(Customer customer);
	
	void update(Customer customer);
	
}
