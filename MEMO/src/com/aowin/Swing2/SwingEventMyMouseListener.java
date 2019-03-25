package com.aowin.Swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SwingEventMyMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("������+"+e.getButton());//��ȡ��������ĸ���
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("�������");		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("�ɿ����");		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");		
	}

}
