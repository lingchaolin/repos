package com.aowin.Swing;

import java.applet.Applet;
import java.awt.Button;

public class AppletOne extends Applet{
	@Override
	public void init() {
		add(new Button("��ʼ"));
		System.out.println("��ʼ��");
	}

	@Override
	public void start() {
		System.out.println("����");
	}

	@Override
	public void stop() {
		System.out.println("ֹͣ");
	}

	@Override
	public void destroy() {
		System.out.println("����");
	}

}
//servelet

//����Ƕ������ҳ�У���������ҳ�Ķ�̬Ч��init()-start()-stop()-destory()
