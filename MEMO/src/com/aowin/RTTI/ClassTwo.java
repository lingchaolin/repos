package com.aowin.RTTI;

import java.lang.reflect.Constructor;
/**
 * ���䴴������
 * 1.��ȡ���Class����
 * 2.����пղη���->����.newInstance()--���ÿղι��췽��
 * 3.ͨ��ָ�����췽����������
 * @author Administrator
 *
 */
public class ClassTwo {
	public static void main(String[]args) {
		try {
			Class c=GameOne.class;
			GameOne one=(GameOne) c.newInstance();//�ղι��췽��
			Constructor con=c.getDeclaredConstructor(int.class);//��ȡ�в����Ĺ��췽��
			GameOne two=(GameOne) con.newInstance(12);
			
			System.out.println("��������Ȩ�޵Ĺ��췽��!");
			Constructor cons[]=c.getDeclaredConstructors();
			for( Constructor conn:cons) {
				System.out.println(conn);
			}
			System.out.println("��������Ȩ�޵Ĺ��췽��!--����");
			
			System.out.println("����publicȨ�޵Ĺ��췽��!");
			Constructor con2s[]=c.getConstructors();
			for( Constructor conn:con2s) {
				System.out.println(conn);
			}
			System.out.println("����publicȨ�޵Ĺ��췽��!--����");
			con=c.getDeclaredConstructor(String.class);//��ȡ˽�еĹ��췽��
			Constructor c2=c.getConstructor(int.class);
			GameOne cc=(GameOne) c2.newInstance(12);
			System.out.println("cc:"+cc);
			con.setAccessible(true);//���÷���Ȩ�ޣ����Ե���˽�еĹ��췽��
			GameOne three=(GameOne) con.newInstance("asd");
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
