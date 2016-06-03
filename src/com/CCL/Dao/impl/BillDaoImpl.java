package com.CCL.Dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.BillDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;

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

	@Override
	public List<Bill> queryByExample(Bill instance) {
		Session session = getSession();
		List results = getSession().createCriteria(mClassName).add(Example.create(instance)).list();
		return results;
	}
	
	@Override
	public List<Bill> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		String hql = "from " + mClassName + " where "+property+" like '%"+value+"%'";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(pageSize*(pageNumber-1));
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	@Override
	public List<Bill> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		
		String hql = "from " + mClassName + " where 1=1";
		List<String> keyOrder = new ArrayList<String>();
		for (String property : entrys.keySet()) {
			hql+=" and "+property + " like ?";
			keyOrder.add(property);
		}
		Query query = getSession().createQuery(hql);
		for(int i=0,n=keyOrder.size();i<n;i++){
			query.setString(i, "%" + entrys.get(keyOrder.get(i)) + "%");
		}
		query.setFirstResult(pageSize*(pageNumber-1));
		query.setMaxResults(pageSize);
		return query.list();
	}

}
