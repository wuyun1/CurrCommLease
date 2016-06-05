/*
 * V_queryAndupgrade.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.view.huiyuan.son;

import com.CCL.beans.Customer;
import com.CCL.beans.CustomerType;
import com.CCL.view.huiyuan.VipManager;
import com.CCL.view.huiyuan.service.CustomerService;
import com.CCL.view.huiyuan.service.CustomerTypeService;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class V_queryAndupgrade extends javax.swing.JPanel {
	
	/** Creates new form V_queryAndupgrade */
	public V_queryAndupgrade() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				updateTypeList();
			}
		});
		
		initComponents();
	}

	public javax.swing.JButton getjButton1() {
		return jbt_out;
	}

	public void setjButton1(javax.swing.JButton jButton1) {
		this.jbt_out = jButton1;
	}

	public javax.swing.JComboBox getjComboBox1() {
		return jComboBox1;
	}

	public void setjComboBox1(javax.swing.JComboBox jComboBox1) {
		this.jComboBox1 = jComboBox1;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public javax.swing.JSeparator getjSeparator1() {
		return jSeparator1;
	}

	public void setjSeparator1(javax.swing.JSeparator jSeparator1) {
		this.jSeparator1 = jSeparator1;
	}

	public javax.swing.JButton getJbt_cancle() {
		return jbt_cancle;
	}

	public void setJbt_cancle(javax.swing.JButton jbt_cancle) {
		this.jbt_cancle = jbt_cancle;
	}

	public javax.swing.JButton getJbt_ok() {
		return jbt_ok;
	}

	public void setJbt_ok(javax.swing.JButton jbt_ok) {
		this.jbt_ok = jbt_ok;
	}

	public javax.swing.JLabel getLbl_grade() {
		return lbl_grade;
	}

	public void setLbl_grade(javax.swing.JLabel lbl_grade) {
		this.lbl_grade = lbl_grade;
	}

	public javax.swing.JLabel getLbl_grade_old() {
		return lbl_grade_old;
	}

	public void setLbl_grade_old(javax.swing.JLabel lbl_grade_old) {
		this.lbl_grade_old = lbl_grade_old;
	}

	public javax.swing.JLabel getLbl_money() {
		return lbl_money;
	}

	public void setLbl_money(javax.swing.JLabel lbl_money) {
		this.lbl_money = lbl_money;
	}

	public javax.swing.JLabel getLbl_money_print() {
		return lbl_money_print;
	}

	public void setLbl_money_print(javax.swing.JLabel lbl_money_print) {
		this.lbl_money_print = lbl_money_print;
	}

	public javax.swing.JLabel getLbl_newgrade() {
		return lbl_newgrade;
	}

	public void setLbl_newgrade(javax.swing.JLabel lbl_newgrade) {
		this.lbl_newgrade = lbl_newgrade;
	}

	public javax.swing.JLabel getLbl_password() {
		return lbl_password;
	}

	public void setLbl_password(javax.swing.JLabel lbl_password) {
		this.lbl_password = lbl_password;
	}

	public javax.swing.JLabel getLbl_query() {
		return lbl_query;
	}

	public void setLbl_query(javax.swing.JLabel lbl_query) {
		this.lbl_query = lbl_query;
	}

	public javax.swing.JLabel getLbl_upgrade() {
		return lbl_upgrade;
	}

	public void setLbl_upgrade(javax.swing.JLabel lbl_upgrade) {
		this.lbl_upgrade = lbl_upgrade;
	}

	public javax.swing.JLabel getLbl_vid_password() {
		return lbl_vid_password;
	}

	public void setLbl_vid_password(javax.swing.JLabel lbl_vid_password) {
		this.lbl_vid_password = lbl_vid_password;
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

	public javax.swing.JPasswordField getTxt_vid_password() {
		return txt_vid_password;
	}

	public void setTxt_vid_password(javax.swing.JPasswordField txt_vid_password) {
		this.txt_vid_password = txt_vid_password;
	}

	public javax.swing.JTextField getTxt_vid_up() {
		return txt_name_up;
	}

	public void setTxt_vid_up(javax.swing.JTextField txt_vid_up) {
		this.txt_name_up = txt_vid_up;
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		txt_vname = new javax.swing.JTextField();
		txt_vname.setBounds(116, 39, 126, 21);
		lbl_password = new javax.swing.JLabel();
		lbl_password.setBounds(298, 42, 81, 15);
		txt_password = new javax.swing.JPasswordField();
		txt_password.setBounds(389, 39, 147, 21);
		lbl_money = new javax.swing.JLabel();
		lbl_money.setBounds(46, 105, 80, 15);
		lbl_money_print = new javax.swing.JLabel();
		lbl_money_print.setBounds(216, 94, 0, 0);
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(136, 101, 104, 19);
		jbt_cancle = new javax.swing.JButton();
		jbt_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_vname.setText("");
				txt_password.setText("");
				lbl_money_print.setText("");
			}
		});
		jbt_cancle.setBounds(479, 101, 75, 23);
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator1.setBounds(10, 155, 801, 10);
		lbl_query = new javax.swing.JLabel();
		lbl_query.setBounds(10, 6, 90, 15);
		lbl_upgrade = new javax.swing.JLabel();
		lbl_upgrade.setBounds(20, 171, 80, 15);
		txt_name_up = new javax.swing.JTextField();
		txt_name_up.setBounds(116, 204, 128, 21);
		lbl_vid_password = new javax.swing.JLabel();
		lbl_vid_password.setBounds(298, 207, 81, 15);
		txt_vid_password = new javax.swing.JPasswordField();
		txt_vid_password.setBounds(389, 204, 146, 21);
		lbl_grade = new javax.swing.JLabel();
		lbl_grade.setBounds(46, 258, 87, 15);
		lbl_grade_old = new javax.swing.JLabel();
		lbl_grade_old.setBounds(134, 256, 168, 17);
		lbl_newgrade = new javax.swing.JLabel();
		lbl_newgrade.setBounds(367, 334, 60, 15);
		jComboBox1 = new javax.swing.JComboBox<CustomerType>();
		jComboBox1.setBounds(454, 331, 87, 21);
		jbt_ok = new javax.swing.JButton();
		jbt_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_name_up.getText();
				Customer ct = CustomerService.query(name);
				
				
				CustomerType selectedItem = (CustomerType)jComboBox1.getSelectedItem();
				ct.setCustomerType(selectedItem);
				
				CustomerService.update(ct);
				
				JOptionPane.showMessageDialog(null, "成功升级！");
				
			}
		});
		jbt_ok.setBounds(367, 384, 81, 23);
		jbt_out = new javax.swing.JButton();
		jbt_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_name_up.setText("");
				txt_vid_password.setText("");
				lbl_grade_old.setText("");
				lbl_print.setText("");
			}
		});
		jbt_out.setBounds(479, 384, 81, 23);

		lbl_password.setText("\u4f1a\u5458\u5bc6\u7801\uff1a");

		lbl_money.setText("\u4F59    \u989D\uFF1A");

		jbt_cancle.setText("\u5173   \u95ed");

		lbl_query.setText(" \u67e5\u8be2\u4f1a\u5458\u4f59\u989d");

		lbl_upgrade.setText("\u4f1a\u5458\u5361\u5347\u7ea7");

		lbl_vid_password.setText("\u4f1a\u5458\u5bc6\u7801\uff1a");

		lbl_grade.setText("\u4f1a\u5458\u539f\u7b49\u7ea7\uff1a");

		lbl_newgrade.setText("\u5347\u7ea7\u4e3a\uff1a");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"金卡", "铂金卡", "钻石卡" }));

		jbt_ok.setText("\u5347    \u7ea7");

		jbt_out.setText("\u53d6    \u6d88");
		setLayout(null);
		add(lbl_money);
		add(jLabel1);
		add(jbt_cancle);
		add(txt_vname);
		add(lbl_password);
		add(txt_password);
		add(lbl_money_print);
		add(lbl_query);
		add(lbl_upgrade);
		add(jSeparator1);
		add(lbl_grade);
		add(lbl_grade_old);
		add(txt_name_up);
		add(lbl_vid_password);
		add(lbl_newgrade);
		add(jbt_ok);
		add(jComboBox1);
		add(jbt_out);
		add(txt_vid_password);
		
		JButton jbt_found = new JButton("\u67E5  \u8BE2");
		jbt_found.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_vname.getText();
				Customer ct = CustomerService.query(name);
				
				jLabel1.setText(ct.getMoney().toString());
			}
		});
		jbt_found.setBounds(370, 101, 78, 23);
		add(jbt_found);
		
		jbt_f = new JButton("\u67E5  \u627E");
		jbt_f.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_name_up.getText();
				Customer ct = CustomerService.query(name);
				
				CustomerType ctp =ct.getCustomerType();
				lbl_grade_old.setText(ctp.getName());
				lbl_print.setText(ct.getIntegral().toString());
			}
		});
		jbt_f.setBounds(367, 252, 93, 23);
		add(jbt_f);
		
		lbl_vname = new JLabel("\u4F1A\u5458\u59D3\u540D\uFF1A");
		lbl_vname.setBounds(46, 42, 80, 15);
		add(lbl_vname);
		
		lbl_name_up = new JLabel("\u4F1A\u5458\u59D3\u540D\uFF1A");
		lbl_name_up.setBounds(46, 207, 80, 15);
		add(lbl_name_up);
		
		JLabel lbl_integral = new JLabel("\u4F1A\u5458\u79EF\u5206\uFF1A");
		lbl_integral.setBounds(46, 308, 80, 15);
		add(lbl_integral);
		
		lbl_print = new JLabel("");
		lbl_print.setBounds(116, 308, 100, 15);
		add(lbl_print);
	}// </editor-fold>
	//GEN-END:initComponents
	void updateTypeList(){
		jComboBox1.setModel(new DefaultComboBoxModel(CustomerTypeService.getAllType().toArray()));
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jbt_out;
	private javax.swing.JComboBox<CustomerType> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JButton jbt_cancle;
	private javax.swing.JButton jbt_ok;
	private javax.swing.JLabel lbl_grade;
	private javax.swing.JLabel lbl_grade_old;
	private javax.swing.JLabel lbl_money;
	private javax.swing.JLabel lbl_money_print;
	private javax.swing.JLabel lbl_newgrade;
	private javax.swing.JLabel lbl_password;
	private javax.swing.JLabel lbl_query;
	private javax.swing.JLabel lbl_upgrade;
	private javax.swing.JLabel lbl_vid_password;
	private javax.swing.JPasswordField txt_password;
	private javax.swing.JTextField txt_vname;
	private javax.swing.JPasswordField txt_vid_password;
	private javax.swing.JTextField txt_name_up;
	private JButton jbt_f;
	private JLabel lbl_vname;
	private JLabel lbl_name_up;
	private JLabel lbl_print;
}