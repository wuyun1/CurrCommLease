package com.CCL.Dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.OrderDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	private final static String mClassName = Order.class.getName();

	@Override
	public Order get(int id) {
		Order order = null;
		Session session = getSession();
		order = session.get(Order.class, id);
		return order;
	}

	@Override
	public List<Order> queryAll() {
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
	public void add(Order orderDao) {
		Session session = getSession();
		session.save(orderDao);
		session.beginTransaction().commit();

	}

	@Override
	public void update(Order orderDao) {
		Session session = getSession();
		session.update(orderDao);
		session.beginTransaction().commit();
	}

	@Override
	public List<Order> queryByExample(Order instance) {
		Session session = getSession();
		List results = getSession().createCriteria(mClassName).add(Example.create(instance)).list();
		return results;
	}

	@Override
	public List<Order> queryByState(OrderState bicycleState) {
		String hql = "from " + mClassName + " where ORDER_STATE_ID=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, bicycleState.getId());
		return query.list();
	}
	


	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return mClassName;
	}
}
