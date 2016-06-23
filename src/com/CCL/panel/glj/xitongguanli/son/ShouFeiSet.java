package com.CCL.panel.glj.xitongguanli.son;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.CCL.beans.Bicycle;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.ButtonRenderer;
import com.CCL.mwing.glj.MButton;
import com.CCL.panel.MPanel;
import com.CCL.service.glj.ShouFeiSetService;
import com.CCL.view.glj.AddDialog;

public class ShouFeiSet extends MPanel {
	private MButton btn_add, btn_delete, btn_save, btn_cancle, btn_exit;
	private FixedColumnTablePanel shouFeiTablePanel;
	private Vector<String> tableColumnV;// ���ͷ�ֶ�
	private Vector<Vector<Object>> tableValueV;// �������
	private MJLable lbl_left;
	private ShouFeiSetService shouFeiSetService;
	private Vector<Object> row1, row2;
	private int xuhao = 1;
	private JPanel sellPanel;

	public ShouFeiSet(String imageUrl, JPanel sellPanel) {
		super(imageUrl);
		this.sellPanel = sellPanel;
		this.setSize(920, 520);
		this.setLayout(null);
		this.setVisible(true);

		init();

	}

	private void init() {
		shouFeiSetService = new ShouFeiSetService();

		lbl_left = new MJLable(new ImageIcon("images/glj/shoufei/bg_�շ�����.jpg"),
				new ImageIcon("images/glj/shoufei/bg_�շ�����.jpg").getIconWidth(),
				new ImageIcon("images/MJBtn/����_����.gif").getIconHeight());
		lbl_left.setBounds(10, 5, 250, 50);
		btn_add = new MButton("images/MJBtn/tree���г�.png", "����", 310, 10, 60, 30);
		btn_delete = new MButton("images/MJBtn/tree���г�.png", "ɾ��", 390, 10, 60,
				30);
		btn_exit = new MButton("images/MJBtn/tree���г�.png", "�˳�", 470, 10, 60,
				30);
		tableColumnV = new Vector<String>();
		tableColumnV.add("���");
		tableColumnV.add("������");
		tableColumnV.add("����");
		tableColumnV.add("�۸�");
		tableColumnV.add("����ʱ��");
		tableColumnV.add("�Ʒ�ʱ��");
		tableColumnV.add("���ڼƷ�ʱ��۸�");
		tableColumnV.add("С�ڼƷ�ʱ��۸�");
		tableColumnV.add("�Ƿ�μӻ���");
		tableColumnV.add("�Ƿ�μ��ۿ�");
		tableColumnV.add("�ۿ�ֵ");

		tableValueV = shouFeiSetService.getAllBicycle(); // ��ȡ���ݿ�ֵ

		row1 = new Vector<Object>();
		row1.add(xuhao);
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		if (tableValueV.size() == 1 || tableValueV.size() == 0) {// ��û����ʱ���һ���հ���
			tableValueV.add(row1);
		}

		int[] floatwidth = { 40, 100, 120 };
		int[] fixwidth = { 100, 100, 100, 100, 100, 100, 100 };
		shouFeiTablePanel = new FixedColumnTablePanel(tableColumnV,
				tableValueV, 3, "images/glj/shoufei/72.jpg", floatwidth,
				fixwidth);
		// ���ñ���и߶�
		shouFeiTablePanel.getFixedColumnTable().setRowHeight(22);
		shouFeiTablePanel.getFloatingColumnTable().setRowHeight(22);
		// ��ָ���м����Լ�����Ⱦ��
		String[] zixingche = { "���˳�", "˫�˳�", "���˳�" };
		JComboBox com = new JComboBox(zixingche);
		shouFeiTablePanel.getFixedColumnTable().getColumnModel().getColumn(1)
				.setCellEditor(new DefaultCellEditor(com));
		shouFeiTablePanel.getFloatingColumnTable().getColumn("�Ƿ�μӻ���")
				.setCellRenderer(new ButtonRenderer());
		shouFeiTablePanel.getFloatingColumnTable().getColumn("�Ƿ�μ��ۿ�")
				.setCellRenderer(new ButtonRenderer());

		shouFeiTablePanel.setBounds(10, 70, 560, 420);
		this.add(lbl_left);
		this.add(btn_add);
		this.add(btn_delete);
		this.add(btn_exit);
		btn_add.setActionCommand("����");
		btn_delete.setActionCommand("ɾ��");
		btn_exit.setActionCommand("�˳�");
		btn_add.addActionListener(new ActionListener_btn(this));
		btn_delete.addActionListener(new ActionListener_btn(this));
		btn_exit.addActionListener(new ActionListener_btn(this));

		this.add(shouFeiTablePanel);
	}

