package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Bicycle;

public class BicycleDaoImpl extends BaseDao implements BicycleDao {
	
	private final static String mClassName = Bicycle.class.getName();

	@Override
	public Bicycle get(int id) {
		Bicycle bicycle = null;
		Session session = getSession();
		bicycle = session.get(Bicycle.class, id);
		return bicycle;
	}

	@Override
	public List<Bicycle> queryAll() {
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
	public void add(Bicycle bicycleDao) {
		Session session = getSession();
		session.save(bicycleDao);
		session.beginTransaction().commit();
		
	}

	@Override
	public void update(Bicycle bicycleDao) {
		Session session = getSession();
		session.update(bicycleDao);
		session.beginTransaction().commit();
	}

}
