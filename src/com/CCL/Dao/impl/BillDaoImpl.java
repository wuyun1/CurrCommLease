package com.CCL.Dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.BillDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;

public class BillDaoImpl extends BaseDao<Bill> implements BillDao {
	
	private final static Class mClassName = Bill.class;



	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
