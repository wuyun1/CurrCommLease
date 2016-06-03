package com.CCL.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.CCL.model.MTree_fuzhuang;
import com.CCL.model.MTree_zixingche;
import com.CCL.mwing.MJLable;
import com.CCL.panel.BGPanel;
import com.CCL.panel.CalenderPanel;
import com.CCL.panel.Clockpael;
import com.CCL.panel.GlassButton;
import com.CCL.panel.MPanel;
import com.CCL.panel.MemberManagePanel;
import com.CCL.panel.ProgressPanel;
import com.CCL.panel.SmallScrollPanel;

public class MainFrame extends JFrame {
	private final static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20;
	private final static int HEIGTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 80;

	private JSplitPane SpaneA, SpaneA2;
	private JPanel paneA1, paneA2, paneA2a, paneA2b;

	private JSplitPane SpaneA2a;
	private JPanel paneA2a1, paneA2a2;// paneA2a2������

	private JSplitPane SpaneA2a1; // �ű��״̬
	private JPanel paneA2a1a, paneA2a1b;

	private SmallScrollPanel smallPanel;// �ƶ����
	/////////////////////////////////////////////////
	private BGPanel backPanel;
	JLabel fristLabel = new JLabel("");
	private SmallScrollPanel moduleButtonGroup = null;
	private BGPanel jPanel = null;
	private ButtonGroup buttonGroup = null;
	private GlassButton qichebtn = null;
	private GlassButton fangzibtn = null;
	private GlassButton fuzhuangbtn = null;
	private GlassButton bookspaceButton = null;
	private GlassButton zixingchebtn = null;
	private GlassButton dianzishebeibtn = null;
	private GlassButton jianzugongjubtn = null;
	JPanel panel_1;
	JPanel panel;
	final JPanel sellPanel = new JPanel();
	private JTree zixingchetree, fuzhuangtree;
	JLabel label_1 = new JLabel("����ǰ��λ����:");
	///////////////////////////////////////////

	public MainFrame() throws MalformedURLException {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setBounds(0, 0, WIDTH, HEIGTH);
		// this.setIconImage(new
		// ImageIcon("image/ImageDialog.png").getImage());//���ô������Ͻ�ͼ��
		initCom();
		initAction();

		this.setVisible(true);

	}

