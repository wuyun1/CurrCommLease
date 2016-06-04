package com.CCL.view.kaitaimgr.son;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.CCL.beans.Customer;
import com.CCL.view.kaitaimgr.service.CustomerService;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Insets;
import javax.swing.JComboBox;

public class KaiTaiPanel extends JPanel {
	private JComboBox textCustomerId;

	/**
	 * Create the panel.
	 */
	public KaiTaiPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				upDateCustomerList();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("\u795D\u60A8\u65C5\u884C\u6109\u5FEB");
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		
		JScrollPane panel_2 = new JScrollPane();
		
		JPanel scrollPane_1 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		setLayout(new BorderLayout(0, 0));
		add(lblNewLabel_2, BorderLayout.NORTH);
		add(panel);
														GroupLayout gl_panel = new GroupLayout(panel);
														gl_panel.setHorizontalGroup(
															gl_panel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
																	.addContainerGap())
														);
														gl_panel.setVerticalGroup(
															gl_panel.createParallelGroup(Alignment.TRAILING)
																.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
																	.addContainerGap())
														);
														panel.setLayout(gl_panel);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);
		
				JButton button = new JButton("\u786E\u5B9A");
				panel_4.add(button);
				
				JPanel panel_1 = new JPanel();
				add(panel_1, BorderLayout.WEST);
																
																JPanel panel_5 = new JPanel();
																
																JPanel panel_3 = new JPanel();
																
																		JLabel lblNewLabel = new JLabel("\u62BC\u91D1\uFF1A");
																		
																				JSpinner spinner = new JSpinner();
																				spinner.setModel(new SpinnerNumberModel(new Integer(200), null, null, new Integer(1)));
																				
																						JPanel lblNewLabel_1 = new JPanel();
																						lblNewLabel_1
																								.setBorder(new TitledBorder(null, "\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																						
																						JComboBox comboBox = new JComboBox();
																						GroupLayout gl_panel_3 = new GroupLayout(panel_3);
																						gl_panel_3.setHorizontalGroup(
																							gl_panel_3.createParallelGroup(Alignment.LEADING)
																								.addGroup(gl_panel_3.createSequentialGroup()
																									.addContainerGap()
																									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
																										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
																										.addGroup(gl_panel_3.createSequentialGroup()
																											.addComponent(lblNewLabel)
																											.addPreferredGap(ComponentPlacement.RELATED)
																											.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(ComponentPlacement.RELATED)
																											.addComponent(comboBox, 0, 131, Short.MAX_VALUE)))
																									.addContainerGap())
																						);
																						gl_panel_3.setVerticalGroup(
																							gl_panel_3.createParallelGroup(Alignment.LEADING)
																								.addGroup(gl_panel_3.createSequentialGroup()
																									.addContainerGap()
																									.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
																										.addComponent(lblNewLabel)
																										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																									.addPreferredGap(ComponentPlacement.RELATED)
																									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
																									.addContainerGap())
																						);
																						panel_3.setLayout(gl_panel_3);
																
																		textCustomerId = new JComboBox();
																		textCustomerId.setEditable(true);
																		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
																		
																				JLabel label = new JLabel("\u67E5\u8BE2\u7528\u6237:");
																		
																		JPanel lblNewLabel_3 = new JPanel();
																		lblNewLabel_3.setBorder(new TitledBorder(null, "\u7528\u6237\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
																		gl_panel_5.setHorizontalGroup(
																			gl_panel_5.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel_5.createSequentialGroup()
																					.addContainerGap()
																					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
																						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
																						.addGroup(gl_panel_5.createSequentialGroup()
																							.addComponent(label, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
																							.addPreferredGap(ComponentPlacement.RELATED)
																							.addComponent(textCustomerId, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
																					.addContainerGap())
																		);
																		gl_panel_5.setVerticalGroup(
																			gl_panel_5.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel_5.createSequentialGroup()
																					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
																						.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																						.addComponent(textCustomerId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																					.addPreferredGap(ComponentPlacement.RELATED)
																					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
																					.addContainerGap())
																		);
																		
																		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u540D:");
																		
																		JLabel label_1 = new JLabel("\u7528\u6237\u79EF\u5206:");
																		
																		JLabel label_2 = new JLabel("\u5C0F\u9EC4");
																		
																		JLabel label_3 = new JLabel("30");
																		
																		JLabel lblNewLabel_5 = new JLabel("\u7528\u6237\u7C7B\u578B:");
																		
																		JLabel label_4 = new JLabel("30");
																		GroupLayout gl_lblNewLabel_3 = new GroupLayout(lblNewLabel_3);
																		gl_lblNewLabel_3.setHorizontalGroup(
																			gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_lblNewLabel_3.createSequentialGroup()
																					.addContainerGap()
																					.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
																						.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.TRAILING, false)
																							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																							.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																						.addComponent(lblNewLabel_4))
																					.addPreferredGap(ComponentPlacement.UNRELATED)
																					.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
																						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
																						.addComponent(label_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
																						.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
																					.addContainerGap())
																		);
																		gl_lblNewLabel_3.setVerticalGroup(
																			gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_lblNewLabel_3.createSequentialGroup()
																					.addContainerGap()
																					.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.BASELINE)
																						.addComponent(lblNewLabel_4)
																						.addComponent(label_2))
																					.addPreferredGap(ComponentPlacement.UNRELATED)
																					.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.BASELINE)
																						.addComponent(label_1)
																						.addComponent(label_3))
																					.addPreferredGap(ComponentPlacement.UNRELATED)
																					.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.BASELINE)
																						.addComponent(lblNewLabel_5)
																						.addComponent(label_4))
																					.addContainerGap(23, Short.MAX_VALUE))
																		);
																		lblNewLabel_3.setLayout(gl_lblNewLabel_3);
																		panel_5.setLayout(gl_panel_5);
																panel_1.add(panel_5);
																panel_1.add(panel_3);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});

//		upDateCustomerList();

	}

	void upDateCustomerList() {
//		String text = textCustomerId.getText();
//		if("".equals(text)){
//			list.setModel(new MyCustomerModel(CustomerService.getAll()));
//		}else{
//			list.setModel(new MyCustomerModel(CustomerService.getAllByIdUseLike(text)));
//		}
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
