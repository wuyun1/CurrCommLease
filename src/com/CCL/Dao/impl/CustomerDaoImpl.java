package com.CCL.Dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;

public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {

	private final static Class mClassName = Customer.class;


	@Override
	public List<Customer> queryByType(CustomerType customerType) {
		String hql = "from " + mClassName + " where CUSTOMER_TYPE_ID=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, customerType.getId());
		return query.list();
	}

	@Override
	public List<Customer> queryByState(CustomerState customerState) {
		String hql = "from " + mClassName + " where CUSTOMER_STATE_ID=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, customerState.getId());
		return query.list();
	}

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

	
	
	

}
