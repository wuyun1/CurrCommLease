package com.CCL.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import sun.misc.Resource;

import com.CCL.model.MTree_fuzhuang;
import com.CCL.model.MTree_zixingche;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.MButton;
import com.CCL.panel.BGPanel;
import com.CCL.panel.CalenderPanel;
import com.CCL.panel.Clockpael;
import com.CCL.panel.GlassButton;
import com.CCL.panel.MPanel;
import com.CCL.panel.MemberManagePanel;
import com.CCL.panel.ProgressPanel;
import com.CCL.panel.SmallScrollPanel;
import com.CCL.panel.glj.AddPanel;
import com.CCL.panel.glj.MenuPanel;
import com.CCL.panel.glj.RiYinYeSelect;
import com.CCL.panel.glj.ShouFeiSet;
import com.CCL.panel.glj.ZheKouSet;
import com.CCL.panel.mlf.Panel_setvehicle;
import com.CCL.view.huiyuan.VipManager;
import com.CCL.view.kaitaimgr.KaiTaiMgr;
import com.CCL.view.other.OtherManager;


public class MainFrame extends JFrame {
	private final static int WIDTH=1366;//(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20;
	private final static int HEIGTH=748;//(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-80;
	
	private JSplitPane SpaneA,SpaneA2;
	private JPanel paneA1,paneA2,paneA2a,paneA2b;
	
	private JSplitPane SpaneA2a;
	private JPanel paneA2a1,paneA2a2;//  paneA2a2������
	
	private JSplitPane SpaneA2a1;  //�ű��״̬
	private JPanel paneA2a1a,paneA2a1b;
	
	private String whoShown;
	
	public JPanel getSellPanel() {
		return sellPanel;
	}

	public static TrayIcon trayicon;
	private SmallScrollPanel smallPanel;//�ƶ����
	/////////////////////////////////////////////////
	private BGPanel backPanel;
	private JLabel fristLabel = new JLabel("");
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
	private JPanel panel_1;
	private  JPanel panel;
	private final JPanel sellPanel = new JPanel();
	private MButton btn_exit,btn_zuida,btn_help;
	
	private MenuPanel menuPanel;
	private JFrame frame ;
	 private JTree zixingchetree,fuzhuangtree;
	 private JLabel label_1 = new JLabel("����ǰ��λ����:");
	///////////////////////////////////////////
	
	public MainFrame() throws MalformedURLException
	{
		this.setName("������");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setBounds(0, 0, WIDTH, HEIGTH);
		//this.setIconImage(new ImageIcon("image/ImageDialog.png").getImage());//���ô������Ͻ�ͼ��
		initCom();
		initAction();
		
		this.setVisible(true);
		
	}

