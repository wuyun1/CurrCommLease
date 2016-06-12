package com.CCL.view.other.son;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SMS_alerts extends JPanel {
	private JTextField txt_name;
	private JTextField txt_password;
	private JTextField txt_tel;
	private JTextField txt_text;
	public SMS_alerts() {
		setLayout(null);
		
		JLabel lbl_message = new JLabel("\u77ED\u4FE1\u914D\u7F6E\uFF1A");
		lbl_message.setBounds(59, 33, 79, 15);
		add(lbl_message);
		
		JLabel lbl_fromname = new JLabel("\u53D1\u9001\u65B9\u7528\u6237\u540D\uFF1A");
		lbl_fromname.setBounds(124, 68, 95, 15);
		add(lbl_fromname);
		
		JLabel lbl_password = new JLabel("\u5BC6    \u94A5\uFF1A");
		lbl_password.setBounds(124, 105, 95, 15);
		add(lbl_password);
		
		JLabel lbl_tel = new JLabel("\u5BA2\u6237\u53F7\u7801\uFF1A");
		lbl_tel.setBounds(124, 144, 79, 15);
		add(lbl_tel);
		
		JLabel lbl_text = new JLabel("\u53D1\u9001\u5185\u5BB9\uFF1A");
		lbl_text.setBounds(124, 182, 79, 15);
		add(lbl_text);
		
		txt_name = new JTextField();
		txt_name.setBounds(209, 65, 125, 21);
		add(txt_name);
		txt_name.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBounds(209, 102, 125, 21);
		add(txt_password);
		txt_password.setColumns(10);
		
		txt_tel = new JTextField();
		txt_tel.setBounds(209, 141, 125, 21);
		add(txt_tel);
		txt_tel.setColumns(10);
		
		txt_text = new JTextField();
		txt_text.setBounds(209, 178, 294, 23);
		add(txt_text);
		
		JButton jbt_send = new JButton("\u53D1    \u9001");
		jbt_send.setBounds(209, 251, 93, 23);
		jbt_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Util_pro.writeData("id.pro", txt_name.getText());
					Util_pro.writeData("key", txt_password.getText());
					Util_pro.writeData("tel.pro", txt_tel.getText());
					Util_pro.writeData("text.pro", txt_text.getText());
					int r=Send.sendMessage();
					if(r>0){
						JOptionPane.showMessageDialog(null, "成功发送信息", "结果", JOptionPane.OK_OPTION);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add(jbt_send);
		
		JButton jbt_cancle = new JButton("\u53D6    \u6D88");
		jbt_cancle.setBounds(329, 251, 93, 23);
		add(jbt_cancle);
	}
}
