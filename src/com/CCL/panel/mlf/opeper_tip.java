package com.CCL.panel.mlf;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sun.net.www.content.image.jpeg;

public class opeper_tip extends JPanel {

	private JTextField txt_tip;
	public opeper_tip()
	{
		txt_tip=new JTextField("���û��޴˹���Ȩ�ޣ���");
		init();
	}
	private void init() {
		txt_tip.setFont(new Font("����",Font.BOLD,20));
		txt_tip.setEditable(false);
		this.add(txt_tip);
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
}
