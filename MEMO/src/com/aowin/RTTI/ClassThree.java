package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/**
 * 反射分析类中属性
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
			//获得指定属性
			//public--通过getField(属性名称);
			Field ff=c.getField("size");
			//set(对象,属性值);
			ff.setInt(game, 11);
			int no=ff.getInt(game);
			System.out.println("no:"+no);
			//不是public--通过getDeclaredField(属性名称);
			
			Field fs=c.getDeclaredField("num");
			fs.setAccessible(true);//num是私有属性，要访问的话需要设置权限；
			fs.setLong(game, 222L);
			long num=fs.getLong(game);
			System.out.println("num:"+num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
