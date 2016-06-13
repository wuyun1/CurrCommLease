package com.CCL.Dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.CCL.Dao.base.HibernateSessionFactory;

public class TestSql {
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		
		String queryString = "select bill.id,ope_user.user_name,t_order.customer_id,t_order.put_time,t_order.stop_time,t_order.deposit,bill.payway,bill.total,bill.delay from bill,t_order,ope_user where bill.order_id=t_order.id and t_order.opeuser_id=ope_user.id";
		
		
		
//		String queryString = "select id abc,put_Time ttt from T_oRdeR";
		SQLQuery sqlQuery = session.createSQLQuery(queryString  );
		List<Object[]> list = sqlQuery.list();
		
		for (Object[] objects : list) {
			System.out.println(objects[0]+":"+objects[1]);
		}
		
	}
}
