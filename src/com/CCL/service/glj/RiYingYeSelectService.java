package com.CCL.service.glj;

import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTable;


import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.OrderDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerType;
import com.CCL.beans.Order;
import com.CCL.util.glj.DateUtil;
import com.CCL.util.glj.DateUtils;

public class RiYingYeSelectService {
	static BillDao rry_billdao = new BillDaoImpl();
	static OrderDao rry_orderdao = new OrderDaoImpl();
	static BicycleDao bicycleDao = new BicycleDaoImpl();

	// // ���1��3�еı�����Ӧ�������µ����ݱ�
	// public void get1_3Table() {
	// List<Bill> bill_list = rry_billdao.queryAll();
	// for (Bill bill : bill_list) {
	// Order order = bill.getOrder();
	// List<Bicycle> biy_list = getBicycleByOrder(order);
	// writebicycleMap(order);// �Ѷ�Ӧ�����ĳ���д��Map<Bicycle, Integer>
	// for (Bicycle b : biy_list) {
	// System.out.println("daying");
	// Vector<String> temp = new Vector<String>();
	// if (b.getType().toString().equals("���˳�"))// ���1��3�еı�����Ӧ�������µ�����
	// {
	// String num = order.getBicyclesMap().get(b) + " ��";
	// String delay = bill.getDelay() + " ����";
	// String total = bill.getTotal() + " Ԫ";
	// temp.add(num);
	// temp.add(delay);
	// temp.add(total);
	// JTable table_1 = new JTable(null, temp);
	// try {
	// System.out.println("daying");
	// table_1.print();
	// } catch (PrinterException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// } else {
	// temp.add(0 + " ��");
	// temp.add(0 + " ����");
	// temp.add(0 + " Ԫ");
	// JTable table_1 = new JTable(null, temp);
	// }
	// }
	// }
	// }

	public static Vector<Vector<Object>> getRiYinYeBill(Date starttime,
			Date endtime) {
		Vector<Vector<Object>> tableValueV = new Vector<Vector<Object>>();

		List<Bill> bill_list = rry_billdao.queryAll();
		// List<Order> order_list = rry_orderdao.queryAll();
		int i = 1;
		for (Bill bill : bill_list) {
			Vector<Object> valueRow = new Vector<Object>();
			Order order = bill.getOrder();
			String time = DateUtil.formatHMDate(bill.getOutTime());// �˵����ʱ��
			String xiaofei_time = bill.getDelay().toString();// ����ʱ��
			List<Bicycle> biy_list = getBicycleByOrder(order);// ��Ӧһ��order��һ��bill
			writebicycleMap(order);// �Ѷ�Ӧ�����ĳ���д��Map<Bicycle, Integer>

			String str = bill.getOutTime().toString().substring(0,bill.getOutTime().toString().indexOf(" "));
			Date outtime = DateUtil.paseDate(str);
			System.out.println(outtime);
			if (DateUtils.betweenTowDate(starttime,endtime,outtime)==-1||
					DateUtils.betweenTowDate(starttime,endtime,outtime)==0||
					DateUtils.betweenTowDate(starttime,endtime,outtime)==1||
					DateUtils.betweenTowDate(starttime,endtime,outtime)==3	) {

				valueRow.add(i++);
				valueRow.add(bill);
				valueRow.add(time);
				valueRow.add(bill.getTotal() + "Ԫ");
				Map<Integer, Bicycle> temp = new HashMap<Integer, Bicycle>();
				for (Bicycle b : biy_list) {
					if (b.getType().toString().equals("���˳�"))// ���1��3�еı�����Ӧ�������µ�����
					{
						temp.put(1, b);
					} else if (b.getType().toString().equals("˫�˳�"))// ���1��3�еı�����Ӧ�������µ�����
					{
						temp.put(2, b);
					} else if (b.getType().toString().equals("���˳�"))// ���1��3�еı�����Ӧ�������µ�����
					{
						temp.put(3, b);
					}

				}
				for (int j = 1; j <= 3; j++) {
					if (temp.get(j) != null) {
						String num = order.getBicyclesMap().get(temp.get(j))
								+ " ��";
						String delay = Integer.valueOf((bill.getDelay()
								.toString())) + "����";
						Bicycle bicycle = temp.get(j);// ���г�����

						String total1 = String.valueOf(getTatolPrice(bicycle,
								order.getCustomer(),
								Integer.valueOf((bill.getDelay().toString()))));

						String total = String.valueOf(Double.valueOf(total1
								.substring(0, total1.indexOf(".")))
								* (order.getBicyclesMap().get(temp.get(j))));
						String total_money = total.substring(0,
								total1.indexOf("."))
								+ " Ԫ";
						valueRow.add(delay + "��" + num + "��" + total_money);
					} else {
						// valueRow.add("00"+"��"+"00"+"��"+"00");
						valueRow.add("" + "" + "");
					}
				}

				tableValueV.add(valueRow);

			}
		}

		return tableValueV;
	}