	private void initCom() throws MalformedURLException {
		
		whoShown = "������";
		
		 panel_1 = new JPanel();
		    panel_1.setLayout(null);
		
		paneA1 = new MPanel("images/����up.jpg");
		paneA1.setLayout(null);
		paneA1.setSize(500, 100);
		
		MJLable titleImage = new MJLable("images/jpanel/calendar.jpg", 263, 90);
		titleImage.setBounds(0, 0, 293, 90);
		
		MJLable ImageR = new MJLable("images/����up_r_lbl.gif", 350, 90);
		ImageR.setBounds(1000, 0, 383, 90);
		
		smallPanel = new SmallScrollPanel();//"images/jpanel/������.jpg");
		smallPanel.setBounds(328, 10, 363, 69);
		
		paneA1.add(ImageR);
//		paneA1.add(titleImage);
		/////////////////
		paneA1.add(getModuleButtonGroup());
		paneA2 = new JPanel();
		
		paneA2a = new JPanel();
		paneA2b = new MPanel("images/����down.jpg");/////////////////////////////////////////////////////////
		MJLable mainR = new MJLable("images/beijin_r_lbl_end.gif", 300, 300);
		mainR.setBounds(780, 340, 300, 300);
		paneA2b.add(mainR);
		
		//������½����
		paneA2b.setLayout(null);
		backPanel=getZixingCheContentPanel("",this);
		paneA2a1 = new JPanel();
		paneA2a2 = new JPanel();
		
		paneA2a1b = new MPanel("images/jpanel/caltitle.jpg");// ��ã�***�ѵ�¼
		
		SpaneA = new JSplitPane();
		SpaneA2 = new JSplitPane();
		SpaneA2a = new JSplitPane();
		SpaneA2a1 = new JSplitPane();
		
		//��������SpaneA2a1a��ӱ�
		Clockpael cp=new Clockpael(-47,-50);
		//�ű�
		SpaneA2a1.setOneTouchExpandable(true);//�Ƿָ����ķָ�����ʾ����ͷ
		SpaneA2a1.setContinuousLayout(true);
		SpaneA2a1.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		SpaneA2a1.setLeftComponent(cp);
		SpaneA2a1.setRightComponent(paneA2a1b);
		SpaneA2a1.setOrientation(JSplitPane.VERTICAL_SPLIT);//����Ϊˮƽ�ָ�
		SpaneA2a1.setDividerSize(3);//���÷ָ�����С
		SpaneA2a1.setDividerLocation(290);
		SpaneA2a1.setEnabled(false);//���÷ָ��߲����ƶ�
		
		//��������SpaneA2a�������
		JLabel label = new JLabel();
        //label.setBounds(70, 10, 80,90);
        CalenderPanel CalPanel = new CalenderPanel(label);
        String info = "<html><body><font color=#FFFFFF>�� �ã�</font><font color=yellow><b>" + 
        	      "admin" + "</b></font>" + 
        	      "<font color=#FFFFFF>                �� ӭ �� ¼</font>" + "</body></html>";
	    JLabel labeltip = new JLabel(info);
	    labeltip.setBackground(Color.yellow);
	    labeltip.setBounds(45, 210, 128, 35);
	    paneA2a1b.add(labeltip);
        /////////////////////
        //������
		SpaneA2a.setOneTouchExpandable(true);//�Ƿָ����ķָ�����ʾ����ͷ
		SpaneA2a.setContinuousLayout(true);
		SpaneA2a.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		SpaneA2a.setLeftComponent(SpaneA2a1);
		SpaneA2a.setRightComponent(CalPanel);
		SpaneA2a.setOrientation(JSplitPane.VERTICAL_SPLIT);//����Ϊˮƽ�ָ�
		SpaneA2a.setDividerSize(3);//���÷ָ�����С
		SpaneA2a.setDividerLocation(340);
		SpaneA2a.setEnabled(false);//���÷ָ��߲����ƶ�
		
		SpaneA2.setOneTouchExpandable(true);//�Ƿָ����ķָ�����ʾ����ͷ
		SpaneA2.setContinuousLayout(true);
		SpaneA2.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//����Ϊˮƽ�ָ�
		SpaneA2.setDividerSize(3);//���÷ָ�����С
		SpaneA2.setDividerLocation(263);
		SpaneA2.setLeftComponent(SpaneA2a);
		SpaneA2.setRightComponent(paneA2b);//////////�ǵ��޸�paneA2bΪjsplitpane
		SpaneA2.setEnabled(false);//���÷ָ��߲����ƶ�
		
		SpaneA.setOneTouchExpandable(true);//�Ƿָ����ķָ�����ʾ����ͷ
		SpaneA.setContinuousLayout(true);
		SpaneA.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		SpaneA.setLeftComponent(paneA1);
		SpaneA.setRightComponent(SpaneA2);
		SpaneA.setOrientation(JSplitPane.VERTICAL_SPLIT);//����Ϊˮƽ�ָ�
		SpaneA.setDividerSize(3);//���÷ָ�����С
		SpaneA.setDividerLocation(90);
		SpaneA.setEnabled(false);//���÷ָ��߲����ƶ�
		
		this.setContentPane(SpaneA);
		this.pack();
		//����JFrame�����⣻
		this.addWindowListener(new WindowAdapter(){
            //ͼ�껯����ʱ�����¼�
            public void windowIconified(WindowEvent e) {
                dispose(); //������С��ʱdispose�ô���
            }
        });
	}
	
	private void initAction() {
		
	}
	
