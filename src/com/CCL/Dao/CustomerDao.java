package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface CustomerDao  {

	Customer get(int id);
	
	List<Customer> queryAll();
	
	List<Customer> queryByType(CustomerType customerType);
	
	List<Customer> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	List<Customer> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);

	List<Customer> queryByState(CustomerState customerState);
	
	//通过对象查询
	List<Customer> queryByExample(Customer instance);
	
	void remove(int id);
	
	void add(Customer customer);
	
	void update(Customer customer);
	
}
