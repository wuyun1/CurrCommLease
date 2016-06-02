package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.BicycleStateDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.BicycleState;

public class BicycleStateDaoImpl extends BaseDao implements BicycleStateDao {
	
	private final static String mClassName = BicycleState.class.getName();

	@Override
	public BicycleState get(int id) {
		BicycleState bicycleState = null;
		Session session = getSession();
		bicycleState = session.get(BicycleState.class, id);
		return bicycleState;
	}

	@Override
	public List<BicycleState> queryAll() {
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
	public void add(BicycleState bicycleStateDao) {
		Session session = getSession();
		session.save(bicycleStateDao);
		session.beginTransaction().commit();
		
	}

	@Override
	public void update(BicycleState bicycleStateDao) {
		Session session = getSession();
		session.update(bicycleStateDao);
		session.beginTransaction().commit();
	}

}
