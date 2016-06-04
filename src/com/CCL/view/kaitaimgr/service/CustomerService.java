package com.CCL.view.kaitaimgr.service;

import java.util.List;

import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.beans.Customer;

public class CustomerService {
	
	static CustomerDao customerDao = new CustomerDaoImpl();
	
	public static List<Customer> getAll(){
		
		return customerDao.queryAll();
	}

	public static List<Customer> getAllByIdUseLike(String text) {
		return customerDao.queryByUseLikeAndPage("id", text, 20, 0);
	}
}
