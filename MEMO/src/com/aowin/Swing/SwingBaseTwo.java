package com.aowin.Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SwingBaseTwo {
	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);

		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
//		���-JTable
		String []colNames= {"���","����","����ֵ"};
//		����������������
		DefaultTableModel model=new DefaultTableModel(colNames,8);
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
		model.removeRow(1);//ɾ����--ָ���к�
//		�����
		model.addRow(data1);
		model.addRow(data2);
		model.addRow(data3);
//		�޸�
		model.setValueAt(35, 2, 2);//�У��ж��Ǵ�0��ʼ����ģ�
//		��ѯ
		Object value1=model.getValueAt(2, 2);//��ѯָ����Ԫ���ֵ
		int rows=model.getRowCount();
		int columns=model.getColumnCount();//�����������
//		���
//		model.setRowCount(0);//--�к�Ϊ0--�������
		
		
		
//		????????/
//		table.setTableHeader(new JTableHeader(null));
		JTableHeader header=table.getTableHeader();
		
//		System.out.println(header.getm);
//		ȷ�Ͽ�--��-0����-1��ȡ��-2
		int num=JOptionPane.showConfirmDialog(null, "�Ƿ���ʾ��������������?");//�з���ֵ
//		System.out.println(num);
		if(num==0){
//		�Ի���--��Ϣ��:JOptionPane
		JOptionPane.showMessageDialog(null, "ss","��Ϣ��",JOptionPane.WARNING_MESSAGE);
//		ȷ�Ͽ�
//		JOptionPane.showConfirmDialog(null, "ȷ��?");//�з���ֵ
//		�����
		JOptionPane.showInputDialog(null,"����������ʲô");
		
//		ѡ����ļ�--JFileChooser
		JFileChooser fc=new JFileChooser("d:/work");
		fc.showOpenDialog(null);//--�з���ֵ---����ͨ��IO����ȡ����
//		ѡ�񱣴��ļ�
		fc.showSaveDialog(null);
		}
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
