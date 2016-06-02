package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.BillDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Bill;

public class BillDaoImpl extends BaseDao implements BillDao {
	
	private final static String mClassName = Bill.class.getName();

	@Override
	public Bill get(int id) {
		Bill bill = null;
		Session session = getSession();
		bill = session.get(Bill.class, id);
		return bill;
	}

	@Override
	public List<Bill> queryAll() {
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
	public void add(Bill billDao) {
		Session session = getSession();
		session.save(billDao);
		session.beginTransaction().commit();
		
	}

	@Override
	public void update(Bill billDao) {
		Session session = getSession();
		session.update(billDao);
		session.beginTransaction().commit();
	}

}