	private SmallScrollPanel getModuleButtonGroup()
	  {
	    if (this.moduleButtonGroup == null)
	    {
	      this.moduleButtonGroup = new SmallScrollPanel();
	      this.moduleButtonGroup.setBounds(560, 10, 334, 69);//�����ƶ����λ��
	      this.moduleButtonGroup.setOpaque(false);
	      
	      this.moduleButtonGroup.setViewportView(getJPanel());
	      this.moduleButtonGroup.getAlphaScrollPanel()
	        .setViewportView(getJPanel());
	    }
	    return this.moduleButtonGroup;
	  }/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//paneA2b���½����
	private BGPanel getZixingCheContentPanel(String title,JFrame frame)
	  {
	    
	      this.backPanel = new BGPanel();
	      backPanel.setOpaque(false);//���͸��
	      backPanel.setName(title);
	      this.backPanel.setSize(1079,595);//�������½����paneA2bλ��
	      this.backPanel.setLocation(10, 10);
	      this.backPanel.setLayout(null);
	      
	      /////////////////////////////////////////////
	      menuPanel = new MenuPanel("",this);
//	      menuPanel.setVisible(false);
	      this.backPanel.add(menuPanel);
	      
	      btn_help= new MButton("images/glj/ButtonImages/arraw_left1.png");
	      btn_help.setSelectedIcon(new ImageIcon("images/glj/ButtonImages/arraw_left1.png"));
	      btn_help.setRolloverIcon(new ImageIcon("images/glj/ButtonImages/arraw_left2.png"));
	      btn_help.setPressedIcon(new ImageIcon("images/glj/ButtonImages/arraw_left1.png"));
	      if(whoShown.equals("С����"))
			{
	    	  btn_help.setBounds(1046, 15, 24, 24);
			}else{
				btn_help.setBounds(980, 15, 24, 24);
			}
	      btn_help.setBounds(980, 15, 24, 24);
	      btn_help.setToolTipText("����");
	      this.backPanel.add(btn_help);
	      
	      btn_exit= new MButton("images/glj/ButtonImages/close-3.png");
	      btn_exit.setSelectedIcon(new ImageIcon("images/glj/ButtonImages/close-2.png"));
	      btn_exit.setRolloverIcon(new ImageIcon("images/glj/ButtonImages/close-2.png"));
	      btn_exit.setPressedIcon(new ImageIcon("images/glj/ButtonImages/close-3.png"));
	      btn_exit.setBounds(1046, 15, 24, 24);
	      btn_exit.setToolTipText("�ر�");
	      this.backPanel.add(btn_exit);
	      
	      btn_zuida = new MButton("images/glj/ButtonImages/zuida-1.png");
	      btn_zuida.setSelectedIcon(new ImageIcon("images/glj/ButtonImages/zuida-1.png"));
	      btn_zuida.setRolloverIcon(new ImageIcon("images/glj/ButtonImages/zuida-2.png"));
	      btn_zuida.setPressedIcon(new ImageIcon("images/glj/ButtonImages/zuida-2.png"));
	      btn_zuida.setBounds(1015, 15, 24, 24);
	      btn_exit.setToolTipText("������ʾ");
	      this.backPanel.add(btn_zuida);
	      
	      btn_exit.setActionCommand("�ر�");
	      btn_zuida.setActionCommand("���"); 
	      btn_help.setActionCommand("����");
	      btn_help.addActionListener(new ActionListener_btn_exit_zuida(this));
	      btn_exit.addActionListener(new ActionListener_btn_exit_zuida(this));
	      btn_zuida.addActionListener(new ActionListener_btn_exit_zuida(this));
	      
	      this.label_1.setHorizontalAlignment(4);
	      this.label_1.setVerticalAlignment(3);
	      this.label_1.setBounds(38, 38, 96, 15);//����jlable���㵱ǰ��λ�ã���
	      
	      this.backPanel .setBorder(BorderFactory.createTitledBorder(null, title, 0,  2, new Font("sansserif", 1, 12), new Color(59, 59, 59)));
	      this.backPanel.add(this.label_1);
	      this.fristLabel.setBounds(139, 38, 123, 15);
	      this.fristLabel.setFont(new   java.awt.Font("����",   1,   12));   
	      this.fristLabel.setForeground(Color.red);
	      this.backPanel.add(this.fristLabel);
	    
	      sellPanel.setBounds(178, 63, 920, 520);
//	      sellPanel .setBackground(Color.red);//new Color(71, 201, 223));
	      sellPanel.setLayout(null);
	      sellPanel.setOpaque(false);
	      this.backPanel.add(sellPanel);
	      this.backPanel.add(getZiXingCheTree(frame));
	    
	    return this.backPanel;
	  }
	
	class ActionListener_btn_exit_zuida implements ActionListener
	{

		private MainFrame mainFrame;
		
