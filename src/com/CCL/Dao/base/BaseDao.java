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

/**
 * Hibernate Dao��Ļ��� ����ͬ�ķ����������
 * 
 * @author Jonney
 *
 * @param <T>
 *            Bean��ľ�������
 */
public abstract class BaseDao<T> {

	public BaseDao() {
	}

	/**
	 * ��ȡ Hibernate Session ����
	 * 
	 * @return �����ݿ⽻���� Session ����
	 */
	protected static Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	/**
	 * �ͷ� Hibernate Session����
	 */
	protected static void closeSession() {
		HibernateSessionFactory.closeSession();
	}

	/**
	 * ģ�巽�� ����ʵ�� ��ȡ Bean��Class���� �Թ�Hibernate�����ݿ���н���
	 * 
	 * @return ��ǰҪ������ Bean �� Class ����
	 */
	public abstract Class getEntityClass();

	/**
	 * ����ĳ���ؼ���ģ��ƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param property
	 *            ƥ��������ֶ� �����ݿ���ֶ�Ϊ׼
	 * @param value
	 *            ����ģ��ƥ��Ĺؼ��ֵ�ֵ
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	public List<T> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		String hql = "from " + getEntityClass().getName() + " where " + property + " like '%" + value + "%'";
		Query query = getSession().createQuery(hql);
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * ���ݶ���ؼ���ͬʱ������ģ��ƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param entrys
	 *            ������ֵ�� ��ֵ��
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	public List<T> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {

		String hql = "from " + getEntityClass().getName() + " where 1=1";
		List<String> keyOrder = new ArrayList<String>();
		for (String property : entrys.keySet()) {
			hql += " and " + property + " like ?";
			keyOrder.add(property);
		}
		Query query = getSession().createQuery(hql);
		for (int i = 0, n = keyOrder.size(); i < n; i++) {
			query.setString(i, "%" + entrys.get(keyOrder.get(i)) + "%");
		}
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 
	 * @param instance
	 * @return
	 */
	public List<T> queryByExample(T instance) {
		Session session = getSession();
		List results = getSession().createCriteria(getEntityClass()).add(Example.create(instance)).list();
		return results;
	}

	/**
	 * ����ĳ���ؼ��־�ȷƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param property
	 *            ƥ��������ֶ� �����ݿ���ֶ�Ϊ׼
	 * @param value
	 *            ����ģ��ƥ��Ĺؼ��ֵ�ֵ
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		String hql = "from " + getEntityClass().getName() + " where " + property + "= ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, value);
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * ���ݶ���ؼ���ͬʱ�����ľ�ȷƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param entrys
	 *            ������ֵ�� ��ֵ��
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {

		String hql = "from " + getEntityClass().getName() + " where 1=1";
		List<String> keyOrder = new ArrayList<String>();
		for (String property : entrys.keySet()) {
			hql += " and " + property + " = ?";
			keyOrder.add(property);
		}
		Query query = getSession().createQuery(hql);
		for (int i = 0, n = keyOrder.size(); i < n; i++) {
			query.setParameter(i, entrys.get(keyOrder.get(i)));
		}
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * ����ID��ȡĳһ���ݿ����
	 * 
	 * @param id
	 * @return ���ظ����ݿ��ѯ�����װ��Ķ���
	 */
	public T get(int id) {
		T bicycle = null;
		Session session = getSession();
		bicycle = (T) session.get(getEntityClass(), id);
		return bicycle;
	}

	/**
	 * ��ѯ���Զ���
	 * 
	 * @return ��������Bean��List�ļ���
	 */
	public List<T> queryAll() {
		Session session = getSession();
		return session.createQuery("from " + getEntityClass().getName()).list();
	}

	/**
	 * ����IDɾ��ĳһ���ݼ�¼
	 * 
	 * @param id
	 *            ����ID
	 * @return ɾ���Ƿ�ɹ�
	 */
	public boolean remove(int id) {
		String hql = "delete " + getEntityClass().getName() + " where id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		try {
			query.executeUpdate();
			getSession().beginTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * �����ݶ��󱣴浽���ݿ�,�����ݳ־û�
	 * 
	 * @param obj
	 *            ����������ݶ���
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean add(T obj) {
		Session session = getSession();
		Serializable result = session.save(obj);
		session.beginTransaction().commit();
		return result != null;

	}

	/**
	 * �������ݿ��еĶ��� ������Ϊ����
	 * 
	 * @param obj
	 * @return �Ƿ���³ɹ�
	 */
	public boolean update(T obj) {
		try {
			Session session = getSession();
			session.update(obj);
			session.beginTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * ��ѯ���������
	 * 
	 * @return �����������ݿ�ļ�¼����
	 */
	public long count() {
		String hql = "select count(*) from " + getEntityClass().getName();
		Query query = getSession().createQuery(hql);
		return ((Long) query.uniqueResult()).intValue();

	}

}
