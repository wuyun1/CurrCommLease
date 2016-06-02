package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.OrderDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
	
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

}
