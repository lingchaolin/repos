package com.aowin.Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Swing 基于AWT开发的，完全用java语言编写的，不依赖于本地运行平台
 * @author Administrator
 *
 */
public class SwingOne {

	public static void main(String[] args) {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 400);
		jf.setLocation(200, 200);
		
//		swing 是默认创建容器的，添加的时候要获取容器
		Container con=jf.getContentPane();
		con.setLayout(new FlowLayout());
		JButton button=new JButton("a button");
//		获取按钮上的文字；getText;
		button.getText();
//		设置按钮上的文字；setText;
		button.setText("确定");
//		使按钮不可用；
//		button.setEnabled(false);
		con.add(button);
		
		JLabel label=new JLabel("a label") ;
		label.setForeground(Color.RED);//设置文字颜色
		con.add(label);
//添加图片
		JPanel panel=new JPanel() {
			public  void paintComponent(Graphics g) {
				Image back=GameUtil.getImage("images/Law.jpg");
				g.drawImage(back,-150,0,950,630,null);
			}
		};
//		panel.add(button);
//		con.add(panel);
//		JTextField-文本行--设置文字--修改文字；
		JTextField jt=new JTextField("text",8);//--设置宽度
	
		
//		setText()-设置文字、修改文字
//		seEditable(false)-设置为不可编辑
		jt.setEditable(false);
		con.add(jt);
//		文本域、
		JTextArea jta=new JTextArea("正文",4,8);//设置宽度长度
//		自动换行
		jta.setLineWrap(true);
//		添加滑动面板；
		JScrollPane jsp=new JScrollPane(jta);

		con.add(jsp);
//		密码框；JPasswordField
		JLabel label2=new JLabel("密码：");
		con.add(label2);
		JPasswordField jpd=new JPasswordField("123",6);
		con.add(jpd);
//		设置回显字符；--可以设置密码框中显示的是'********'还是'^^^^^^^^^'还是……
		jpd.setEchoChar('^');
//		获取密码--char数组
		char[]arr=jpd.getPassword();
		String str=new String(arr);
//		System.out.println("密码是:"+str);
		
//		用面板保持一致；
		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel lab3=new JLabel("性别");
		JRadioButton rb1=new JRadioButton("男");
		JRadioButton rb2=new JRadioButton("女");
		panel2.add(lab3);
		panel2.add(rb1);
		panel2.add(rb2);
//		-逻辑分组
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		rb1.setSelected(true);//设置选中
		
		con.add(panel2);
//		复选框
		JPanel panel3=new JPanel();
		panel3.add(new JLabel("投票选择今天上什么课"));
		JCheckBox cb1=new JCheckBox("体育");
		JCheckBox cb2=new JCheckBox("语文");
		JCheckBox cb3=new JCheckBox("数学");
		JCheckBox cb4=new JCheckBox("英语");
		panel3.add(cb1);
		panel3.add(cb2);
		panel3.add(cb3);
		panel3.add(cb4);
//		设置被选中；
		cb4.setSelected(true);
		cb1.setEnabled(false);
		con.add(panel3);
//		下拉式列表框
		JPanel pan1=new JPanel();
		pan1.add(new JLabel("出生年份:"));
		String []arr2= {"2015","2016","2017"};
		JComboBox jcb=new JComboBox(arr2);
//		设置、获取被选中的项；
		jcb.setSelectedIndex(2);
		jcb.setSelectedItem("2017");
		String item=(String) jcb.getSelectedItem();//默认返回Object类型
//		System.out.println("选中的是："+item);
		pan1.add(jcb);
		con.add(pan1);
		
//		菜单
//		JMenuBar-菜单栏
		JMenuBar jmbar=new JMenuBar();
		
		jf.setJMenuBar(jmbar);//属性-设置菜单栏
//		JMenu-有下一层菜单；
		JMenu jmf=new JMenu("FileF");
		jmbar.add(jmf);
		
		JMenu jms=new JMenu("FileS");
		jmf.add(jms);
		
//		JMenuItem-没有下一级菜单的菜单；
		JMenuItem item1=new JMenuItem("ITEM1");
		jms.add(item1);
		jms.addSeparator();
		JMenuItem item2=new JMenuItem("ITEM2");
		jms.add(item2);
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
//		获取表头
//		JTableHeader header=table.getTableHeader();
//		对话框--消息框:JOptionPane
//		JOptionPane.showMessageDialog(null, "ss","消息框",JOptionPane.WARNING_MESSAGE);
//		确认框
//		JOptionPane.showConfirmDialog(null, "确定?");//有返回值
//		输入框
//		JOptionPane.showInputDialog(null,"请随便输入点什么");
		
//		选择打开文件--JFileChooser
		JFileChooser fc=new JFileChooser("d:/work");
		fc.showOpenDialog(null);//--有返回值---可以通过IO流读取数据
//		选择保存文件
		fc.showSaveDialog(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时结束程序
	}

}
