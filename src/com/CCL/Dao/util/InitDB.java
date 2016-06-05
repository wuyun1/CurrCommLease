package com.CCL.Dao.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BicycleStateDao;
import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.CustomerStateDao;
import com.CCL.Dao.CustomerTypeDao;
import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.base.HibernateSessionFactory;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;

public class InitDB {

	private static org.hibernate.SessionFactory sessionFactory;
	private static Configuration configuration = new Configuration();
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static String configFile = CONFIG_FILE_LOCATION;

	
	public static void main(String[] args) {
		
		configuration.configure(configFile);
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		configuration.getProperties().list(System.out);
		sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		//init bicycle type
		BicycleState bs1 = new BicycleState("A","A ״̬");
		BicycleState bs2 = new BicycleState("B","B ״̬");
		BicycleState bs3 = new BicycleState("C","C ״̬");
		session.save(bs1);
		session.save(bs2);
		session.save(bs3);
		
		BicycleType bt1 = new BicycleType("A","A ����",0.7f);
		BicycleType bt2 = new BicycleType("B","B ����",0.98f);
		BicycleType bt3 = new BicycleType("C","C ����",0.9f);
		session.save(bt1);
		session.save(bt2);
		session.save(bt3);

		Bicycle b1 = new Bicycle(bs3, bt2, "��������", "��������������", 8, 20, "���", 1, 1, 9,5 ,10);
		Bicycle b2 = new Bicycle(bs1, bt1, "�µ�A8", "�µ�A8������", 7, 15, "����", 1, 1, 9,5 ,10);
		Bicycle b3 = new Bicycle(bs2, bt3, "С���糵", "С���糵������", 9, 2, "���", 1, 1, 5,4 ,13);
		session.save(b1);
		session.save(b2);
		session.save(b3);
		
		
		
		
		
		
		
		
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
//		System.exit(0);
	}
	
	
}