	public static Vector<Vector<Object>> getRiYinYeBill() {
		Vector<Vector<Object>> tableValueV = new Vector<Vector<Object>>();

		List<Bill> bill_list = rry_billdao.queryAll();
		// List<Order> order_list = rry_orderdao.queryAll();
		int i = 1;
		for (Bill bill : bill_list) {
			Vector<Object> valueRow = new Vector<Object>();
			Order order = bill.getOrder();
			String time = DateUtil.formatHMDate(bill.getOutTime());// �˵����ʱ��
			String xiaofei_time = bill.getDelay().toString();// ����ʱ��
			List<Bicycle> biy_list = getBicycleByOrder(order);// ��Ӧһ��order��һ��bill
			writebicycleMap(order);// �Ѷ�Ӧ�����ĳ���д��Map<Bicycle, Integer>

			valueRow.add(i++);
			valueRow.add(bill);
			valueRow.add(time);
			valueRow.add(bill.getTotal() + "Ԫ");
			Map<Integer, Bicycle> temp = new HashMap<Integer, Bicycle>();
			for (Bicycle b : biy_list) {
				if (b.getType().toString().equals("���˳�"))// ���1��3�еı�����Ӧ�������µ�����
				{
					temp.put(1, b);
				} else if (b.getType().toString().equals("˫�˳�"))// ���1��3�еı�����Ӧ�������µ�����
				{
					temp.put(2, b);
				} else if (b.getType().toString().equals("���˳�"))// ���1��3�еı�����Ӧ�������µ�����
				{
					temp.put(3, b);
				}

			}
			for (int j = 1; j <= 3; j++) {
				if (temp.get(j) != null) {
					String num = order.getBicyclesMap().get(temp.get(j)) + " ��";
					String delay = Integer
							.valueOf((bill.getDelay().toString())) + "����";
					Bicycle bicycle = temp.get(j);// ���г�����

					String total1 = String.valueOf(getTatolPrice(bicycle,
							order.getCustomer(),
							Integer.valueOf((bill.getDelay().toString()))));
					Double total = Double.valueOf(total1)
							* (order.getBicyclesMap().get(temp.get(j)));
					
					DecimalFormat df = new DecimalFormat("#.0");
					String total_money = df.format(total) + " Ԫ";
					valueRow.add(delay + "��" + num + "��" + total_money);
				} else {
					// valueRow.add("00"+"��"+"00"+"��"+"00");
					valueRow.add("" + "" + "");
				}
			}

			tableValueV.add(valueRow);

		}

		return tableValueV;
	}

	// ���һ���û���һ�����ͳ������Ѽ۸�
	public static double getTatolPrice(Bicycle bicycle, Customer cus, int time) {
		double consume = 0;
		int bic_price = bicycle.getPrice();// ��Ӧ�ļ۸�
		Integer isDaZhe_bic = bicycle.getIsDaZhe();// ���г��Ƿ����

		CustomerType cus_type = cus.getCustomerType();// ����û����
		if (bicycle.getBaseTime() == 0) {
			bicycle.setBaseTime(60);
		}
		if (bicycle.getChargeTime() == 0) {
			bicycle.setChargeTime(30);
		}
		if (time > bicycle.getBaseTime()) {

			int yushu = time % bicycle.getBaseTime();
			int shang = time / bicycle.getBaseTime();
			consume = yushu > bicycle.getChargeTime() ? ((shang + 1) * bicycle
					.getPrice()) : (shang * bicycle.getPrice() + bicycle
					.getOverTimePrice());
		} else if (time > bicycle.getChargeTime()
				&& time < bicycle.getBaseTime()) {
			consume = bic_price;
		} else {
			consume = bicycle.getOverTimePrice();
		}

		if (isDaZhe_bic != 0) {
			
			consume = consume * ((bicycle.getType().getDiscount()) / 10.0);
			consume = consume * ((cus_type.getDiscount()) / 10.0);
		} else {
			consume = consume * ((cus_type.getDiscount()) / 10.0);
		}
		return consume;
	}

	public static List<Bicycle> getBicycleByOrder(Order corder) {
		List<Bicycle> bic_list = new ArrayList();
		String[] entryStrs = corder.getBicycles().split(";");
		for (String string : entryStrs) {
			String[] entry = string.split(":");
			int bicycleId = Integer.parseInt(entry[0]);
			Bicycle bicycle = bicycleDao.get(bicycleId);
			bic_list.add(bicycle);
		}
		return bic_list;
	}

	public static void writebicycleMap(Order corder) {

		Map<Bicycle, Integer> bicyclesMap = new HashMap<Bicycle, Integer>();
		String[] entryStrs = corder.getBicycles().split(";");

		for (String string : entryStrs) {
			String[] entry = string.split(":");
			int bicycleId = Integer.parseInt(entry[0]);
			Bicycle bicycle = bicycleDao.get(bicycleId);
			int num = entry.length == 2 ? Integer.parseInt(entry[1]) : 1;
			bicyclesMap.put(bicycle, num);
		}
		corder.setBicyclesMap(bicyclesMap);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new RiYingYeSelectService().getRiYinYeBill(null, null);

	}

}
