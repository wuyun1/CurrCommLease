package com.CCL.view.kaitaimgr;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class KaiTaiPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public KaiTaiPanel() {
		
		JList list = new JList();
		list.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u6B22\u8FCE\u5149\u4E34", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JList list_1 = new JList();
		list_1.setBorder(new TitledBorder(null, "\u9009\u8F66", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("\u7F16\u53F7:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(textField))
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_1))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(button)))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
