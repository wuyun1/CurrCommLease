package com.CCL.panel.glj.qita;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.CCL.panel.mlf.Opanel_opeuser_set;
import com.CCL.panel.mlf.opeper_tip;
import com.CCL.panel.mlf.panel_UserAuthorzatiom;
import com.CCL.util.mlf.PublicDate;
import com.CCL.view.other.OtherManager;

public class Other extends JPanel{
	/**
	 * Create the panel.
	 */
	public Other() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		 if(!PublicDate.getOuser().getUserName().equals("admin"))
	        {
			 
			 opeper_tip o=new opeper_tip();
	        	tabbedPane.addTab("����ԱȨ�޹���", null, o, null);
	        }
		 else
		 {
			 panel_UserAuthorzatiom panel = new panel_UserAuthorzatiom();
			 tabbedPane.addTab("����ԱȨ�޹���", null, panel, null);
		 }
		 if(!PublicDate.getOuser().getUserName().equals("admin"))
	        {
			 
			 opeper_tip o=new opeper_tip();
	        	tabbedPane.addTab("����Ա����", null, o, null);
	        }
		 else
		 {
			 Opanel_opeuser_set panel_1 = new Opanel_opeuser_set();
				tabbedPane.addTab("����Ա����", null, panel_1, null);
		 }
//		 if(PublicDate.getOpeper(PublicDate.getOuser()).getMessageTel()!=1)
//		 {
//			 opeper_tip o=new opeper_tip();
//	        	tabbedPane.addTab("����Ա����", null, o, null);
//		 }
//		 else{
//			 OtherManager panel_2 = new OtherManager();
//				tabbedPane.addTab("��������", null, panel_2, null);
//		 }
		

	}
}
