package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.CustomerType;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface CustomerTypeDao  {

	CustomerType get(int id);
	
	List<CustomerType> queryAll();
	
	void remove(int id);
	
	void add(CustomerType customerType);
	
	void update(CustomerType customerType);
	
}
