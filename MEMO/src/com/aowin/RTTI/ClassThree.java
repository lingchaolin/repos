package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/**
 * ���������������
 * 
 *
 */
public class ClassThree {
	public static void main(String[]args) {
		try {
			Class c=Class.forName("com.aowin.RTTI.GameOne");
			GameOne game=(GameOne) c.newInstance();
			Field []f=c.getDeclaredFields();
			for(Field temp:f) {
				System.out.println(temp);
			}
			//���ָ������
			//public--ͨ��getField(��������);
			Field ff=c.getField("size");
			//set(����,����ֵ);
			ff.setInt(game, 11);
			int no=ff.getInt(game);
			System.out.println("no:"+no);
			//����public--ͨ��getDeclaredField(��������);
			
			Field fs=c.getDeclaredField("num");
			fs.setAccessible(true);//num��˽�����ԣ�Ҫ���ʵĻ���Ҫ����Ȩ�ޣ�
			fs.setLong(game, 222L);
			long num=fs.getLong(game);
			System.out.println("num:"+num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
