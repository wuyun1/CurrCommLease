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

public class KaiTaiPanel extends JPanel {
	private JTextField textCustomerId;

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
		
		JPanel panel_2 = new JPanel();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(31)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		setLayout(new BorderLayout(0, 0));
		add(lblNewLabel_2, BorderLayout.NORTH);
		add(panel);
								
								JPanel panel_3 = new JPanel();
								
										JLabel lblNewLabel = new JLabel("\u62BC\u91D1\uFF1A");
										
												JSpinner spinner = new JSpinner();
												spinner.setModel(new SpinnerNumberModel(new Integer(200), null, null, new Integer(1)));
												
														JLabel lblNewLabel_1 = new JLabel("");
														lblNewLabel_1
																.setBorder(new TitledBorder(null, "\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
														GroupLayout gl_panel_3 = new GroupLayout(panel_3);
														gl_panel_3.setHorizontalGroup(
															gl_panel_3.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel_3.createSequentialGroup()
																	.addContainerGap()
																	.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
																		.addGroup(gl_panel_3.createSequentialGroup()
																			.addComponent(lblNewLabel)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
																	.addContainerGap())
														);
														gl_panel_3.setVerticalGroup(
															gl_panel_3.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel_3.createSequentialGroup()
																	.addContainerGap()
																	.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblNewLabel)
																		.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
																	.addContainerGap())
														);
														panel_3.setLayout(gl_panel_3);
														GroupLayout gl_panel = new GroupLayout(panel);
														gl_panel.setHorizontalGroup(
															gl_panel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel.createSequentialGroup()
																	.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel.createSequentialGroup()
																			.addGap(54)
																			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_panel.createSequentialGroup()
																			.addGap(183)
																			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
																	.addContainerGap(80, Short.MAX_VALUE))
														);
														gl_panel.setVerticalGroup(
															gl_panel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel.createSequentialGroup()
																	.addGap(62)
																	.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
																	.addGap(18)
																	.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
																	.addContainerGap(23, Short.MAX_VALUE))
														);
														panel.setLayout(gl_panel);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);
		
				JButton button = new JButton("\u786E\u5B9A");
				panel_4.add(button);
				
				JPanel panel_1 = new JPanel();
				add(panel_1, BorderLayout.WEST);
				
						JLabel label = new JLabel("\u67E5\u8BE2\u7528\u6237:");
						
								textCustomerId = new JTextField();
								textCustomerId.addCaretListener(new CaretListener() {
									public void caretUpdate(CaretEvent arg0) {
										System.out.println(32);
										upDateCustomerList();
									}
								});
								textCustomerId.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										System.out.println(32);
										upDateCustomerList();
									}
								});
								textCustomerId.addInputMethodListener(new InputMethodListener() {
									public void caretPositionChanged(InputMethodEvent arg0) {
									}
									public void inputMethodTextChanged(InputMethodEvent arg0) {
										
									}
								});
								textCustomerId.setColumns(10);
																GroupLayout gl_panel_1 = new GroupLayout(panel_1);
																gl_panel_1.setHorizontalGroup(
																	gl_panel_1.createParallelGroup(Alignment.LEADING)
																		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
																			.addContainerGap(20, Short.MAX_VALUE)
																			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel_1.createSequentialGroup()
																					.addComponent(textCustomerId, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
																					.addContainerGap())
																				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
																					.addComponent(label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																					.addGap(40))))
																);
																gl_panel_1.setVerticalGroup(
																	gl_panel_1.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel_1.createSequentialGroup()
																			.addGap(24)
																			.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																			.addGap(67)
																			.addComponent(textCustomerId, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
																			.addContainerGap(118, Short.MAX_VALUE))
																);
																panel_1.setLayout(gl_panel_1);
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
