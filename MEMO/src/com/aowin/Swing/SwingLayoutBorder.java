package com.aowin.Swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayoutBorder {
/**
 * BorderLayout--
 * 四周无组件时会被中间的覆盖
 * 容器分为东西南北中五个区域-每个区域放一个组件
 */
	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
//		创建按钮
		JButton button1=new JButton("按钮1");
		JButton button2=new JButton("按钮2");
		JButton button3=new JButton("按钮3");
		JButton button4=new JButton("按钮4");
		JButton button5=new JButton("按钮5");
		JButton button6=new JButton("按钮6");	
//		获取和顶层窗口关联的容器
		Container con=jf.getContentPane();
//		设置为====默认 水平、垂直间隙为0px
		con.setLayout(new BorderLayout());
		con.setLayout(new BorderLayout(10,10));
		con.add(BorderLayout.CENTER,button1);
		con.add(BorderLayout.NORTH,button2);
		con.add(BorderLayout.SOUTH,button3);
		con.add(BorderLayout.EAST,button4);
		con.add(BorderLayout.WEST,button5);
//		默认添加到中间
		con.add(button6);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
