package com.CCL.model;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class MTree_zixingche extends JTree
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3331152583299579341L;
	private JTree tree;
  public  JTree getTree() {
		return tree;
	}
public MTree_zixingche()
  {
	super();
	this.setOpaque(false);
	  DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
		        "���г�");
		      DefaultMutableTreeNode childNode1 = new DefaultMutableTreeNode(
		        "ǰ̨��������");
		      DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode(
		        "��Ա������");
		      DefaultMutableTreeNode childNode3 = new DefaultMutableTreeNode(
		        "ϵͳ����");
		      DefaultMutableTreeNode childNode4 = new DefaultMutableTreeNode(
		  	        "����");
		      DefaultMutableTreeNode childNode5 = new DefaultMutableTreeNode(
		        "����");
		      
		              DefaultMutableTreeNode childNode31 = new DefaultMutableTreeNode(
				        "�շ�����");
				      DefaultMutableTreeNode childNode32 = new DefaultMutableTreeNode(
				        "�ۿ�����");
				      DefaultMutableTreeNode childNode33 = new DefaultMutableTreeNode(
				        "����");
				      DefaultMutableTreeNode childNode34 = new DefaultMutableTreeNode(
				  	        "�˵�����");
				      DefaultMutableTreeNode childNode35 = new DefaultMutableTreeNode(
				        "��������");
				              DefaultMutableTreeNode childNode341 = new DefaultMutableTreeNode(
						        "��Ӫҵ��ѯ");
						      DefaultMutableTreeNode childNode342 = new DefaultMutableTreeNode(
						        "�˵���ϸ");
						      DefaultMutableTreeNode childNode343 = new DefaultMutableTreeNode(
						        "��������");
						      
						      childNode34.add(childNode341);
						      childNode34.add(childNode342);
						      childNode34.add(childNode343); 
//				      childNode3.add(childNode31);
//				      childNode3.add(childNode32);
//				      childNode3.add(childNode33);
//				      childNode3.add(childNode34);
//				      childNode3.add(childNode35);      
		      
		      rootNode.add(childNode1);
		      rootNode.add(childNode2);
		      rootNode.add(childNode3);
		      rootNode.add(childNode4);
//		      rootNode.add(childNode5);
    
    setExpandedState(new TreePath(rootNode), true);//Ĭ����չ��
    expandRow(0);
    this.tree = new JTree(rootNode);
  //���չ��ʱ��ͼ��
  	Icon ExpandedIcon=new ImageIcon("images/MJBtn/tree���г�.png");

  	//����۵�ʱ��ͼ��
  	Icon CollapsedIcon=new ImageIcon("images/MJBtn/tree���г�.png");

  	//Ҷ�ڵ��ͼ�꣬Ҳ��������û���ӽ��Ľڵ�ͼ��
  	Icon LeafIcon=new ImageIcon("images/MJBtn/tree���г�.png");

  	//��Ҷ�ڵ�ر�ʱ��ͼ�꣬Ҳ�����������ӽ��Ľڵ�ͼ��
  	Icon ClosedIcon=new ImageIcon("images/MJBtn/tree���г�.png");
  //��Ҷ�ڵ��ʱ��ͼ��
  	Icon OpenedIcon=new ImageIcon("images/MJBtn/tree����.png");

  	
  	DefaultTreeCellRenderer render=(DefaultTreeCellRenderer)(tree.getCellRenderer());render.setLeafIcon(LeafIcon);render.setClosedIcon(ClosedIcon);render.setOpenIcon(OpenedIcon);
  //�������ڵ�����
  	tree.setFont(new Font("����", Font.ITALIC, 13));
  	BasicTreeUI ui=(BasicTreeUI)(tree.getUI());
  //����ˢ����
//  	tree.updateUI();
  	ui.setCollapsedIcon(CollapsedIcon);
  	ui.setExpandedIcon(ExpandedIcon);
  	
  }
}
