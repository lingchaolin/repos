package com.aowin.Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Swing ����AWT�����ģ���ȫ��java���Ա�д�ģ��������ڱ�������ƽ̨
 * @author Administrator
 *
 */
public class SwingOne2 {

	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
		
//		swing ��Ĭ�ϴ��������ģ���ӵ�ʱ��Ҫ��ȡ����
		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
//		���-JTable
		String []colNames= {"���","����","����ֵ"};
//		����������������
		DefaultTableModel model=new DefaultTableModel(colNames,0);
		JTable table=new JTable(model);//���ݱ��ģ�����������
		JScrollPane jsp2=new JScrollPane(table);//�����������װ�α��
//		�趨����С
		jsp2.setPreferredSize(new Dimension(300,150));//--
		con.add(jsp2);
//		�������--��ģ�������
//		addRow
		Object []data1= {"1","��������",1233234235};
		Object []data2= {"2","������",123323423};
		Object []data3= {"3","����",12332};
//		ɾ��
		model.addRow(data1);
		model.addRow(data2);
		model.addRow(data3);
//		��ѯ
		
		JTableHeader header=table.getTableHeader();
//		System.out.println(header.contains(p));
		header.addMouseListener(new MouseAdapter() {
			
		} );
//		header.setToolTipText("tesst");
//		System.out.println(header.getToolTipText(event));
		
		int rows=model.getRowCount();
		int columns=model.getColumnCount();//�����������
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�ʱ��������
	}

}