		public ActionListener_btn_exit_zuida(MainFrame mainFrame) {
			this.mainFrame = mainFrame;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			if(command.equals("�ر�"))
			{
				
			}
			else if (command.equals("����"))
			{
				mainFrame.getBtn_help().setVisible(false);
				mainFrame.getMenuPanel().setVisible(true);
			}
			else if (command.equals("���"))
			{
				frame = new JFrame();
				mainFrame.setWhoShown("С����");
				final BGPanel zixingchePanel = getZixingCheContentPanel("���г�",frame);

				frame.setResizable(false);//���ô��岻�ɱ�
				frame.addWindowListener(new WindowAdapter()  
		        {  
		            public void windowClosing(WindowEvent e)  
		            { 
		            	mainFrame.setWhoShown("������");
//		            	MainFrame.this.getBtn_help().setBounds(1046, 15, 24, 24);
		            	MainFrame.this.getBtn_help().setBounds(980, 15, 24, 24);
						MainFrame.this.getMenuPanel().setBounds(779, 7, 240, 40);
						MainFrame.this.getMenuPanel().getBtn_fanhui().setBounds(181, 5, 65, 30);
						MainFrame.this.getMenuPanel().setVisible(true);
						MainFrame.this.getBtn_exit().setVisible(true);
						MainFrame.this.getBtn_zuida().setVisible(true);
		            	new SysTrayActionListener().actionPerformed(e);//����ϵͳ���̵�˫���¼���ʹmainFrame�ظ�ԭʼ״̬
		            	mainFrame.getPaneA2b().removeAll();
		            	mainFrame.getPaneA2b().add(zixingchePanel);
		            	
		            	mainFrame.repaint();
		            }  
		  
		            public void windowClosed(WindowEvent e)  
		            {  
//		                System.out.println("����windowClosed�¼�");  
		            }  
		        });  
				
				
				frame.setName("С����");
				frame.setIconImage(new ImageIcon("images/glj/frametitle.png").getImage());//���ô������Ͻ�ͼ��
				MPanel mianPanel = new MPanel("images/����down1.jpg");
				mainFrame.setExtendedState(JFrame.ICONIFIED);//ʹ��������С��
				
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1123,638);
				mianPanel.setLayout(null);
				

				
				mianPanel.add(zixingchePanel);
				frame.setContentPane(mianPanel);
				
				frame.setVisible(true);
				if(mainFrame.getWhoShown().equals("С����"))
				{
					MainFrame.this.getBtn_help().setBounds(1046, 15, 24, 24);
					MainFrame.this.setVisible(true);
					MainFrame.this.getMenuPanel().setBounds(847, 7, 240, 40);
					MainFrame.this.getBtn_exit().setVisible(false);
					MainFrame.this.getBtn_zuida().setVisible(false);
					frame.repaint();
				}
			}
			
		}
		
	}
	public JPanel getZiXingCheTree(final JFrame frame)
	  {
		final String frame_name = frame.getName();
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(5, 62, 168, 520);
		panel.setOpaque(false);
		 

	      MTree_zixingche zixingche= new MTree_zixingche();
		this.zixingchetree = zixingche.getTree();//������г�tree
//	      scrollPane_1.setColumnHeaderView(this.zixingchetree);
		
		 JScrollPane scrollPane_1 = new JScrollPane(this.zixingchetree);
//		  scrollPane_1.setLayout(null);
		  scrollPane_1.setBounds(0,0, 168, 520);
		  scrollPane_1.setOpaque(false);
	      this.panel.add(scrollPane_1);
	      
	      this.zixingchetree.getSelectionModel().setSelectionMode(1);
	  	      TreeSelectionModel treeSelectionModel = this.zixingchetree.getSelectionModel();
	  	      treeSelectionModel .setSelectionMode(2);
	  	    this.zixingchetree.addTreeSelectionListener(new TreeSelectionListener()
		      {
		        public void valueChanged(TreeSelectionEvent e)
		        {
		          if (!MainFrame.this.zixingchetree.isSelectionEmpty())
		          {
		            TreePath selectionPaths = MainFrame.this.zixingchetree.getSelectionPath();
		            Object path = selectionPaths.getLastPathComponent();
		            DefaultMutableTreeNode node = (DefaultMutableTreeNode)path;
		            String userObject = (String)node.getUserObject();
		            MainFrame.this.repaint();
		            if (userObject.equals("���г�"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		              if(frame_name.equals("С����"))
		            	{
		            	  
		            	 frame.repaint();
		            	}
		            }
		            else if (userObject.equals("ǰ̨��������"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		            	 sellPanel.setLayout(null);
		            	sellPanel.removeAll();
		              KaiTaiMgr kaiTaiPanel= new KaiTaiMgr();
		              kaiTaiPanel.setBounds(0, 0,910, 520);
		              sellPanel.add(kaiTaiPanel);//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		          
		              if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }
		            else if (userObject.equals("��Ա������"))
		            {
		              MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              VipManager vipManager = new VipManager();//                         ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		              vipManager.setBounds(0, 0, 910, 520);
		               sellPanel.add(vipManager);
		          
		               if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }//ϵͳ����������������������������������������������
		            else if (userObject.equals("�շ�����"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              System.out.println("С����r");
		              ShouFeiSet shouFeiSet = new ShouFeiSet("",sellPanel);
		              shouFeiSet.setBounds(0, 0,910, 520);
		             sellPanel.add(shouFeiSet);//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		            
		             System.out.println(frame_name);
		             if(frame_name.equals("С����"))
		            	{
		            	 System.out.println("С����repaaint");
		            	 frame.repaint();
		            	}
		            }
		            else if (userObject.equals("�ۿ�����"))
		            {
		            	
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		             sellPanel.add(new ZheKouSet("images/glj/shoufei/72.jpg"));//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		             
		             if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }else if (userObject.equals("����"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		             sellPanel.add(new ProgressPanel());//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		           
		             if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }//ϵͳ����---�˵�����
		            else if (userObject.equals("��Ӫҵ��ѯ"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		             sellPanel.add(new RiYinYeSelect(""));//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		             if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }else if (userObject.equals("�˵���ϸ"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		             sellPanel.add(new ProgressPanel());//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		            
		             if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }else if (userObject.equals("���۷���"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		             sellPanel.add(new ProgressPanel());//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
		           
		             if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }//ϵͳ����---��������
		            else if (userObject.equals("��������"))
		            { 
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              Panel_setvehicle panel_setvehicle = new Panel_setvehicle();
		              panel_setvehicle.setBounds(0, 0, 800, 500);
		             sellPanel.add(panel_setvehicle);//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
//		             sellPanel.repaint();
		           
		             if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }
		            else if (userObject.equals("ϵͳά��"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              OtherManager otherManager =new OtherManager();
		              otherManager.setBounds(0, 0, 800, 500);
		               sellPanel.add(otherManager);//                                       ����ӹ��ܴ��ڣ��滻new ProgressPanel()��
//		              MainFrame.this.repaint();
		           
		               if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            } else if (userObject.equals("����"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		              sellPanel.add(new ProgressPanel());
		              MainFrame.this.repaint();
		            
		              if(frame_name.equals("С����"))
		            	{
		            	 frame.repaint();
		            	}
		            }
		          }
		        }
		      });
	  	    return panel;
	  }
	private BGPanel getFuZhuangContentPanel(String title)
	  {
	      this.backPanel = new BGPanel();
	      backPanel.setName(title);
	      this.backPanel.setBackground(Color.BLUE);//new Color(71, 201, 223));
	      this.backPanel.setSize(1079,595);//�������½����paneA2bλ��
	      this.backPanel.setLocation(10, 10);
	      this.backPanel.setLayout(null);
	      
	      this.label_1.setHorizontalAlignment(4);
	      this.label_1.setVerticalAlignment(3);
	      this.label_1.setBounds(38, 38, 96, 15);//����jlable���㵱ǰ��λ�ã���
	      this.backPanel .setBorder(BorderFactory.createTitledBorder(null, title, 0,  2, new Font("sansserif", 1, 12), new Color(59, 59, 59)));
	      this.backPanel.add(this.label_1);
	      this.fristLabel.setBounds(133, 38, 123, 15);
	      this.backPanel.add(this.fristLabel);
	    
	      sellPanel.setBounds(148, 63, 920, 520);
	      sellPanel.setBackground(Color.yellow);//new Color(71, 201, 223));
	     
	      sellPanel.setLayout(null);
	      this.backPanel.add(sellPanel);
	      this.backPanel.add(getFuZhuangTree());
	    
	    return this.backPanel;
	  }
	private JPanel getFuZhuangTree()
	{
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.red);
		panel.setBounds(5, 62, 138, 520);
		
		  JScrollPane scrollPane_1 = new JScrollPane();
	      scrollPane_1.setBackground(Color.yellow );
	      scrollPane_1.setBounds(0,0, 138, 520);
	      MTree_fuzhuang fuzhuang = new MTree_fuzhuang();
	      this.fuzhuangtree =fuzhuang.getTree();
	      scrollPane_1.setColumnHeaderView(this.fuzhuangtree);
	      this.panel.add(scrollPane_1);
	      
	      this.fuzhuangtree.getSelectionModel().setSelectionMode(
	  	        1);
	  	      TreeSelectionModel treeSelectionModel = this.fuzhuangtree.getSelectionModel();
	  	      treeSelectionModel
	  	        .setSelectionMode(2);
	  	    this.fuzhuangtree.addTreeSelectionListener(new TreeSelectionListener()
		      {
		        public void valueChanged(TreeSelectionEvent e)
		        {
		          if (!MainFrame.this.fuzhuangtree.isSelectionEmpty())
		          {
		            TreePath selectionPaths = MainFrame.this.fuzhuangtree.getSelectionPath();
		            Object path = selectionPaths.getLastPathComponent();
		            DefaultMutableTreeNode node = (DefaultMutableTreeNode)path;
		            String userObject = (String)node.getUserObject();
		            MainFrame.this.repaint();
		            if (userObject.equals("1����"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.removeAll();
//		              sellPanel.add(new ProgressPanel());
		            }
		            else if (userObject.equals("2����"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		              sellPanel.add(new ProgressPanel());
		            }
		            else if (userObject.equals("3����"))
		            {
		              MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              MemberManagePanel memberManagePanel = new MemberManagePanel();
		              memberManagePanel.setBounds(10, 11, 700, 500);
		               sellPanel.add(memberManagePanel);
		            }
		            else if (userObject.equals("����"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		             sellPanel.add(new ProgressPanel());
		            }
		            else if (userObject.equals("ϵͳά��"))
		            {
		            	MainFrame.this.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		               sellPanel.add(new ProgressPanel());
//		              MainFrame.this.repaint();
		            } else if (userObject.equals("����"))
		            {
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
	public BGPanel getJPanel()
	  {
	    if (this.jPanel == null)
	    {
	      GridLayout gridLayout = new GridLayout();
	      gridLayout.setRows(1);
	      gridLayout.setHgap(0);
	      gridLayout.setVgap(5);
	      this.jPanel = new BGPanel();
	      
	      this.jPanel.setLayout(gridLayout);
	      
	      this.jPanel.setPreferredSize(new Dimension(400, 50));
	      this.jPanel.setOpaque(false);
	      //�Ѱ�ť���뵽�ƶ����
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
	private GlassButton getQiCheBtn()
	  {
	    if (this.qichebtn == null)
	    {
	      this.qichebtn = new GlassButton();
	      qichebtn.setToolTipText("��������");
	      this.qichebtn.setActionCommand("����");
	      this.qichebtn.setIcon(new ImageIcon(
	        "images/MJBtn/����.png"));
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/����.png");
	      this.qichebtn.setRolloverIcon(icon);
	      this.qichebtn.setSelectedIcon(icon);
	      this.qichebtn.setSelected(true);
	      this.qichebtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.qichebtn;
	  }
	  
	  private GlassButton getFangZiBtn()
	  {
	    if (this.fangzibtn == null)
	    {
	      this.fangzibtn = new GlassButton();
	      this.fangzibtn.setActionCommand("����");
	      this.fangzibtn.setToolTipText("��������");
	      this.fangzibtn.setIcon(new ImageIcon(
	        "images/MJBtn/����.png"));
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/����.png");
	      this.fangzibtn.setRolloverIcon(icon);
	      this.fangzibtn.setSelectedIcon(icon);
	      this.fangzibtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.fangzibtn;
	  }
	  
	  private GlassButton getFuZhuangBtn()
	  {
	    if (this.fuzhuangbtn == null)
	    {
	      this.fuzhuangbtn = new GlassButton();
	      this.fuzhuangbtn.setActionCommand("��װ");
	      this.fuzhuangbtn.setToolTipText("��װ����");
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/��װ.png");
	      this.fuzhuangbtn.setSelectedIcon(icon);
	      this.fuzhuangbtn.setRolloverIcon(icon);
	      this.fuzhuangbtn.setIcon(new ImageIcon(
	        "images/MJBtn/��װ.png"));
	      this.fuzhuangbtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.fuzhuangbtn;
	  }
	  
	  private GlassButton getZiXingCheBtn()
	  {
	    if (this.zixingchebtn == null)
	    {
	      this.zixingchebtn = new GlassButton();
	      this.zixingchebtn.setActionCommand("���г�");
	      this.zixingchebtn.setToolTipText("���г�����");
	      ImageIcon icon = new ImageIcon("images\\MJBtn\\���г�.png");
	      this.zixingchebtn.setSelectedIcon(icon);
	      this.zixingchebtn.setRolloverIcon(icon);
	      this.zixingchebtn.setIcon(new ImageIcon("images\\MJBtn\\���г�.png"));
	      this.zixingchebtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.zixingchebtn;
	  }
	  
	  private GlassButton getBookspaceButton()
	  {
	    if (this.bookspaceButton == null)
	    {
	      this.bookspaceButton = new GlassButton();
	      
	      this.bookspaceButton.setActionCommand("�鼮");
	      this.bookspaceButton.setToolTipText("�鼮����");
	      
	      ImageIcon imageIcon = new ImageIcon(
	        "images/MJBtn/�鼮.png");
	      this.bookspaceButton.setIcon(imageIcon);
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/�鼮.png");
	      this.bookspaceButton.setRolloverIcon(icon);
	      this.bookspaceButton.setSelectedIcon(icon);
	      this.bookspaceButton.setFocusPainted(false);
	      this.bookspaceButton.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.bookspaceButton;
	  }
	  
	  private GlassButton getDianZiSheBeiBtn()
	  {
	    if (this.dianzishebeibtn == null)
	    {
	      this.dianzishebeibtn = new GlassButton();
	      
	      this.dianzishebeibtn.setActionCommand("�����豸");
	      this.dianzishebeibtn.setToolTipText("�����豸����");
	      
	      ImageIcon imageIcon = new ImageIcon(
	    		  "images/MJBtn/�����豸.png");
	      this.dianzishebeibtn.setIcon(imageIcon);
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/�����豸.png");
	      this.dianzishebeibtn.setRolloverIcon(icon);
	      this.dianzishebeibtn.setSelectedIcon(icon);
	      this.dianzishebeibtn.setFocusPainted(false);
	      this.dianzishebeibtn .addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.dianzishebeibtn;
	  }
	  
	  private GlassButton getJianZuGongJuBtn()
	  {
	    if (this.jianzugongjubtn == null)
	    {
	      this.jianzugongjubtn = new GlassButton();
	      
	      this.jianzugongjubtn.setActionCommand("��������");
	      this.jianzugongjubtn.setToolTipText("������������");
	      
	      ImageIcon imageIcon = new ImageIcon(
	        "images/MJBtn/��������.png");
	      this.jianzugongjubtn.setIcon(imageIcon);
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/��������.png");
	      this.jianzugongjubtn.setRolloverIcon(icon);
	      this.jianzugongjubtn.setSelectedIcon(icon);
	      this.jianzugongjubtn.setFocusPainted(false);
	      this.jianzugongjubtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.jianzugongjubtn;
	  }
	  //ƽ����尴ť������
	  class toolsButtonActionAdapter implements ActionListener
	  {
	    toolsButtonActionAdapter() {}
	    public void actionPerformed(ActionEvent e)
	    {
	    	String backpaneltitle=e.getActionCommand();
	      if (e.getSource() == MainFrame.this.qichebtn)
	      {
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
	      if (e.getSource() == MainFrame.this.fangzibtn)
	      {
	    	  MainFrame.this.backPanel.removeAll();
	    	  MainFrame.this.sellPanel.removeAll();
	    	  MainFrame.this.backPanel.add(MainFrame.this.label_1);
	    	  MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
	        MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
	        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
	        
	        MainFrame.this.fristLabel.setText(backpaneltitle);
	                                                                                   //���¼���Ҫ��ʾ�����
	        MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));
	        MainFrame.this.repaint();
	      }
	      if (e.getSource() == MainFrame.this.fuzhuangbtn)
	      {
	    	  if(!backPanel.getName().equals("��װ"))
	    	  {
		    	  MainFrame.this.paneA2b.removeAll();
		    	  MainFrame.this.sellPanel.removeAll();
		    	  MainFrame.this.backPanel.add(MainFrame.this.label_1);
		    	  MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
		          MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
		          MainFrame.this.paneA2b.add(getFuZhuangContentPanel("��װ"));//���¼���Ҫ��ʾ�����y
		          MainFrame.this.fristLabel.setText(backpaneltitle);
		          MainFrame.this.repaint();
	    	  }
	      }
	      if (e.getSource() == MainFrame.this.zixingchebtn)
	      {
	    	  if(!backPanel.getName().equals("���г�"))
	    	  {
		     	  MainFrame.this.paneA2b.removeAll();
		     	  MainFrame.this.sellPanel.removeAll();
		    	  MainFrame.this.backPanel.add(MainFrame.this.label_1);
		    	  MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
		          MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
		          MJLable mainR = new MJLable("images/beijin_r_lbl_end.gif", 300, 300);
			  	  mainR.setBounds(780, 340, 300, 300);
//			   	  MainFrame.this.paneA2b.add(mainR);
		          MainFrame.this.paneA2b.add(getZixingCheContentPanel("���г�",MainFrame.this));//���¼���Ҫ��ʾ�����y
		          MainFrame.this.fristLabel.setText(backpaneltitle);
		          
		          MainFrame.this.repaint();
	    	  }
	      }
	      if (e.getSource() == MainFrame.this.bookspaceButton)
	      {
    	    MainFrame.this.backPanel.removeAll();
	        MainFrame.this.backPanel.add(MainFrame.this.label_1);
	        MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
	        MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
	        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
	        
	        MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));//���¼���Ҫ��ʾ�����
	        MainFrame.this.fristLabel.setText(backpaneltitle);
	        MainFrame.this.repaint();
	      
	    	 
	      }
	      if (e.getSource() == MainFrame.this.dianzishebeibtn)
	      {
	    	  MainFrame.this.backPanel.removeAll();
		        MainFrame.this.backPanel.add(MainFrame.this.label_1);
		        MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
		        MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
		        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
		        
		        MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));//���¼���Ҫ��ʾ�����
		        MainFrame.this.fristLabel.setText(backpaneltitle);
		        MainFrame.this.repaint();
	      }
	      if (e.getSource() == MainFrame.this.jianzugongjubtn)
	      {
	    	  MainFrame.this.backPanel.removeAll();
		        MainFrame.this.backPanel.add(MainFrame.this.label_1);
		        MainFrame.this.fristLabel.setBounds(133, 38, 123, 15);
		        MainFrame.this.backPanel.add(MainFrame.this.fristLabel);
		        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
		        
		        MainFrame.this.backPanel.add(new ProgressPanel("����ά���С�����"));//���¼���Ҫ��ʾ�����
		        MainFrame.this.fristLabel.setText(backpaneltitle);
		        MainFrame.this.repaint();
	      }
	    }
	  }
	  
	  public void SystemTrayInitial() { // ϵͳ����ʼ��
			if (!SystemTray.isSupported()) // �жϵ�ǰϵͳ�Ƿ�֧��ϵͳ��
				return;
			try {
				String title = "ͨ����Ʒ���޹���";
				String company = "";
				SystemTray sysTray = SystemTray.getSystemTray();
				Image image = Toolkit.getDefaultToolkit().getImage(
						MainFrame.class.getResource("/���г�.png"));// ϵͳ��ͼ��
				trayicon = new TrayIcon(image, title + "\n" + company, createMenu());
				trayicon.setImageAutoSize(true);
				trayicon.addActionListener(new SysTrayActionListener());
				sysTray.add(trayicon);
				trayicon.displayMessage(title, company, MessageType.INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		private PopupMenu createMenu() { // ����ϵͳ���˵��ķ���
			PopupMenu menu = new PopupMenu();
			MenuItem exitItem = new MenuItem("�˳�");
			exitItem.addActionListener(new ActionListener() { // ϵͳ���˳��¼�
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
			MenuItem openItem = new MenuItem("��");
			openItem.addActionListener(new ActionListener() {// ϵͳ���򿪲˵����¼�
						public void actionPerformed(ActionEvent e) {
							if (!isVisible()) {
								setVisible(true);
								toFront();
							} else
								toFront();
						}
					});

			// ϵͳ���ķ��ʷ������˵����¼�
			menu.add(openItem);
			menu.addSeparator();
			menu.add(exitItem);
			return menu;
		}
		class SysTrayActionListener implements ActionListener {// ϵͳ��˫���¼�
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				toFront();
			}

		public void actionPerformed(WindowEvent e) {
			System.out.println("fgfdfdggfg");
			setVisible(true);
			toFront();
					
		}
		}
	  
	public JLabel getFristLabel() {
			return fristLabel;
		}

		public void setFristLabel(JLabel fristLabel) {
			this.fristLabel = fristLabel;
		}

		public JLabel getLabel_1() {
			return label_1;
		}

		public void setLabel_1(JLabel label_1) {
			this.label_1 = label_1;
		}

	public JPanel getPaneA2b() {
			return paneA2b;
		}

		public void setPaneA2b(JPanel paneA2b) {
			this.paneA2b = paneA2b;
		}

	public JPanel getPanel_1() {
			return panel_1;
		}

		public void setPanel_1(JPanel panel_1) {
			this.panel_1 = panel_1;
		}

	public MButton getBtn_exit() {
			return btn_exit;
		}

		public void setBtn_exit(MButton btn_exit) {
			this.btn_exit = btn_exit;
		}

		public MButton getBtn_zuida() {
			return btn_zuida;
		}

		public void setBtn_zuida(MButton btn_zuida) {
			this.btn_zuida = btn_zuida;
		}

	public MenuPanel getMenuPanel() {
			return menuPanel;
		}

		public void setMenuPanel(MenuPanel menuPanel) {
			this.menuPanel = menuPanel;
		}

	public MButton getBtn_help() {
			return btn_help;
		}

		public void setBtn_help(MButton btn_help) {
			this.btn_help = btn_help;
		}

	public JFrame getFrame() {
			return frame;
		}

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}

	public String getWhoShown() {
			return whoShown;
		}

		public void setWhoShown(String whoShown) {
			this.whoShown = whoShown;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			MainFrame mainFrame =new MainFrame();
			mainFrame.setResizable(false);
			mainFrame.SystemTrayInitial();// ��ʼ��ϵͳ��
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
