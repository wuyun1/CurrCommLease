package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.CustomerTypeDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.CustomerType;

public class CustomerTypeDaoImpl extends BaseDao<CustomerType> implements CustomerTypeDao {

	private final static String mClassName = CustomerType.class.getName();

	@Override
	public CustomerType get(int id) {
		CustomerType customerType = null;
		Session session = getSession();
		customerType = session.get(CustomerType.class, id);
		return customerType;
	}

	@Override
	public List<CustomerType> queryAll() {
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
	public void add(CustomerType customerTypeDao) {
		Session session = getSession();
		session.save(customerTypeDao);
		session.beginTransaction().commit();

	}

	@Override
	public void update(CustomerType customerTypeDao) {
		Session session = getSession();
		session.update(customerTypeDao);
		session.beginTransaction().commit();
	}

	@Override
	public String getClassName() {
		return mClassName;
	}

}
