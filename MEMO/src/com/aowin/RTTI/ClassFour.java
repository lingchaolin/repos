package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * ���������������
 * 
 *
 */
public class ClassFour {
	public static void main(String[]args) {
		try {
			Class<?> c=Class.forName("com.aowin.reflection.GameOne");
			GameOne game=(GameOne) c.newInstance();
			
//			System.out.println("��ӡ���еķ��������������̳е�");
//			Method []f=c.getDeclaredMethods();
//			for(Method temp:f) {
//				System.out.println(temp);
//			}
			
//			f=c.getMethods();//�����˴�Object�̳еķ���
//			for(Method temp:f) {
//				System.out.println(temp);
//			}
			//��ȡָ��������
			Method ma=c.getMethod("test");//û�в���дnull,����ֱ�Ӳ�д
			ma.invoke(game);
			//����˽�еķ���
			Method mb=c.getDeclaredMethod("test",long.class,String.class);
			mb.setAccessible(true);
			mb.invoke(game,112L,"hahaha");
			//���ָ������
			//public--ͨ��getField(��������);
			//set(����,����ֵ);
			//����public--ͨ��getDeclaredField(��������);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
