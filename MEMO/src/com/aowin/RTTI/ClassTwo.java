package com.aowin.RTTI;

import java.lang.reflect.Constructor;
/**
 * 反射创建对象
 * 1.获取类的Class对象
 * 2.如果有空参方法->对象.newInstance()--调用空参构造方法
 * 3.通过指定构造方法创建对象
 * @author Administrator
 *
 */
public class ClassTwo {
	public static void main(String[]args) {
		try {
			Class c=GameOne.class;
			GameOne one=(GameOne) c.newInstance();//空参构造方法
			Constructor con=c.getDeclaredConstructor(int.class);//获取有参数的构造方法
			GameOne two=(GameOne) con.newInstance(12);
			
			System.out.println("遍历所有权限的构造方法!");
			Constructor cons[]=c.getDeclaredConstructors();
			for( Constructor conn:cons) {
				System.out.println(conn);
			}
			System.out.println("遍历所有权限的构造方法!--结束");
			
			System.out.println("遍历public权限的构造方法!");
			Constructor con2s[]=c.getConstructors();
			for( Constructor conn:con2s) {
				System.out.println(conn);
			}
			System.out.println("遍历public权限的构造方法!--结束");
			con=c.getDeclaredConstructor(String.class);//获取私有的构造方法
			Constructor c2=c.getConstructor(int.class);
			GameOne cc=(GameOne) c2.newInstance(12);
			System.out.println("cc:"+cc);
			con.setAccessible(true);//设置访问权限，可以调用私有的构造方法
			GameOne three=(GameOne) con.newInstance("asd");
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
