package com.aowin.Swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayoutFlow {
/**
 * FlowLayout--��ʽ����
 * Ĭ�ϴ����ң�һ�з���������һ�м������ã�
 * @param args
 */
	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
//		������ť
		JButton button1=new JButton("��ť");
		JButton button2=new JButton("��ť");
		JButton button3=new JButton("��ť");
		JButton button4=new JButton("��ť");
		JButton button5=new JButton("��ť");
		JButton button6=new JButton("��ť");	
//		��ȡ�Ͷ��㴰�ڹ���������
		Container con=jf.getContentPane();
//		����Ϊ��ʽ����--Ĭ�ϼ�϶Ϊ5px
		con.setLayout(new FlowLayout());
//		���ö��뷽ʽ
		con.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		���ü�϶(���뷽ʽ��ˮƽ��϶����ֱ��϶);
		con.setLayout(new FlowLayout(FlowLayout.RIGHT,10,15));
//		��Ӱ�ť
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
