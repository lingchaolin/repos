package com.aowin.Swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayoutGrid {
/**
 * GridLayout--默认为一行
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
//		con.setLayout(new GridLayout(4,2));
//		con.setLayout(new BorderLayout(10,10));
//		con.add(button1);
//		con.add(button2);
//		con.add(button3);
//		con.add(button4);
//		con.add(button5);
//		默认添加到中间
//		con.add(button6);
		con.setLayout(new GridLayout(3,3));
		String[]arr= {"1","2","3","4","5","6","7","8","9"};
		JButton[]brr=new JButton[arr.length];
		for(int i=0;i<arr.length;i++) {
			brr[i]=new JButton(arr[i]);
			con.add(brr[i]);
		}
//		移除
		con.remove(brr[5]);//删除指定按钮
		con.remove(0);//删除指定位置的按钮
		con.add(brr[5],0);//指定位置添加按钮
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
