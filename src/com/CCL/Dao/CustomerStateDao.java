package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.CustomerState;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface CustomerStateDao  {

	CustomerState get(int id);
	
	List<CustomerState> queryAll();
	
	void remove(int id);
	
	void add(CustomerState customerState);
	
	void update(CustomerState customerState);
	
}
