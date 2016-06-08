package com.CCL.view.kaitaimgr.son;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
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
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Customer;
import com.CCL.view.kaitaimgr.render.BicyclesMapRenderer;
import com.CCL.view.kaitaimgr.service.BicycleService;
import com.CCL.view.kaitaimgr.service.KaiTaiService;
import javax.swing.JSplitPane;

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
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 26));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);

		JSplitPane panel = new JSplitPane();
		panel.setResizeWeight(0.5);
		panel.setDividerSize(1);
		setLayout(new BorderLayout(0, 0));
		add(lblNewLabel_2, BorderLayout.NORTH);
		add(panel);

		scrollPane_1 = new JScrollPane();
		panel.setRightComponent(scrollPane_1);

		list_1 = new JList<Map<Bicycle, Integer>>();
		list_1.setValueIsAdjusting(true);

		list_1.setModel(new BicyclesListModel());
		list_1.setCellRenderer(new BicyclesMapRenderer());
		scrollPane_1.setViewportView(list_1);

		JScrollPane scrollPane = new JScrollPane();
		panel.setLeftComponent(scrollPane);

		list = new JList<Bicycle>();
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
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

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		panel_4.add(spinner_1);

		JButton button_1 = new JButton("\u6DFB\u52A0\u8F66\u8F86");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bicycle selectedValue = list.getSelectedValue();
				if (selectedValue != null) {
					addBicycle(selectedValue, Integer.parseInt(spinner_1.getValue().toString()));
					updateShowMsg();
					list_1.updateUI();
				} else {
					JOptionPane.showMessageDialog(null, "����ѡ����!");
				}
			}
		});
		panel_4.add(button_1);

		JButton button_3 = new JButton("\u51CF\u5C11\u8F66\u8F86");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bicycle selectedValue = list.getSelectedValue();
				if (selectedValue != null) {
					reduceBicycle(selectedValue, Integer.parseInt(spinner_1.getValue().toString()));
					updateShowMsg();
					list_1.updateUI();
				} else {
					JOptionPane.showMessageDialog(null, "����ѡ����!");
				}

			}

		});
		panel_4.add(button_3);
		
		JButton button_2 = new JButton("\u6E05\u7A7A\u8F66\u8F86");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bicyclesList.clear();
				bicyclesMap.clear();
				updateShowMsg();
				list_1.updateUI();
			}
		});
		panel_4.add(button_2);

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

		lbl_UserName = new JLabel("\u8BF7\u9009\u62E9\u7528\u6237");

		lbl_score = new JLabel("0");

		JLabel lblNewLabel_5 = new JLabel("\u7528\u6237\u7C7B\u578B:");

		lbl_userType = new JLabel("\u666E\u901A");
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
				if (updateShowMsg()) {
					int result = JOptionPane.showConfirmDialog(null, msgBox.getText(), "��ȷ��������Ϣ",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.OK_OPTION) {

						boolean isSuccess = KaiTaiService.rentCar(currentCustomer, bicyclesMap) != null;
						if (isSuccess) {
							JOptionPane.showMessageDialog(null, "�ɹ���Ӷ���");
						} else {
							JOptionPane.showMessageDialog(null, "��Ӷ���δ�ɹ�", "����", JOptionPane.ERROR_MESSAGE);
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, msgBox.getText(), "����", JOptionPane.ERROR_MESSAGE);
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
		ImageIcon BicycleImage = new ImageIcon("images\\MJBtn\\���г�.png");
		JLabel txt_kc = new JLabel("",JLabel.CENTER);
		JLabel txt_name = new JLabel("",JLabel.CENTER);
		JLabel txt_price = new JLabel("",JLabel.CENTER);
		JLabel txt_desc = new JLabel("",JLabel.CENTER);
		JPanel msgPanel = new JPanel(new GridLayout(2, 2));

		public BicycleListRenderer() {
			this.setLayout(new BorderLayout());
			add(new JLabel(BicycleImage), BorderLayout.WEST);
			msgPanel.add(txt_kc);
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
			txt_kc.setText("���: " + value.getInventory());
			txt_name.setText("����: " + value.getName());
			txt_price.setText("ԭ��: " + value.getPrice() + "\t" + "   �ۿۼ�:"
					+ (value.getPrice() * value.getType().getDiscount()));
			txt_desc.setText("����: " + value.getDescript());

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
			txt_kc.setForeground(foreground);
			txt_name.setForeground(foreground);
			txt_price.setForeground(foreground);
			txt_desc.setForeground(foreground);

			txt_kc.setBackground(background);
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
			msgBox.setText(msgBox.getText() + "��ӭ��," + currentCustomer.getName()
					+ ("Ů".equals(currentCustomer.getSex()) ? "Ůʿ" : "����") + "\n");
			String customerTypestr = currentCustomer.getCustomerType() == null ? "��ͨ"
					: currentCustomer.getCustomerType().toString();
			msgBox.setText(msgBox.getText() + "��ӭ���������:" + customerTypestr + "�ͻ�\n");

		} else {
			msgBox.setText(msgBox.getText() + "����ǰ��δѡ���κ��û�" + "\n");
			isOk = false;
		}

		if (bicyclesMap != null && !bicyclesMap.isEmpty()) {
			StringBuilder sb = new StringBuilder("��ѡ��ĳ�����: \n");
			for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
				sb.append("\t" + entry.getValue() + "��" + entry.getKey().getName() + "\n");
			}
			msgBox.setText(msgBox.getText() + sb.toString());

		} else {
			msgBox.setText(msgBox.getText() + "����ǰ��δѡ���κγ�" + "\n");
			isOk = false;
		}
		return isOk;

	}

	protected Map<Bicycle, Integer> bicyclesMap = new HashMap<Bicycle, Integer>();
	List<Map<Bicycle, Integer>> bicyclesList = new ArrayList<Map<Bicycle, Integer>>();
	private JSpinner spinner_1;
	private JList<Map<Bicycle, Integer>> list_1;
	private JScrollPane scrollPane_1;

	class BicyclesListModel implements ListModel<Map<Bicycle, Integer>> {

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

	boolean addBicycle(Bicycle b, int num) {

		Integer number = bicyclesMap.get(b);

		if (number == null) {
			number = num;
		} else {
			number += num;
		}

		if (number > b.getInventory()) {
			return false;
		}

		bicyclesMap.put(b, number);

		boolean isNotExist = true;
		for (Map<Bicycle, Integer> entry : bicyclesList) {
			if (entry.containsKey(b)) {
				entry.put(b, number);
				isNotExist = false;
				break;
			}
		}
		if (isNotExist) {
			Map<Bicycle, Integer> newEntry = new HashMap<Bicycle, Integer>();
			newEntry.put(b, number);
			bicyclesList.add(newEntry);
		}

		return true;
	}

	boolean reduceBicycle(Bicycle b, int num) {
		Integer number = bicyclesMap.get(b);

		if (number == null) {
			number = 0;
		} else {
			number -= num;
		}

		if (number <= 0) {

			bicyclesMap.remove(b);
			Iterator<Map<Bicycle, Integer>> iterator = bicyclesList.iterator();

			while (iterator.hasNext()) {
				Map<Bicycle, Integer> next = iterator.next();
				if (next.containsKey(b)) {
					iterator.remove();
					break;
				}
			}

			return true;
		}

		bicyclesMap.put(b, number);

		boolean isNotExist = true;
		for (Map<Bicycle, Integer> entry : bicyclesList) {
			if (entry.containsKey(b)) {
				entry.put(b, number);
				isNotExist = false;
				break;
			}
		}
		if (isNotExist) {
			Map<Bicycle, Integer> newEntry = new HashMap<Bicycle, Integer>();
			newEntry.put(b, number);
			bicyclesList.add(newEntry);
		}

		return true;
	}
}
