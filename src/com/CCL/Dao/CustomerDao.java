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
	
	
	/**
	 * 分页模糊查询 
	 * @param property	需要进行筛选的属性字段(对象的属性名)
	 * @param value	 模糊匹配的值
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<Customer> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * 分页模糊查询 
	 * @param entrys	属性和值的键值对
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<Customer> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);

	List<Customer> queryByState(CustomerState customerState);
	
	//通过对象查询
	List<Customer> queryByExample(Customer instance);
	
	void remove(int id);
	
	void add(Customer customer);
	
	void update(Customer customer);
	
}
