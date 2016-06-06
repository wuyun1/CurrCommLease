package com.CCL.Dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.beans.Bicycle;
import com.CCL.beans.Customer;

//用来封装基本的操作数据库方法
public abstract class BaseDao<T> {
	
	public BaseDao() {
		
		
	}
	
	protected static Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	protected static void closeSession() {
		HibernateSessionFactory.closeSession();
	}
	
	public abstract Class getEntityClass();
	
	public List<T> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		String hql = "from " + getEntityClass().getName() + " where "+property+" like '%"+value+"%'";
		Query query = getSession().createQuery(hql);
		int i = pageSize*(pageNumber-1);
		query.setFirstResult(i<0?0:i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List<T> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		
		String hql = "from " + getEntityClass().getName() + " where 1=1";
		List<String> keyOrder = new ArrayList<String>();
		for (String property : entrys.keySet()) {
			hql+=" and "+property + " like ?";
			keyOrder.add(property);
		}
		Query query = getSession().createQuery(hql);
		for(int i=0,n=keyOrder.size();i<n;i++){
			query.setString(i, "%" + entrys.get(keyOrder.get(i)) + "%");
		}
		int i = pageSize*(pageNumber-1);
		query.setFirstResult(i<0?0:i);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	public List<T> queryByExample(T instance) {
		Session session = getSession();
		List results = getSession().createCriteria( getEntityClass()).add(Example.create(instance)).list();
		return results;
	}
	
	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		String hql = "from " + getEntityClass().getName() + " where "+property+"= ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, value);
		int i = pageSize*(pageNumber-1);
		query.setFirstResult(i<0?0:i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		
		String hql = "from " + getEntityClass().getName() + " where 1=1";
		List<String> keyOrder = new ArrayList<String>();
		for (String property : entrys.keySet()) {
			hql+=" and "+property + " = ?";
			keyOrder.add(property);
		}
		Query query = getSession().createQuery(hql);
		for(int i=0,n=keyOrder.size();i<n;i++){
			query.setParameter(i, entrys.get(keyOrder.get(i)));
		}
		int i = pageSize*(pageNumber-1);
		query.setFirstResult(i<0?0:i);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	public T get(int id) {
		T bicycle = null;
		Session session = getSession();
		bicycle = (T) session.get(getEntityClass(), id);
		return bicycle;
	}

	public List<T> queryAll() {
		Session session = getSession();
		return session.createQuery("from " + getEntityClass().getName()).list();
	}

	public boolean remove(int id) {
		String hql = "delete " + getEntityClass().getName() + " where id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		int result = query.executeUpdate();
		getSession().beginTransaction().commit();
		return result>=1;
	}

	public boolean add(T obj) {
		Session session = getSession();
		 Serializable result = session.save(obj);
		session.beginTransaction().commit();
		return result!=null;
		
	}

	public boolean update(T obj) {
		try{
			Session session = getSession();
			session.update(obj);
			session.beginTransaction().commit();
		}catch(Exception e){
			return false;
		}
		return true;
		
	}
	
	public long count() {
		 String hql = "select count(*) from "+getEntityClass().getName();
		 Query query =  getSession().createQuery( hql);
		 return ((Long)query.uniqueResult()).intValue(); 
		 
	}

	
}
