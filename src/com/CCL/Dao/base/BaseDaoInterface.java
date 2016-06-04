package com.CCL.Dao.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Bill;

public interface BaseDaoInterface<T> {
	T get(int id);

	List<T> queryAll();
	
	long count();

	void remove(int id);

	void add(T bicycle);

	void update(T bicycle);
	
	//通过对象查询
	List<T> queryByExample(T instance);
	/**
	 * 分页模糊查询 
	 * @param property	需要进行筛选的属性字段(对象的属性名)
	 * @param value	 模糊匹配的值
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<T> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * 分页模糊查询 
	 * @param entrys	属性和值的键值对
	 * @param pageSize   页面大小
	 * @param pageNumber  第几页
	 * @return
	 */
	List<T> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);

	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber);

	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber);
	
}
