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
	
	//ͨ�������ѯ
	List<T> queryByExample(T instance);
	/**
	 * ��ҳģ����ѯ 
	 * @param property	��Ҫ����ɸѡ�������ֶ�(�����������)
	 * @param value	 ģ��ƥ���ֵ
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<T> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * ��ҳģ����ѯ 
	 * @param entrys	���Ժ�ֵ�ļ�ֵ��
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<T> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);

	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber);

	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber);
	
}
