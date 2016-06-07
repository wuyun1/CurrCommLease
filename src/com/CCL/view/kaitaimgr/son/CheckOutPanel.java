package com.CCL.view.kaitaimgr.son;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.CCL.beans.Order;
import com.CCL.beans.OrderState;
import com.CCL.view.kaitaimgr.service.KaiTaiService;

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
		static String[] colmnName = new String[] { "选中", "ID", "用户", "车型", "押金", "产生费用", "生成时间", "已启动时间", "状态" };
		Class[] columnTypes = new Class[] { Boolean.class, Long.class, Object.class, Object.class, Object.class,
				Object.class, Date.class, Date.class, Object.class };
		
		Vector<Order> orders = new Vector<Order>();

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
		
		public MyOrderTableModel() {
			super( convertToVector(colmnName), 3);
		}

		public void addRow(List<Order> orders2) {
			for (Order order : orders2) {
				addRow(order);
			}
		}
		
		public void addRow(Order order){
			if(!this.orders.contains(order)){
				this.orders.add(order);
				
				OrderState orderState = order.getOrderState();
				Date startTime = new Date();
				this.addRow(new Object[]{false,order.getId(),order.getCustomer().getName(),order.getBicycle().getName(),order.getDeposit(),300,startTime,startTime,orderState});
				
			}
		}

		public void removeAllrows() {
			this.dataVector.removeAllElements();
			this.orders.removeAllElements();
			this.fireTableDataChanged();
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

		JScrollPane scrollPane = new JScrollPane();

		// class

		table = new JTable();

		

		

		initTableData();

		scrollPane.setViewportView(table);
		add(scrollPane);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("\u8BA2\u5355\u7BA1\u7406");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 29));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		JButton button = new JButton("\u5168\u9009");
		panel_1.add(button);

		JButton button_1 = new JButton("\u542F\u52A8\u8BA2\u5355");
		panel_1.add(button_1);

		JButton button_2 = new JButton("\u7ED3\u7B97\u8BA2\u5355");
		panel_1.add(button_2);

	}
	private void initTableData() {
		table.setModel(dataModel);
		dataModel.removeAllrows();
		List<Order> orders = KaiTaiService.getAllOrder();
		dataModel.addRow(orders);
		TableColumn datecolumn = table.getColumn("生成时间");
		datecolumn.setPreferredWidth(80);
		datecolumn.setCellEditor(new DateTableCellEditor());
		datecolumn.setCellRenderer(new DateTableCellRenderer());
	}
	
	class DateTableCellEditor extends AbstractCellEditor implements TableCellEditor
	{
	    private JTextField tfDate = new JTextField();
	    private Date date;
	     
	    public Object getCellEditorValue() 
	    {
	        return date;
	    }
	 
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
	    {
	        Date date = (Date) value;
	        this.date = date;
	        tfDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
	        return tfDate;
	    }   
	}
	 
	class DateTableCellRenderer extends JLabel implements TableCellRenderer
	{
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	    {
	        Date date = (Date) value;
	        this.setText(new SimpleDateFormat("MM-dd HH:mm:ss").format(date));
	        return this;
	    }
	}

}
