package com.CCL.panel.glj;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.ButtonRenderer;
import com.CCL.mwing.glj.DefaultTableCellHeaderRenderer;
import com.CCL.mwing.glj.MButton;
import com.CCL.mwing.glj.TableRender;
import com.CCL.panel.MPanel;
import com.CCL.service.glj.RiYingYeSelectService;
import com.CCL.util.glj.Today;


public class RiYinYeSelect extends MPanel {
	private MButton btn_select,btn_export,btn_exit;
	private FixedColumnTablePanel riYinYeTablePanel;
	private Vector<String> tableColumnV;//���ͷ�ֶ�
	private Vector<Vector<Object>> tableValueV;//�������
	private MJLable lbl_stime,lbl_etime;
	private JTextField txt_stime,txt_etime;
	private JTextField txt_stime_temp = new JTextField() ,txt_etime_temp= new JTextField();
	private JDialog calenderDialog;
	private JButton sbtn,ebtn;
	public RiYinYeSelect(String imageUrl)
	{
		super(imageUrl);
		this.setSize(920, 520);
		this.setLayout(null);
		this.setVisible(true);
		init();
		
		
	}

	private void init() {
		lbl_stime = new MJLable("",0,0);
		lbl_stime.setText("���ڴ�");
		lbl_stime.setBounds(10, 17, 50, 25);
		txt_stime=new JTextField(Today.getDate()); 
		txt_stime.setBounds(60, 19, 90, 20);
		txt_stime.setHorizontalAlignment(SwingConstants.CENTER);
		sbtn = new JButton("...");
		sbtn.setBounds(151, 19, 20, 20);
		sbtn.setBorder(BorderFactory.createLineBorder(Color.white));
		sbtn.setContentAreaFilled(false);
		//����ActionCommand
		sbtn.setActionCommand("��ʼʱ��");
//		String startTime = "��ʼʱ��";
		sbtn.addActionListener(new MouseListener_sbtn(this));
		
		lbl_etime = new MJLable("",0,0);
		lbl_etime.setText("��");
		lbl_etime.setBounds(170, 17, 20, 25);
		
		txt_etime=new JTextField(Today.getDate());
		txt_etime.setBounds(190, 19, 90, 20);
		txt_etime.setHorizontalAlignment(SwingConstants.CENTER);
		ebtn = new JButton("...");
		ebtn.setBounds(281, 19, 20, 20);
		ebtn.setBorder(BorderFactory.createLineBorder(Color.white));
		ebtn.setContentAreaFilled(false);
		//����ActionCommand
	    ebtn.setActionCommand("����ʱ��");
	    ebtn.addActionListener(new MouseListener_sbtn(this));
		
		btn_select = new MButton("images/MJBtn/tree���г�.png","��ѯ",340,15,60,30);
		btn_export = new MButton("images/MJBtn/tree���г�.png","����",420,15,60,30);
		btn_exit = new MButton("images/MJBtn/tree���г�.png","�˳�",500,15,60,30);
		
		btn_select.setActionCommand("��ѯ");
		btn_export.setActionCommand("����");
		btn_exit.setActionCommand("�˳�");
		
		
		btn_export.addActionListener(new ActionListener_btn(this));
		
		
		tableColumnV = new Vector<String>();
		tableColumnV.add("���");
		tableColumnV.add("�˵����");
		tableColumnV.add("ʱ��");
		tableColumnV.add("������(Ԫ)");
		tableColumnV.add("���˳�");
		tableColumnV.add("˫�˳�");
		tableColumnV.add("���˳�");
		
//		tableColumnV.add("�Żݽ��");
		tableValueV = RiYingYeSelectService.getRiYinYeBill();//new Vector<Vector<Object>>(); 
		Vector<Object> row1 = new Vector<Object>();
		row1.add("1");
		row1.add("");
		row1.add("");
		row1.add("");
		
		row1.add("");
		row1.add("");
		row1.add("");
		
//		tableValueV.add(row1);
		int[] floatwidth ={40,130,130,80};
		int[] fixwidth ={130,130,130};
		riYinYeTablePanel = new FixedColumnTablePanel(tableColumnV,tableValueV,4,"images/glj/shoufei/72.jpg",floatwidth,fixwidth);
		//���ñ���и߶�
		riYinYeTablePanel.getFixedColumnTable().setRowHeight(22);
		riYinYeTablePanel.getFloatingColumnTable().setRowHeight(22);
		
		
		TableRender tableRender =new TableRender();
//		tableRender.setToolTipText("������-����ʱ��-����");
		riYinYeTablePanel.getFloatingColumnTable().getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer());//�Զ����ͷ��Ⱦ��
//		riYinYeTablePanel.getFloatingColumnTable().getColumn("���˳�").setCellRenderer(tableRender);
//		riYinYeTablePanel.getFloatingColumnTable().getColumn("˫�˳�").setCellRenderer(tableRender);
//		riYinYeTablePanel.getFloatingColumnTable().getColumn("���˳�").setCellRenderer(tableRender);
		
