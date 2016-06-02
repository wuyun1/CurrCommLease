package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Customer;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface CustomerDao  {

	Customer get(int id);
	
	List<Customer> queryAll();
	
	void remove(int id);
	
	void add(Customer customer);
	
	void update(Customer customer);
	
}
