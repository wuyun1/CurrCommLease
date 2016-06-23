package com.CCL.service.glj;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.hibernate.SQLQuery;
import org.hibernate.Session;


import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.base.HibernateSessionFactory;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.Dao.impl.OrderDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.beans.OpeUser;
import com.CCL.util.glj.DateUtil;

public class MingXiSelectService {

	static BillDao rry_billdao = new BillDaoImpl();
	static OrderDao rry_orderdao = new OrderDaoImpl();
	static BicycleDao bicycleDao = new BicycleDaoImpl();
	static OpeUserDao opeUserDao = new OpeUserDaoImpl();
	
	
	
	/**
	 * @Description:����һ��ope_user ��name����һ��������select���
	 * @param splstr_tiaojian1
	 * @return  String
	 * @returnType String
	 * * @author ������
	 * @Createed  2016-06-14 13:30
	 */
	public static String getSqlstr(String splstr_tiaojian1 , String splstr_tiaojian2)
	{
		String sqlstr_all = "select bill.id,ope_user.user_name,t_order.customer_id,bill.customer_name,t_order.start_time,t_order.stop_time,t_order.deposit,bill.total,bill.payway,bill.delay,t_order.bicycles from bill,t_order,ope_user where bill.order_id=t_order.id and t_order.opeuser_id=ope_user.id";
		sqlstr_all = splstr_tiaojian1.equals("����") ? sqlstr_all :  sqlstr_all +" "+"and" + " "+"ope_user.user_name ="+"'"+splstr_tiaojian1+"'";
		System.out.println(sqlstr_all);
		sqlstr_all = splstr_tiaojian2.equals("����") ? sqlstr_all :  sqlstr_all +" "+"and" + " "+"bill.payway ="+"'"+splstr_tiaojian2+"'";
	
		return sqlstr_all;
	}
	
	/**  
	*  
	* @Description:�������в���Ա
	* @param null
	* @return  ���в���Ա
	* @ReturnType List
	*  @author:  ������
	*@Created 2016-06-13 22��03
	*/
	public static List<OpeUser> getAllOpeUser()
	{
		return opeUserDao.queryAll();
	}
	
	/**  
	*  
	* @Description:�˵���ϸ��ѯ�����µı�����ݣ��������Ա�����֣��� Vector<Vector<Object>>����
	* @param opeUser_name
	* @return  tableValueV
	* @ReturnType Vector<Vector<Object>>
	*  @author:  ������
	*@Created 2016-06-13 21��03
	*/
	public static Vector<Vector<Object>> getTableDate(String opeUser_name,String bill_payway)
	{
		String sqlstr = getSqlstr(opeUser_name,bill_payway);
		List<Object[]> tableDate = getDateList(sqlstr);
		Vector<Vector<Object>> tableValueV = new Vector<Vector<Object>>();
		Vector<Object> rowDate = null;
		int i = 1;
	for (Object[] objects : tableDate) {
		rowDate = new Vector<Object>();
		rowDate.add(i++);
		for (Object object : objects) {
			if(rowDate.size()==5||rowDate.size()==6)
			{
				String time =  object.toString();
				String str = time.substring(0,time.lastIndexOf(":"));
				object = str;
			}else if(rowDate.size()==7||rowDate.size()==8)
			{
				String money1 =  object.toString();
				String money = money1 + "Ԫ";
				object = money;
			}else if(rowDate.size()==9)
			{
				if(object.equals("�ֽ�֧��"))
				{
					object = "�ֽ�֧��";
				}else if(object.equals("���֧��")){
					object = "���֧��";
				}
				else{
					object = "֧����";
				}
			}else if(rowDate.size()==10)
			{
				object = object + "����";
			}else if(rowDate.size()==11)
			{
				String[] entryStrs = object.toString().split(";");
				object = "";
				for (String string : entryStrs) {
					String[] entry = string.split(":");
					int bicycleId = Integer.parseInt(entry[0]);
					int num = Integer.parseInt(entry[1]);
					BicycleType bicycleType = bicycleDao.get(bicycleId).getType();
					object = object + bicycleType.toString() +" " + num + "��"+"   ";
				}
			}
			rowDate.addElement(object);
		}
		tableValueV.add(rowDate);
	}
	return tableValueV;
	}
	
	
	/**  
	*  
	* @Description:����һ��sql����ѯ���ݿ� 
	* @param sqlStr 
	* @return  list
	* @ReturnType List<Object[]>
	*  @author:  ������
	*@Created 2016-06-13 20��03
	*/
	public static List<Object[]> getDateList(String sqlStr)
	{
		Session session = HibernateSessionFactory.getSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlStr);
		List<Object[]> list = sqlQuery.list();
		return list;
	}
	public static void main(String[] args) {
		System.out.println(MingXiSelectService.getSqlstr("����","zfb"));
	}
}
