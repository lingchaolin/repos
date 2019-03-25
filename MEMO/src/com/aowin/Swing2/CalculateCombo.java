package com.aowin.Swing2;
/**
 * 同一个事件源可以注册多个不同的事件监听器
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class CalculateCombo  {
	public static void main(String[] args) {
		CalculateCombo c=new CalculateCombo();
		c.init();
	}
	JTextArea txt;
	
	public void init() {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(300, 450);
		jf.setLocation(200, 200);
		
		Container con=jf.getContentPane();
		con.setLayout(new BorderLayout(5,5));
		String[]arr= {"1","2","3","/","4","5","6","*","7","8","9","-","0",".","=","+"};
		JButton[]brr=new JButton[arr.length];
//		上
		txt=new JTextArea(6,10);
		txt.setBackground(new Color(230,250,250));
		txt.setEditable(false);
		con.add(BorderLayout.NORTH,txt);
//		中
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4,4,5,5));
		con.add(BorderLayout.CENTER,panel);
		for(int i=0;i<arr.length;i++) {
			brr[i]=new JButton(arr[i]);
			panel.add(brr[i]);
//			brr[i].addActionListener(new MyCalculationActionListener(txt));
		}
		panel.addMouseListener(new SwingEventMyMouseListener());

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