		riYinYeTablePanel.getFloatingColumnTable().getTableHeader().setToolTipText("��ͬ������");
		riYinYeTablePanel.getFixedColumnTable().getTableHeader().setToolTipText("��Ӫҵ��ѯ");
		
//		riYinYeTablePanel.getFloatingColumnTable().setEnabled(false);
		riYinYeTablePanel.setBounds(10, 70, 740, 420);
		
		this.add(lbl_stime);
		this.add(txt_stime);
		this.add(sbtn);
		this.add(lbl_etime);
		this.add(txt_etime);
		this.add(ebtn);
		
		this.add(btn_select);
		this.add(btn_export);
		this.add(btn_exit);
		
		this.add(riYinYeTablePanel);
		
		
	}
	
	
	
	class ActionListener_btn implements ActionListener{

		private RiYinYeSelect riYinYeSelect;
		public ActionListener_btn(RiYinYeSelect riYinYeSelect) {
			this.riYinYeSelect = riYinYeSelect;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();
			if(command.equals("��ѯ"))
			{
				String start_time = riYinYeSelect.getTxt_stime().getText().trim();
				String end_time = riYinYeSelect.getTxt_etime().getText().trim();
				
				
				
				
			}else if (command.equals("����"))
			{
				
			}else if (command.equals("�˳�"))
			{
				
			}
		}
		
	}
	class MouseListener_sbtn implements ActionListener
	{
		private RiYinYeSelect ryd;
		public MouseListener_sbtn(RiYinYeSelect ryd)
		{
			this.ryd = ryd;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("��ʼʱ��"))
			{
				//���濪ʼʱ��ͽ���ʱ��
				ryd.getTxt_stime_temp().setText(ryd.getTxt_stime().getText());
				ryd.getTxt_etime_temp().setText(ryd.getTxt_etime().getText());
//				if(calenderDialog==null){
					calenderDialog = new JDialog();
					MButton btn_sure=new MButton("");
					btn_sure.setText("ȷ��");
					MButton btn_cancele=new MButton("");
					btn_cancele.setText("ȡ��");
					btn_sure.setBounds(50, 200, 50, 30);
					btn_cancele.setBounds(118, 200, 50, 30);
					MPanel mainpanel = new MPanel("images/glj/��Ӫҵ��ѯ/��������.jpg");
					
					calenderDialog.setContentPane(mainpanel);
					calenderDialog.setLayout(null);
					
					calenderDialog.setUndecorated(true);
					calenderDialog.setBounds(612, 215, 230, 235);
					//����dialog�������
					calenderDialog.setModal(true);
					MyCalenderPanel mc = new MyCalenderPanel(ryd,"��ʼʱ��");
					
				
					mc.setBounds(0, 0, 230, 200);
					mainpanel.add(mc);
					mainpanel.add(btn_sure);
					mainpanel.add(btn_cancele);
					//����dialog��ʧȥ����
					calenderDialog.setAlwaysOnTop(true);
					btn_sure.setActionCommand("��ʼʱ��ȷ��");
					btn_cancele.setActionCommand("��ʼʱ��ȡ��");
					btn_sure.addActionListener(new MouseAdapter_btn_sure(calenderDialog,mc));
					btn_cancele.addActionListener(new MouseAdapter_btn_cancele(calenderDialog,mc));
					calenderDialog.setVisible(true);
				
//				}
				
			}else if(e.getActionCommand().equals("����ʱ��"))
			{
				//���濪ʼʱ��ͽ���ʱ��
				ryd.getTxt_stime_temp().setText(ryd.getTxt_stime().getText());
				ryd.getTxt_etime_temp().setText(ryd.getTxt_etime().getText());
//				if(calenderDialog==null){
					calenderDialog = new JDialog();
					MButton btn_sure=new MButton("");
					btn_sure.setText("ȷ��");
					MButton btn_cancele=new MButton("");
					btn_cancele.setText("ȡ��");
					btn_sure.setBounds(50, 200, 50, 30);
					btn_cancele.setBounds(118, 200, 50, 30);
					MPanel mainpanel = new MPanel("images/glj/��Ӫҵ��ѯ/��������.jpg");
					
					calenderDialog.setContentPane(mainpanel);
					calenderDialog.setLayout(null);
					
					calenderDialog.setUndecorated(true);
					calenderDialog.setBounds(741, 215, 230, 235);
					calenderDialog.setModal(true);
					MyCalenderPanel mc = new MyCalenderPanel(ryd,"����ʱ��");
					mc.setBounds(0, 0, 230, 200);
					mainpanel.add(mc);
					mainpanel.add(btn_sure);
					mainpanel.add(btn_cancele);
					//����dialog��ʧȥ����
					calenderDialog.setAlwaysOnTop(true);
					btn_sure.setActionCommand("����ʱ��ȷ��");
					btn_cancele.setActionCommand("����ʱ��ȡ��");
					btn_sure.addActionListener(new MouseAdapter_btn_sure(calenderDialog,mc));
					btn_cancele.addActionListener(new MouseAdapter_btn_cancele(calenderDialog,mc));
					calenderDialog.setVisible(true);
				}
//			}
			
		}
		class MouseAdapter_btn_cancele implements ActionListener
		{

			private JDialog calDialog;
			private MyCalenderPanel mc;
			public MouseAdapter_btn_cancele(JDialog calDialog,MyCalenderPanel mc) {
				this.calDialog = calDialog;
				this.mc = mc;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("��ʼʱ��ȡ��"))
				{
					ryd.getTxt_stime().setText(ryd.getTxt_stime_temp().getText());
					calDialog.dispose();
				}
				else if(e.getActionCommand().equals("����ʱ��ȡ��")){
					ryd.getTxt_etime().setText(ryd.getTxt_etime_temp().getText());
					calDialog.dispose();
				}
				
			}
			
		}

		class MouseAdapter_btn_sure implements ActionListener
		{

			private JDialog calDialog;
			private MyCalenderPanel mc;
			public MouseAdapter_btn_sure(JDialog calDialog,MyCalenderPanel mc) {
				this.calDialog = calDialog;
				this.mc = mc;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("��ʼʱ��ȷ��"))
				{
					calDialog.dispose();
				}
				else if(e.getActionCommand().equals("����ʱ��ȷ��")){
					calDialog.dispose();
				}
				
			}
			
		}

		
		
	}
	
	
	public JTextField getTxt_stime_temp() {
		return txt_stime_temp;
	}

	public void setTxt_stime_temp(JTextField txt_stime_temp) {
		this.txt_stime_temp = txt_stime_temp;
	}

	public JTextField getTxt_etime_temp() {
		return txt_etime_temp;
	}

	public void setTxt_etime_temp(JTextField txt_etime_temp) {
		this.txt_etime_temp = txt_etime_temp;
	}

	public JTextField getTxt_stime() {
		return txt_stime;
	}

	public void setTxt_stime(JTextField txt_stime) {
		this.txt_stime = txt_stime;
	}

	public JTextField getTxt_etime() {
		return txt_etime;
	}

	public void setTxt_etime(JTextField txt_etime) {
		this.txt_etime = txt_etime;
	}

}
