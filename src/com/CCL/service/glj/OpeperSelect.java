package com.CCL.service.glj;

import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.util.mlf.PublicDate;

public class OpeperSelect {

	
	private static OpeUser opeuser = PublicDate.getOuser();
	private static Opeper opeper = getOpeperList(opeuser);
	/**
	 * @Description  ����һ������Ա���󣬻�����Ĳ���Ȩ�޶���
	 * @param opeuser
	 * @return Opener
	 * @author ������
	 * @create 2016-06-14 16:22
	 */
	public static Opeper getOpeperList(OpeUser opeuser)
	{
		return opeuser.getOpePer();
	}
	
	/**
	 * @Description  ��ѯ�û��Ƿ���ʹ��ĳ���ܵ�Ȩ��
	 * @param preName
	 * @return boolean
	 * @author ������
	 * @create 2016-06-14 16:42
	 */
	public static boolean preJudge(String preName) {
		int i = 1 ;
		boolean result = false;
		if(preName.equals("�շ�����"))
		{
			i = opeper.getChargingSet();
		}else if(preName.equals("�ۿ�����")){
			i = opeper.getDiscountSet();
		}else if(preName.equals("��Ӫҵ��ѯ")){
			i = opeper.getTradingQuery();
		}else if(preName.equals("�˵���ϸ��ѯ")){
			i = opeper.getBillDetails();
		}else if(preName.equals("�������Ʒ���")){
			i = opeper.getChargingSet();
		}else if(preName.equals("��������")){
			i = opeper.getCarManager();
		}
		result =  i==1 ? true:false;
		return result;

	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
