package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	private final static String mClassName = Customer.class.getName();

	@Override
	public Customer get(int id) {
		Customer customer = null;
		Session session = getSession();
		customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public List<Customer> queryAll() {
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
	public void add(Customer customerDao) {
		Session session = getSession();
		session.save(customerDao);
		session.beginTransaction().commit();

	}

	@Override
	public void update(Customer customerDao) {
		Session session = getSession();
		session.update(customerDao);
		session.beginTransaction().commit();
	}

	@Override
	public List<Customer> queryByExample(Customer instance) {
		Session session = getSession();
		List results = getSession().createCriteria(mClassName).add(Example.create(instance)).list();
		return results;

	}

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

}
