package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.beans.Bill;
import com.CCL.beans.Customer;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface BillDao {

	Bill get(int id);

	List<Bill> queryAll();
	
	
	
	/**
	 * 分页模糊查询 
	 * @param property	需要进行筛选的属性字段(对象的属性名)
	 * @param value	 模糊匹配的值
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<Bill> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * 分页模糊查询 
	 * @param entrys	属性和值的键值对
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<Bill> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);


	void remove(int id);

	void add(Bill bill);

	void update(Bill bill);
	//通过对象查询
	List<Bill> queryByExample(Bill instance);

}
