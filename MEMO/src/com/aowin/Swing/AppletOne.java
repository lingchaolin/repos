package com.aowin.Swing;

import java.applet.Applet;
import java.awt.Button;

public class AppletOne extends Applet{
	@Override
	public void init() {
		add(new Button("开始"));
		System.out.println("初始化");
	}

	@Override
	public void start() {
		System.out.println("启动");
	}

	@Override
	public void stop() {
		System.out.println("停止");
	}

	@Override
	public void destroy() {
		System.out.println("销毁");
	}

}
//servelet

//必须嵌入在网页中，可增加网页的动态效果init()-start()-stop()-destory()
