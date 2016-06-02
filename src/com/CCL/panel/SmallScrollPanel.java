package com.CCL.panel;

import static javax.swing.BorderFactory.createEmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;

import com.CCL.mwing.MJLable;

/**
 * �ƶ����
 * 
 * @author
 */
public class SmallScrollPanel extends BGPanel {
	private static final long serialVersionUID = 3592329256836525981L;
	private AlphaScrollPane alphaScrollPane;// �������
	private JButton leftScrollButton = null;// ���΢����ť
	private JButton rightScrollButton = null;// �Ҳ�΢����ť
	private ScrollMouseAdapter scrollMouseAdapter; // �����¼�������
	private ImageIcon icon1;
	private ImageIcon icon2;

	/**
	 * ���췽��
	 */
	public SmallScrollPanel() {
		scrollMouseAdapter = new ScrollMouseAdapter();// ��ʼ��������
		// ��ʼ��������ͼ
		icon1 = new ImageIcon(getClass().getResource("top01.png"));
		icon2 = new ImageIcon(getClass().getResource("top02.png"));
		setIcon(icon1);// ������ͼ
		setIconFill(BOTH_FILL);// ��ͼ��������Ӧ�����С
		initialize();// ���ó�ʼ������
	}

	/**
	 * ��ʼ���������ķ���
	 */
	private void initialize() {
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(0);
		this.setLayout(borderLayout);// ���ò��ֹ�����
		this.setSize(new Dimension(500, 84));
		this.setOpaque(false);// ʹ�ؼ�͸��
		// ��ӹ�����嵽�������λ��
		this.add(getAlphaScrollPanel(), BorderLayout.CENTER);
		// ������΢����ť
		this.add(getLeftScrollButton(), BorderLayout.WEST);
		// ����Ҳ�΢����ť
		this.add(getRightScrollButton(), BorderLayout.EAST);
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	public AlphaScrollPane getAlphaScrollPanel() {
		if (alphaScrollPane == null) {
			alphaScrollPane = new AlphaScrollPane();
			// ���ó�ʼ��С
			alphaScrollPane.setPreferredSize(new Dimension(464, 69));
			// ����ʾ��ֱ������
			alphaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			// ����ʾˮƽ������
			alphaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			// ȡ���������߿�
			alphaScrollPane.setBorderPaint(false);
			// ����¼�������
			alphaScrollPane.addComponentListener(new ScrollButtonShowListener());
		}
		return alphaScrollPane;
	}

	public void setViewportView(Component view) {
		alphaScrollPane.setViewportView(view);
	}

	/**
	 * ����΢��������
	 * 
	 * @author
	 */
	private class ScrollButtonShowListener extends ComponentAdapter implements Serializable {
		private static final long serialVersionUID = 814596372430146361L;

		@Override
		public void componentResized(ComponentEvent e) {
			// ��ȡ���������
			JScrollBar scrollBar = alphaScrollPane.getHorizontalScrollBar();
			// ��ȡ��Χ���Ʋ���
			int scrollWidth = scrollBar.getMaximum();
			int paneWidth = alphaScrollPane.getWidth();
			// ���������ڰ������ݵ�ʱ����������΢����ť
			if (paneWidth >= scrollWidth) {
				getLeftScrollButton().setVisible(false);
				getRightScrollButton().setVisible(false);
			}
			// ������С�ڰ������ݵ�ʱ����ʾ����΢����ť
			if (paneWidth < scrollWidth) {
				getLeftScrollButton().setVisible(true);
				getRightScrollButton().setVisible(true);
			}
		}
	}

	/**
	 * �������΢����ť
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getLeftScrollButton() {
		if (leftScrollButton == null) {
			leftScrollButton = new JButton();
			// ������ťͼ��
			ImageIcon icon1 = new ImageIcon("images/MJBtn/LBtnoff.png");
			// ������ťͼ��2
			ImageIcon icon2 = new ImageIcon("images/MJBtn/LBtnon.png");
			leftScrollButton.setOpaque(false);// ��ť͸��
			// ���ñ߿�
			leftScrollButton.setBorder(createEmptyBorder(0, 10, 0, 0));
			// ���ð�ťͼ��
			leftScrollButton.setIcon(icon1);
			leftScrollButton.setPressedIcon(icon2);
			leftScrollButton.setRolloverIcon(icon2);
			// ȡ����ť�������
			leftScrollButton.setContentAreaFilled(false);
			// ���ó�ʼ��С
			leftScrollButton.setPreferredSize(new Dimension(38, 0));
			// ȡ����ť���㹦��
			leftScrollButton.setFocusable(false);
			// ��ӹ����¼�������
			leftScrollButton.addMouseListener(scrollMouseAdapter);
		}
		return leftScrollButton;
	}

	/**
	 * �����Ҳ����΢����ť
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getRightScrollButton() {
		if (rightScrollButton == null) {
			rightScrollButton = new JButton();
			// ������ťͼ��
			ImageIcon icon1 = new ImageIcon("images/MJBtn/RBtnoff.png");
			// ������ťͼ��2
			ImageIcon icon2 = new ImageIcon("images/MJBtn/RBtnon.png");
			// ��ť͸��
			rightScrollButton.setOpaque(false);
			// ���ñ߿�
			rightScrollButton.setBorder(createEmptyBorder(0, 0, 0, 10));
			rightScrollButton.setIcon(icon1);// ���ð�ťͼ��
			rightScrollButton.setPressedIcon(icon2);
			rightScrollButton.setRolloverIcon(icon2);
			// ȡ����ť���ݻ���
			rightScrollButton.setContentAreaFilled(false);
			// ���ð�ť��ʼ��С
			rightScrollButton.setPreferredSize(new Dimension(38, 92));
			// ȡ����ť���㹦��
			rightScrollButton.setFocusable(false);
			// ��ӹ����¼�������
			rightScrollButton.addMouseListener(scrollMouseAdapter);
		}
		return rightScrollButton;
	}

	/**
	 * ����΢����ť���¼�������
	 * 
	 * @author
	 */
	private final class ScrollMouseAdapter extends MouseAdapter implements Serializable {
		private static final long serialVersionUID = 5589204752770150732L;
		// ��ȡ��������ˮƽ������
		JScrollBar scrollBar = getAlphaScrollPanel().getHorizontalScrollBar();
		// �����߳̿��Ʊ���
		private boolean isPressed = true;

		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();// ��ȡ�¼�Դ
			isPressed = true;
			// �ж��¼�Դ����ఴť�����Ҳఴť����ִ����Ӧ����
			if (source == getLeftScrollButton()) {
				scrollMoved(1);
			} else {
				scrollMoved(-1);
			}
		}

		/**
		 * �ƶ��������ķ���
		 * 
		 * @param orientation
		 *            �ƶ����� -1��������ƶ���1���һ����ƶ�
		 */
		private void scrollMoved(final int orientation) {
			new Thread() {// �����µ��߳�
				// ����ԭ�й�������ֵ
				private int oldValue = scrollBar.getValue();

				public void run() {
					while (isPressed) {// ѭ���ƶ����
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						// ��ȡ��������ǰֵ
						oldValue = scrollBar.getValue();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								// ���ù������ƶ�3������
								scrollBar.setValue(oldValue + 3 * orientation);
							}
						});
					}
				}
			}.start();
		}

		public void mouseExited(java.awt.event.MouseEvent e) {
			isPressed = false;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			isPressed = false;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// ������������ͼƬ
		g.drawImage(icon2.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
} // @jve:decl-index=0:visual-constraint="10,10"

/*
 * import java.awt.BorderLayout; import java.awt.Color; import
 * java.awt.Dimension; import java.awt.EventQueue; import java.awt.FlowLayout;
 * import java.awt.event.MouseAdapter; import java.awt.event.MouseEvent; import
 * java.io.Serializable; import java.lang.reflect.InvocationTargetException;
 * 
 * import javax.swing.BorderFactory; import javax.swing.ImageIcon; import
 * javax.swing.JButton; import javax.swing.JScrollBar; import
 * javax.swing.JScrollPane; import javax.swing.JTextArea; import
 * javax.swing.ScrollPaneConstants; import javax.swing.ScrollPaneLayout;
 * 
 * import com.CCL.mwing.MJLable;
 * 
 * 
 * public class SmallPanel extends MPanel {
 * 
 * private JButton leftScrollButton ,rightScrollButton; private
 * ScrollMouseAdapter scrollMouseAdapter; private JScrollBar scrollBar =
 * getAlphaScrollPanel().getHorizontalScrollBar(); private MPanel centerPanel1;
 * public SmallPanel(String imageUrl) { super(imageUrl);
 * this.setBackground(Color.BLUE);
 * 
 * 
 * scrollMouseAdapter = new ScrollMouseAdapter(); //centerPanel = new
 * MPanel("");// //centerPanel.setBackground(Color.black); //���ñ���ͼƬ
 * 
 * 
 * init(); }
 * 
 * private void init() { BorderLayout borderLayout = new BorderLayout();
 * borderLayout.setHgap(0); this.setLayout(borderLayout); /////////////////////
 * ���ò��ֹ����� this.setSize(new Dimension(200,54)); //��������С this.setOpaque(false);
 * 
 * 
 * 
 * //������΢����ť this.add(getLeftScrollButton(), BorderLayout.WEST); //����Ҳ�΢����ť
 * this.add(getRightScrollButton(), BorderLayout.EAST); //��ӹ�����嵽�����м�
 * this.add(getAlphaScrollPanel(),BorderLayout.CENTER); this.setVisible(true); }
 * 
 * public JScrollPane getAlphaScrollPanel() { centerPanel1= new MPanel("");
 * centerPanel1.setBounds(0, 0, 543, 40); JScrollPane centerPanel= new
 * JScrollPane();//centerPanel1);
 * //centerPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.
 * HORIZONTAL_SCROLLBAR_ALWAYS); //centerPanel.setSize(500, 60);
 * centerPanel.setLayout(new ScrollPaneLayout()); MJLable titleImage = new
 * MJLable("images/jpanel/������.jpg", 543, 40); titleImage.setBounds(0, 30, 543,
 * 40); centerPanel1.add(titleImage); JButton btn = new JButton("fddhdh");
 * btn.setBounds(10, 90, 800, 60); centerPanel.add(btn);
 * 
 * centerPanel.add(titleImage); if (null != scrollBar) {
 * scrollBar.setValue(scrollBar.getMaximum() / 2); } return centerPanel; }
 * 
 * private JButton getLeftScrollButton() { if(leftScrollButton ==null) {
 * 
 * leftScrollButton = new JButton(); //������ť�ͷ�ͼ�� ImageIcon icon1 = new
 * ImageIcon("images/MJBtn/lBtn.png");//////////////////////////////////
 * //������ť����ͼ�� ImageIcon icon2 = new
 * ImageIcon("images/MJBtn/lBtnON1.jpg");//////////////////////////////////
 * leftScrollButton.setOpaque(false);//���ð�ť͸�� //���ñ߿�
 * leftScrollButton.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
 * //���ð�ťͼ�� leftScrollButton.setIcon(icon1);
 * leftScrollButton.setPressedIcon(icon1);
 * leftScrollButton.setRolloverIcon(icon2); //ȡ����ť�������
 * leftScrollButton.setContentAreaFilled(false); //���ó�ʼ��С
 * leftScrollButton.setPreferredSize(new Dimension(38,0));//////////////////////
 * //ȡ����ť���㹦�� leftScrollButton.setFocusable(false); //��ӹ����¼�������
 * leftScrollButton.addMouseListener(scrollMouseAdapter); } return
 * leftScrollButton; }
 * 
 * private JButton getRightScrollButton() { if(rightScrollButton ==null) {
 * 
 * rightScrollButton = new JButton(); //������ť�ͷ�ͼ�� ImageIcon icon1 = new
 * ImageIcon("images/jpanel/leftBtn.ico");//////////////////////////////////
 * //������ť����ͼ�� ImageIcon icon2 = new
 * ImageIcon("");//////////////////////////////////
 * rightScrollButton.setOpaque(false);//���ð�ť͸�� //���ñ߿�
 * rightScrollButton.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
 * //���ð�ťͼ�� rightScrollButton.setIcon(icon1);
 * rightScrollButton.setPressedIcon(icon1);
 * rightScrollButton.setRolloverIcon(icon2); //ȡ����ť�������
 * rightScrollButton.setContentAreaFilled(false); //���ó�ʼ��С
 * rightScrollButton.setPreferredSize(new
 * Dimension(38,0));////////////////////// //ȡ����ť���㹦��
 * rightScrollButton.setFocusable(false); //��ӹ����¼�������
 * rightScrollButton.addMouseListener(scrollMouseAdapter); } return
 * rightScrollButton; }
 * 
 * private final class ScrollMouseAdapter extends MouseAdapter implements
 * Serializable {
 * 
 * private boolean isPressed = true;
 * 
 * public void mousePressed(MouseEvent e) { Object source = e.getSource();
 * isPressed = true; if(source == getLeftScrollButton()) { scrollMove(1); }else{
 * scrollMove(-1); } }
 */

/**
 * �ƶ��������ķ���
 * 
 * �ƶ�����-1��������ƶ���1���л����ƶ�
 */
/*
 * private void scrollMove(final int orientation) { new Thread(){ private int
 * oldValue = scrollBar.getValue();//����ԭ�й�����ֵ
 * 
 * public void run() { System.out.println(oldValue+"or"+orientation);
 * while(isPressed) { try { Thread.sleep(10); } catch (InterruptedException e) {
 * // TODO Auto-generated catch block e.printStackTrace(); } oldValue =
 * scrollBar.getValue(); //��ȡ��ǰ������ֵ try { EventQueue.invokeAndWait(new
 * Runnable() {
 * 
 * @Override public void run() { // TODO Auto-generated method stub
 * scrollBar.setValue(oldValue + 3*orientation);//���ù������ƶ�3������
 * scrollBar.setBlockIncrement(oldValue + 3*orientation);
 * System.out.println("new"+oldValue); } }); } catch (InterruptedException e) {
 * // TODO Auto-generated catch block e.printStackTrace(); } catch
 * (InvocationTargetException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } } } }.start(); }
 * 
 * public void mouseExit(MouseEvent e) { isPressed = false; }
 * 
 * @Override public void mouseReleased(MouseEvent e) { // TODO Auto-generated
 * method stub //super.mouseReleased(e); isPressed = false; }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */