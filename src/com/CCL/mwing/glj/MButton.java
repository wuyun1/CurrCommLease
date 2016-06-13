package com.CCL.mwing.glj;

import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MButton extends JButton {
	private ImageIcon imico;
	private String text;
	public MButton(String imageUrl,String text,int x,int y ,int w,int h)
	{
		super();
		imico = new ImageIcon(imageUrl);
		this.setIcon(imico);
		this.setBounds(x, y, w, h);
		this.setText(text);
		setBorderPainted(false);//�Ƿ񻭱߿�������Զ���ͼƬ����ť����������Ϊ false��
		setContentAreaFilled(false);//�Ƿ���䣬�������Զ���ͼƬ���Ǿ��λ���ڿհױ߾࣬������Ϊ false ʹ��ť������͸����
		setMargin(new Insets(0, 0, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	public MButton(String imageUrl,String text)
	{
		super();
		imico = new ImageIcon(imageUrl);
		this.setIcon(imico);
		this.setText(text);
		setBorderPainted(false);//�Ƿ񻭱߿�������Զ���ͼƬ����ť����������Ϊ false��
		setContentAreaFilled(false);//�Ƿ���䣬�������Զ���ͼƬ���Ǿ��λ���ڿհױ߾࣬������Ϊ false ʹ��ť������͸����
		setMargin(new Insets(0, 0, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public MButton(String imageUrl)
	{
		super();
		imico = new ImageIcon(imageUrl);
		this.setIcon(imico);
		setBorderPainted(false);//�Ƿ񻭱߿�������Զ���ͼƬ����ť����������Ϊ false��
		setContentAreaFilled(false);//�Ƿ���䣬�������Զ���ͼƬ���Ǿ��λ���ڿհױ߾࣬������Ϊ false ʹ��ť������͸����
		setMargin(new Insets(0, 0, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
		/*
		 * setFocusPainted(boolean b)	//�Ƿ���ƽ��㣨����ǳɫ���߿���߼Ӵֵı߿������ť��ǰ�н��㣩��

			setMargin(Insets m)	//�ı�߾࣬��� borderPainted �� contentAreaFilled ������� false������ѱ߾඼��Ϊ 0��new Insets(0, 0, 0, 0)��
			
			setIcon(Icon defaultIcon)	//ע�������Ǹĵ�Ĭ��ͼ�ꡣ��̬�е�Ĭ�ϣ������δ�����ϵ�ʱ��
			
			setPressedIcon(Icon pressedIcon)	//����ʱ��ͼ�ꡣ
			
			setRolloverIcon(Icon rolloverIcon)	//��꾭��ʱ��ͼ�ꡣ
			
			setRolloverSelectedIcon(Icon rolloverSelectedIcon)	//��꾭��ʱ�ұ�ѡ��״̬��ͼ�ꡣ
			
			setSelectedIcon(Icon selectedIcon)	//ѡ��ʱ��ͼ�ꡣ
			
			setDisabledIcon(Icon disabledIcon)	//����ʱ��ʾ��ͼ�ꡣ������Ի�һ�ŻҶ�ͼƬ��
			
			setDisabledSelectedIcon(Icon disabledSelectedIcon)	//�����ұ�ѡ��״̬��ͼ�ꡣ
           ��ť���ȥ���߾��Ժ�ͼƬ���Ƕ�󡣻��Զ����ŵġ������� margin ����� 0 �Ļ�����ť���ͼƬ���Ƕ��������Щ������������Ҫ�Լ�����ť����������������
		 */

}
