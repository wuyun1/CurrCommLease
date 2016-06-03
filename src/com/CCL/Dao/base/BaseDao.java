package com.CCL.Dao.base;

import org.hibernate.Session;

//用来封装基本的操作数据库方法
public class BaseDao {
	protected static Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	protected static void closeSession() {
		HibernateSessionFactory.closeSession();
	}
}
