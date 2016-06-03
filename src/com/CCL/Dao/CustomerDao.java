package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface CustomerDao  {

	Customer get(int id);
	
	List<Customer> queryAll();
	
	List<Customer> queryByType(CustomerType customerType);
	
	
	/**
	 * ��ҳģ����ѯ 
	 * @param property	��Ҫ����ɸѡ�������ֶ�(�����������)
	 * @param value	 ģ��ƥ���ֵ
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<Customer> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * ��ҳģ����ѯ 
	 * @param entrys	���Ժ�ֵ�ļ�ֵ��
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<Customer> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);

	List<Customer> queryByState(CustomerState customerState);
	
	//ͨ�������ѯ
	List<Customer> queryByExample(Customer instance);
	
	void remove(int id);
	
	void add(Customer customer);
	
	void update(Customer customer);
	
}
