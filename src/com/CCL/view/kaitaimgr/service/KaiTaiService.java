package com.CCL.view.kaitaimgr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.Dao.impl.OrderDaoImpl;
import com.CCL.Dao.impl.OrderStateDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;
import com.CCL.util.mlf.PublicDate;
import com.CCL.view.other.son.Send;
import com.CCL.view.other.son.Util_pro;

/**
 * ǰ̨����ĺ����߼� ,�ṩ��Ҫ��ǰ̨��ҵ�񷽷� �������ݲ����ͼ��
 * 
 * @author Jonney
 * 
 */
public class KaiTaiService {

	// �������ݿ���ʲ�Ķ���
	static OrderDao orderDao = new OrderDaoImpl();
	static OrderStateDao orderStateDao = new OrderStateDaoImpl();
	static BillDao billDao = new BillDaoImpl();
	static BicycleDao bicycleDao = new BicycleDaoImpl();
	static CustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * �⳵��ҵ�񷽷� ���ɶ��� �����浽���ݿ�
	 * 
	 * @param currentCustomer
	 *            ��ǰ����Ҫ�⳵�Ŀͻ�
	 * @param bicycles
	 *            Ҫ��ĳ��������� ��Map����
	 * @return ��������
	 */
	public static Order rentCar(Customer currentCustomer,
			Map<Bicycle, Integer> bicycles) {

		if (bicycles == null) {
			return null;
		}

		boolean isCanRent = true;
		for (Entry<Bicycle, Integer> bicycleEntry : bicycles.entrySet()) {
			if (bicycleEntry.getKey().getInventory() < bicycleEntry.getValue()) {
				isCanRent = false;
			}
		}
		if (isCanRent == false) {
			return null;
		}
		Order newOrder = new Order(currentCustomer, PublicDate.getOuser(),
				converyBicycles2String(bicycles), getStateByName("׼������"),
				new Date(), null, null, 200f);
		if (orderDao.add(newOrder)) {
			return newOrder;
		} else {
			return null;
		}

	}

	/**
	 * ͨ������״̬�����ƻ�ȡ��Ӧ״̬����
	 * 
	 * @param state
	 *            ״̬����
	 * @return ״̬����
	 */
	public static OrderState getStateByName(String state) {
		List<OrderState> queryByUseLikeAndPage = orderStateDao
				.queryByUseLikeAndPage("name", state, 10, 0);
		OrderState cst = null;
		if (queryByUseLikeAndPage != null && queryByUseLikeAndPage.size() > 0) {
			cst = queryByUseLikeAndPage.get(0);
		} else {
			OrderState newState = new OrderState(state, null);
			orderStateDao.add(newState);
			cst = newState;
		}
		return cst;
	}

	/**
	 * ��ȡ���Զ���(Ĭ���ǰ���������ʱ������)
	 * 
	 * @return ���Զ���
	 */
	public static List<Order> getAllOrder() {

		List<Order> allOrder = orderDao.queryAll();

		return allOrder;
	}

