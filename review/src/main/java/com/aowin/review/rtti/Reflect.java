package com.aowin.review.rtti;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Reflect {

	public Reflect() {
		
	}

	public static void main(String[] args) {
		try {
			Class d1=Class.forName("com.aowin.review.rtti.Dog");
			/*Class d2=Dog.class;
			Dog dog=new Dog();
			Class d3=dog.getClass();
			Dog d11=(Dog) d1.newInstance();
			Dog d22=(Dog) d2.newInstance();
			Dog d33=(Dog) d3.newInstance();
			System.out.println(d11.getName());
			System.out.println(d22.getName());
			System.out.println(d33.getName());*/
			/*Constructor c1=d1.getConstructor(String.class,int.class);
			Dog dog1=(Dog) c1.newInstance("李四",14);
			System.out.println(dog1);*/
			/*	Dog d11=(Dog) d1.newInstance();
			Method method=d1.getMethod("publicPrint", int.class,int.class,String.class);
			method.invoke(d11, 11,12,"name");
			Method method2=d1.getDeclaredMethod("privatePrint");
			method2.setAccessible(true);
			method2.invoke(d11);*/
/*			Dog d11=(Dog) d1.newInstance();
			Field field=d1.getField("name");
			field.set(d11, "lili");
			System.out.println(d11);
			Field field2=d1.getDeclaredField("age");
			field2.setAccessible(true);
			field2.set(d11, 15);
			System.out.println(d11);*/
			
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
//			Statement stat=conn.createStatement();
//			ResultSet resultSet=stat.executeQuery("select * from person");
//			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection conn2=DriverManager.getConnection("jdbc:oracle:this:@localhost:1521:test","root","123456");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			int n=1/0;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}finally {
			System.out.println(123);
//			System.exit(1);
			System.out.println(456);
		}
	}

}
class Dog{
	public String name="张三";
	private int age=12;
	public Dog() {
		super();
	}
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void publicPrint(int num,int num2,String name) {
		System.out.println("this is public method");
	}
	private void privatePrint() {
		System.out.println("this is private method");
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	
}