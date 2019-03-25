package com.aowin.Swing2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;
/**
 * 组件，容器，布局管理器；
 * 3种常用的布局管理器
 * FLOW BORDER GRID
 * 事件-事件源-事件处理器-
 * 	ActionEvent
 * MouseEvent--任意组件
 * KeyEvent--任意组件
 * @author Administrator
 *
 */
public class SimpleCalculate {
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JComboBox jc;
	public static void main(String[] args) {
		SimpleCalculate si=new SimpleCalculate();
		si.init();
	}
	public void init() {
		JFrame jf=new JFrame("简易计算器");
		jf.setSize(250, 350);
		jf.setLocation(200, 200);
		
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		txt1=new JTextField (6);
		txt2=new JTextField (6);
		txt3=new JTextField (17);
		
		String arr[]= {"+","-","*","/"};
		jc=new JComboBox(arr);
		panel.add(txt1);
		panel.add(jc);
		panel.add(txt2);
		txt3.setEditable(false);
		JPanel panel2=new JPanel();
		panel2.add(new JLabel("结果:"));
		panel2.add(txt3);
		JPanel panel3=new JPanel();
		JButton button1=new JButton("计算");
		JButton button2=new JButton("清零");
//		button1.addActionListener(new MyCalActionListener(this));
//		button2.addActionListener(new MyCalActionListener(this));
		ActionListener aL=new ActionListener() {
//匿名内部类创建
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("清零")) {
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
				}else if(e.getActionCommand().equals("计算")){
					try {
						num1=Double.valueOf(txt1.getText());
						num2=Double.valueOf(txt2.getText());
					} catch (NumberFormatException e1) {
						txt3.setText("ERROR-只能进行数字运算");
						txt3.setForeground(Color.RED);
//						System.out.println(si.txt3.getFont());
						return;
					}
					txt3.setForeground(Color.BLACK);
					switch((String)jc.getSelectedItem()) {
						case"+":
							msg=String.valueOf(num1+num2);
							txt3.setText(msg);
							num1=num2=0;
							break;
						case"-":
							msg=String.valueOf(num1-num2);
							txt3.setText(msg);
							num1=num2=0;
							break;
						case"*":
							msg=String.valueOf(num1*num2);
							txt3.setText(msg);
							num1=num2=0;
							break;
						case"/":
							if(num2!=0) {
								msg=String.valueOf(num1/num2);
							}else {
								msg="ERROR-除数不能为0";
							}
							txt3.setText(msg);
							num1=num2=0;
							break;
					}
				}
				
			}};
			button1.addActionListener(aL);
			button2.addActionListener(aL);
		panel3.add(button1);
		panel3.add(button2);
		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
		con.add(panel);
		con.add(panel2);
		con.add(panel3);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	double num1;
	double num2;
	String msg;
	String str;
}
class MyCalActionListener implements ActionListener{
	SimpleCalculate si;
	double num1;
	double num2;
	String msg;
	String str;
	public MyCalActionListener(SimpleCalculate si) {	
		this.si=si;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("清零")) {
			si.txt1.setText("");
			si.txt2.setText("");
			si.txt3.setText("");
		}else if(e.getActionCommand().equals("计算")){
			try {
				num1=Double.valueOf(si.txt1.getText());
				num2=Double.valueOf(si.txt2.getText());
			} catch (NumberFormatException e1) {
				si.txt3.setText("ERROR-只能进行数字运算");
				si.txt3.setForeground(Color.RED);
//				System.out.println(si.txt3.getFont());
				return;
			}
			si.txt3.setForeground(Color.BLACK);
			switch((String)si.jc.getSelectedItem()) {
				case"+":
					msg=String.valueOf(num1+num2);
					si.txt3.setText(msg);
					num1=num2=0;
					break;
				case"-":
					msg=String.valueOf(num1-num2);
					si.txt3.setText(msg);
					num1=num2=0;
					break;
				case"*":
					msg=String.valueOf(num1*num2);
					si.txt3.setText(msg);
					num1=num2=0;
					break;
				case"/":
					if(num2!=0) {
						msg=String.valueOf(num1/num2);
					}else {
						msg="ERROR-除数不能为0";
					}
					si.txt3.setText(msg);
					num1=num2=0;
					break;
			}
		}
	}
}