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
//		表格-JTable
		String []colNames= {"编号","姓名","经验值"};
//		参数是列名和行数
		DefaultTableModel model=new DefaultTableModel(colNames,8);
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
		model.removeRow(1);//删除行--指定行号
//		添加行
		model.addRow(data1);
		model.addRow(data2);
		model.addRow(data3);
//		修改
		model.setValueAt(35, 2, 2);//行，列都是从0开始计算的；
//		查询
		Object value1=model.getValueAt(2, 2);//查询指定单元格的值
		int rows=model.getRowCount();
		int columns=model.getColumnCount();//获得行数列数
//		清空
//		model.setRowCount(0);//--行号为0--清空数据
		
		
		
//		????????/
//		table.setTableHeader(new JTableHeader(null));
		JTableHeader header=table.getTableHeader();
		
//		System.out.println(header.getm);
//		确认框--是-0，否-1，取消-2
		int num=JOptionPane.showConfirmDialog(null, "是否显示后续的其他窗体?");//有返回值
//		System.out.println(num);
		if(num==0){
//		对话框--消息框:JOptionPane
		JOptionPane.showMessageDialog(null, "ss","消息框",JOptionPane.WARNING_MESSAGE);
//		确认框
//		JOptionPane.showConfirmDialog(null, "确定?");//有返回值
//		输入框
		JOptionPane.showInputDialog(null,"请随便输入点什么");
		
//		选择打开文件--JFileChooser
		JFileChooser fc=new JFileChooser("d:/work");
		fc.showOpenDialog(null);//--有返回值---可以通过IO流读取数据
//		选择保存文件
		fc.showSaveDialog(null);
		}
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
