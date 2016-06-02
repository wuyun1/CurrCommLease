package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.OrderState;

public class OrderStateDaoImpl extends BaseDao implements OrderStateDao {
	
	private final static String mClassName = OrderState.class.getName();

	@Override
	public OrderState get(int id) {
		OrderState orderState = null;
		Session session = getSession();
		orderState = session.get(OrderState.class, id);
		return orderState;
	}

	@Override
	public List<OrderState> queryAll() {
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
	public void add(OrderState orderStateDao) {
		Session session = getSession();
		session.save(orderStateDao);
		session.beginTransaction().commit();
		
	}

	@Override
	public void update(OrderState orderStateDao) {
		Session session = getSession();
		session.update(orderStateDao);
		session.beginTransaction().commit();
	}

}
