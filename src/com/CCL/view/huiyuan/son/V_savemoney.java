/*
 * V_savemoney.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.view.huiyuan.son;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;

import com.CCL.beans.Customer;
import com.CCL.util.DateUtil;
import com.CCL.view.huiyuan.VipManager;
import com.CCL.view.huiyuan.service.CustomerService;

import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 *
 * @author __USER__
 */
public class V_savemoney extends javax.swing.JPanel {

	/** Creates new form V_savemoney */
	public V_savemoney() {
		setLayout(null);
		initComponents();
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JButton getJbt_cancle() {
		return jbt_cancle;
	}

	public void setJbt_cancle(javax.swing.JButton jbt_cancle) {
		this.jbt_cancle = jbt_cancle;
	}

	public javax.swing.JButton getJbt_sava() {
		return jbt_sava;
	}

	public void setJbt_sava(javax.swing.JButton jbt_sava) {
		this.jbt_sava = jbt_sava;
	}

	public javax.swing.JList getJlist_info() {
		return jlist_info;
	}

	public void setJlist_info(javax.swing.JList jlist_info) {
		this.jlist_info = jlist_info;
	}

	public javax.swing.JLabel getLbl_info() {
		return lbl_info;
	}

	public void setLbl_info(javax.swing.JLabel lbl_info) {
		this.lbl_info = lbl_info;
	}

	public javax.swing.JLabel getLbl_money() {
		return lbl_money;
	}

	public void setLbl_money(javax.swing.JLabel lbl_money) {
		this.lbl_money = lbl_money;
	}

	public javax.swing.JLabel getLbl_password() {
		return lbl_password;
	}

	public void setLbl_password(javax.swing.JLabel lbl_password) {
		this.lbl_password = lbl_password;
	}

	public javax.swing.JLabel getLbl_succese() {
		return lbl_succese;
	}

	public void setLbl_succese(javax.swing.JLabel lbl_succese) {
		this.lbl_succese = lbl_succese;
	}

	public javax.swing.JLabel getLbl_yuan() {
		return lbl_yuan;
	}

	public void setLbl_yuan(javax.swing.JLabel lbl_yuan) {
		this.lbl_yuan = lbl_yuan;
	}

	public javax.swing.JTextField getTxt_money() {
		return txt_money;
	}

	public void setTxt_money(javax.swing.JTextField txt_money) {
		this.txt_money = txt_money;
	}

	public javax.swing.JPasswordField getTxt_password() {
		return txt_password;
	}

	public void setTxt_password(javax.swing.JPasswordField txt_password) {
		this.txt_password = txt_password;
	}

	public javax.swing.JTextField getTxt_vid() {
		return txt_vname;
	}

	public void setTxt_vid(javax.swing.JTextField txt_vid) {
		this.txt_vname = txt_vid;
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		txt_vname = new javax.swing.JTextField();
		txt_vname.setBounds(152, 43, 107, 21);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(82, 148, 187, 203);
		lbl_info = new javax.swing.JLabel();
		lbl_info.setBounds(82, 111, 75, 15);
		lbl_money = new javax.swing.JLabel();
		lbl_money.setBounds(329, 111, 68, 15);
		txt_money = new javax.swing.JTextField();
		txt_money.setBounds(407, 108, 93, 21);
		lbl_yuan = new javax.swing.JLabel();
		lbl_yuan.setBounds(510, 111, 18, 15);
		jbt_sava = new javax.swing.JButton();
		jbt_sava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float money = Integer.parseInt(txt_money.getText());
				String name = txt_vname.getText();
				Customer ct = CustomerService.query(name);
				
				ct.setMoney(money);
				CustomerService.update(ct);
				DefaultListModel model = new DefaultListModel();
				model.addElement("姓名:" + ct.getName());
				model.addElement("性别:" + ct.getSex());
				model.addElement("电话:" + ct.getPhone());
				model.addElement("类型：" + ct.getCustomerType().getName());
				model.addElement("余额:" + ct.getMoney());
				model.addElement("状态:" + ct.getCustomerState().getName());
				model.addElement("积分:" + ct.getIntegral());
				model.addElement("出生日期:" + DateUtil.getDate(ct.getBirthday()));
				model.addElement("地址:" + ct.getAddress());
				model.addElement("EMAIL:" + ct.getEmail());
				lbl_succese.setText("你好！"+ct.getName()+"客户成功充值："+ct.getMoney()+"元");
				
				jlist_info.setModel(model);
			}
		});
		jbt_sava.setBounds(329, 315, 69, 23);
		jbt_cancle = new javax.swing.JButton();
		jbt_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_vname.setText(null);
				txt_password.setText(null);
				txt_money.setText(null);
				DefaultListModel model = new DefaultListModel();
				jlist_info.setModel(model);
				
				lbl_info.setText(null);
			}
			
		});
		jbt_cancle.setBounds(475, 315, 69, 23);
		lbl_succese = new javax.swing.JLabel();
		lbl_succese
				.setBorder(new TitledBorder(null, "\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lbl_succese.setBounds(329, 176, 236, 92);
		lbl_password = new javax.swing.JLabel();
		lbl_password.setBounds(329, 46, 69, 15);
		txt_password = new javax.swing.JPasswordField();
		txt_password.setBounds(407, 43, 137, 21);

		lbl_info.setText("\u4f1a\u5458\u4fe1\u606f\uff1a");

		lbl_money.setText("\u5145\u503c\u91d1\u989d\uff1a");

		lbl_yuan.setText(" \u5143");

		jbt_sava.setText("\u5145  \u503c");

		jbt_cancle.setText("\u53d6  \u6d88");

		lbl_password.setText("\u4f1a\u5458\u5bc6\u7801\uff1a");
		setLayout(null);
		setLayout(null);
		add(jScrollPane1);
		jlist_info = new javax.swing.JList();
		jScrollPane1.setViewportView(jlist_info);
		add(lbl_info);
		add(txt_vname);
		add(lbl_money);
		add(txt_money);
		add(lbl_yuan);
		add(jbt_sava);
		add(jbt_cancle);
		add(lbl_password);
		add(txt_password);
		add(lbl_succese);
		JButton jbt_found = new JButton("\u67E5  \u627E");
		jbt_found.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_vname.getText();
				String passwrod=txt_password.getText();
				DefaultListModel model = new DefaultListModel();

				Customer ct = CustomerService.query(name);
				
//				System.out.println(ct.getCustomerType().getName());
				
				if (ct == null) {
					// JOptionPane.showMessageDialog(null, "");
					model.addElement("客户不存在！！！");
				} else {
					if(passwrod.equals(ct.getPassword()))
					{
					model.addElement("姓名:" + ct.getName());
					model.addElement("性别:" + ct.getSex());
					model.addElement("电话:" + ct.getPhone());
					model.addElement("类型：" + ct.getCustomerType().getName());
					model.addElement("余额:" + ct.getMoney());
					model.addElement("状态:" + ct.getCustomerState().getName());
					model.addElement("积分:" + ct.getIntegral());
					model.addElement("出生日期:" + DateUtil.getDate(ct.getBirthday()));
					model.addElement("地址:" + ct.getAddress());
					model.addElement("EMAIL:" + ct.getEmail());
					}
				}

				jlist_info.setModel(model);

			}
		});
		jbt_found.setBounds(162, 74, 93, 23);
		add(jbt_found);
		
		JLabel lbl_vname = new JLabel("\u4F1A\u5458\u59D3\u540D\uFF1A");
		lbl_vname.setBounds(82, 46, 93, 15);
		add(lbl_vname);
	}// </editor-fold>

	// GEN-END:initComponents

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jbt_cancle;
	private javax.swing.JButton jbt_sava;
	private javax.swing.JList jlist_info;
	private javax.swing.JLabel lbl_info;
	private javax.swing.JLabel lbl_money;
	private javax.swing.JLabel lbl_password;
	private javax.swing.JLabel lbl_succese;
	private javax.swing.JLabel lbl_yuan;
	private javax.swing.JTextField txt_money;
	private javax.swing.JPasswordField txt_password;
	private javax.swing.JTextField txt_vname;
}