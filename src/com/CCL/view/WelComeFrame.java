package com.CCL.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.CCL.Dao.base.HibernateSessionFactory;
import com.CCL.view.kaitaimgr.test.TesetF;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JProgressBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Point;

public class WelComeFrame extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	private static boolean isOver = false;
	static int count = 0;
	static int f = 1;

	Timer processWork = new Timer(20, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (count < 0 || count > 100)
				f = -f;
			progressBar.setValue(count += f);
			if (isOver)
				processWork.stop();
		}
	});
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final WelComeFrame frame = new WelComeFrame();
					frame.setVisible(true);

					EventQueue.invokeLater(new Runnable() {
						public void run() {

							new Thread() {
								public void run() {

									HibernateSessionFactory.getSession();

									isOver = true;
									frame.dispose();
									MainFrame.main(args);
								};
							}.start();

						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		 super.paintComponents(g);
	}

	@Override
	public void paintAll(Graphics g) {
		// TODO Auto-generated method stub
		 super.paintAll(g);
	}

	/**
	 * Create the frame.
	 */
	public WelComeFrame() {

		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 643);
		contentPane = new JPanel();

		contentPane.setOpaque(false);
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image image = Toolkit.getDefaultToolkit().getImage("images\\jpanel\\calendar1.jpg");
		contentPane.setLayout(null);

		JPanel lblNewLabel = new JPanel();
		lblNewLabel.setBounds(5, 5, 1030, 619);
		lblNewLabel.setOpaque(false);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(Color.BLUE);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/jpanel/Ö÷±³¾°.jpg"));
		lblNewLabel.add(lblNewLabel_1);

		progressBar = new JProgressBar();
		progressBar.setBounds(5, 624, 1030, 14);
		progressBar.setValue(2);
		contentPane.add(progressBar);
		setLocationRelativeTo(null);
		processWork.start();
	}

}
