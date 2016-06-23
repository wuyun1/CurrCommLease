package com.CCL.panel.glj.xitongguanli;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.CCL.panel.MPanel;
import com.CCL.panel.ProgressPanel;
import com.CCL.panel.glj.xitongguanli.son.RiYinYeSelect;
import com.CCL.panel.glj.xitongguanli.son.ShouFeiSet;
import com.CCL.panel.glj.xitongguanli.son.ZhangDanMingXiSelect;
import com.CCL.panel.glj.xitongguanli.son.ZheKouSet;
import com.CCL.panel.mlf.Opanel_opeuser_set;
import com.CCL.panel.mlf.Panel_setvehicle;
import com.CCL.panel.mlf.panel_UserAuthorzatiom;
import com.CCL.service.glj.OpeperSelect;
import com.CCL.view.other.OtherManager;

public class XiTongMgr extends JPanel{
	private JPanel sellPanel;
	public XiTongMgr(JPanel sellPanel) {
		this.sellPanel = sellPanel;
		setLayout(new BorderLayout(0, 0));
		
		 final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.add(tabbedPane);
		
		ShouFeiSet panel = new ShouFeiSet("",sellPanel);
		if(!OpeperSelect.preJudge("收费设置"))
		{
			Component[] com = panel.getComponents();
			panel.getShouFeiTablePanel().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbedPane.addTab("收费设置", null, panel, null);
		
		ZheKouSet panel_1 = new ZheKouSet("",sellPanel);
		if(!OpeperSelect.preJudge("折扣设置"))
		{
			Component[] com = panel_1.getComponents();
			panel_1.getZhekouTablePanel().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbedPane.addTab("折扣设置", null, panel_1, null);
		
		final JTabbedPane tabbed_zhangdangmgr = new JTabbedPane(JTabbedPane.TOP);
		tabbed_zhangdangmgr.setOpaque(false);
		RiYinYeSelect panel_21 = new RiYinYeSelect("",sellPanel);
		if(!OpeperSelect.preJudge("日营业查询"))
		{
			Component[] com = panel_21.getComponents();
			panel_21.getRiYinYeTablePanel().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbed_zhangdangmgr.addTab("日营业查询", null, panel_21, null);
		ZhangDanMingXiSelect panel_22 = new ZhangDanMingXiSelect("",sellPanel);
		if(!OpeperSelect.preJudge("账单明细查询"))
		{
			Component[] com = panel_22.getComponents();
			panel_22.getZhangdanmingxi().setEnabled(false);
//			panel_22.getRadPanel().setEnabled(false);
			panel_22.getRad_all().setEnabled(false);
			panel_22.getRad_huiyuan().setEnabled(false);
			panel_22.getRad_putong().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbed_zhangdangmgr.addTab("账单明细查询", null, panel_22, null);
		ProgressPanel panel_23 = new ProgressPanel();
		if(!OpeperSelect.preJudge("销售趋势分析"))
		{
//			Component[] com = panel_23.getComponents();
//			for (Component component : com) {
//				component.setEnabled(false);
//			}
		}
		tabbed_zhangdangmgr.addTab("销售趋势分析", null, panel_23, null);
		tabbedPane.addTab("账单管理", null, tabbed_zhangdangmgr, null);
		
		
		Panel_setvehicle panel_4 = new Panel_setvehicle();
		if(!OpeperSelect.preJudge("账单明细查询"))
		{
			Component[] com = panel_4.getComponents();
			panel_4.getTab_vehicleinfo().setEnabled(false);
			panel_4.getBtn_vrhicle_add().setVisible(false);
			panel_4.getBtn_Vehicle_search().setVisible(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbedPane.addTab("车辆管理", null, panel_4, null);
		
		tabbed_zhangdangmgr.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {

				int selectedIndex = tabbed_zhangdangmgr.getSelectedIndex();
				String panelTitle = tabbedPane.getTitleAt(selectedIndex);
				if(!OpeperSelect.preJudge(panelTitle))
				{
					JOptionPane.showMessageDialog(null, "您没有"+panelTitle+"的权限", "提醒", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
	
	
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tabbed_zhangdangmgr.getSelectedIndex();
					String title = tabbedPane.getTitleAt(selectedIndex);
					if(!OpeperSelect.preJudge(title))
					{
						JOptionPane.showMessageDialog(null, "您没有"+title+"的权限", "提醒", JOptionPane.ERROR_MESSAGE); 
					}
				}
		});
	}

}
