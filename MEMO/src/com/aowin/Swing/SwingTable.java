package com.aowin.Swing;

import java.awt.Container;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class SwingTable {

	public static void main(String[] args) {

		JFrame jf=new JFrame("table");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
		
		Container con=jf.getContentPane();
		String columns[]={ "����", "ѧ��", "����", "����", "��Ա" };
		Object[][]data={ { "�Դ�Ԫ", "S050107001", new Integer(23), "����", new Boolean(false) },
				{ "��С��", "S050107002", new Integer(22), "���", new Boolean(true) },
				{ "�� ��", "S050107003", new Integer(23), "�Ϻ�", new Boolean(false) },
				{ "��ԪԪ", "S050107004", new Integer(23), "����", new Boolean(true) },
				{ "�� ��", "S050107005", new Integer(24), "�㽭", new Boolean(false) },
				{ "�� ��", "S050107006", new Integer(25), "����", new Boolean(true) }, };
//		DefaultTableModel df=new DefaultTableModel(columns,3);//��������
		DefaultTableModel df=new DefaultTableModel(data,columns);
		JTable table=new JTable(df);
		JScrollPane jsp=new JScrollPane(table);
		con.add(jsp);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�ʱ��������
	}

}
class tableOne extends AbstractTableModel{
	final String[]columnNames= { "����", "ѧ��", "����", "����", "��Ա" };
	final Object[][]data={ { "�Դ�Ԫ", "S050107001", new Integer(23), "����", new Boolean(false) },
			{ "��С��", "S050107002", new Integer(22), "���", new Boolean(true) },
			{ "�� ��", "S050107003", new Integer(23), "�Ϻ�", new Boolean(false) },
			{ "��ԪԪ", "S050107004", new Integer(23), "����", new Boolean(true) },
			{ "�� ��", "S050107005", new Integer(24), "�㽭", new Boolean(false) },
			{ "�� ��", "S050107006", new Integer(25), "����", new Boolean(true) }, };
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {//���ָ����Ԫ���ֵ
		return data[rowIndex][columnIndex];
	}
	
}
