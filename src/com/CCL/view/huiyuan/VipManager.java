/*
 * VipManager.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.view.huiyuan;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Panel;

import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.beans.Customer;
import com.CCL.view.huiyuan.son.V_cancleanddo;
import com.CCL.view.huiyuan.son.V_information;
import com.CCL.view.huiyuan.son.V_queryAndupgrade;
import com.CCL.view.huiyuan.son.V_records;
import com.CCL.view.huiyuan.son.V_regist;
import com.CCL.view.huiyuan.son.V_savemoney;
import com.CCL.view.huiyuan.son.V_update;
import com.CCL.view.huiyuan.test.MyCusDao;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.CCL.view.huiyuan.son.V_typemanager;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author  __USER__
 */
public class VipManager extends javax.swing.JPanel {
	
	/** Creates new form VipManager */
	public VipManager() {
		this.setLayout(new BorderLayout());
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTabbedPane1 = new javax.swing.JTabbedPane();
//		jTabbedPane1.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				
//				int selectedIndex = jTabbedPane1.getSelectedIndex();
//				JPanel selectedComponent = (JPanel) jTabbedPane1.getSelectedComponent();
//				String titleAt = jTabbedPane1.getTitleAt(selectedIndex);
//				
//				if(PregadeService.fun(titleAt)==false){
//					Component[] components = selectedComponent.getComponents();
//					
//					for (Component component : components) {
//						component.setEnabled(false);
//					}
//					JOptionPane.showMessageDialog(null, "");
//				}
//				
//			}
//		});
		savemoney = new V_savemoney();
		cancleanddo = new V_cancleanddo();
		queryAndupgrade = new V_queryAndupgrade();
		update = new V_update();
	    information = new V_information();
	    records = new V_records();
		regist = new V_regist();
		
		jTabbedPane1.addTab("会员卡办理", regist);
		jTabbedPane1.addTab("会员卡充值", savemoney);
		jTabbedPane1.addTab("会员卡注销补办", cancleanddo);
		jTabbedPane1.addTab("会员余额查询/升级会员卡", queryAndupgrade);
		jTabbedPane1.addTab("会员修改信息", update);
		jTabbedPane1.addTab("会员信息查询", information);
		jTabbedPane1.addTab("会员消费记录查询", records);
		
		
		add(jTabbedPane1, java.awt.BorderLayout.CENTER);
		
		V_typemanager panel = new V_typemanager();
		jTabbedPane1.addTab("\u4F1A\u5458\u7C7B\u522B\u7BA1\u7406", null, panel, null);
		
		
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	
	private V_regist regist;
	



	public V_savemoney getSavemoney() {
		return savemoney;
	}

	public void setSavemoney(V_savemoney savemoney) {
		this.savemoney = savemoney;
	}

	public V_cancleanddo getCancleanddo() {
		return cancleanddo;
	}

	public void setCancleanddo(V_cancleanddo cancleanddo) {
		this.cancleanddo = cancleanddo;
	}

	public V_queryAndupgrade getQueryAndupgrade() {
		return queryAndupgrade;
	}

	public void setQueryAndupgrade(V_queryAndupgrade queryAndupgrade) {
		this.queryAndupgrade = queryAndupgrade;
	}

	public V_update getUpdate() {
		return update;
	}

	public void setUpdate(V_update update) {
		this.update = update;
	}

	public V_information getInformation() {
		return information;
	}

	public void setInformation(V_information information) {
		this.information = information;
	}

	public V_records getRecords() {
		return records;
	}

	public void setRecords(V_records records) {
		this.records = records;
	}

	public javax.swing.JTabbedPane getjTabbedPane1() {
		return jTabbedPane1;
	}

	public void setjTabbedPane1(javax.swing.JTabbedPane jTabbedPane1) {
		this.jTabbedPane1 = jTabbedPane1;
	}

	private V_savemoney savemoney;
	private V_cancleanddo cancleanddo;
	private V_queryAndupgrade queryAndupgrade;
	private V_update update;
	private V_information information;
	private V_records records;
	private javax.swing.JTabbedPane jTabbedPane1;
	// End of variables declaration//GEN-END:variables

	public JPanel getRegist() {
		return regist;
	}
}