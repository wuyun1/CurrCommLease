package com.CCL.mwing;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class MJLable extends JLabel {
	protected ImageIcon imico;

	public MJLable(String imageUrl, int x, int y) {
		super(); // �̳и��๹�췽��
		imico = new ImageIcon(imageUrl);
		// this.setSize(imico.getIconWidth(),
		// imico.getIconHeight());//����jlable��ͼƬ�ȴ�
		this.setHorizontalAlignment(SwingConstants.CENTER);// ����ͼƬ�����־���
		// this.setBorder(new
		// TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));//���ñ߿�
		this.setPreferredSize(new Dimension(x, y));// ����ͼƬ��С
		this.setIcon(imico);
	}

}
