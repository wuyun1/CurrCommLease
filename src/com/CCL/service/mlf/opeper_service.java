package com.CCL.service.mlf;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.Dao.impl.OpeperDaoImpl;
import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.util.mlf.PublicDate;

public class opeper_service {
	
	private OpeperDao opeperDao = new OpeperDaoImpl();
	private Opeper opeper;
	private JList list;
	private int i;
	private String name;
	private String pwd;
	private OpeUserDao Opdao;
	private OpeUser oper;
	public opeper_service()
	{
		Opdao=new OpeUserDaoImpl();
		oper=new OpeUser();
	}
	public Vector<Object> readQuanxian_vctor(Opeper opeper,String name,int j)
	{
		this.opeper = opeper;
//		List<Opeper> opeperlist = opeperDao.queryAll();
		Vector<Object> temp =null;//new Vector<Object>();;
		if(name.equals("ǰ̨��������"))
		{
			Vector<Object> vc=new Vector<Object>();
				if(opeper.getToChange()==j)
				{
					vc.addElement("��������");
				}
				if(opeper.getPointsFor()==j)
			    {
					vc.addElement("���ֶһ�");
					
			}
			temp =vc;
		}
		
		if(name.equals("��Ա������"))
		{
			Vector<Object> vc=new Vector<Object>();
				 if(opeper.getUpgrade()==j)
				    {
					 vc.addElement("��Ա������");
				    }
				    if(opeper.getReCard()==j)
				    {
				    	vc.addElement("��Ա������");
				    }
				    if(opeper.getCardTopup()==j)
				    {
				    	vc.addElement("��Ա����ֵ");
				    }
				    if(opeper.getMoneyQuery()==j)
				    {
				    	vc.addElement("����ѯ");
				    }
				    if(opeper.getReInfo()==j)
				    {
				    	vc.addElement("��Ϣ�޸�");
				    }
				    if(opeper.getReCordQuery()==j)
				    {
				    	vc.addElement("���Ѽ�¼��ѯ");
				    }
			temp = vc;
		}
		if(name.equals("ϵͳ����"))
		{
			Vector<Object> vc=new Vector<Object>();
				 if(opeper.getChargingSet()==j)
				    {
					    vc.addElement("�շ�����");
				    }
				    if(opeper.getDiscountSet()==j)
				    {
				    	vc.addElement("�ۿ�����");
				    }
				    
				    if(opeper.getCarManager()==j)
				    {
				    	vc.addElement("��������");
				    }
			return vc;
		}
		if(name.equals("����"))
		{
			Vector<Object> vc=new Vector<Object>();
				if(opeper.getDataBackup()==j)
			    {
			    	vc.addElement("���ݱ���");
			    }
			    if(opeper.getMessageTel()==j)
			    {
			    	vc.addElement("��������");
			    }
			temp = vc;
		}
	   
	   return temp;
	}
	public  Vector<Object> readQuanXian(Opeper opeper,int i)
	  {  
		DefaultListModel  listmodel=new DefaultListModel();
		this.opeper=opeper;
	    this.list=list;
	    this.i=i;
	    List<Opeper> opeperlist = opeperDao.queryAll();
		Vector<Object> vc=new Vector<Object>();
	    if(opeper.getToChange()==i)
	    {
	    	vc.addElement("��������");
	    }
	    if(opeper.getBillPrint()==i)
	    {
	    	vc.addElement("�˵�����");
	    }
	    if(opeper.getPointsFor()==i)
	    {
	    	vc.addElement("���ֶһ�");
	    }
	    if(opeper.getUpgrade()==i)
	    {
	    	vc.addElement("��Ա������");
	    }
	    if(opeper.getReCard()==i)
	    {
	    	vc.addElement("��Ա������");
	    }
	    if(opeper.getCardTopup()==i)
	    {
	    	vc.addElement("��Ա����ֵ");
	    }
	    if(opeper.getMoneyQuery()==i)
	    {
	    	vc.addElement("����ѯ");
	    }
	    if(opeper.getReInfo()==i)
	    {
	    	vc.addElement("��Ϣ�޸�");
	    }
	    if(opeper.getReCordQuery()==i)
	    {
	    	vc.addElement("���Ѽ�¼��ѯ");
	    }
	    if(opeper.getChargingSet()==i)
	    {
	    	vc.addElement("�շ�����");
	    }
	    if(opeper.getDiscountSet()==i)
	    {
	    	vc.addElement("�ۿ�����");
	    }
	    
	    if(opeper.getCarManager()==i)
	    {
	    	vc.addElement("��������");
	    }
	    if(opeper.getDataBackup()==i)
	    {
	    	vc.addElement("���ݱ���");
	    }
	    if(opeper.getMessageTel()==i)
	    {
	    	vc.addElement("��������");
	    }
	    return vc;
	}
	public void shouQuan(Opeper opeper,String name,int s)
	{
		this.opeper = opeper;
		if(name.equals("��������"))
		{
			opeper.setToChange(s);
		}
		if(name.equals("�˵�����"))
		{
			opeper.setBillPrint(s);
	
		}
		if(name.equals("���ֶһ�"))
		{
			opeper.setPointsFor(s);
		}
		if(name.equals("��Ա������"))
		{
			opeper.setUpgrade(s);
		}
		if(name.equals("��Ա������"))
		{
			opeper.setReCard(s);
		}
		if(name.equals("��Ա����ֵ"))
		{
			opeper.setCardTopup(s);
		}
		if(name.equals("����ѯ"))
		{
			opeper.setMoneyQuery(s);
		}
		if(name.equals("��Ϣ�޸�"))
		{
			opeper.setReInfo(s);
		}
		if(name.equals("���Ѽ�¼��ѯ"))
		{
			opeper.setReCordQuery(s);
		}
		if(name.equals("�շ�����"))
		{
			opeper.setChargingSet(s);
		}	
		if(name.equals("�ۿ�����"))
		{
			opeper.setDiscountSet(s);
		}
		if(name.equals("��������"))
		{
			opeper.setCarManager(s);
		}
		if(name.equals("���ݱ���"))
		{
			opeper.setDataBackup(s);
		}
		if(name.equals("��������"))
		{
			opeper.setMessageTel(s);
		}
		
	}
	public OpeUser selectByNameAndPwd(String name,String pwd)
	{
		this.name=name;		
		this.pwd=pwd;
		OpeUser oper=null;
		List<OpeUser> user=Opdao.queryAll();
		for(OpeUser u:user)
		{
			if(u.getUserName().equals(name)&&u.getPassword().equals(pwd))
			{
				oper=u;
			}
		}
		return oper;
	}
	public static  boolean preJudgeByPanelTitle(String panelTitle) 
	{

		switch(panelTitle){
		case "��Ա����ֵ":
			return preJudge("cardTopup");
		case "��Ա��ע������":
			return preJudge("reInfo");
		case "��Ա����ѯ/������Ա��":
			return preJudge("reInfo");
		case "��Ա�޸���Ϣ":
			return preJudge("reInfo");
		case "��Ա���Ѽ�¼��ѯ":
			return preJudge("reCordQuery");
		case "��������":
		    return preJudge("carManager");
		}

		return true;

	}
static public  Opeper getCurrentUserOpe(){
		
		
		return  PublicDate.getOuser().getOpePer();
		
//		return new Opeper(null,1,1,1,1,1,0,1,1,1,1,1,1,1,1);
//		return new Opeper();
		
	}
	static public boolean preJudge(String preName) {

		switch (preName) {

		case "pointsFor":
			if (getCurrentUserOpe().getPointsFor() == 1) {
				return true; // ���ֶһ�Ȩ��
			}
			;
			break;
		case "upgrade":
			if (getCurrentUserOpe().getUpgrade() == 1) {
				return true; // ������Ա��Ȩ��
			}
			;
			break;
		case "cardTopup":
			if (getCurrentUserOpe().getCardTopup() == 1) {
				return true; // ��Ա����ֵ
			}
			;
			break;
		case "reCard":
			if (getCurrentUserOpe().getReCard() == 1) {
				return true; // �����Ա��
			}
			;
			break;
		case "moneyQuery":
			if (getCurrentUserOpe().getMoneyQuery() == 1) {
				return true; // ����ѯ
			}
			;
			break;
		case "reCordQuery":
			if (getCurrentUserOpe().getReCordQuery() == 1) {
				return true; // ���Ѽ�¼��ѯ
			}
			;
			break;
		case "reInfo":
			if (getCurrentUserOpe().getReInfo() == 1) {
				return true; // ��Ϣ�޸�
			}
			;
			break;
		}

		return false;

	}

}
