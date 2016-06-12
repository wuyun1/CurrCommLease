package com.CCL.view.kaitaimgr;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import com.CCL.view.kaitaimgr.son.KaiTaiPanel;
import com.CCL.view.kaitaimgr.son.CheckOutPanel;
import com.CCL.view.kaitaimgr.son.ChangeCarPanel;

public class KaiTaiMgr extends JPanel {

	/**
	 * Create the panel.
	 */
	public KaiTaiMgr() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		KaiTaiPanel panel = new KaiTaiPanel();
		tabbedPane.addTab("\u5F00\u53F0", null, panel, null);
		
		CheckOutPanel panel_1 = new CheckOutPanel();
		tabbedPane.addTab("\u7ED3\u8D26", null, panel_1, null);
		
		ChangeCarPanel panel_2 = new ChangeCarPanel();
		tabbedPane.addTab("\u6362\u8F66", null, panel_2, null);

	}

}
