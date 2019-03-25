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
		String columns[]={ "姓名", "学号", "年龄", "籍贯", "党员" };
		Object[][]data={ { "赵大元", "S050107001", new Integer(23), "北京", new Boolean(false) },
				{ "李小乐", "S050107002", new Integer(22), "天津", new Boolean(true) },
				{ "孙 月", "S050107003", new Integer(23), "上海", new Boolean(false) },
				{ "周元元", "S050107004", new Integer(23), "重庆", new Boolean(true) },
				{ "刘 涛", "S050107005", new Integer(24), "浙江", new Boolean(false) },
				{ "杨 光", "S050107006", new Integer(25), "江西", new Boolean(true) }, };
//		DefaultTableModel df=new DefaultTableModel(columns,3);//列名行数
		DefaultTableModel df=new DefaultTableModel(data,columns);
		JTable table=new JTable(df);
		JScrollPane jsp=new JScrollPane(table);
		con.add(jsp);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时结束程序
	}

}
class tableOne extends AbstractTableModel{
	final String[]columnNames= { "姓名", "学号", "年龄", "籍贯", "党员" };
	final Object[][]data={ { "赵大元", "S050107001", new Integer(23), "北京", new Boolean(false) },
			{ "李小乐", "S050107002", new Integer(22), "天津", new Boolean(true) },
			{ "孙 月", "S050107003", new Integer(23), "上海", new Boolean(false) },
			{ "周元元", "S050107004", new Integer(23), "重庆", new Boolean(true) },
			{ "刘 涛", "S050107005", new Integer(24), "浙江", new Boolean(false) },
			{ "杨 光", "S050107006", new Integer(25), "江西", new Boolean(true) }, };
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
	public Object getValueAt(int rowIndex, int columnIndex) {//获得指定单元格的值
		return data[rowIndex][columnIndex];
	}
	
}
