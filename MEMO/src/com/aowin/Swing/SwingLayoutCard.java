package com.aowin.Swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayoutCard {
//	CardLayout
	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
//		������ť
		JButton button1=new JButton("��ť1");
		JButton button2=new JButton("��ť2");
		JButton button3=new JButton("��ť3");
		JButton button4=new JButton("��ť4");
		JButton button5=new JButton("��ť5");
		JButton button6=new JButton("��ť6");	
//		��ȡ�Ͷ��㴰�ڹ���������
		Container con=jf.getContentPane();
//		����Ϊ====Ĭ�� ˮƽ����ֱ��϶Ϊ0px
		con.setLayout(new CardLayout());
		con.add(button1);
		con.add(button2);
		con.add(button3);
		con.add(button4);
		con.add(button5);
//		Ĭ����ӵ��м�
		con.add(button6);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
