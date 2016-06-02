package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.BicycleType;

public class BicycleTypeDaoImpl extends BaseDao implements BicycleTypeDao {

	private final static String mClassName = BicycleType.class.getName();

	@Override
	public BicycleType get(int id) {
		BicycleType bicycleType = null;
		Session session = getSession();
		bicycleType = session.get(BicycleType.class, id);
		return bicycleType;
	}

	@Override
	public List<BicycleType> queryAll() {
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
	public void add(BicycleType bicycleTypeDao) {
		Session session = getSession();
		session.save(bicycleTypeDao);
		session.beginTransaction().commit();

	}

	@Override
	public void update(BicycleType bicycleTypeDao) {
		Session session = getSession();
		session.update(bicycleTypeDao);
		session.beginTransaction().commit();
	}

}
