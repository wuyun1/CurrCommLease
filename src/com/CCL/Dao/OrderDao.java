package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface OrderDao  {

	Order get(int id);
	
	List<Order> queryAll();
	
	List<Order> queryByState(OrderState bicycleState);
	
	
	/**
	 * ��ҳģ����ѯ 
	 * @param property	��Ҫ����ɸѡ�������ֶ�(�����������)
	 * @param value	 ģ��ƥ���ֵ
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<Order> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * ��ҳģ����ѯ 
	 * @param entrys	���Ժ�ֵ�ļ�ֵ��
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<Order> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);

	
	void remove(int id);
	
	void add(Order order);
	
	void update(Order order);
	
	//ͨ�������ѯ
	List<Order> queryByExample(Order instance);
	
}
