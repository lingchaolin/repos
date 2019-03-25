package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 反射分析类中属性
 * 
 *
 */
public class ClassFour {
	public static void main(String[]args) {
		try {
			Class<?> c=Class.forName("com.aowin.reflection.GameOne");
			GameOne game=(GameOne) c.newInstance();
			
//			System.out.println("打印所有的方法，但不包括继承的");
//			Method []f=c.getDeclaredMethods();
//			for(Method temp:f) {
//				System.out.println(temp);
//			}
			
//			f=c.getMethods();//包括了从Object继承的方法
//			for(Method temp:f) {
//				System.out.println(temp);
//			}
			//获取指定方法：
			Method ma=c.getMethod("test");//没有参数写null,或者直接不写
			ma.invoke(game);
			//调用私有的方法
			Method mb=c.getDeclaredMethod("test",long.class,String.class);
			mb.setAccessible(true);
			mb.invoke(game,112L,"hahaha");
			//获得指定属性
			//public--通过getField(属性名称);
			//set(对象,属性值);
			//不是public--通过getDeclaredField(属性名称);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
