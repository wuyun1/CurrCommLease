package com.CCL.view.huiyuan.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.CCL.Dao.CustomerTypeDao;
import com.CCL.beans.CustomerType;

public class MyCustomerTypeDaoImpl implements CustomerTypeDao {
	
	List<CustomerType>  t = new ArrayList<CustomerType>();
	
	int count = 3;
	
	public MyCustomerTypeDaoImpl() {
		CustomerType e = new CustomerType();
		CustomerType e1 = new CustomerType();
		CustomerType e2 = new CustomerType();
		e.setName("��");
		e.setId(1);
		t.add(e );
		e1.setName("����");
		e1.setId(2);
		t.add(e1);
		e2.setName("��ʯ��");
		e2.setId(3);
		t.add(e2);
	}

	@Override
	public CustomerType get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerType> queryAll() {
		
		
		
		
		return t;
	}

	@Override
	public int remove(int id) {
		
		for (CustomerType customerType : t) {
			if(customerType.getId().equals(id)){
				t.remove(customerType);
				break;
			}
		}
		return 0;

	}

	@Override
	public Serializable add(CustomerType customerType) {
		customerType.setId(++count);
		return t.add(customerType);
		
	}

	@Override
	public void update(CustomerType customerType) {
		// TODO Auto-generated method stub

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerType> queryByExample(CustomerType instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerType> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerType> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerType> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerType> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
