package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.OpeUser;

public class OpeUserDaoImpl extends BaseDao<OpeUser> implements OpeUserDao {

	private final static String mClassName = OpeUser.class.getName();

	@Override
	public OpeUser get(int id) {
		OpeUser opeUser = null;
		Session session = getSession();
		opeUser = session.get(OpeUser.class, id);
		return opeUser;
	}

	@Override
	public List<OpeUser> queryAll() {
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
	public void add(OpeUser opeUserDao) {
		Session session = getSession();
		session.save(opeUserDao);
		session.beginTransaction().commit();

	}

	@Override
	public void update(OpeUser opeUserDao) {
		Session session = getSession();
		session.update(opeUserDao);
		session.beginTransaction().commit();
	}

	@Override
	public List<OpeUser> queryByExample(OpeUser instance) {
		Session session = getSession();
		List results = getSession().createCriteria(mClassName).add(Example.create(instance)).list();
		return results;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