	class ActionListener_btn implements ActionListener {
		private ShouFeiSet shouFeiSet;
		com.CCL.panel.glj.xitongguanli.son.FixedColumnTablePanel.MTable fixedColumnTable;
		com.CCL.panel.glj.xitongguanli.son.FixedColumnTablePanel.MTable floatingColumnTable;

		public ActionListener_btn(ShouFeiSet shouFeiSet) {

			this.shouFeiSet = shouFeiSet;
			// shouFeiSetService = new ShouFeiSetService();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actioncommand = e.getActionCommand();

			floatingColumnTable = shouFeiSet.getShouFeiTablePanel()
					.getFixedColumnTable();
			if (actioncommand.equals("����")) {
				xuhao = floatingColumnTable.getRowCount() + 1;
				row2 = new Vector<Object>();
				row2.add(xuhao);
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("�μ�");
				row2.add("�μ�");
				row2.add("");
				if (!floatingColumnTable.getValueAt(floatingColumnTable.getRowCount() - 1, 2).equals("")) 
				{
					AddDialog adddialog = new AddDialog(shouFeiSet);
					adddialog.setBounds(700, 220, 293, 480);
				}
			} else if (actioncommand.equals("ɾ��")) {

				int floatindex = floatingColumnTable.getSelectedRow();// ���ѡ�����±�
				if (floatindex > -1) {
					if (floatingColumnTable.getModel().getRowCount() > 1) {
					Bicycle bicycle = null;
					if (floatingColumnTable.getValueAt(floatindex, 2) instanceof Bicycle) {
						bicycle = (Bicycle) floatingColumnTable.getValueAt(
								floatindex, 2);
					}

					if (bicycle != null && floatindex > -1) {

						// ʵ���߼�ɾ��
						bicycle.setIsShow(false);
						shouFeiSet.getShouFeiSetService().update(bicycle);
						tableValueV = shouFeiSetService.getAllBicycle(); // ���¶�ȡ���ݿ�ֵ;
						row1 = new Vector<Object>();
						row1.add(xuhao);
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						if (tableValueV.size() == 1 || tableValueV.size() == 0) {// ��û����ʱ���һ���հ���
							tableValueV.add(row1);
						}
						
						shouFeiTablePanel.setTableValueV(tableValueV);
						shouFeiSet.add(shouFeiTablePanel);

						shouFeiTablePanel.revalidate(); // ��Ҫ����������������������������
						shouFeiTablePanel.repaint();

					}
				}
				}
			} 
			else if (actioncommand.equals("�˳�")) {
				sellPanel.removeAll();
				sellPanel.repaint();
				
			}
		}

	}

	public FixedColumnTablePanel getShouFeiTablePanel() {
		return shouFeiTablePanel;
	}

	public void setShouFeiTablePanel(FixedColumnTablePanel shouFeiTablePanel) {
		this.shouFeiTablePanel = shouFeiTablePanel;
	}

	public ShouFeiSetService getShouFeiSetService() {
		return shouFeiSetService;
	}

	public void setShouFeiSetService(ShouFeiSetService shouFeiSetService) {
		this.shouFeiSetService = shouFeiSetService;
	}

}
