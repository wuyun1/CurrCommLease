package com.CCL.panel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.CCL.mwing.MJLable;
import com.CCL.panel.glj.xitongguanli.son.RiYinYeSelect;
import com.CCL.view.MainFrame;



public class CalenderPanel extends JPanel{
	
	private Calendar calendar;
	private Calendar now = Calendar.getInstance();
	private java.awt.Font font = new java.awt.Font("Times",java.awt.Font.PLAIN,12);
    private java.text.SimpleDateFormat sdf;
    private final LabelManager lm = new LabelManager();
    private javax.swing.Popup pop;
    private TitlePanel titlePanel;
    private BodyPanel bodyPanel;
    private FooterPanel footerPanel;
    
    private JComponent showDate;
    private boolean isShow = false;

    private static final String DEFAULTFORMAT = "yyyy-MM-dd";
    private static final String[] showTEXT = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    private static WeekLabel[] weekLabels = new WeekLabel[7];
    private static int defaultStartDAY = 0;//0 is from Sun, 1 is from Mon, 2 is from Tue
    private static Color hoverColor = Color.BLUE; // hover color
    
	private int startDAY  = defaultStartDAY;
	private Date date = new Date();
	private String format =DEFAULTFORMAT;
	private MainFrame mainFrame;
	private JPanel paneA2b,sellpanel;
    
    public CalenderPanel(JComponent showDate, MainFrame mainFrame) throws MalformedURLException {
    	this.showDate = showDate;
    	this.mainFrame = mainFrame;
    	this.paneA2b = mainFrame.getPaneA2b();
    	this.sellpanel = mainFrame.getSellPanel();
    	this.setLayout(new BorderLayout());
    	
    	if(startDAY > -1 && startDAY < 7) 
        	defaultStartDAY = startDAY;
        int dayIndex = defaultStartDAY;
        for(int i=0; i<7; i++){
            if(dayIndex > 6) dayIndex = 0;
            weekLabels[i] = new WeekLabel(dayIndex, showTEXT[dayIndex]);
            dayIndex ++ ;
        }
		sdf = new java.text.SimpleDateFormat(format);
        calendar = Calendar.getInstance();
        calendar.setTime(date);
    	
    	
    	initCalendarPanel();
	}
    
