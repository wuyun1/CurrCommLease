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
		setBorderPainted(false);//是否画边框，如果用自定义图片做按钮背景可以设为 false。
		setContentAreaFilled(false);//是否填充，如果你的自定义图片不是矩形或存在空白边距，可以设为 false 使按钮看起来透明。
		setMargin(new Insets(0, 0, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	public MButton(String imageUrl,String text)
	{
		super();
		imico = new ImageIcon(imageUrl);
		this.setIcon(imico);
		this.setText(text);
		setBorderPainted(false);//是否画边框，如果用自定义图片做按钮背景可以设为 false。
		setContentAreaFilled(false);//是否填充，如果你的自定义图片不是矩形或存在空白边距，可以设为 false 使按钮看起来透明。
		setMargin(new Insets(0, 0, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public MButton(String imageUrl)
	{
		super();
		imico = new ImageIcon(imageUrl);
		this.setIcon(imico);
		setBorderPainted(false);//是否画边框，如果用自定义图片做按钮背景可以设为 false。
		setContentAreaFilled(false);//是否填充，如果你的自定义图片不是矩形或存在空白边距，可以设为 false 使按钮看起来透明。
		setMargin(new Insets(0, 0, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
		/*
		 * setFocusPainted(boolean b)	//是否绘制焦点（例如浅色虚线框或者加粗的边框表明按钮当前有焦点）。

			setMargin(Insets m)	//改变边距，如果 borderPainted 和 contentAreaFilled 都设成了 false，建议把边距都调为 0：new Insets(0, 0, 0, 0)。
			
			setIcon(Icon defaultIcon)	//注意了这是改的默认图标。三态中的默认，即鼠标未在其上的时候。
			
			setPressedIcon(Icon pressedIcon)	//按下时的图标。
			
			setRolloverIcon(Icon rolloverIcon)	//鼠标经过时的图标。
			
			setRolloverSelectedIcon(Icon rolloverSelectedIcon)	//鼠标经过时且被选中状态的图标。
			
			setSelectedIcon(Icon selectedIcon)	//选中时的图标。
			
			setDisabledIcon(Icon disabledIcon)	//禁用时显示的图标。例如可以换一张灰度图片。
			
			setDisabledSelectedIcon(Icon disabledSelectedIcon)	//禁用且被选中状态的图标。
           按钮多大，去掉边距以后图片就是多大。会自动缩放的。因此如果 margin 都设成 0 的话，按钮多大图片就是多大。有了这些方法根本不需要自己画按钮或者用鼠标监听器。
		 */

}
