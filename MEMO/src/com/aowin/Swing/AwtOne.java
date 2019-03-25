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
/**AWT 抽象窗口工具包 重量级组件，依赖于本地运行平台
 * 
 * @param args
 */
	public static void main(String[] args) {
		AwtOne a=new AwtOne();
		a.init();
	}
	public void init() {
//		创建带有标题的窗口
//		Frame frame=new Frame("FIRST FRAME");
		setTitle("FIRST FRAME");
//		大小
		setSize(600,400);//像素
//		位置
		setLocation(200,200);
//		新建容器--存放组件
		Container con=new Container();
		con.setLayout(new GridLayout(3,2));
//		按钮添加到容器中--标签
		con.add(new Button("asd"));
//		创建标签--名字--颜色--
		Label label=new Label("123");
		label.setBackground(Color.gray);
		con.add(label);
//		添加容器到窗口
		add(con);
//		窗口默认不可见
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt) {
			setVisible(false); //设置窗口 f 不可见
			dispose(); //释放窗口及其子组件的屏幕资源
			System.exit(0); //退出程序
			}
			});
	}
}
