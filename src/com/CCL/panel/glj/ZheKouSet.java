package com.CCL.panel.glj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.beans.CustomerType;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.ButtonRenderer;
import com.CCL.mwing.glj.MButton;
import com.CCL.panel.MPanel;
import com.CCL.panel.glj.ShouFeiSet.ActionListener_btn;
import com.CCL.service.glj.ZheKouSetService;

public class ZheKouSet extends MPanel {
	private MButton btn_add, btn_delete, btn_xiugai, btn_exit;
	private FixedColumnTablePanel zhekouTablePanel;
	private Vector<String> tableColumnV;// ���ͷ�ֶ�
	private Vector<Vector<Object>> tableValueV;// �������
	private MJLable lbl_left;
	private ZheKouSetService zheKouSetService;

	public ZheKouSet(String imageUrl) {
		super(imageUrl);
		this.zheKouSetService = new ZheKouSetService();

		this.setSize(920, 520);
		this.setLayout(null);
		this.setVisible(true);

		init();

	}

	private void init() {
		lbl_left = new MJLable(new ImageIcon("images/glj/shoufei/bg_�շ�����.jpg"),
				new ImageIcon("images/glj/shoufei/bg_�շ�����.jpg").getIconWidth(),
				new ImageIcon("images/MJBtn/����_����.gif").getIconHeight());
		lbl_left.setBounds(10, 5, 250, 50);
		btn_add = new MButton("images/MJBtn/tree���г�.png", "����", 310, 10, 60, 30);
		btn_delete = new MButton("images/MJBtn/tree���г�.png", "ɾ��", 390, 10, 60,
				30);
		btn_xiugai = new MButton("images/MJBtn/tree���г�.png", "�޸�", 470, 10, 60,
				30);
		btn_exit = new MButton("images/MJBtn/tree���г�.png", "�˳�", 550, 10, 60,
				30);

		// ����ActionCommand���жϲ�ͬ��ť���¼�
		btn_add.setActionCommand("����");
		btn_delete.setActionCommand("ɾ��");
		btn_xiugai.setActionCommand("�޸�");
		btn_exit.setActionCommand("�˳�");

		btn_add.addActionListener(new ActionListener_btn(this));
		btn_delete.addActionListener(new ActionListener_btn(this));
		btn_xiugai.addActionListener(new ActionListener_btn(this));
		btn_exit.addActionListener(new ActionListener_btn(this));

		tableColumnV = new Vector<String>();
		tableColumnV.add("���");
		tableColumnV.add("������");
		tableColumnV.add("�������ۿ�");
		tableColumnV.add("��Ա������");
		tableColumnV.add("�û������ۿ�");
		tableValueV = zheKouSetService.getZheKouSetDate(); // ��ȡ���ݿ�ֵ
		Vector<Object> row1 = new Vector<Object>();
		row1.add("1");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		if (tableValueV.size() == 1 || tableValueV.size() == 0) {
			tableValueV.add(row1);
		}
		int[] floatwidth = { 40, 120, 120 };
		int[] fixwidth = { 120, 120 };
		zhekouTablePanel = new FixedColumnTablePanel(tableColumnV, tableValueV,
				3, "images/glj/shoufei/72.jpg", floatwidth, fixwidth);
		// ���ñ���и߶�
		zhekouTablePanel.getFixedColumnTable().setRowHeight(22);
		zhekouTablePanel.getFloatingColumnTable().setRowHeight(22);
		zhekouTablePanel.setBounds(10, 70, 524, 420);
		this.add(lbl_left);
		this.add(btn_add);
		this.add(btn_delete);
		this.add(btn_xiugai);
		this.add(btn_exit);

		this.add(zhekouTablePanel);

	}

	class ActionListener_btn implements ActionListener {

		private ZheKouSet zheKouSet;
		com.CCL.panel.glj.FixedColumnTablePanel.MTable fixedColumnTable;
		com.CCL.panel.glj.FixedColumnTablePanel.MTable floatingColumnTable;
		ZheKouSet_Add zheKouSet_Add = null;

