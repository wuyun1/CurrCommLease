package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.CustomerType;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface CustomerTypeDao  {

	CustomerType get(int id);
	
	List<CustomerType> queryAll();
	
	void remove(int id);
	
	void add(CustomerType customerType);
	
	void update(CustomerType customerType);
	
}
