package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Opeper;

public class OpeperDaoImpl extends BaseDao implements OpeperDao {

	private final static String mClassName = Opeper.class.getName();

	@Override
	public Opeper get(int id) {
		Opeper opeper = null;
		Session session = getSession();
		opeper = session.get(Opeper.class, id);
		return opeper;
	}

	@Override
	public List<Opeper> queryAll() {
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
	public void add(Opeper opeperDao) {
		Session session = getSession();
		session.save(opeperDao);
		session.beginTransaction().commit();

	}

	@Override
	public void update(Opeper opeperDao) {
		Session session = getSession();
		session.update(opeperDao);
		session.beginTransaction().commit();
	}

}
