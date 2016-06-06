package com.CCL.view.huiyuan.service;

import java.util.List;

import com.CCL.Dao.BillDao;
import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.CustomerStateDao;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.Dao.impl.CustomerStateDaoImpl;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;

public class CustomerService {
	
	static CustomerDao cd = new CustomerDaoImpl();
	static CustomerStateDao csd = new CustomerStateDaoImpl();
	static BillDao bi = new BillDaoImpl();
	public static boolean add(Customer ct) {
		// TODO Auto-generated method stub
//		System.out.println("Ìí¼Ó¿Í»§:"+ct.getName());	
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

	public static CustomerState getStateByName(String state) {
		// TODO Auto-generated method stub
		CustomerState cst = csd.queryByUseLikeAndPage("name", state, 10,0).get(0);
		
		if(cst==null){
			CustomerState newState = new CustomerState(state, null);
			csd.add(newState);
			cst=newState;
		}
		return cst;
	}

	public static List<Customer> queryUserByKeyWord(String text) {
		
		
		return cd.queryByUseLikeAndPage("name", text, 100, 0);
	}

	public static List<Bill> queryUserByName(String text) {
		// TODO Auto-generated method stub
		return bi.queryByUsePage("CUSTOMER_NAME", text, 100, 0);
	}
	
	
	public static List<Bill> queryUserByCustomer(Customer c) {
		// TODO Auto-generated method stub
		return bi.queryByUsePage("CUSTOMER_ID", c, 100, 0);
	}
	


}
