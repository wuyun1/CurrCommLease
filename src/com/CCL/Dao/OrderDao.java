package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface OrderDao  {

	Order get(int id);
	
	List<Order> queryAll();
	
	List<Order> queryByState(OrderState bicycleState);
	
	
	/**
	 * 分页模糊查询 
	 * @param property	需要进行筛选的属性字段(对象的属性名)
	 * @param value	 模糊匹配的值
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<Order> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * 分页模糊查询 
	 * @param entrys	属性和值的键值对
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<Order> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);

	
	void remove(int id);
	
	void add(Order order);
	
	void update(Order order);
	
	//通过对象查询
	List<Order> queryByExample(Order instance);
	
}