	private void initCom() throws MalformedURLException {

		panel_1 = new JPanel();
		panel_1.setLayout(null);

		paneA1 = new JPanel();
		paneA1.setLayout(null);
		paneA1.setSize(500, 100);

		MJLable titleImage = new MJLable("images/jpanel/calendar.jpg", 263, 90);
		titleImage.setBounds(0, 0, 293, 90);

		MJLable ImageR = new MJLable("images/jpanel/����1.gif", 383, 90);
		ImageR.setBounds(700, 5, 383, 90);

		smallPanel = new SmallScrollPanel();// "images/jpanel/������.jpg");
		smallPanel.setBounds(328, 10, 363, 69);
		paneA1.add(ImageR);
		paneA1.add(titleImage);
		/////////////////
		paneA1.add(getModuleButtonGroup());
		paneA2 = new JPanel();

		paneA2a = new JPanel();
		paneA2b = new JPanel();
		// ������½����
		paneA2b.setLayout(null);
		backPanel = getZixingCheContentPanel("");

		paneA2a1 = new JPanel();
		paneA2a2 = new JPanel();

		paneA2a1b = new MPanel("images/jpanel/caltitle.jpg");// ��ã�***�ѵ�¼

		SpaneA = new JSplitPane();
		SpaneA2 = new JSplitPane();
		SpaneA2a = new JSplitPane();
		SpaneA2a1 = new JSplitPane();

		// ��������SpaneA2a1a��ӱ�
		Clockpael cp = new Clockpael(-47, -50);
		// �ű�
		SpaneA2a1.setOneTouchExpandable(true);// �Ƿָ����ķָ�����ʾ����ͷ
		SpaneA2a1.setContinuousLayout(true);
		SpaneA2a1.setPreferredSize(new Dimension(WIDTH, HEIGTH));
		SpaneA2a1.setLeftComponent(cp);
		SpaneA2a1.setRightComponent(paneA2a1b);
		SpaneA2a1.setOrientation(JSplitPane.VERTICAL_SPLIT);// ����Ϊˮƽ�ָ�
		SpaneA2a1.setDividerSize(3);// ���÷ָ�����С
		SpaneA2a1.setDividerLocation(290);
		SpaneA2a1.setEnabled(false);// ���÷ָ��߲����ƶ�

		// ��������SpaneA2a�������
		JLabel label = new JLabel();
		// label.setBounds(70, 10, 80,90);
		CalenderPanel CalPanel = new CalenderPanel(label);
		String info = "<html><body><font color=#FFFFFF>�� �ã�</font><font color=yellow><b>" + "admin" + "</b></font>"
				+ "<font color=#FFFFFF>                �� ӭ �� ¼</font>" + "</body></html>";
		JLabel labeltip = new JLabel(info);
		labeltip.setBackground(Color.yellow);
		labeltip.setBounds(45, 210, 128, 35);
		paneA2a1b.add(labeltip);
		/////////////////////
		// ������
		SpaneA2a.setOneTouchExpandable(true);// �Ƿָ����ķָ�����ʾ����ͷ
		SpaneA2a.setContinuousLayout(true);
		SpaneA2a.setPreferredSize(new Dimension(WIDTH, HEIGTH));
		SpaneA2a.setLeftComponent(SpaneA2a1);
		SpaneA2a.setRightComponent(CalPanel);
		SpaneA2a.setOrientation(JSplitPane.VERTICAL_SPLIT);// ����Ϊˮƽ�ָ�
		SpaneA2a.setDividerSize(3);// ���÷ָ�����С
		SpaneA2a.setDividerLocation(340);
		SpaneA2a.setEnabled(false);// ���÷ָ��߲����ƶ�

		SpaneA2.setOneTouchExpandable(true);// �Ƿָ����ķָ�����ʾ����ͷ
		SpaneA2.setContinuousLayout(true);
		SpaneA2.setOrientation(JSplitPane.HORIZONTAL_SPLIT);// ����Ϊˮƽ�ָ�
		SpaneA2.setDividerSize(3);// ���÷ָ�����С
		SpaneA2.setDividerLocation(263);
		SpaneA2.setLeftComponent(SpaneA2a);
		SpaneA2.setRightComponent(paneA2b);////////// �ǵ��޸�paneA2bΪjsplitpane
		SpaneA2.setEnabled(false);// ���÷ָ��߲����ƶ�

		SpaneA.setOneTouchExpandable(true);// �Ƿָ����ķָ�����ʾ����ͷ
		SpaneA.setContinuousLayout(true);
		SpaneA.setPreferredSize(new Dimension(WIDTH, HEIGTH));
		SpaneA.setLeftComponent(paneA1);
		SpaneA.setRightComponent(SpaneA2);
		SpaneA.setOrientation(JSplitPane.VERTICAL_SPLIT);// ����Ϊˮƽ�ָ�
		SpaneA.setDividerSize(3);// ���÷ָ�����С
		SpaneA.setDividerLocation(90);
		SpaneA.setEnabled(false);// ���÷ָ��߲����ƶ�

		this.setContentPane(SpaneA);
		this.pack();
	}

	private void initAction() {

	}

	private SmallScrollPanel getModuleButtonGroup() {
		if (this.moduleButtonGroup == null) {
			this.moduleButtonGroup = new SmallScrollPanel();
			this.moduleButtonGroup.setBounds(290, 10, 334, 68);// �����ƶ����λ��
			this.moduleButtonGroup.setOpaque(false);

			this.moduleButtonGroup.setViewportView(getJPanel());
			this.moduleButtonGroup.getAlphaScrollPanel().setViewportView(getJPanel());
		}
		return this.moduleButtonGroup;
	}

