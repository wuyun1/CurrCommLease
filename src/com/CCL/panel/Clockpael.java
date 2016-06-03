package com.CCL.panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;

//����ʱ��
public class Clockpael extends MPanel implements Runnable {
	Thread clock;
	final int x;
	final int y;
	final int Xpoint = 180;
	final int Ypoint = 180;
	final int R = 80;
	int xHour = 0, yHour = 0, xSecond = 0, ySecond = 0, xMin = 0, yMin = 0;

	public Clockpael(int x, int y) {
		super("images/jpanel/calender1.jpg", x, y);
		this.x = x;
		this.y = y;
		start(); // ��ʼ����

	}

	public void start() { // ��ʼ����
		if (clock == null)// �������Ϊ��ֵ
		{
			clock = new Thread(this); // ʵ��������
			clock.start(); // ��ʼ����
		}
	}

	public void run()// ���н���
	{
		while (clock != null) {
			repaint(); // ����paint�����ػ����
			try {
				Thread.sleep(1000); // �߳���ͣһ��(1000����)
			} catch (InterruptedException ex) {
				ex.printStackTrace(); // ���������Ϣ
			}
		}
	}

	public void stop()// ֹͣ����
	{
		clock = null;
	}

	public void paint(Graphics g)// ���������paint����
	{
		// Image image = imico.getImage(); //ͨ��ImageIco������Image����
		// System.out.println(image.getSource());
		// g.drawImage(image, 0, 0, null); //��ͼƬ���Ƶ������
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		Calendar now = new GregorianCalendar(); // ʵ������������
		now.setTime(new Date());// dateFormat.format(now.getTime())
		String timeInfo = ""; // �����Ϣ
		int hour = now.get(Calendar.HOUR_OF_DAY); // �õ�Сʱ��
		int minute = now.get(Calendar.MINUTE); // �õ�����
		int second = now.get(Calendar.SECOND); // �õ�����
		if (hour <= 9)
			timeInfo += "0" + hour + ":"; // ��ʽ�����
		else
			timeInfo += hour + ":";
		if (minute <= 9)
			timeInfo += "0" + minute + ":";
		else
			timeInfo += minute + ":";
		if (second <= 9)
			timeInfo += "0" + second;
		else
			timeInfo += second;
		g.setColor(Color.white); // ���õ�ǰ��ɫΪ��ɫ
		Dimension dim = getSize(); // �õ����ڳߴ�
		g.fillRect(0, 0, dim.width, dim.height); // ��䱳��ɫΪ��ɫ

		Image image = new ImageIcon("images/jpanel/��1.jpg").getImage(); // ͨ��ImageIco������Image����
		g.drawImage(image, 0, 0, 263, 251, null); // ��ͼƬ���Ƶ������

		g.setColor(Color.black); // ���õ�ǰ��ɫΪ��ɫ
		g.setFont(new Font("", Font.BOLD, 30));

		// Image image1 = new
		// ImageIcon("images/jpanel/caltitle.jpg").getImage();
		// //ͨ��ImageIco������Image����
		// g.drawImage(image1, 0, 251,263,40, null); //��ͼƬ���Ƶ������
		g.drawString(timeInfo, x + 115, y + 333); // ��ʾʱ���ַ���������������////////////////////��λ��
		g.setColor(Color.green);
		// g.drawString(dateFormat.format(now.getTime()),x+50,y+50);

		g.setColor(Color.black);
		g.setFont(new Font("", Font.BOLD, 15));

		/*
		 * for(int i=0,num=12;i<360;i+=6) { double alfa = Math.toRadians(i); int
		 * xPos=x+Xpoint+(int)(R*Math.sin(alfa)); int
		 * yPos=y+Ypoint-(int)(R*Math.cos(alfa)); if(i%5==0) { if (num%3==0)
		 * 
		 * g.setColor(Color.red); // ����3,6,9,12Ϊ��ɫ else g.setColor(Color.black);
		 * // ��������Ϊ��ɫ if(num==12){ g.setFont(new Font("",Font.BOLD,17));
		 * g.drawString(""+num,xPos-5,yPos+3); // д���� } else
		 * g.drawString(""+(num-12),xPos-5,yPos+3); num=(num+1); } else {
		 * g.setColor(Color.black); g.drawString(".",xPos,yPos); }
		 * 
		 * }
		 */
		g.setColor(Color.black);
		g.fillOval(x + Xpoint - 4, y + Ypoint - 4, 8, 8);
		// ������
		xSecond = (int) (Xpoint + (R - 10) * Math.sin(second * (2 * Math.PI / 60)));
		ySecond = (int) (Ypoint - (R - 10) * Math.cos(second * (2 * Math.PI / 60)));
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(3.0f));// ���ƻ��ߵĴ�ϸ
		g.drawLine(x + Xpoint, y + Ypoint, x + xSecond, y + ySecond);
		// ������
		xMin = (int) (Xpoint + (R - 20) * Math.sin((minute + second / 60) * (2 * Math.PI / 60)));
		yMin = (int) (Ypoint - (R - 20) * Math.cos((minute + second / 60) * (2 * Math.PI / 60)));
		g.setColor(Color.green);
		g.drawLine(x + Xpoint, y + Ypoint, x + xMin, y + yMin);
		// ��ʱ��
		xHour = (int) (Xpoint + (R - 30) * Math.sin((hour + minute / 60 + second / 60 / 60) * (2 * Math.PI / 12)));
		yHour = (int) (Ypoint - (R - 30) * Math.cos((hour + minute / 60 + second / 60 / 60) * (2 * Math.PI / 12)));
		g.setColor(Color.red);
		g.drawLine(x + Xpoint, y + Ypoint, x + xHour, y + yHour);
	}

}