package com.CCL.panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MPanel extends JPanel {             //��JPanel�ϻ���ָ������ͼƬ
	protected ImageIcon imico; 
	public MPanel(String imgUrl,int x,int y){
		super();                                  //�̳и��๹�췽��
		this.setLayout(new GridBagLayout());
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//���������ͼƬ�ȴ�
	}
	public MPanel(String imgUrl){
		super();                                  //�̳и��๹�췽��
		this.setLayout(new GridBagLayout());
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//���������ͼƬ�ȴ�
	}
	public MPanel(String imgUrl,GridLayout gridLayout){
		super();                                  //�̳и��๹�췽��
		this.setLayout(gridLayout);
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//���������ͼƬ�ȴ�
	}
	public MPanel(String imgUrl,BorderLayout borderLayout){
		super();                                  //�̳и��๹�췽��
		this.setLayout(borderLayout);
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//���������ͼƬ�ȴ�
	}
	
	protected void paintComponent(Graphics g) {    //��дJPanel���paintComponent(Graphics g)����
		// TODO Auto-generated method stub
		super.paintComponent(g);                    // ����JPanel���paintComponent(Graphics g)����
		Image image = imico.getImage();              //ͨ��ImageIco������Image����
		g.drawImage(image, 0, 0, null);              //��ͼƬ���Ƶ������
	}
	

}
