package com.aowin.Swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayoutGrid {
/**
 * GridLayout--Ĭ��Ϊһ��
 */
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
//		con.setLayout(new GridLayout(4,2));
//		con.setLayout(new BorderLayout(10,10));
//		con.add(button1);
//		con.add(button2);
//		con.add(button3);
//		con.add(button4);
//		con.add(button5);
//		Ĭ����ӵ��м�
//		con.add(button6);
		con.setLayout(new GridLayout(3,3));
		String[]arr= {"1","2","3","4","5","6","7","8","9"};
		JButton[]brr=new JButton[arr.length];
		for(int i=0;i<arr.length;i++) {
			brr[i]=new JButton(arr[i]);
			con.add(brr[i]);
		}
//		�Ƴ�
		con.remove(brr[5]);//ɾ��ָ����ť
		con.remove(0);//ɾ��ָ��λ�õİ�ť
		con.add(brr[5],0);//ָ��λ����Ӱ�ť
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
