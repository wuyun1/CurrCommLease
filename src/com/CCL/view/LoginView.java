package com.CCL.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.CCL.util.Globel;
import com.CCL.util.ValidateCode;
import com.CCL.util.ValidateCodeBuilder;

public class LoginView extends JFrame {

	private JPanel loginMain;
	private JLabel lblName;
	private JLabel lblPwd;
	private JLabel lblvalidateCode;
	private final JLabel lbl_validateCode;
	private JTextField txt_validateCode;
	private JTextField txtName;
	private JPasswordField txtPwd;
	private JLabel lblprompt; // 验证码提示文本框
	private static String currentValidateCode;
	// private JTextField txtPwd;
	private JButton btnLogin;
	private JButton btnExit;

	public JPanel getLoginMain() {
		return loginMain;
	}

	public void setLoginMain(JPanel loginMain) {
		this.loginMain = loginMain;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblPwd() {
		return lblPwd;
	}

	public void setLblPwd(JLabel lblPwd) {
		this.lblPwd = lblPwd;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtPwd() {
		return txtPwd;
	}

	public void setTxtPwd(JPasswordField txtPwd) {
		this.txtPwd = txtPwd;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public LoginView() {

		loginMain = new JPanel(null) {
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				Image img = new ImageIcon("images/sign.jpg").getImage();
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

		lblName = new JLabel("用户名：");
		lblPwd = new JLabel("密   码：");
		txtName = new JTextField();
		txtPwd = new JPasswordField();
		btnLogin = new JButton();
		btnExit = new JButton();
		lblvalidateCode = new JLabel("验证码：");
		lbl_validateCode = new JLabel("") {

			public void paint(Graphics g) {

				ValidateCode vc = ValidateCodeBuilder.drawValidateCode(80, 25, 4);
				currentValidateCode = vc.getValidateCodeString();
				g.drawImage(vc.getBufferedImage(), 0, 0, this);
			}

		};
		lbl_validateCode.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (e.getButton() == java.awt.event.MouseEvent.BUTTON1 && e.getClickCount() == 1) {
					lbl_validateCode.repaint();
				}
			}

		});

		txt_validateCode = new JTextField();
		txt_validateCode.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				String code = txt_validateCode.getText();
				if (!code.isEmpty()) {
					if (!code.equalsIgnoreCase(currentValidateCode)) {
						txt_validateCode.setText("");
						lbl_validateCode.repaint();
						lblprompt.setFont(new Font("", Font.ITALIC, 10));
						lblprompt.setText("验证码有误，请重新输入");

					}
				}
			}

		});
		lblprompt = new JLabel("");
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(660, 387);
		btnLogin.setIcon(new ImageIcon("images/login\\SignIn.png"));
		btnLogin.setText("登录");
		btnExit.setIcon(new ImageIcon("images/login\\signOut.png"));
		btnExit.setText("退出");

		btnLogin.setBounds(175, 251, 107, 30);
		btnExit.setBounds(385, 251, 107, 30);
		lblName.setBounds(198, 122, 60, 25);
		lblPwd.setBounds(198, 157, 60, 25);
		txtName.setBounds(258, 122, 155, 25);
		txtPwd.setBounds(258, 157, 155, 25);
		lblvalidateCode.setBounds(198, 185, 60, 25);
		txt_validateCode.setBounds(258, 185, 100, 25);
		lbl_validateCode.setBounds(385, 185, 80, 25);
		lblprompt.setBounds(258, 210, 250, 20);
		this.setUndecorated(true);
		loginMain.add(btnLogin);
		loginMain.add(btnExit);
		loginMain.add(lblName);
		loginMain.add(lblPwd);
		loginMain.add(txtName);
		loginMain.add(txtPwd);
		loginMain.add(lblvalidateCode);
		loginMain.add(txt_validateCode);
		loginMain.add(lbl_validateCode);
		loginMain.add(lblprompt);
		this.add(loginMain);
		this.setVisible(true);

		Globel.centerByWindow(this);

		// btnLogin.addActionListener(new
		// LogionFrame_btnLogin_ActionListener(this));
		// btnExit.addActionListener(new
		// LogionFrame_btnExit_ActionListener(this));
	}

	public static void main(String[] args) {
		new LoginView().setVisible(true);
	}
}
