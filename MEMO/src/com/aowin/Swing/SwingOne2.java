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
 * Swing 基于AWT开发的，完全用java语言编写的，不依赖于本地运行平台
 * @author Administrator
 *
 */
public class SwingOne2 {

	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
		
//		swing 是默认创建容器的，添加的时候要获取容器
		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
//		表格-JTable
		String []colNames= {"编号","姓名","经验值"};
//		参数是列名和行数
		DefaultTableModel model=new DefaultTableModel(colNames,0);
		JTable table=new JTable(model);//根据表格模型来创建表格
		JScrollPane jsp2=new JScrollPane(table);//创建滑动面板装饰表格
//		设定表格大小
		jsp2.setPreferredSize(new Dimension(300,150));//--
		con.add(jsp2);
//		添加数据--在模型中添加
//		addRow
		Object []data1= {"1","卡卡罗特",1233234235};
		Object []data2= {"2","贝吉塔",123323423};
		Object []data3= {"3","孙悟饭",12332};
//		删除
		model.addRow(data1);
		model.addRow(data2);
		model.addRow(data3);
//		查询
		
		JTableHeader header=table.getTableHeader();
//		System.out.println(header.contains(p));
		header.addMouseListener(new MouseAdapter() {
			
		} );
//		header.setToolTipText("tesst");
//		System.out.println(header.getToolTipText(event));
		
		int rows=model.getRowCount();
		int columns=model.getColumnCount();//获得行数列数
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时结束程序
	}

}
