package com.CCL.view.huiyuan.service;

import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.util.mlf.PublicDate;

public class OperUserPerService {

	static public  Opeper getCurrentUserOpe(){
		
		
//		return  PublicDate.getOuser().getOpePer();
		
		return new Opeper(null,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1);
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
	
//	jTabbedPane1.addTab("��Ա������", regist);
//	jTabbedPane1.addTab("��Ա����ֵ", savemoney);
//	jTabbedPane1.addTab("��Ա��ע������", cancleanddo);
//
//	jTabbedPane1.addTab("��Ա����ѯ/������Ա��", queryAndupgrade);
//	jTabbedPane1.addTab("��Ա�޸���Ϣ", update);
//	jTabbedPane1.addTab("��Ա��Ϣ��ѯ", information);
//	jTabbedPane1.addTab("��Ա���Ѽ�¼��ѯ", records);
	
	static public boolean preJudgeByPanelTitle(String panelTitle) {

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
		}

		return true;

	}
	
	
}
