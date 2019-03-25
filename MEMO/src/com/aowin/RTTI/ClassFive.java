package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 *���ͼ�飬���ַ�ʽ
 * 
 * rtti��ʲô��������ʽ��
 * reflection���䣿Դͷ������
 * 	���䴴�����󣬹�����
 * 	������Ľṹ-���ԣ�����
 * Class����
 * Class��
 *���ͼ��*
 */
public class ClassFive {
	public static void main(String[]args) {
		try {
			Class<?> c=Class.forName("com.aowin.aaad.reflection.GameTwo");
			GameOne game=(GameOne) c.newInstance();
			//1.instanceof
			GameOne game1=new GameTwo();
//			game1=new GameOne();
//			if(game1 instanceof GameTwo) {//���ͼ��
//				GameTwo g2=(GameTwo)game1;
//				System.out.println("color="+g2.color);
//			}
//			
			//2.Class c=*.class--instanceof c����
			if(c.isInstance(game1)) {//���ͼ��
				GameTwo g2=(GameTwo)game1;
				System.out.println("color="+g2.color);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
