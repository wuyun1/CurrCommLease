package com.CCL.Dao;

import java.util.List;

import com.CCL.beans.CustomerState;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface CustomerStateDao  {

	CustomerState get(int id);
	
	List<CustomerState> queryAll();
	
	void remove(int id);
	
	void add(CustomerState customerState);
	
	void update(CustomerState customerState);
	
}
