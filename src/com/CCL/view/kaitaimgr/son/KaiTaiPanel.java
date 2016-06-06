package com.CCL.view.kaitaimgr.son;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Customer;
import com.CCL.view.kaitaimgr.service.BicycleService;
import com.CCL.view.kaitaimgr.service.KaiTaiService;

public class KaiTaiPanel extends JPanel {

	/**
	 * Create the panel.
	 */

	FindCustomerDialog findCustomerDialog;

	Customer currentCustomer = null;
	Bicycle currentBicycle = null;
	private JLabel lbl_UserName;
	private JLabel lbl_score;
	private JLabel lbl_userType;
	private JComboBox<BicycleType> cb_bicycleType;
	private JList<Bicycle> list;
	private JTextPane msgBox;

	public KaiTaiPanel() {

		JLabel lblNewLabel_2 = new JLabel("\u795D\u60A8\u65C5\u884C\u6109\u5FEB");

		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panel = new JPanel();
		setLayout(new BorderLayout(0, 0));
		add(lblNewLabel_2, BorderLayout.NORTH);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		list = new JList<Bicycle>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				currentBicycle = list.getSelectedValue();
				updateShowMsg();
			}
		});
		list.setCellRenderer(new BicycleListRenderer());
		scrollPane.setViewportView(list);

		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);

		JButton button = new JButton("\u786E\u5B9A\u4FE1\u606F");
		panel_4.add(button);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);

		JPanel panel_5 = new JPanel();

		JPanel panel_3 = new JPanel();

		JLabel lblNewLabel = new JLabel("\u62BC\u91D1\uFF1A");

		JLabel spinner = new JLabel();
		spinner.setText("200");

		msgBox = new JTextPane();
		msgBox.setBorder(new TitledBorder(null, "\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		cb_bicycleType = new JComboBox<BicycleType>();
		cb_bicycleType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BicycleType selectedItem = (BicycleType) cb_bicycleType.getSelectedItem();
				if (selectedItem == null)
					return;
				List<Bicycle> bicycles = BicycleService.queryByType(selectedItem);
				list.setModel(new MyListModel(bicycles));
			}
		});

		List<BicycleType> allType = BicycleService.getAllType();
		if (allType != null && !allType.isEmpty()) {
			cb_bicycleType.setModel(new DefaultComboBoxModel<BicycleType>(allType.toArray(new BicycleType[] {})));
			ActionListener[] actionListeners = cb_bicycleType.getActionListeners();
			if (actionListeners.length > 0) {
				actionListeners[0].actionPerformed(null);
			}
		}

		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(msgBox, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
								.addGroup(gl_panel_3.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 62,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cb_bicycleType, 0, 131, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(cb_bicycleType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(msgBox, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE).addContainerGap()));
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label = new JLabel("\u67E5\u8BE2\u7528\u6237:");

		JPanel lblNewLabel_3 = new JPanel();
		lblNewLabel_3.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5F53\u524D\u7528\u6237\u4FE1\u606F",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JLayeredPane layeredPane = new JLayeredPane();

		JButton btnNewButton = new JButton("\u5207\u6362\u7528\u6237");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (findCustomerDialog == null) {
					findCustomerDialog = new FindCustomerDialog(KaiTaiPanel.this);
					findCustomerDialog.setModal(true);
				}
				findCustomerDialog.setLocationRelativeTo(null);
				findCustomerDialog.setVisible(true);
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
						.addGroup(gl_panel_5.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton)
										.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
				.addContainerGap()));
		gl_panel_5
				.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
										.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
												.addComponent(label, GroupLayout.PREFERRED_SIZE, 28,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addContainerGap()));
		layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.X_AXIS));

		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u540D:");

		JLabel label_1 = new JLabel("\u7528\u6237\u79EF\u5206:");

		lbl_UserName = new JLabel("\u5C0F\u9EC4");

		lbl_score = new JLabel("30");

		JLabel lblNewLabel_5 = new JLabel("\u7528\u6237\u7C7B\u578B:");

		lbl_userType = new JLabel("\u9EC4\u91D1");
		GroupLayout gl_lblNewLabel_3 = new GroupLayout(lblNewLabel_3);
		gl_lblNewLabel_3.setHorizontalGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lblNewLabel_3.createSequentialGroup().addContainerGap()
						.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addComponent(lblNewLabel_4))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_UserName, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addComponent(lbl_score, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143,
										Short.MAX_VALUE)
								.addComponent(lbl_userType, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
						.addContainerGap()));
		gl_lblNewLabel_3
				.setVerticalGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lblNewLabel_3.createSequentialGroup().addContainerGap()
								.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4).addComponent(lbl_UserName))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
										.addComponent(lbl_score))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_lblNewLabel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_5).addComponent(lbl_userType))
								.addContainerGap(23, Short.MAX_VALUE)));
		lblNewLabel_3.setLayout(gl_lblNewLabel_3);
		panel_5.setLayout(gl_panel_5);
		panel_1.add(panel_5);
		panel_1.add(panel_3);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(updateShowMsg()){
					int result = JOptionPane.showConfirmDialog(null, msgBox.getText(), "请确认您的信息",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.OK_OPTION) {
						
						boolean isSuccess = KaiTaiService.rentCar(currentCustomer,currentBicycle);
						if(isSuccess){
							JOptionPane.showMessageDialog(null, "成功添加订单");
						}else{
							JOptionPane.showMessageDialog(null, "添加订单未成功","错误",JOptionPane.ERROR_MESSAGE);
						}
					}

				}else{
					JOptionPane.showMessageDialog(null, msgBox.getText(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

		// upDateCustomerList();

	}

	public void setCurrCustomer(Customer currentUser) {

		if (currentUser == null)
			return;
		currentCustomer = currentUser;

		lbl_UserName.setText(currentUser.getName());
		int integral = currentUser.getIntegral() == null ? 0 : currentUser.getIntegral();
		lbl_score.setText(integral + "");
		lbl_userType.setText(currentUser.getCustomerType() + "");
		updateShowMsg();

	}

	class MyListModel extends AbstractListModel<Bicycle> {

		List<Bicycle> bicycles = null;

		public MyListModel(List<Bicycle> bicycles) {
			this.bicycles = bicycles;
		}

		@Override
		public int getSize() {
			return bicycles.size();
		}

		@Override
		public Bicycle getElementAt(int index) {
			return bicycles.get(index);
		}
	}

	class BicycleListRenderer extends JPanel implements ListCellRenderer<Bicycle> {
		ImageIcon BicycleImage = new ImageIcon("images\\MJBtn\\自行车.png");
		JLabel txt_id = new JLabel();
		JLabel txt_name = new JLabel();
		JLabel txt_price = new JLabel();
		JLabel txt_desc = new JLabel();
		JPanel msgPanel = new JPanel(new GridLayout(2, 2));

		public BicycleListRenderer() {
			this.setLayout(new BorderLayout());
			add(new JLabel(BicycleImage), BorderLayout.WEST);
			msgPanel.add(txt_id);
			msgPanel.add(txt_name);
			msgPanel.add(txt_price);
			msgPanel.add(txt_desc);
			add(msgPanel);
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Bicycle value, int index, boolean isSelected,
				boolean cellHasFocus) {

			// removeAll();
			txt_id.setText("ID: " + value.getId());
			txt_name.setText("名称: " + value.getName());
			txt_price.setText("价格: " + value.getPrice());
			txt_desc.setText("介绍: " + value.getDescript());

			Color background;
			Color foreground;

			// check if this cell represents the current DnD drop location
			JList.DropLocation dropLocation = list.getDropLocation();
			if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {

				background = Color.RED;
				foreground = Color.WHITE;

				// check if this cell is selected
			} else if (isSelected) {

				background = Color.BLUE;
				foreground = Color.WHITE;

				// unselected, and not the DnD drop location
			} else {
				background = Color.WHITE;
				foreground = Color.BLACK;
			}
			;

			setBackground(background);
			setForeground(foreground);
			txt_id.setForeground(foreground);
			txt_name.setForeground(foreground);
			txt_price.setForeground(foreground);
			txt_desc.setForeground(foreground);

			txt_id.setBackground(background);
			txt_name.setBackground(background);
			txt_price.setBackground(background);
			txt_desc.setBackground(background);

			msgPanel.setBackground(background);
			msgPanel.setForeground(foreground);

			return this;

		}

	}

	boolean updateShowMsg() {
		
		boolean isOk = true;
		msgBox.setText("");

		if (currentCustomer != null) {
			msgBox.setText(msgBox.getText() + "欢迎您," + currentCustomer.getName()
					+ ("女".equals(currentCustomer.getSex()) ? "女士" : "先生") + "\n");
			String customerTypestr = currentCustomer.getCustomerType() == null ? "普通"
					: currentCustomer.getCustomerType().toString();
			msgBox.setText(msgBox.getText() + "欢迎您的身份是:" + customerTypestr + "客户\n");
			
		} else {
			msgBox.setText(msgBox.getText() + "您当前还未选择任何用户" + "\n");
			isOk=false;
		}

		if (currentBicycle != null) {
			msgBox.setText(msgBox.getText() + "您选择的车辆是: " + currentBicycle.getName() + "\n");

		} else {
			msgBox.setText(msgBox.getText() + "您当前还未选择任何车" + "\n");
			isOk=false;
		}
		return isOk;

	}

}
