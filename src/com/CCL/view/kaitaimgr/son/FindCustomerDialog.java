package com.CCL.view.kaitaimgr.son;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.CCL.beans.Customer;
import com.CCL.view.kaitaimgr.service.CustomerService;

import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FindCustomerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindCustomerDialog dialog = new FindCustomerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindCustomerDialog() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				updateCustomerList();
			}
		});
		setTitle("\u9009\u62E9\u7528\u6237");
		setBounds(100, 100, 287, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			textField = new JTextField();
			textField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateCustomerList();
				}
			});
			textField.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("\u641C\u7D22");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
		);
		
		list = new JList<Customer>();
		list.setCellRenderer(new MyCellRenderer());
		scrollPane.setViewportView(list);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
						System.out.println("OK");
						if(kaiTaiPanel!=null){
							Customer currentUser = list.getSelectedValue();
							kaiTaiPanel.setCurrCustomer(currentUser);
						}
						
						setVisible(false);
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void updateCustomerList() {
		
		
		List<Customer> customers = null;
		String text = textField.getText();
		if("".equals(text)){
			customers= CustomerService.getAll();
		}else{
			customers = CustomerService.getAllUseLike(text);
		}
		
		
		
		list.setModel(new MyCustomerModel(customers ));
		
	}

	KaiTaiPanel kaiTaiPanel = null;
	private JList<Customer> list;
	private JTextField textField;

	public FindCustomerDialog(KaiTaiPanel kaiTaiPanel) {
		this();
		this.kaiTaiPanel = kaiTaiPanel;
	}
	
	
	class MyCustomerModel extends AbstractListModel<Customer> {

		public MyCustomerModel(List<Customer> values) {
			this.values.addAll(values);

		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		List<Customer> values = new ArrayList<Customer>();

		@Override
		public Customer getElementAt(int index) {
			return values.get(index);

		}

		@Override
		public int getSize() {
			return values.size();
		}

	}



	class MyCellRenderer extends JPanel implements ListCellRenderer<Customer> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;



		public MyCellRenderer() {
			this.setLayout(new BorderLayout());
			setOpaque(true);
		}

		

		@Override
		public Component getListCellRendererComponent(JList<? extends Customer> list, Customer value, int index,
				boolean isSelected, boolean cellHasFocus) {
			removeAll();
			
			add(new JLabel(new ImageIcon("images\\MJBtn\\man.png")),BorderLayout.WEST);
			add(new JLabel(value.getId()+" : "+value.getName()));

			Color background;
			Color foreground;

			// check if this cell represents the current DnD drop location
			JList.DropLocation dropLocation = list.getDropLocation();
			if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {

				background = Color.BLUE;
				foreground = Color.WHITE;

				// check if this cell is selected
			} else if (isSelected) {
				background = Color.RED;
				foreground = Color.WHITE;

				// unselected, and not the DnD drop location
			} else {
				background = Color.WHITE;
				foreground = Color.BLACK;
			}
			;

			setBackground(background);
			setForeground(foreground);

			return this;
		}
	}
}