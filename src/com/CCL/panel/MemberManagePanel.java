package com.CCL.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MemberManagePanel extends JPanel {
	public MemberManagePanel() {
		this.setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
		JTabbedPane jp = new JTabbedPane(); // ����ѡ�������
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel(); // �����������
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();

		p1.setBackground(new Color(10, 20, 6));

		p2.setBackground(new Color(120, 20, 6));

		JButton jb = new JButton("123");
		p2.add(jb);

		jp.addTab(p1.getName(), p1);
		jp.addTab("��Ա����ʧ/����", p2);
		jp.addTab("��Ա����ֵ", p3);
		jp.addTab("��Ա����", p4); // ��������� ����Ϊѡ��������
		jp.addTab("��Ա����Ϣ�޸�", p5);
		jp.addTab("��Ա������Ϣ��ѯ", p6);
		this.add(jp, BorderLayout.CENTER); // ��ѡ�������ӵ� ��������ȥ
	}

}
