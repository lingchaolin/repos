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
//		��ť
		JButton button=new JButton("��ť");
//		��ȡ��ť�ϵ����֣�getText;
		button.getText();
		System.out.println(button.getText());
//		���ð�ť�ϵ����֣�setText;
		button.setText("ȷ��");
		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
		con.add(button);
//		��ǩ
		JLabel label=new JLabel("a label") ;
		label.setForeground(Color.RED);//����������ɫ
		con.add(label);
//���ͼƬ
		JPanel panel=new JPanel() {
			public  void paintComponent(Graphics g) {
				Image back=GameUtil.getImage("images/Law.jpg");
				g.drawImage(back,-150,0,950,630,null);
			}
		};
//		JTextField-�ı���--��������--�ɼ���ȣ�
		JTextField jt=new JTextField("text",8);//--���ÿ��
//		setText()-�������֡��޸�����
		jt.setEditable(false);//		seEditable(false)-����Ϊ���ɱ༭
		con.add(jt);
		
//		�ı���
		JTextArea jta=new JTextArea("����",4,8);//���ÿ�ȳ���
//		�Զ�����
		jta.setLineWrap(true);
//		��ӻ�����壻
		JScrollPane jsp=new JScrollPane(jta);
		con.add(jsp);
		
//		�����JPasswordField
		JLabel label2=new JLabel("���룺");
		con.add(label2);
		JPasswordField jpd=new JPasswordField("123",6);
		con.add(jpd);
//		���û����ַ���--�����������������ʾ����'********'����'^^^^^^^^^'���ǡ���
		jpd.setEchoChar('^');
//		��ȡ����--char����
		char[]arr=jpd.getPassword();
		String str=new String(arr);
//		System.out.println("������:"+str);
		
//		����屣��һ�£�-��ѡ��
		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel lab3=new JLabel("�Ա�");
		JRadioButton rb1=new JRadioButton("��");
		JRadioButton rb2=new JRadioButton("Ů");
		panel2.add(lab3);
		panel2.add(rb1);
		panel2.add(rb2);
//		-�߼�����-����ѡ�����
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		rb1.setSelected(true);//����ѡ��
		
		con.add(panel2);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
