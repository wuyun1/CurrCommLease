package com.CCL.Dao.base;

import java.sql.Connection;

import org.hibernate.Session;

//������װ�����Ĳ������ݿⷽ��
public class BaseDao {
	protected static Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	protected static void closeSession() {
		HibernateSessionFactory.closeSession();
	}
}
