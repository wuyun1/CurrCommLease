package com.CCL.view.huiyuan.service;

import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.beans.Customer;
import com.CCL.view.huiyuan.test.MyCusDao;

public class CustomerService {
	
	static CustomerDao cd = new CustomerDaoImpl();

	public static boolean add(Customer ct) {
		// TODO Auto-generated method stub
		System.out.println("Ìí¼Ó¿Í»§:"+ct.getName());	
		
		cd.add(ct);
		return true;
		
	}

	public static Customer query(String name) {
		
		// TODO Auto-generated method stub
		 Customer ct = cd.queryByUsePage("name", name, 20, 0).get(0);
		 return ct;
		
	}

	public static void update(Customer ct) {
		// TODO Auto-generated method stub
		cd.update(ct);
	}

	public static boolean existUsername(String text) {
		// TODO Auto-generated method stub
		return !cd.queryByUsePage("name", text, 20, 0).isEmpty();
		 
	}
	


}
