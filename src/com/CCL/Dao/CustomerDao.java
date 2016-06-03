package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface CustomerDao  {

	Customer get(int id);
	
	List<Customer> queryAll();
	
	List<Customer> queryByType(CustomerType customerType);

	List<Customer> queryByState(CustomerState customerState);
	
	//ͨ�������ѯ
	List<Customer> queryByExample(Customer instance);
	
	void remove(int id);
	
	void add(Customer customer);
	
	void update(Customer customer);
	
}
