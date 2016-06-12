package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.OpeUser;

public class OpeUserDaoImpl extends BaseDao<OpeUser> implements OpeUserDao {

	private final static Class mClassName = OpeUser.class;

	

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}
	
	@Override
	public boolean remove(int id) {
		
		
		
//		String hql = "delete " + getEntityClass().getName() + " where id=?";
//		Query query = getSession().createQuery(hql);
//		query.setInteger(0, id);
//		try{
//			query.executeUpdate();
//			getSession().beginTransaction().commit();
//			return true;
//		}catch(Exception e){
//			return false;
//		}
		
		try{
			OpeUser opeUser = get(id);
			getSession().delete(opeUser);
			getSession().beginTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	

}
