package com.aowin.Swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayoutFlow {
/**
 * FlowLayout--流式布局
 * 默认从左到右，一行放满换到下一行继续放置，
 * @param args
 */
	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
//		创建按钮
		JButton button1=new JButton("按钮");
		JButton button2=new JButton("按钮");
		JButton button3=new JButton("按钮");
		JButton button4=new JButton("按钮");
		JButton button5=new JButton("按钮");
		JButton button6=new JButton("按钮");	
//		获取和顶层窗口关联的容器
		Container con=jf.getContentPane();
//		设置为流式布局--默认间隙为5px
		con.setLayout(new FlowLayout());
//		设置对齐方式
		con.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		设置间隙(对齐方式，水平间隙，垂直间隙);
		con.setLayout(new FlowLayout(FlowLayout.RIGHT,10,15));
//		添加按钮
		con.add(button1);
		con.add(button2);
		con.add(button3);
		con.add(button4);
		con.add(button5);
		con.add(button6);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
