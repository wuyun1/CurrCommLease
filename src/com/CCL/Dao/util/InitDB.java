package com.CCL.Dao.util;

import java.util.Date;

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
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;
import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

/**
 * ��ʼ�����ݿ�
 * @author Jonney
 *
 */
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

		// init bicycle type
		BicycleState bs1 = new BicycleState("A", "A ״̬");
		BicycleState bs2 = new BicycleState("B", "B ״̬");
		BicycleState bs3 = new BicycleState("C", "C ״̬");
		session.save(bs1);
		session.save(bs2);
		session.save(bs3);

		BicycleType bt1 = new BicycleType("���˳�", "A ����", 0.7f);
		BicycleType bt2 = new BicycleType("˫�˳�", "B ����", 0.98f);
		BicycleType bt3 = new BicycleType("C", "C ����", 0.9f);
		session.save(bt1);
		session.save(bt2);
		session.save(bt3);

		Bicycle b1 = new Bicycle(bs3, bt2, "��������", "��������������", 8, 20, "���", true,true, 9, 5, 10);
		Bicycle b2 = new Bicycle(bs1, bt1, "�µ�A8", "�µ�A8������", 7, 15, "����", true,true, 9, 5, 10);
		Bicycle b3 = new Bicycle(bs2, bt3, "С���糵", "С���糵������", 9, 14, "���", true,true, 5, 4, 13);
		session.save(b1);
		session.save(b2);
		session.save(b3);

		CustomerState cs1 = new CustomerState("����", "�Ѽ���");
		CustomerState cs2 = new CustomerState("ע��", "��ע��");
		// CustomerState cs3= new CustomerState("", "�Ѽ���");
		session.save(cs1);
		session.save(cs2);

		CustomerType ct1 = new CustomerType("�׽�", "", 3.2f);
		CustomerType ct2 = new CustomerType("�ƽ�", "", 2.5f);
		// CustomerState cs3= new CustomerState("", "�Ѽ���",4.2f);
		session.save(ct1);
		session.save(ct2);
		
		
		Customer c1= new Customer(null, ct1, "����", null, new Date(), "520", null, null, null,30,12f );
		Customer c2= new Customer(null, ct1, "����", null, new Date(), "555", null, null, null,56,56f );
		Customer c3= new Customer(null, ct1, "����", null, new Date(), "520", null, null, null,36,63f );
		Customer c4= new Customer(null, ct1, "����", null, new Date(), "555", null, null, null,86,56f );
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		
		OrderState os1 = new OrderState("׼������", null);
		OrderState os2 = new OrderState("���ڽ���", null);
		OrderState os3 = new OrderState("�������", null);
		session.save(os1);
		session.save(os2);
		session.save(os3);
		
		Order o1 = new Order(c1, null, b2.getId()+":3", os1, new Date(2014,5,9),new Date(2014,5,9),new Date(2014,5,9), 0f);
		Order o2 = new Order(c1, null, b2.getId()+":3;"+b3.getId()+":4", os1, new Date(2014,11,7),new Date(2014,5,9),new Date(2014,5,9), 560f);
		Order o3 = new Order(c1, null, b2.getId()+":3", os1, new Date(2011,1,9), new Date(2014,5,9),new Date(2014,5,9),120f);
		session.save(o3);
		session.save(o2);
		session.save(o1);
		
		
		
//		Bill bill1 = new Bill(new Date(), 20l,o2,c1.getName(),c1.getId(),"ZFB", 100);
//		Bill bill2 = new Bill(new Date(), 20l,o2,c1.getName(),c1.getId(),"ZFB", 200);
//		Bill bill3 = new Bill(new Date(), 20l,o3,c1.getName(),c1.getId(),"ZFB", 600);
//		Bill bill4 = new Bill(new Date(), 20l,o2,c2.getName(),c2.getId(),"ZFB", 200);
//		Bill bill5 = new Bill(new Date(), 20l,o1,c2.getName(),c2.getId(),"ZFB", 300);
//
//		session.save(bill1);
//		session.save(bill2);
//		session.save(bill3);
//		session.save(bill4);
//		session.save(bill5);
//		
		
		//String userName, String password, Float salary, String name, String sex, Date birthday,String address, String phone, String photo, Opeper opePer
		
		OpeUser ou1=new OpeUser("abc", "123", 20f, "abc", "��", new Date(), "����", "18711180761", null, null);
		Opeper op1 = new Opeper(ou1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		ou1.setOpePer(op1);
		session.save(ou1);

		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		// System.exit(0);
	}

}
