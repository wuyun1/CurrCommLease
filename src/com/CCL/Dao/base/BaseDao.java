package com.CCL.Dao.base;

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
	protected static Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	protected static void closeSession() {
		HibernateSessionFactory.closeSession();
	}
	
	public abstract String getClassName();
	
	public List<T> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		String hql = "from " + getClassName() + " where "+property+" like '%"+value+"%'";
		Query query = getSession().createQuery(hql);
		int i = pageSize*(pageNumber-1);
		query.setFirstResult(i<0?0:i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List<T> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		
		String hql = "from " + getClassName() + " where 1=1";
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
		List results = getSession().createCriteria( getClassName()).add(Example.create(instance)).list();
		return results;
	}
	
	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		String hql = "from " + getClassName() + " where "+property+"= ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, value);
		int i = pageSize*(pageNumber-1);
		query.setFirstResult(i<0?0:i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		
		String hql = "from " + getClassName() + " where 1=1";
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
	
	
}
