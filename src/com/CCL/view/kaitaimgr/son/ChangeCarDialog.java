package com.CCL.view.kaitaimgr.son;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.view.kaitaimgr.render.BicyclesMapRenderer;
import com.CCL.view.kaitaimgr.service.BicycleService;
import com.CCL.view.kaitaimgr.son.KaiTaiPanel.BicycleListRenderer;
import com.CCL.view.kaitaimgr.son.KaiTaiPanel.BicyclesListModel;
import com.CCL.view.kaitaimgr.son.KaiTaiPanel.MyListModel;

import javax.swing.JSplitPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ChangeCarDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangeCarDialog dialog = new ChangeCarDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangeCarDialog() {
		setBounds(100, 100, 843, 457);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setResizeWeight(0.5);
			contentPanel.add(splitPane);
			{
				JScrollPane scrollPane = new JScrollPane();
				splitPane.setLeftComponent(scrollPane);
				{
					list_2 = new JList<Bicycle>();
					list_2.setCellRenderer(new BicycleListRenderer());
					scrollPane.setViewportView(list_2);
				}
				{
					cb_bicycleType = new JComboBox<BicycleType>();
					cb_bicycleType.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BicycleType selectedItem = (BicycleType) cb_bicycleType.getSelectedItem();
							if (selectedItem == null)
								return;
							List<Bicycle> bicycles = BicycleService.queryByType(selectedItem);
							list_2.setModel(new MyListModel(bicycles));
						}
					});
					List<BicycleType> allType = BicycleService.getAllType();
					if (allType != null && !allType.isEmpty()) {
						cb_bicycleType
								.setModel(new DefaultComboBoxModel<BicycleType>(allType.toArray(new BicycleType[] {})));
						ActionListener[] actionListeners = cb_bicycleType.getActionListeners();
						if (actionListeners.length > 0) {
							actionListeners[0].actionPerformed(null);
						}
					}

					scrollPane.setColumnHeaderView(cb_bicycleType);
				}
				
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				splitPane.setRightComponent(scrollPane);
				{
					list_1 = new JList<Map<Bicycle, Integer>>();
					list_1.setModel(new BicyclesListModel());
					list_1.setCellRenderer(new BicyclesMapRenderer());
					scrollPane.setViewportView(list_1);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
				panel.add(spinner);
			}
			{
				JButton button = new JButton("\u6DFB\u52A0\u8F66\u8F86");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Bicycle selectedValue = list_2.getSelectedValue();
						if (selectedValue != null) {
							addBicycle(selectedValue, Integer.parseInt(spinner.getValue().toString()));
							list_1.updateUI();
						} else {
							JOptionPane.showMessageDialog(null, "����ѡ����!");
						}
					}
				});
				panel.add(button);
			}
			{
				JButton button = new JButton("\u51CF\u5C11\u8F66\u8F86");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bicycle selectedValue = list_2.getSelectedValue();
						if (selectedValue != null) {
							reduceBicycle(selectedValue, Integer.parseInt(spinner.getValue().toString()));
							list_1.updateUI();
						} else {
							JOptionPane.showMessageDialog(null, "����ѡ����!");
						}

					}
				});
				panel.add(button);
			}
			{
				JButton button = new JButton("\u6E05\u7A7A\u8F66\u8F86");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bicyclesList.clear();
						bicyclesMap.clear();
						list_1.updateUI();
					}
				});
				panel.add(button);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parent.updateCurrentBicycMap(bicyclesMap);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	ChangeCarPanel parent;
	private JComboBox<BicycleType> cb_bicycleType;
	private JList<Bicycle> list_2;
	Map<Bicycle, Integer> bicyclesMap ;
	List<Map<Bicycle, Integer>> bicyclesList;
	private JSpinner spinner;
	private JList<Map<Bicycle, Integer>> list_1;

	public ChangeCarDialog(ChangeCarPanel changeCarPanel) {
		this();
		this.parent = changeCarPanel;
		this.bicyclesMap=changeCarPanel.getCurrentBicyclesMap();
		
		this.bicyclesList = new ArrayList<Map<Bicycle, Integer>>();

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			HashMap<Bicycle, Integer> newMap = new HashMap<Bicycle, Integer>();
			newMap.put(entry.getKey(), entry.getValue());
			this.bicyclesList.add(newMap);
		}
		
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
		JLabel txt_kc = new JLabel("", JLabel.CENTER);
		JLabel txt_name = new JLabel("", JLabel.CENTER);
		JLabel txt_price = new JLabel("", JLabel.CENTER);
		JLabel txt_desc = new JLabel("", JLabel.CENTER);
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
			txt_price.setText(
					"ԭ��: " + value.getPrice() + "\t" + "   �ۿۼ�:" + (value.getPrice() * value.getType().getDiscount()));
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
