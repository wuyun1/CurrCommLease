package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.beans.Bill;
import com.CCL.beans.Customer;

//������װ�����Ĳ������ݿⷽ�����̳���BaseDao
public interface BillDao {

	Bill get(int id);

	List<Bill> queryAll();
	
	
	
	/**
	 * ��ҳģ����ѯ 
	 * @param property	��Ҫ����ɸѡ�������ֶ�(�����������)
	 * @param value	 ģ��ƥ���ֵ
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<Bill> queryByUseLikeAndPage(String  property,String value,int pageSize,int pageNumber);
	
	
	/**
	 * ��ҳģ����ѯ 
	 * @param entrys	���Ժ�ֵ�ļ�ֵ��
	 * @param pageSize   ҳ���С
	 * @param pageNumber  �ڼ�ҳ
	 * @return
	 */
	List<Bill> queryByUseLikeAndPage(Map<String,String> entrys,int pageSize,int pageNumber);


	void remove(int id);

	void add(Bill bill);

	void update(Bill bill);
	//ͨ�������ѯ
	List<Bill> queryByExample(Bill instance);

}
