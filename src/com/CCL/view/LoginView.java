package com.CCL.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.base.HibernateSessionFactory;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.beans.OpeUser;
import com.CCL.panel.ProgressPanel;
import com.CCL.service.mlf.Loginservice;
import com.CCL.util.Globel;
import com.CCL.util.ValidateCode;
import com.CCL.util.ValidateCodeBuilder;
import com.CCL.util.mlf.PublicDate;



public class LoginView extends JFrame{

	private JPanel loginMain;
	private JLabel lblName;
	private JLabel lblPwd;
	private JLabel lblvalidateCode;
	private JLabel lblType;
	private final JLabel lbl_validateCode;
	private JTextField txt_validateCode;
	private JTextField txtName;
	private JPasswordField txtPwd;
	private JLabel lblprompt; //验证码提示文本框
	private static String currentValidateCode;
	private JButton btnLogin;
	private JButton btnExit;
	private JComboBox jcbType;
	private OpeUserDao Opdao;
	
	private String name,pwd;
	private ProgressPanel progressPanel;
	
	private JProgressBar progressBar;
	private static boolean isOver = false;
	static int count = 0;
	static int f = 1;
	
	
	Timer processWork = new Timer(20, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isOver)
				processWork.stop();
		}
	});
 
	
	
	
	
	public LoginView()
	{
		
		Opdao=new OpeUserDaoImpl();
		loginMain=new JPanel(null){
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub/CurrCommLease2/images/jpanel/主背景.jpg
				
			
			}
		};
		jcbType=new JComboBox();
		lblType=new JLabel("类别：");
		lblName=new JLabel("用户名：");
		lblPwd=new JLabel("密   码：");
		txtName=new JTextField();
		txtPwd=new JPasswordField();
		btnLogin=new JButton();
		btnExit=new JButton();
        lblvalidateCode=new  JLabel("验证码：");
		lbl_validateCode=new JLabel("")
		{
			
			public void paint(Graphics g) {
				
				ValidateCode  vc=ValidateCodeBuilder.drawValidateCode(80, 25, 4);
				currentValidateCode=vc.getValidateCodeString();
				g.drawImage(vc.getBufferedImage(), 0,0,this);
			}
			
		};
		lbl_validateCode.addMouseListener(new java.awt.event.MouseAdapter() {

		
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getButton() ==java.awt.event.MouseEvent.BUTTON1 && e.getClickCount() == 1)
				{
					lbl_validateCode.repaint();
				}
			}
			
		});
		
		
		jcbType.addItem("管理员");
		jcbType.addItem("普通用户");
		

		txt_validateCode=new JTextField();
		txt_validateCode.addFocusListener(new FocusAdapter() {

			
			public void focusLost(FocusEvent e) {
				String code=txt_validateCode.getText();
				if(!code.isEmpty())
				{
					if(!code.equalsIgnoreCase(currentValidateCode))
					{
						txt_validateCode.setText("");
						lblprompt.setFont(new Font("",Font.ITALIC,10));
						lblprompt.setText("验证码有误，请重新输入");
						lbl_validateCode.repaint();
					}
				}
			}
			
			
		});
		lblprompt=new JLabel("");
		init();
	}
	private void init() {
		
		
		progressPanel = new ProgressPanel();
		progressPanel.setBounds(180, 250, 300, 200);
		progressPanel.setVisible(false);
		this.add(progressPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(690, 457);
		btnLogin.setIcon(new ImageIcon("images/login\\SignIn.png"));
		btnLogin.setText("登录");
		btnLogin.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			btnlogin_MouseAction(e);
		}});
		btnExit.setIcon(new ImageIcon("images/login\\signOut.png"));
		btnExit.setText("退出");
		btnExit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				LoginView.this.dispose();
			}
			
		});

		
		btnLogin.setBounds(175, 280, 107, 30);
		btnExit.setBounds(385, 280, 107, 30);
		lblName.setBounds(198,122,60,25);
		lblPwd.setBounds(198,157,60,25);
		lblType.setBounds(198, 220, 60, 25);
		jcbType.setBounds(258, 220, 80, 25);
		txtName.setBounds(258,122,155,25);
		txtPwd.setBounds(258,157,155,25);
		lblvalidateCode.setBounds(198, 185, 60, 25);
		txt_validateCode.setBounds(258, 185, 100, 25);
		lbl_validateCode.setBounds(385, 185, 80, 25);
		lblprompt.setBounds(480, 185, 180, 20);
		
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
		loginMain.add(lblType);
		loginMain.add(jcbType);
		this.add(loginMain);
		
		processWork.start();
		
		
		this.setVisible(true);
		
		Globel.centerByWindow(this);
		
		//btnLogin.addActionListener(new LogionFrame_btnLogin_ActionListener(this));
		//btnExit.addActionListener(new LogionFrame_btnExit_ActionListener(this));
}
	protected void btnlogin_MouseAction(MouseEvent e) {
		String type=(String)jcbType.getSelectedItem();
		name=(String)txtName.getText().trim();
		pwd=(String)txtPwd.getText().trim();
		OpeUser oper=new OpeUser();
		if(txt_validateCode.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null, "验证码有误，请重新输入！");
		       return;
		}	
		if(type.equals("管理员"))
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						EventQueue.invokeLater(new Runnable() {
							public void run() {

								new Thread() {
									public void run() {
										progressPanel.setVisible(true);
										loginMain.setVisible(false);
										HibernateSessionFactory.getSession();
										isOver = true;
										List<OpeUser> user=Opdao.queryAll();
									    Loginservice ls=new Loginservice();
										if(ls.isExixt(name, pwd))
										{
											try {
												
												LoginView.this.dispose();
												 PublicDate.setOuser(ls.selectByNameAndPwd(name, pwd));//把登录用户存入
												 MainFrame mainFrame =new MainFrame();
													mainFrame.setResizable(false);
													mainFrame.SystemTrayInitial();// 初始化系统栏
											   LoginView.this.dispose();
											} catch (MalformedURLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}else
										{
											progressPanel.setVisible(false);
											loginMain.setVisible(true);
											LoginView.this.repaint();
											JOptionPane.showMessageDialog(null, "账号或密码有误，请重新输入！");
										}
									};
								}.start();

							}
						});

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		
	}
	public JLabel getLblvalidateCode() {
		return lblvalidateCode;
	}
	public void setLblvalidateCode(JLabel lblvalidateCode) {
		this.lblvalidateCode = lblvalidateCode;
	}
	public JLabel getLblType() {
		return lblType;
	}
	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}
	public JTextField getTxt_validateCode() {
		return txt_validateCode;
	}
	public void setTxt_validateCode(JTextField txt_validateCode) {
		this.txt_validateCode = txt_validateCode;
	}
	public JLabel getLblprompt() {
		return lblprompt;
	}
	public void setLblprompt(JLabel lblprompt) {
		this.lblprompt = lblprompt;
	}
	public static String getCurrentValidateCode() {
		return currentValidateCode;
	}
	public static void setCurrentValidateCode(String currentValidateCode) {
		LoginView.currentValidateCode = currentValidateCode;
	}
	public JComboBox getJcbType() {
		return jcbType;
	}
	public void setJcbType(JComboBox jcbType) {
		this.jcbType = jcbType;
	}
	public JLabel getLbl_validateCode() {
		return lbl_validateCode;
	}
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
	
	public  static void main(String [] args)
	{

		 try {
			 
//			 com.jgoodies.looks.windows.WindowsLookAndFeel
//			 com.jgoodies.looks.plastic.PlasticLookAndFeel
//			 com.jgoodies.looks.plastic.Plastic3DLookAndFeel
//			 com.jgoodies.looks.plastic.PlasticXPLookAndFeel
		      UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
		   } catch (Exception e) {}
		new LoginView().setVisible(true);
	}
}