		public ActionListener_btn(ZheKouSet zheKouSet) {
			this.zheKouSet = zheKouSet;
			this.zheKouSet_Add = new ZheKouSet_Add(zheKouSet);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actioncommand = e.getActionCommand();

			fixedColumnTable = zheKouSet.getZhekouTablePanel()
					.getFixedColumnTable();
			floatingColumnTable = zheKouSet.getZhekouTablePanel()
					.getFloatingColumnTable();

			if (actioncommand.equals("����")) {
				zheKouSet_Add.setBounds(540, 70, 403, 390);
				this.updateZheKouSet_AddPanel(actioncommand);
				this.removeZheKouSet();
				this.setDefeateDate();
				zheKouSet.add(zheKouSet_Add);
				zheKouSet.repaint();
			} else if (actioncommand.equals("ɾ��")) {

				int floatindex = floatingColumnTable.getSelectedRow();// ���ѡ�����±�
				if (floatindex > -1) {
					if (fixedColumnTable.getModel().getRowCount() > 1) {

						BicycleType bicycleType = null;
						if (fixedColumnTable.getValueAt(floatindex, 1) instanceof BicycleType) {
							bicycleType = (BicycleType) fixedColumnTable
									.getValueAt(floatindex, 1);
						}

						if (fixedColumnTable.getValueAt(floatindex, 1)
								.toString()// ��ֹû����ʱɾ���հ��� ����
								.trim().length() > 0) {
							if (bicycleType.getName().trim().length() != 0) {// �ж��Ƿ�����һ����ʱ��bicycleType���󣬼�new
																				// �Ķ��󣬲������ݿ���ڵ�

								// ʵ���߼�ɾ��
								bicycleType.setIsShow(false);
								boolean temp = zheKouSet.getZheKouSetService()
										.update(bicycleType);
							}
						}

						CustomerType customerType = null;
						if (floatingColumnTable.getValueAt(floatindex, 0) instanceof CustomerType) {
							customerType = (CustomerType) floatingColumnTable
									.getValueAt(floatindex, 0);
						}

						if (fixedColumnTable.getValueAt(floatindex, 0)
								.toString()// ��ֹû����ʱɾ���հ��� ����
								.trim().length() > 0) {
							if (customerType.getName().trim().length() != 0) {// �ж��Ƿ�����һ����ʱ��bicycleType���󣬼�new
																				// �Ķ��󣬲������ݿ���ڵ�

								// ʵ���߼�ɾ��
								customerType.setIsShow(false);
								zheKouSet.getZheKouSetService().update(
										customerType);
							}
						}
						tableValueV = zheKouSetService.getZheKouSetDate(); // ���¶�ȡ���ݿ�ֵ;
						Vector<Object> row1 = new Vector<Object>();
						row1.add("1");
						row1.add("");
						row1.add("");
						row1.add("");
						row1.add("");
						if (tableValueV.size() == 1 || tableValueV.size() == 0) {// ��û����ʱ���һ���հ���
							tableValueV.add(row1);
						}

						zhekouTablePanel.setTableValueV(tableValueV);
						zheKouSet.add(zhekouTablePanel);

						zhekouTablePanel.revalidate(); // ��Ҫ����������������������������
						zhekouTablePanel.repaint();
						floatingColumnTable.selectAll();// ʹ���ѡ��
						zheKouSet.getLbl_left().requestFocus();
					}
				}
			} else if (actioncommand.equals("�޸�")) {

				this.updateZheKouSet_AddPanel(actioncommand);
				this.removeZheKouSet();
				zheKouSet_Add.setBounds(540, 70, 403, 390);

				setDefeateDate();
				zheKouSet.add(zheKouSet_Add);
				zheKouSet.repaint();

			} else if (actioncommand.equals("�˳�")) {

			}

		}

		// ��ѡ���е�����ͬ����ZheKouSet_AddPanel����ϣ�
		private void setDefeateDate() {
			int floatindex = floatingColumnTable.getSelectedRow();// ���ѡ�����±�
			if (floatindex > -1) {
				if (floatindex != fixedColumnTable.getModel().getRowCount()) {
					// ���ѡ�еĳ����ͺͶ�Ӧ�ۿ�ֵ
					BicycleType bicycleType = null;
					Float bic_type_zhekou = (float) 1;
					if (fixedColumnTable.getValueAt(floatindex, 1) instanceof BicycleType) {
						bicycleType = (BicycleType) fixedColumnTable
								.getValueAt(floatindex, 1);
						bic_type_zhekou = (Float) fixedColumnTable.getValueAt(
								floatindex, 2);
					}
					// ���ѡ�е��û����ͺͶ�Ӧ�ۿ�ֵ
					CustomerType customerType = null;
					Float cus_type_zhekou = (float) 1;
					if (floatingColumnTable.getValueAt(floatindex, 0) instanceof CustomerType) {
						customerType = (CustomerType) floatingColumnTable
								.getValueAt(floatindex, 0);
						cus_type_zhekou = (Float) floatingColumnTable
								.getValueAt(floatindex, 1);
					}
					zheKouSet_Add.getTxt_bicycle_zhekou().setText(
							String.valueOf(bic_type_zhekou));
					zheKouSet_Add.getTxt_cus_zhekou().setText(
							String.valueOf(cus_type_zhekou));

					int cmb_bic_count = zheKouSet_Add.getCmb_bicycle_type()
							.getItemCount();// ��ó����������������������
					int cmb_cus_count = zheKouSet_Add.getCmb_cus_type()
							.getItemCount();// ����û����������������������
					for (int i = 0; i < cmb_bic_count; i++) {
						if (zheKouSet_Add.getCmb_bicycle_type().getItemAt(i) == bicycleType) {
							zheKouSet_Add.getCmb_bicycle_type()
									.setSelectedItem(
											zheKouSet_Add.getCmb_bicycle_type()
													.getItemAt(i));
						}
					}

					for (int i = 0; i < cmb_cus_count; i++) {
						if (zheKouSet_Add.getCmb_cus_type().getItemAt(i) == customerType) {
							zheKouSet_Add.getCmb_cus_type().setSelectedItem(
									zheKouSet_Add.getCmb_cus_type()
											.getItemAt(i));

						}
					}
				}
			}
		}

