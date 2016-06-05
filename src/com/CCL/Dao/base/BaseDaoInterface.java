package com.CCL.Dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDaoInterface<T> {
	
	
	//查询单个对象
	T get(int id);
	
	//查询所以数据库对象
	List<T> queryAll();
	
	//获取数据库记录调试
	long count();

	int remove(int id);

	Serializable add(T bicycle);

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
