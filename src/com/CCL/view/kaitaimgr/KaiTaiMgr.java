package com.CCL.view.kaitaimgr;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import com.CCL.view.kaitaimgr.son.KaiTaiPanel;

public class KaiTaiMgr extends JPanel {

	/**
	 * Create the panel.
	 */
	public KaiTaiMgr() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		KaiTaiPanel panel = new KaiTaiPanel();
		tabbedPane.addTab("×â³µ", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);

	}

}