	// paneA2b���½����
	private BGPanel getZixingCheContentPanel(String title) {

		this.backPanel = new BGPanel();
		backPanel.setName(title);
		this.backPanel.setBackground(Color.BLUE);// new Color(71, 201, 223));
		this.backPanel.setSize(1079, 595);// �������½����paneA2bλ��
		this.backPanel.setLocation(10, 10);
		this.backPanel.setLayout(null);

		this.label_1.setHorizontalAlignment(4);
		this.label_1.setVerticalAlignment(3);
		this.label_1.setBounds(38, 38, 96, 15);// ����jlable���㵱ǰ��λ�ã���
		this.backPanel.setBorder(BorderFactory.createTitledBorder(null, title, 0, 2, new Font("sansserif", 1, 12),
				new Color(59, 59, 59)));
		this.backPanel.add(this.label_1);
		this.fristLabel.setBounds(133, 38, 123, 15);
		this.backPanel.add(this.fristLabel);

		sellPanel.setBounds(148, 63, 920, 520);
		// sellPanel.setBackground(Color.yellow);//new Color(71, 201, 223));

		sellPanel.setLayout(null);
		this.backPanel.add(sellPanel);
		this.backPanel.add(getZiXingCheTree());

		return this.backPanel;
	}

	public JPanel getZiXingCheTree() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.red);
		panel.setBounds(5, 62, 138, 520);

		JScrollPane scrollPane_1 = new JScrollPane();
		// scrollPane_1.setBackground(Color.yellow );
		scrollPane_1.setBounds(0, 0, 138, 520);

		MTree_zixingche zixingche = new MTree_zixingche();
		this.zixingchetree = zixingche.getTree();// ������г�tree
		scrollPane_1.setColumnHeaderView(this.zixingchetree);
		this.panel.add(scrollPane_1);

		this.zixingchetree.getSelectionModel().setSelectionMode(1);
		TreeSelectionModel treeSelectionModel = this.zixingchetree.getSelectionModel();
		treeSelectionModel.setSelectionMode(2);
		this.zixingchetree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (!MainFrame.this.zixingchetree.isSelectionEmpty()) {
					TreePath selectionPaths = MainFrame.this.zixingchetree.getSelectionPath();
					Object path = selectionPaths.getLastPathComponent();
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) path;
					String userObject = (String) node.getUserObject();
					MainFrame.this.repaint();
					if (userObject.equals("���г�")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						// sellPanel.add(new ProgressPanel());
					} else if (userObject.equals("ǰ̨��������")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());// ����ӹ��ܴ��ڣ��滻new
															// ProgressPanel()��
					} else if (userObject.equals("��Ա������")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.setLayout(null);
						sellPanel.removeAll();
						MemberManagePanel memberManagePanel = new MemberManagePanel();// ����ӹ��ܴ��ڣ��滻new
																						// ProgressPanel()��
						memberManagePanel.setBounds(10, 11, 700, 500);
						sellPanel.add(memberManagePanel);
						// MainFrame.this.repaint();
					} else if (userObject.equals("ϵͳ����")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());// ����ӹ��ܴ��ڣ��滻new
															// ProgressPanel()��
					} else if (userObject.equals("ϵͳά��")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());// ����ӹ��ܴ��ڣ��滻new
															// ProgressPanel()��
						// MainFrame.this.repaint();
					} else if (userObject.equals("����")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());
						MainFrame.this.repaint();
					}
				}
			}
		});
		return panel;
	}

	private BGPanel getFuZhuangContentPanel(String title) {
		this.backPanel = new BGPanel();
		backPanel.setName(title);
		this.backPanel.setBackground(Color.BLUE);// new Color(71, 201, 223));
		this.backPanel.setSize(1079, 595);// �������½����paneA2bλ��
		this.backPanel.setLocation(10, 10);
		this.backPanel.setLayout(null);

		this.label_1.setHorizontalAlignment(4);
		this.label_1.setVerticalAlignment(3);
		this.label_1.setBounds(38, 38, 96, 15);// ����jlable���㵱ǰ��λ�ã���
		this.backPanel.setBorder(BorderFactory.createTitledBorder(null, title, 0, 2, new Font("sansserif", 1, 12),
				new Color(59, 59, 59)));
		this.backPanel.add(this.label_1);
		this.fristLabel.setBounds(133, 38, 123, 15);
		this.backPanel.add(this.fristLabel);

		sellPanel.setBounds(148, 63, 920, 520);
		sellPanel.setBackground(Color.yellow);// new Color(71, 201, 223));

		sellPanel.setLayout(null);
		this.backPanel.add(sellPanel);
		this.backPanel.add(getFuZhuangTree());

		return this.backPanel;
	}

	private JPanel getFuZhuangTree() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.red);
		panel.setBounds(5, 62, 138, 520);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.yellow);
		scrollPane_1.setBounds(0, 0, 138, 520);
		MTree_fuzhuang fuzhuang = new MTree_fuzhuang();
		this.fuzhuangtree = fuzhuang.getTree();
		scrollPane_1.setColumnHeaderView(this.fuzhuangtree);
		this.panel.add(scrollPane_1);

		this.fuzhuangtree.getSelectionModel().setSelectionMode(1);
		TreeSelectionModel treeSelectionModel = this.fuzhuangtree.getSelectionModel();
		treeSelectionModel.setSelectionMode(2);
		this.fuzhuangtree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (!MainFrame.this.fuzhuangtree.isSelectionEmpty()) {
					TreePath selectionPaths = MainFrame.this.fuzhuangtree.getSelectionPath();
					Object path = selectionPaths.getLastPathComponent();
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) path;
					String userObject = (String) node.getUserObject();
					MainFrame.this.repaint();
					if (userObject.equals("1����")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						// sellPanel.add(new ProgressPanel());
					} else if (userObject.equals("2����")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());
					} else if (userObject.equals("3����")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.setLayout(null);
						sellPanel.removeAll();
						MemberManagePanel memberManagePanel = new MemberManagePanel();
						memberManagePanel.setBounds(10, 11, 700, 500);
						sellPanel.add(memberManagePanel);
					} else if (userObject.equals("����")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());
					} else if (userObject.equals("ϵͳά��")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());
						// MainFrame.this.repaint();
					} else if (userObject.equals("����")) {
						MainFrame.this.fristLabel.setText(userObject);
						sellPanel.removeAll();
						sellPanel.add(new ProgressPanel());
						MainFrame.this.repaint();
					}
				}
			}
		});
		return panel;
	}

	public BGPanel getJPanel() {
		if (this.jPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setHgap(0);
			gridLayout.setVgap(5);
			this.jPanel = new BGPanel();

			this.jPanel.setLayout(gridLayout);

			this.jPanel.setPreferredSize(new Dimension(400, 50));
			this.jPanel.setOpaque(false);
			// �Ѱ�ť���뵽�ƶ����
			this.jPanel.add(getQiCheBtn(), null);
			this.jPanel.add(getFangZiBtn(), null);
			this.jPanel.add(getFuZhuangBtn(), null);
			this.jPanel.add(getZiXingCheBtn(), null);
			this.jPanel.add(getDianZiSheBeiBtn(), null);
			this.jPanel.add(getJianZuGongJuBtn(), null);
			this.jPanel.add(getBookspaceButton(), null);
			if (this.buttonGroup == null) {
				this.buttonGroup = new ButtonGroup();
			}
			this.buttonGroup.add(getFangZiBtn());
			this.buttonGroup.add(getQiCheBtn());
			this.buttonGroup.add(getFuZhuangBtn());
			this.buttonGroup.add(getZiXingCheBtn());
			this.buttonGroup.add(getDianZiSheBeiBtn());
			this.buttonGroup.add(getJianZuGongJuBtn());
			this.buttonGroup.add(getBookspaceButton());
		}
		return this.jPanel;
	}

	private GlassButton getQiCheBtn() {
		if (this.qichebtn == null) {
			this.qichebtn = new GlassButton();
			this.qichebtn.setActionCommand("����");
			this.qichebtn.setIcon(new ImageIcon("images/MJBtn/��.png"));
			ImageIcon icon = new ImageIcon("images/MJBtn/��.png");
			this.qichebtn.setRolloverIcon(icon);
			this.qichebtn.setSelectedIcon(icon);
			this.qichebtn.setSelected(true);
			this.qichebtn.addActionListener(new toolsButtonActionAdapter());
		}
		return this.qichebtn;
	}

	private GlassButton getFangZiBtn() {
		if (this.fangzibtn == null) {
			this.fangzibtn = new GlassButton();
			this.fangzibtn.setActionCommand("����");
			this.fangzibtn.setIcon(new ImageIcon("images/MJBtn/����.png"));
			ImageIcon icon = new ImageIcon("images/MJBtn/����.png");
			this.fangzibtn.setRolloverIcon(icon);
			this.fangzibtn.setSelectedIcon(icon);
			this.fangzibtn.addActionListener(new toolsButtonActionAdapter());
		}
		return this.fangzibtn;
	}

	private GlassButton getFuZhuangBtn() {
		if (this.fuzhuangbtn == null) {
			this.fuzhuangbtn = new GlassButton();
			this.fuzhuangbtn.setActionCommand("��װ");
			ImageIcon icon = new ImageIcon("images/MJBtn/��װ.png");
			this.fuzhuangbtn.setSelectedIcon(icon);
			this.fuzhuangbtn.setRolloverIcon(icon);
			this.fuzhuangbtn.setIcon(new ImageIcon("images/MJBtn/��װ.png"));
			this.fuzhuangbtn.addActionListener(new toolsButtonActionAdapter());
		}
		return this.fuzhuangbtn;
	}

	private GlassButton getZiXingCheBtn() {
		if (this.zixingchebtn == null) {
			this.zixingchebtn = new GlassButton();
			this.zixingchebtn.setActionCommand("���г�");
			ImageIcon icon = new ImageIcon("images/MJBtn/���г�.png");
			this.zixingchebtn.setSelectedIcon(icon);
			this.zixingchebtn.setRolloverIcon(icon);
			this.zixingchebtn.setIcon(new ImageIcon("images/MJBtn/���г�.png"));
			this.zixingchebtn.addActionListener(new toolsButtonActionAdapter());
		}
		return this.zixingchebtn;
	}

	private GlassButton getBookspaceButton() {
		if (this.bookspaceButton == null) {
			this.bookspaceButton = new GlassButton();

			this.bookspaceButton.setActionCommand("�鼮");

			ImageIcon imageIcon = new ImageIcon("images/MJBtn/�鼮.png");
			this.bookspaceButton.setIcon(imageIcon);
			ImageIcon icon = new ImageIcon("images/MJBtn/�鼮.png");
			this.bookspaceButton.setRolloverIcon(icon);
			this.bookspaceButton.setSelectedIcon(icon);
			this.bookspaceButton.setFocusPainted(false);
			this.bookspaceButton.addActionListener(new toolsButtonActionAdapter());
		}
		return this.bookspaceButton;
	}

	private GlassButton getDianZiSheBeiBtn() {
		if (this.dianzishebeibtn == null) {
			this.dianzishebeibtn = new GlassButton();

			this.dianzishebeibtn.setActionCommand("�����豸");

			ImageIcon imageIcon = new ImageIcon("images/MJBtn/�����豸.png");
			this.dianzishebeibtn.setIcon(imageIcon);
			ImageIcon icon = new ImageIcon("images/MJBtn/�����豸.png");
			this.dianzishebeibtn.setRolloverIcon(icon);
			this.dianzishebeibtn.setSelectedIcon(icon);
			this.dianzishebeibtn.setFocusPainted(false);
			this.dianzishebeibtn.addActionListener(new toolsButtonActionAdapter());
		}
		return this.dianzishebeibtn;
	}

	private GlassButton getJianZuGongJuBtn() {
		if (this.jianzugongjubtn == null) {
			this.jianzugongjubtn = new GlassButton();

			this.jianzugongjubtn.setActionCommand("��������");

			ImageIcon imageIcon = new ImageIcon("images/MJBtn/��������.png");
			this.jianzugongjubtn.setIcon(imageIcon);
			ImageIcon icon = new ImageIcon("images/MJBtn/��������.png");
			this.jianzugongjubtn.setRolloverIcon(icon);
			this.jianzugongjubtn.setSelectedIcon(icon);
			this.jianzugongjubtn.setFocusPainted(false);
			this.jianzugongjubtn.addActionListener(new toolsButtonActionAdapter());
		}
		return this.jianzugongjubtn;
	}

	// ƽ����尴ť������
	class toolsButtonActionAdapter implements ActionListener {
		toolsButtonActionAdapter() {
		}

		public void actionPerformed(ActionEvent e) {
			String backpaneltitle = e.getActionCommand();
			if (e.getSource() == MainFrame.this.qichebtn) {
				MainFrame.this.backPanel.removeAll();
				MainFrame.this.sellPanel.removeAll();
				MainFrame.this.backPanel.add(MainFrame.this.label_1);
				MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
				MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
				MainFrame.this.panel_1.setBounds(10, 63, 611, 376);
				MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));

				MainFrame.this.fristLabel.setText(backpaneltitle);
				MainFrame.this.repaint();
			}
			if (e.getSource() == MainFrame.this.fangzibtn) {
				MainFrame.this.backPanel.removeAll();
				MainFrame.this.sellPanel.removeAll();
				MainFrame.this.backPanel.add(MainFrame.this.label_1);
				MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
				MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
				MainFrame.this.panel_1.setBounds(10, 63, 611, 386);

				MainFrame.this.fristLabel.setText(backpaneltitle);
				// ���¼���Ҫ��ʾ�����
				MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));
				MainFrame.this.repaint();
			}
			if (e.getSource() == MainFrame.this.fuzhuangbtn) {
				if (!backPanel.getName().equals("��װ")) {
					MainFrame.this.paneA2b.removeAll();
					MainFrame.this.sellPanel.removeAll();
					MainFrame.this.backPanel.add(MainFrame.this.label_1);
					MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
					MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
					MainFrame.this.paneA2b.add(getFuZhuangContentPanel("��װ"));// ���¼���Ҫ��ʾ�����y
					MainFrame.this.fristLabel.setText(backpaneltitle);
					MainFrame.this.repaint();
				}
			}
			if (e.getSource() == MainFrame.this.zixingchebtn) {
				if (!backPanel.getName().equals("���г�")) {
					MainFrame.this.paneA2b.removeAll();
					MainFrame.this.sellPanel.removeAll();
					MainFrame.this.backPanel.add(MainFrame.this.label_1);
					MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
					MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
					MainFrame.this.paneA2b.add(getZixingCheContentPanel("���г�"));// ���¼���Ҫ��ʾ�����y
					MainFrame.this.fristLabel.setText(backpaneltitle);
					MainFrame.this.repaint();
				}
			}
			if (e.getSource() == MainFrame.this.bookspaceButton) {
				MainFrame.this.backPanel.removeAll();
				MainFrame.this.backPanel.add(MainFrame.this.label_1);
				MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
				MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
				MainFrame.this.panel_1.setBounds(10, 63, 611, 386);

				MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));// ���¼���Ҫ��ʾ�����
				MainFrame.this.fristLabel.setText(backpaneltitle);
				MainFrame.this.repaint();

			}
			if (e.getSource() == MainFrame.this.dianzishebeibtn) {
				MainFrame.this.backPanel.removeAll();
				MainFrame.this.backPanel.add(MainFrame.this.label_1);
				MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
				MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
				MainFrame.this.panel_1.setBounds(10, 63, 611, 386);

				MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));// ���¼���Ҫ��ʾ�����
				MainFrame.this.fristLabel.setText(backpaneltitle);
				MainFrame.this.repaint();
			}
			if (e.getSource() == MainFrame.this.jianzugongjubtn) {
				MainFrame.this.backPanel.removeAll();
				MainFrame.this.backPanel.add(MainFrame.this.label_1);
				MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
				MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
				MainFrame.this.panel_1.setBounds(10, 63, 611, 386);

				MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));// ���¼���Ҫ��ʾ�����
				MainFrame.this.fristLabel.setText(backpaneltitle);
				MainFrame.this.repaint();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new MainFrame();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