    // change text or label's content.
    private void commit() {
    	if(showDate == null){
    		return ;
    	}
        if (showDate instanceof JTextField) {
            ((JTextField) showDate).setText(sdf.format(calendar.getTime()));
        }else if (showDate instanceof JLabel) {
            ((JLabel) showDate).setText(sdf.format(calendar.getTime()));
        }
    }
    
    
    private void initCalendarPanel() throws MalformedURLException{
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0xAA, 0xAA, 0xAA)));
        this.add(titlePanel = new TitlePanel(), java.awt.BorderLayout.NORTH);
        this.add(bodyPanel = new BodyPanel(), java.awt.BorderLayout.CENTER);
        this.add(footerPanel = new FooterPanel(),java.awt.BorderLayout.SOUTH);
        
    }
    
	private class TitlePanel extends MPanel {

		

		private static final long serialVersionUID = -2865282186037420798L;
		private JLabel preYear, preMonth, center, nextMonth, nextYear,
				centercontainer;

		public TitlePanel() {
			super("images/jpanel/caltitle.jpg",new BorderLayout());
			//this.setBackground(new java.awt.Color(190, 200, 200));
			initTitlePanel();
		}

		private void initTitlePanel() {
			preYear = new JLabel("<<", JLabel.CENTER);
			preMonth = new JLabel("<", JLabel.CENTER);
			center = new JLabel("", JLabel.CENTER);
			centercontainer = new JLabel("", JLabel.CENTER);
			nextMonth = new JLabel(">", JLabel.CENTER);
			nextYear = new JLabel(">>", JLabel.CENTER);

			preYear.setToolTipText("Last Year");
			preMonth.setToolTipText("Last Month");
			nextMonth.setToolTipText("Next Month");
			nextYear.setToolTipText("Next Year");

			preYear.setBorder(javax.swing.BorderFactory.createEmptyBorder(2,
					10, 0, 0));
			preMonth.setBorder(javax.swing.BorderFactory.createEmptyBorder(2,
					15, 0, 0));
			nextMonth.setBorder(javax.swing.BorderFactory.createEmptyBorder(2,
					0, 0, 15));
			nextYear.setBorder(javax.swing.BorderFactory.createEmptyBorder(2,
					0, 0, 10));

			centercontainer.setLayout(new java.awt.BorderLayout());
			centercontainer.add(preMonth, java.awt.BorderLayout.WEST);
			centercontainer.add(center, java.awt.BorderLayout.CENTER);
			centercontainer.add(nextMonth, java.awt.BorderLayout.EAST);

			this.add(preYear, java.awt.BorderLayout.WEST);
			this.add(centercontainer, java.awt.BorderLayout.CENTER);
			this.add(nextYear, java.awt.BorderLayout.EAST);
			this.setPreferredSize(new java.awt.Dimension(210, 25));

			updateDate();

			preYear.addMouseListener(new MyMouseAdapter(preYear, Calendar.YEAR,
					-1));
			preMonth.addMouseListener(new MyMouseAdapter(preMonth,
					Calendar.MONTH, -1));
			nextMonth.addMouseListener(new MyMouseAdapter(nextMonth,
					Calendar.MONTH, 1));
			nextYear.addMouseListener(new MyMouseAdapter(nextYear,
					Calendar.YEAR, 1));
		}

		private void updateDate() {
			center.setText(calendar.get(Calendar.YEAR) + "-"
					+ (calendar.get(Calendar.MONTH) + 1));
		}

		// listener for control label.
		class MyMouseAdapter extends java.awt.event.MouseAdapter {

			JLabel label;
			private int type, value;

			public MyMouseAdapter(final JLabel label, final int type,
					final int value) {
				this.label = label;
				this.type = type;
				this.value = value;
			}

			public void mouseEntered(java.awt.event.MouseEvent me) {
				label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				label.setForeground(hoverColor);
			}

			public void mouseExited(java.awt.event.MouseEvent me) {
				label.setCursor(new java.awt.Cursor(
						java.awt.Cursor.DEFAULT_CURSOR));
				label.setForeground(java.awt.Color.BLACK);
			}

			public void mousePressed(java.awt.event.MouseEvent me) {
				calendar.add(type, value);
				label.setForeground(java.awt.Color.WHITE);
				refresh();
			}

			public void mouseReleased(java.awt.event.MouseEvent me) {
				label.setForeground(java.awt.Color.BLACK);
			}
		}
	}

	// body panel, include week labels and day labels.
	private class BodyPanel extends MPanel {

		private static final long serialVersionUID = 5677718768457235447L;
/////////////////////////////////////////////////////////////////////////////////
		public BodyPanel() throws MalformedURLException {
			super("images/jpanel/calendar1.jpg",new GridLayout(7, 7));
			this.setPreferredSize(new java.awt.Dimension(230, 190));//修改日历大小
			initMonthPanel();
		}

		private void initMonthPanel() {
			updateDate();
		}

		public void updateDate() {
			this.removeAll();
			lm.clear();
			java.util.Date temp = calendar.getTime();
			Calendar cal = Calendar.getInstance();
			cal.setTime(temp);
			cal.set(Calendar.DAY_OF_MONTH, 1);

			int index = cal.get(Calendar.DAY_OF_WEEK);
			// 从当月1号前移，一直移动到面板显示的第一天的前一天；当-index +
			// defaultStartDAY为正数时，为避免面板从当月1号之后开始显示，需要前移一周，确保当月显示完全
			if (index > defaultStartDAY)
				cal.add(Calendar.DAY_OF_MONTH, -index + defaultStartDAY);
			else
				cal.add(Calendar.DAY_OF_MONTH, -index + defaultStartDAY - 7);

			for (WeekLabel weekLabel : weekLabels) {
				this.add(weekLabel);
			}
			for (int i = 0; i < 42; i++) {
				cal.add(Calendar.DAY_OF_MONTH, 1);
				lm.addLabel(new DayLabel(cal));
			}
			for (DayLabel my : lm.getLabels()) {
				this.add(my);
			}
		}
	}

	private class FooterPanel extends JPanel {

		private static final long serialVersionUID = 8135037333899746736L;
		private JLabel dateLabel;

		public FooterPanel() {
			super(new BorderLayout());
			initFooterPanel();
		}

		private void initFooterPanel() {
			dateLabel = new JLabel("Today is : "
					+ sdf.format(new java.util.Date()));
			dateLabel.addMouseListener(new MouseListener() {

				public void mouseReleased(MouseEvent e) {
				}

				public void mousePressed(MouseEvent e) {
					calendar.setTime(new Date());
					refresh();
					commit();
				}

				public void mouseExited(MouseEvent e) {
					dateLabel.setForeground(Color.BLACK);
				}

				public void mouseEntered(MouseEvent e) {
					dateLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					dateLabel.setForeground(hoverColor);
				}

				public void mouseClicked(MouseEvent e) {
				}
			});
			this.add(dateLabel);
		}

		public void updateDate() {
		};
	}

	// refresh all panel
	private void refresh() {
		titlePanel.updateDate();
		bodyPanel.updateDate();
		footerPanel.updateDate();
		SwingUtilities.updateComponentTreeUI(this);
	}

	private class WeekLabel extends JLabel {

		private static final long serialVersionUID = -8053965084432740110L;
		private String name;

		public WeekLabel(int index, String name) {
			super(name, JLabel.CENTER);
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}

	private class DayLabel extends JLabel implements
			java.util.Comparator<DayLabel>, java.awt.event.MouseListener,
			java.awt.event.MouseMotionListener {

		private static final long serialVersionUID = -6002103678554799020L;
		private boolean isSelected;
		private int year, month, day;

		public DayLabel(Calendar cal) {
			super("" + cal.get(Calendar.DAY_OF_MONTH), JLabel.CENTER);
			this.year = cal.get(Calendar.YEAR);
			this.month = cal.get(Calendar.MONTH);
			this.day = cal.get(Calendar.DAY_OF_MONTH);

			this.setFont(font);
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			if (month == calendar.get(Calendar.MONTH))
				this.setForeground(java.awt.Color.BLACK);
			else
				this.setForeground(java.awt.Color.LIGHT_GRAY);

		}

		public boolean getIsSelected() {
			return isSelected;
		}

		public void setSelected(boolean b, boolean isDrag) {
			isSelected = b;
			if (b && !isDrag) {
				int temp = calendar.get(Calendar.MONTH);
				calendar.set(year, month, day);
				if (temp == month) {
					SwingUtilities.updateComponentTreeUI(bodyPanel);
				} else {
					refresh();
				}
				this.repaint();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			// set curr select day's background
			if (day == calendar.get(Calendar.DAY_OF_MONTH)
					&& month == calendar.get(Calendar.MONTH)) {
				g.setColor(new java.awt.Color(0xBB, 0xBF, 0xDA));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			// set current day's border
			if (year == now.get(Calendar.YEAR)
					&& month == now.get(Calendar.MONTH)
					&& day == now.get(Calendar.DAY_OF_MONTH)) {
				Graphics2D gd = (Graphics2D) g;
				gd.setColor(new java.awt.Color(0x55, 0x55, 0x88));
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			if (isSelected) {
				Stroke s = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_BEVEL, 1.0f,
						new float[] { 2.0f, 2.0f }, 1.0f);
				Graphics2D gd = (Graphics2D) g;
				gd.setStroke(s);
				gd.setColor(Color.BLACK);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			super.paintComponent(g);
		}

		public boolean contains(Point p) {
			return this.getBounds().contains(p);
		}

		private void update() {
			repaint();
		}

		public void mouseDragged(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {// 处理鼠标双击

				if(!mainFrame.getBackPanel().getName().equals("自行车"))
				{
					paneA2b.removeAll();
			     	  sellpanel.removeAll();
			     	 RiYinYeSelect riYinYeSelect = new RiYinYeSelect("",sellpanel);
			     	 riYinYeSelect.getTxt_stime().setText("0000");
			     	 riYinYeSelect.getTxt_etime().setText("11100");
			     	 sellpanel.add(riYinYeSelect);
			    	  mainFrame.getBackPanel().add(mainFrame.getLabel_1());
			    	  mainFrame.getFristLabel().setBounds(133, 38, 123, 15);
			    	  mainFrame.getBackPanel().add( mainFrame.getFristLabel());
			          MJLable mainR = new MJLable("images/beijin_r_lbl_end.gif", 300, 300);
				  	  mainR.setBounds(780, 340, 300, 300);
			          paneA2b.add(mainFrame.getZixingCheContentPanel("自行车",mainFrame));//重新加入要显示的面板
			          mainFrame.getFristLabel().setText("自行车");                          //固定死数据。显示自行车的标题
				}else{
					 sellpanel.removeAll();
					 RiYinYeSelect riYinYeSelect = new RiYinYeSelect("",sellpanel);
			     	 riYinYeSelect.getTxt_stime().setText("0000");
			     	 riYinYeSelect.getTxt_etime().setText("11100");
			     	 sellpanel.add(riYinYeSelect);
			     	mainFrame.getFristLabel().setText("日营业查询");
				}
//				  paneA2b.removeAll();
//		     	  sellpanel.removeAll();
//		     	 RiYinYeSelect riYinYeSelect = new RiYinYeSelect("",sellpanel);
//		     	 riYinYeSelect.getTxt_stime().setText("0000");
//		     	 riYinYeSelect.getTxt_etime().setText("11100");
//		     	 sellpanel.add(riYinYeSelect);
//		    	  mainFrame.getBackPanel().add(mainFrame.getLabel_1());
//		    	  mainFrame.getFristLabel().setBounds(133, 38, 123, 15);
//		    	  mainFrame.getBackPanel().add( mainFrame.getFristLabel());
//		          MJLable mainR = new MJLable("images/beijin_r_lbl_end.gif", 300, 300);
//			  	  mainR.setBounds(780, 340, 300, 300);
//		          paneA2b.add(mainFrame.getZixingCheContentPanel("自行车",mainFrame));//重新加入要显示的面板
//		          mainFrame.getFristLabel().setText("自行车");                          //固定死数据。显示自行车的标题
//		          
		          mainFrame.repaint();
				

				} else if (e.isMetaDown()) {//检测鼠标右键单击
					System.out.println("右键");
				}

			System.out.println(day);/////////////////////////////////日历事件
		}

		public void mousePressed(MouseEvent e) {
			isSelected = true;
			update();
		}

		public void mouseReleased(MouseEvent e) {
			Point p = SwingUtilities
					.convertPoint(this, e.getPoint(), bodyPanel);
			this.setForeground(Color.BLACK);
			lm.setSelect(p, false);
			commit();
		}

		
		// change color when mouse over.
		public void mouseEntered(MouseEvent e) {
			this.setForeground(hoverColor);
			this.repaint();
			
		}

		
		// change color when mouse exit.
		public void mouseExited(MouseEvent e) {
			if (month == calendar.get(Calendar.MONTH))
				this.setForeground(java.awt.Color.BLACK);
			else
				this.setForeground(java.awt.Color.LIGHT_GRAY);
			this.repaint();
		}

		public int compare(DayLabel o1, DayLabel o2) {
			Calendar c1 = Calendar.getInstance();
			c1.set(o1.year, o1.month, o1.day);
			Calendar c2 = Calendar.getInstance();
			c2.set(o2.year, o2.month, o2.day);
			return c1.compareTo(c2);
		}

	}

	private class LabelManager {
		private List<DayLabel> list;

		public LabelManager() {
			list = new ArrayList<CalenderPanel.DayLabel>();
		}

		public List<DayLabel> getLabels() {
			return list;
		}

		public void addLabel(DayLabel label) {
			list.add(label);
		}

		public void clear() {
			list.clear();
		}

		public void setSelect(Point p, boolean b) {
			// 如果是拖动,则要优化一下,以提高效率
			if (b) {
				// 表示是否能返回,不用比较完所有的标签,能返回的标志就是把上一个标签和
				// 将要显示的标签找到了就可以了
				boolean findPrevious = false, findNext = false;
				for (DayLabel lab : list) {
					if (lab.contains(p)) {
						findNext = true;
						if (lab.getIsSelected())
							findPrevious = true;
						else
							lab.setSelected(true, b);
					} else if (lab.getIsSelected()) {
						findPrevious = true;
						lab.setSelected(false, b);
					}
					if (findPrevious && findNext)
						return;
				}
			} else {
				DayLabel temp = null;
				for (DayLabel m : list) {
					if (m.contains(p)) {
						temp = m;
					} else if (m.getIsSelected()) {
						m.setSelected(false, b);
					}
				}
				if (temp != null)
					temp.setSelected(true, b);
			}
		}
	}
}
