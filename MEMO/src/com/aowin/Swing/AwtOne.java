package com.aowin.Swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtOne extends Frame{
/**AWT ���󴰿ڹ��߰� ����������������ڱ�������ƽ̨
 * 
 * @param args
 */
	public static void main(String[] args) {
		AwtOne a=new AwtOne();
		a.init();
	}
	public void init() {
//		�������б���Ĵ���
//		Frame frame=new Frame("FIRST FRAME");
		setTitle("FIRST FRAME");
//		��С
		setSize(600,400);//����
//		λ��
		setLocation(200,200);
//		�½�����--������
		Container con=new Container();
		con.setLayout(new GridLayout(3,2));
//		��ť��ӵ�������--��ǩ
		con.add(new Button("asd"));
//		������ǩ--����--��ɫ--
		Label label=new Label("123");
		label.setBackground(Color.gray);
		con.add(label);
//		�������������
		add(con);
//		����Ĭ�ϲ��ɼ�
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt) {
			setVisible(false); //���ô��� f ���ɼ�
			dispose(); //�ͷŴ��ڼ������������Ļ��Դ
			System.exit(0); //�˳�����
			}
			});
	}
}