		// �����ۿ����õ�ZheKouSet_AddPanel�ϵ�����
		private void updateZheKouSet_AddPanel(String function) {

			zheKouSet_Add.removeAll();

			if (function.equals("����")) {
				System.out.println("����");
				zheKouSet_Add.getCmb_bicycle_type().setEnabled(true);
				zheKouSet_Add.getCmb_cus_type().setEnabled(true);
				zheKouSet_Add.getLbl_title().setText("����");
			} else if (function.equals("�޸�")) {
				System.out.println("�޸�");
				zheKouSet_Add.getCmb_bicycle_type().setEnabled(false);
				zheKouSet_Add.getCmb_cus_type().setEnabled(false);
				zheKouSet_Add.getLbl_title().setText("�޸�");
			}

			zheKouSet_Add.add(zheKouSet_Add.getLbl_title());
			zheKouSet_Add.getPane_bicycle().add(zheKouSet_Add.getTip_bicycle());
			zheKouSet_Add.getPane_bicycle().add(zheKouSet_Add.getLbl_bicycle());
			zheKouSet_Add.getPane_bicycle().add(
					zheKouSet_Add.getLbl_bicycle_zhekou());
			zheKouSet_Add.getPane_bicycle().add(
					zheKouSet_Add.getTxt_bicycle_zhekou());
			zheKouSet_Add.getPane_bicycle().add(
					zheKouSet_Add.getCmb_bicycle_type());

			zheKouSet_Add.getPanel_custuer().add(
					zheKouSet_Add.getLbl_cusstype());
			zheKouSet_Add.getPanel_custuer().add(
					zheKouSet_Add.getLbl_cus_zhekou());
			zheKouSet_Add.getPanel_custuer().add(
					zheKouSet_Add.getTxt_cus_zhekou());
			zheKouSet_Add.getPanel_custuer().add(
					zheKouSet_Add.getTip_customer());
			zheKouSet_Add.getPanel_custuer().add(
					zheKouSet_Add.getCmb_cus_type());

			zheKouSet_Add.add(zheKouSet_Add.getPane_bicycle());
			zheKouSet_Add.add(zheKouSet_Add.getPanel_custuer());

			zheKouSet_Add.add(zheKouSet_Add.getBtn_cancle());
			zheKouSet_Add.add(zheKouSet_Add.getBtn_save());
		}

		// �Ƴ�ZheKouSet_AddPanel
		private void removeZheKouSet() {
			zheKouSet.removeAll();
			// ���¼������
			zheKouSet.add(zheKouSet.getLbl_left());
			zheKouSet.add(zheKouSet.getBtn_add());
			zheKouSet.add(zheKouSet.getBtn_delete());
			zheKouSet.add(zheKouSet.getBtn_exit());
			zheKouSet.add(zheKouSet.getBtn_xiugai());
			zheKouSet.add(zheKouSet.getZhekouTablePanel());

			zheKouSet.repaint();
		}
	}

	public MButton getBtn_add() {
		return btn_add;
	}

	public void setBtn_add(MButton btn_add) {
		this.btn_add = btn_add;
	}

	public MButton getBtn_delete() {
		return btn_delete;
	}

	public void setBtn_delete(MButton btn_delete) {
		this.btn_delete = btn_delete;
	}

	public MButton getBtn_xiugai() {
		return btn_xiugai;
	}

	public void setBtn_xiugai(MButton btn_xiugai) {
		this.btn_xiugai = btn_xiugai;
	}

	public MButton getBtn_exit() {
		return btn_exit;
	}

	public void setBtn_exit(MButton btn_exit) {
		this.btn_exit = btn_exit;
	}

	public Vector<String> getTableColumnV() {
		return tableColumnV;
	}

	public void setTableColumnV(Vector<String> tableColumnV) {
		this.tableColumnV = tableColumnV;
	}

	public Vector<Vector<Object>> getTableValueV() {
		return tableValueV;
	}

	public void setTableValueV(Vector<Vector<Object>> tableValueV) {
		this.tableValueV = tableValueV;
	}

	public MJLable getLbl_left() {
		return lbl_left;
	}

	public void setLbl_left(MJLable lbl_left) {
		this.lbl_left = lbl_left;
	}

	public ZheKouSetService getZheKouSetService() {
		return zheKouSetService;
	}

	public void setZheKouSetService(ZheKouSetService zheKouSetService) {
		this.zheKouSetService = zheKouSetService;
	}

	public FixedColumnTablePanel getZhekouTablePanel() {
		return zhekouTablePanel;
	}

	public void setZhekouTablePanel(FixedColumnTablePanel zhekouTablePanel) {
		this.zhekouTablePanel = zhekouTablePanel;
	}

}
