package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.CustomerStateDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.CustomerState;

public class CustomerStateDaoImpl extends BaseDao implements CustomerStateDao {

	private final static String mClassName = CustomerState.class.getName();

	@Override
	public CustomerState get(int id) {
		CustomerState customerState = null;
		Session session = getSession();
		customerState = session.get(CustomerState.class, id);
		return customerState;
	}

	@Override
	public List<CustomerState> queryAll() {
		// TODO Auto-generated method stub
		Session session = getSession();
		return session.createQuery("from " + mClassName).list();
	}

	@Override
	public void remove(int id) {
		String hql = "delete " + mClassName + " where id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();
		getSession().beginTransaction().commit();
	}

	@Override
	public void add(CustomerState customerStateDao) {
		Session session = getSession();
		session.save(customerStateDao);
		session.beginTransaction().commit();

	}

	@Override
	public void update(CustomerState customerStateDao) {
		Session session = getSession();
		session.update(customerStateDao);
		session.beginTransaction().commit();
	}

}
