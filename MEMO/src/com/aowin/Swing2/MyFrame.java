package com.aowin.Swing2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
/**
 * ����¼�չʾ
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame {

	public static void main(String[] args) {
		MyFrame m=new MyFrame();
		m.init();
	}
	public void init() {
		JFrame jf=new JFrame("first Swing");
		jf.setSize(600, 450);
		jf.setLocation(200, 200);
		

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