	/**
	 * ��������,ʹ������׼��״̬ת��Ϊ����״̬ ����ֱ�г��������Ĳ���
	 * 
	 * @param corder
	 *            Ҫ�����Ķ���
	 * @return ���ز����ɹ�����ʧ��
	 */
	public static boolean startOrder(Order corder) {

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}
		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			if (entry.getKey().getInventory() < entry.getValue()) {
				return false;
			}
		}

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory() - num);
			bicycleDao.update(bicyc);
		}

		corder.setStartTime(new Date());
		corder.setOrderState(getStateByName("���ڽ���"));
		return orderDao.update(corder);
	}

	/**
	 * �Ѷ����ĵ� �ַ��������ֱ�г��������� ת���� Map
	 * 
	 * @param corder
	 *            Ҫ�����Ķ���
	 */
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

	/**
	 * ���˶���,�����˵� ��������״̬�н���ת������� ,���黹����
	 * 
	 * @param corder
	 *            Ҫ�����Ķ���
	 * @return �������ɵ��˵�
	 */
	public static Bill accountsOrder(Order corder) {
		corder.setStopTime(new Date());
		float spendTime = (float) ((corder.getStopTime().getTime() - corder
				.getStartTime().getTime()) / 1000.0 / 60);

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory() + num);
			// originalCost += (bicyc.getIsDaZhe()?
			// bicyc.getType().getDiscount()/10:1) * bicyc.getPrice() * num;
			bicycleDao.update(bicyc);
		}

		// ���㻨��
		float huafei = calcPrice(corder, spendTime);

		Customer customer = corder.getCustomer();
		Bill newBill = null;

		// ֧������
		if (customer.getMoney() >= huafei) {
			newBill = new Bill(new Date(), (long) spendTime, corder, corder
					.getCustomer().getName(), corder.getCustomer().getId(),
					"���֧��", huafei);
			customer.setMoney(customer.getMoney() - huafei);
		} else {
			newBill = new Bill(new Date(), (long) spendTime, corder, corder
					.getCustomer().getName(), corder.getCustomer().getId(),
					"�ֽ�֧��", huafei);
		}

		corder.setOrderState(getStateByName("�������"));
		orderDao.update(corder);
		billDao.add(newBill);

		// �������
		customer.setIntegral((int) (customer.getIntegral() + calcJiFen(bicyclesMap)));
		customerDao.update(customer);

		return newBill;
	}

	/**
	 * �������
	 * 
	 * @param bicyclesMap
	 * @return
	 */
	private static Float calcJiFen(Map<Bicycle, Integer> bicyclesMap) {
		Float jiFen = 0f;

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			if (bicyc.getIsJiFen() == 1) {
				int num = entry.getValue();
				jiFen += bicyc.getPrice() * num;
			}
		}
		jiFen /= 100;
		return jiFen;
	}

	/**
	 * ɾ��δ��ʼ�Ķ��� ,�Ѿ���ʼ�Ķ����޷�ɾ��
	 * 
	 * @param corder
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public static boolean delOrder(Order corder) {
		boolean remove = orderDao.remove(corder.getId());
		return remove;
	}

	/**
	 * �����ų� �� ������Map���� ����� ��Ӧ���ַ���
	 * 
	 * @param bicycles
	 * @return �������ַ���
	 */
	public static String converyBicycles2String(Map<Bicycle, Integer> bicycles) {

		StringBuilder str = new StringBuilder();

		for (Entry<Bicycle, Integer> bicycleEntry : bicycles.entrySet()) {
			str.append(bicycleEntry.getKey().getId() + ":"
					+ bicycleEntry.getValue() + ";");
		}

		if (str.charAt(str.length() - 1) == ';') {
			str.deleteCharAt(str.length() - 1);
		}
		return str.toString();
	}

	/**
	 * ���㶩���ļ۸�
	 * 
	 * @param corder
	 *            ����
	 * @param spendTime
	 *            ʵ�ʻ��ѵ�ʱ��(����)
	 * @return �۸�
	 */
	public static float calcPrice(Order corder, float spendTime) {
		spendTime = (int) (spendTime + 0.5);

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}

		float originalCost = 0;

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			float unit = (bicyc.getIsDaZhe() == 1 ? bicyc.getType()
					.getDiscount() / 10 : 1) * bicyc.getPrice();
			float unithuafei = (((int) spendTime) / bicyc.getBaseTime()) * unit;
			if ((spendTime % bicyc.getBaseTime()) > bicyc.getChargeTime()) {
				unithuafei += unit;
			} else {
				unithuafei += bicyc.getOverTimePrice();

			}

			originalCost += unithuafei * num;
		}
		float f = originalCost
				* (corder.getCustomer().getCustomerType().getDiscount() / 10);
		return f;

	}

	/**
	 * ��ȡ���Կ���׼�������Ķ���
	 * 
	 * @return ��������
	 */
	public static List<Order> getAllPreOrder() {

		OrderState bicycleState = getStateByName("׼������");
		return orderDao.queryByState(bicycleState);
	}

	/**
	 * ���¶���
	 * 
	 * @param currentOrder
	 *            �����µĶ���
	 */
	public static void updateOrder(Order currentOrder) {
		orderDao.update(currentOrder);
	}

	public static Bill getBillByOrder(Order order) {
		
		List<Bill> queryByUsePage = billDao.queryByUsePage("ORDER_ID", order.getId(), 1, 0);
		if(queryByUsePage.isEmpty()){
			return null;
		}
		else{
			return queryByUsePage.get(0);
		}
	}
	
	static boolean isEnableSmsNotice = "true".equals( Util_pro.readData("sms.enable"));
	static int noticeOverTime = Integer.parseInt( Util_pro.readData("time"));
	static Map<String,Boolean> isSended = new HashMap<String,Boolean>();
	public static int smsNotice(Order order) {
		if(isEnableSmsNotice){
			Date date = order.getStartTime();
			Date d1 = new Date();
			
			Date d2 = date;
			long diff = d1.getTime() - d2.getTime();// �����õ��Ĳ�ֵ��΢�뼶��
			
			
			int hours = (int) (diff / (1000 * 60 * 60));
			Boolean issended = isSended.get(order.getId()+":"+hours);
			if(issended==null) issended=false;
			if(hours>0&&hours%noticeOverTime==0&&!issended){
				String tel = order.getCustomer().getPhone();
				if(tel!=null){
					String text = "���������Ʒ�쵽�黹ʱ����  ,��������黹!";
					int sendMessage = Send.sendMessage(tel, text);
					System.out.println("���Ͷ��ŷ�����:"+sendMessage);
					isSended.put(order.getId()+":"+hours, true);
					return sendMessage;
					
				}
				
			}
			
			
		}
		return 0;
	}
	
}
