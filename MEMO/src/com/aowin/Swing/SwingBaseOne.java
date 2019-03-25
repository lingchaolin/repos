package com.aowin.Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingBaseOne {
	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
//		按钮
		JButton button=new JButton("按钮");
//		获取按钮上的文字；getText;
		button.getText();
		System.out.println(button.getText());
//		设置按钮上的文字；setText;
		button.setText("确定");
		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
		con.add(button);
//		标签
		JLabel label=new JLabel("a label") ;
		label.setForeground(Color.RED);//设置文字颜色
		con.add(label);
//添加图片
		JPanel panel=new JPanel() {
			public  void paintComponent(Graphics g) {
				Image back=GameUtil.getImage("images/Law.jpg");
				g.drawImage(back,-150,0,950,630,null);
			}
		};
//		JTextField-文本行--设置文字--可见宽度；
		JTextField jt=new JTextField("text",8);//--设置宽度
//		setText()-设置文字、修改文字
		jt.setEditable(false);//		seEditable(false)-设置为不可编辑
		con.add(jt);
		
//		文本域、
		JTextArea jta=new JTextArea("正文",4,8);//设置宽度长度
//		自动换行
		jta.setLineWrap(true);
//		添加滑动面板；
		JScrollPane jsp=new JScrollPane(jta);
		con.add(jsp);
		
//		密码框；JPasswordField
		JLabel label2=new JLabel("密码：");
		con.add(label2);
		JPasswordField jpd=new JPasswordField("123",6);
		con.add(jpd);
//		设置回显字符；--可以设置密码框中显示的是'********'还是'^^^^^^^^^'还是……
		jpd.setEchoChar('^');
//		获取密码--char数组
		char[]arr=jpd.getPassword();
		String str=new String(arr);
//		System.out.println("密码是:"+str);
		
//		用面板保持一致；-单选框
		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel lab3=new JLabel("性别");
		JRadioButton rb1=new JRadioButton("男");
		JRadioButton rb2=new JRadioButton("女");
		panel2.add(lab3);
		panel2.add(rb1);
		panel2.add(rb2);
//		-逻辑分组-将单选框关联
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		rb1.setSelected(true);//设置选中
		
		con.add(panel2);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
