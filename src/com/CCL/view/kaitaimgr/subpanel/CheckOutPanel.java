package com.CCL.view.kaitaimgr.subpanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.CCL.beans.Bicycle;
import com.CCL.beans.Bill;
import com.CCL.beans.Order;
import com.CCL.view.kaitaimgr.render.BicyclesMapRenderer;
import com.CCL.view.kaitaimgr.service.KaiTaiService;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;

public class CheckOutPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7206926175365227797L;

	static class MyOrderTableModel extends DefaultTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5936892263699091776L;
		static String[] colmnName = new String[] { "ѡ��", "ID", "�û�", "����", "Ѻ��", "��������", "����ʱ��", "������ʱ��", "״̬" };
		Class[] columnTypes = new Class[] { Boolean.class, Long.class, Object.class, Object.class, Object.class,
				Object.class, Date.class, Date.class, Object.class };

		Vector<Order> orders = new Vector<Order>();

		Map<Order, Bill> bills = new HashMap<Order, Bill>();

		public Order getOrderByRow(int row) {
			return orders.get(row);
		}

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		public MyOrderTableModel() {
			super(convertToVector(colmnName), 3);
		}

		public void addRow(List<Order> orders2) {
			for (Order order : orders2) {
				addRow(order);
			}
		}

		public void addRow(Order order) {
			if (!this.orders.contains(order)) {
				this.orders.add(order);
				this.addRow(new Object[] { false, order.getId(), order.getCustomer().getName(), order.getBicycles(),
						order.getDeposit(), 0, order.getPutTime(), order.getStartTime(), order.getOrderState() });
			}
		}

		public void refreshTableData(int row) {
			Order order = this.orders.get(row);
			this.setValueAt(false, row, 0);
			this.setValueAt(order.getBicycles(), row, 3);
			Bill bill = bills.get(order);
			if (bill != null)
				this.setValueAt(bill.getTotal(), row, 5);
			this.setValueAt(order.getStartTime(), row, 7);
			this.setValueAt(order.getOrderState(), row, 8);

			// this.addRow(new
			// Object[]{false,order.getId(),order.getCustomer().getName(),order.getBicycle().getName(),order.getDeposit(),300,order.getPutTime(),order.getStartTime(),
			// order.getOrderState()});
		}

		public void removeAllrows() {
			this.dataVector.removeAllElements();
			this.orders.removeAllElements();
			this.fireTableDataChanged();
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			if (column != 0)
				return false;
			return super.isCellEditable(row, column);
		}

		public void updateSpendTime() {
			// TODO Auto-generated method stub
			for (int i = 0, n = getRowCount(); i < n; i++) {
				try {
					if ("���ڽ���".equals(getStateByRowNum(i))) {
						fireTableCellUpdated(i, 7);
					}
				} catch (Exception e) {

				}

			}

		}

		public void checkAllPrestartOrder() {
			for (int i = 0, n = getRowCount(); i < n; i++) {
				try {
					if ("׼������".equals(getStateByRowNum(i))) {
						setValueAt(true, i, 0);
					} else {
						setValueAt(false, i, 0);
					}
				} catch (Exception e) {

				}

			}
		}

		public String getStateByRowNum(int row) {
			return getValueAt(row, 8).toString();
		}

		boolean isCheckRow(int row) {
			return (Boolean) getValueAt(row, 0);
		}

		public void startAllCheckOrder() {
			for (int i = 0, n = getRowCount(); i < n; i++) {
				if (isCheckRow(i)) {
					try {
						if ("׼������".equals(getStateByRowNum(i))) {

							Order corder = orders.get(i);
							if (KaiTaiService.startOrder(corder)) {
								JOptionPane.showMessageDialog(null, "�����ɹ�");
								refreshTableData(i);
							} else {
								JOptionPane.showMessageDialog(null, "����ʧ��", "����", JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}

		public void checkStartOrder() {
			for (int i = 0, n = getRowCount(); i < n; i++) {
				try {
					if ("���ڽ���".equals(getStateByRowNum(i))) {
						setValueAt(true, i, 0);
					} else {
						setValueAt(false, i, 0);
					}
				} catch (Exception e) {

				}

			}
		}

		public void accountsCheckOrder() {
			for (int i = 0, n = getRowCount(); i < n; i++) {
				if (isCheckRow(i)) {
					try {
						if ("���ڽ���".equals(getStateByRowNum(i))) {

							Order corder = orders.get(i);
							Bill bill = KaiTaiService.accountsOrder(corder);
							if (bill != null) {
								bills.put(corder, bill);
								refreshTableData(i);
							} else {
								JOptionPane.showMessageDialog(null, "��������ʧ��!", "����", JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}

		public Date getStopTime(int row) {
			return this.orders.get(row).getStopTime();
		}

		public void removeAllCheckOrder() {
			for (int i = 0, n = getRowCount(); i < n; i++) {
				if (isCheckRow(i)) {
					try {
						if ("׼������".equals(getStateByRowNum(i))) {

							Order corder = orders.get(i);
							if (KaiTaiService.delOrder(corder)) {
								JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "����", JOptionPane.ERROR_MESSAGE);
								orders.remove(corder);
								removeRow(i);
								n--;
							} else {
								JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "����", JOptionPane.ERROR_MESSAGE);
							}

						}
					} catch (Exception e) {

					}
				}

			}
		}

	}

	MyOrderTableModel dataModel = new MyOrderTableModel();
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CheckOutPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				initTableData();

			}

		});
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("\u8BA2\u5355\u7BA1\u7406");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 29));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "\u542F\u52A8\u8BA2\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);

		JButton button = new JButton("\u5168\u9009\u6240\u6709\u5F85\u5F00\u542F\u8BA2\u5355");
		panel_3.add(button);

		JButton button_1 = new JButton("\u542F\u52A8\u8BA2\u5355");
		panel_3.add(button_1);

		JButton button_4 = new JButton("\u5220\u9664\u8BA2\u5355");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel.removeAllCheckOrder();
			}
		});
		panel_3.add(button_4);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel.startAllCheckOrder();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel.checkAllPrestartOrder();
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "\u7ED3\u675F\u8BA2\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_2);

		JButton button_3 = new JButton("\u5168\u9009\u6240\u6709\u5DF2\u5F00\u542F\u8BA2\u5355");
		panel_2.add(button_3);

		JButton button_2 = new JButton("\u7ED3\u7B97\u8BA2\u5355");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel.accountsCheckOrder();
			}
		});
		panel_2.add(button_2);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setResizeWeight(0.7);
		add(splitPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		// class

		table = new JTable();
		initTableData();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				Order orderByRow = dataModel.getOrderByRow(row);
				if (orderByRow.getBicyclesMap() == null) {
					KaiTaiService.writebicycleMap(orderByRow);
				}
				System.out.println(orderByRow.getBicyclesMap());
				list.setModel(new BicyclesListModel(orderByRow.getBicyclesMap()));
			}
		});
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);

		list = new JList<Map<Bicycle, Integer>>();
		

		 list.setCellRenderer(new BicyclesMapRenderer());
		scrollPane_1.setViewportView(list);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel.checkStartOrder();
			}
		});

	}

	private void initTableData() {
		table.setModel(dataModel);
		dataModel.removeAllrows();
		List<Order> orders = KaiTaiService.getAllOrder();
		dataModel.addRow(orders);
		table.getColumn("ѡ��").setPreferredWidth(20);
		table.getColumn("ID").setPreferredWidth(20);
		TableColumn datecolumn = table.getColumn("����ʱ��");
		datecolumn.setPreferredWidth(80);
		// datecolumn.setCellEditor(new DateTableCellEditor());
		datecolumn.setCellRenderer(new DateTableCellRenderer());

		TableColumn spendcolumn = table.getColumn("������ʱ��");
		spendcolumn.setPreferredWidth(80);
		spendcolumn.setCellRenderer(new SpendDateTableCellRenderer());

		updateSpendTimer.restart();

	}

	Timer updateSpendTimer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dataModel.updateSpendTime();
		}
	});
	private JList<Map<Bicycle, Integer>> list;

	// class DateTableCellEditor extends AbstractCellEditor implements
	// TableCellEditor
	// {
	// private JTextField tfDate = new JTextField();
	// private Date date;
	//
	// public Object getCellEditorValue()
	// {
	// return date;
	// }
	//
	// public Component getTableCellEditorComponent(JTable table, Object value,
	// boolean isSelected, int row, int column)
	// {
	// Date date = (Date) value;
	// this.date = date;
	// tfDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
	// return tfDate;
	// }
	// }

	class DateTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value == null) {
				return null;
			}
			Date date = (Date) value;
			this.setText(new SimpleDateFormat("MM-dd HH:mm:ss").format(date));
			return this;
		}
	}

	// class SpendDateTableCellEditor extends AbstractCellEditor implements
	// TableCellEditor
	// {
	// private JTextField tfDate = new JTextField();
	// private Date date;
	//
	// public Object getCellEditorValue()
	// {
	// return date;
	// }
	//
	// public Component getTableCellEditorComponent(JTable table, Object value,
	// boolean isSelected, int row, int column)
	// {
	// Date date = (Date) value;
	// this.date = date;
	// tfDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
	// return tfDate;
	// }
	// }

	class SpendDateTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value == null || "׼������".equals(dataModel.getStateByRowNum(row))) {
				this.setText("0 �� 0 ��");
				return this;
			}
			Date date = (Date) value;
			Date d1;
			if ("�������".equals(dataModel.getStateByRowNum(row))) {
				d1 = dataModel.getStopTime(row);
			} else {
				d1 = new Date();
			}
			Date d2 = date;
			long diff = d1.getTime() - d2.getTime();// �����õ��Ĳ�ֵ��΢�뼶��
			long days = diff / (1000 * 60 * 60 * 24);

			int hours = (int) ((diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
			int minutes = (int) ((diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60));
			int second = (int) ((diff / 1000) % 60);
			String showText = minutes + " �� " + second + " ��";
			if (days > 0 || hours > 0) {
				showText = hours + " Сʱ " + showText;
				if (days > 0) {
					showText = days + " �� " + hours + " Сʱ " + showText;
				}
			}
			// new SimpleDateFormat("MM-dd HH:mm:ss").format(date)
			this.setText(showText);
			return this;
		}
	}

	class BicyclesListModel implements ListModel<Map<Bicycle, Integer>> {

		private List<Map<Bicycle, Integer>> bicyclesList;

		public BicyclesListModel(Map<Bicycle, Integer> bicycmaps) {
			this.bicyclesList = new ArrayList<Map<Bicycle, Integer>>();

			for (Entry<Bicycle, Integer> entry : bicycmaps.entrySet()) {
				HashMap<Bicycle, Integer> newMap = new HashMap<Bicycle, Integer>();
				newMap.put(entry.getKey(), entry.getValue());
				this.bicyclesList.add(newMap);
			}

		}

		@Override
		public int getSize() {
			int size = bicyclesList.size();

			return size;
		}

		@Override
		public Map<Bicycle, Integer> getElementAt(int index) {

			return bicyclesList.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {

		}

		@Override
		public void removeListDataListener(ListDataListener l) {

		}
	}

}
