package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 *类型检查，两种方式
 * 
 * rtti是什么？两种形式？
 * reflection反射？源头？作用
 * 	反射创建对象，构造器
 * 	分析类的结构-属性，方法
 * Class对象；
 * Class类
 *类型检查*
 */
public class ClassFive {
	public static void main(String[]args) {
		try {
			Class<?> c=Class.forName("com.aowin.aaad.reflection.GameTwo");
			GameOne game=(GameOne) c.newInstance();
			//1.instanceof
			GameOne game1=new GameTwo();
//			game1=new GameOne();
//			if(game1 instanceof GameTwo) {//类型检测
//				GameTwo g2=(GameTwo)game1;
//				System.out.println("color="+g2.color);
//			}
//			
			//2.Class c=*.class--instanceof c……
			if(c.isInstance(game1)) {//类型检测
				GameTwo g2=(GameTwo)game1;
				System.out.println("color="+g2.color);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
