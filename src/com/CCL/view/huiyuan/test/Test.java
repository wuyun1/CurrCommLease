/*
 * Test.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.view.huiyuan.test;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.CCL.view.huiyuan.VipManager;

/**
 *
 * @author  __USER__
 */
public class Test extends javax.swing.JFrame {

	/** Creates new form Test */
	public Test() {
		setSize(new Dimension(800, 600));

		initComponents();
		JPanel vipManager = new VipManager();
		getContentPane().add(vipManager);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(vipManager);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Test().setVisible(true);
			}
		});
	}
}