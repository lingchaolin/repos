package com.aowin.RTTI;
/**
 * 三种通过反射获取对象的方式
 * @author Administrator
 *
 *1.传统rtti;
 *2.reflection机制
 *反射：对象->类
 *反射机制的源头是Class对象
 *Class对象是对某个普通class类的描述
 *Class类是一个类，不对外提供构造方法，提供一些方法
 *当一个普通的类编译通过之后，该类的Class对象开始保存在生成的同名的。class文件中
 *--第一次使用该类时，检测是否已加载。加载->调用；未加载->加载
 *三种获取Class对象的方式；--获取的对象是同一个
 *
 *反射的作用：1.反射创建对象 ，2反射分析类的结构（属性，方法）；
 */
public class ClassOne {
	public static void main(String[]args) {
		
		try {
			/**
			 * Class--描述类的对象：Class的一个对象，用来描述指定路径的类
			 */
			//1 forName();
			//主要用于加载驱动，，不需要提前拥有对象
			Class c1=Class.forName("com.aowin.RTTI.ClassOne");
			System.out.println("c1:"+c1.getName());
			
			//2  对象.getClass
			//主要用于类型检查,需要提前拥有对象
			Class c22=c1.getClass();//class类的'Class'对象
			System.out.println("c2:"+c22.getName());
			/**
			 * 上转型测试
			 */
			GameOne g1=new GameOne();
			Class c2=g1.getClass();
			System.out.println("c2:"+c2.getName());
			
			//3  类名.class
			//主要用于参数传递，注意基本类型也可以使用，
			Class c3=GameOne.class;
			System.out.println("c3:"+c3.getName());
		
			System.out.println(c1==c2);
			System.out.println(c1==c3);
			System.out.println(c2==c22);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			/**
			 * 上转型测试--得到的是子类对象
			 */
			GameOne game2=new GameTwo();
			Class ca1=game2.getClass();
			System.out.println("ca1:"+ca1.getName());
			
			GameOne game3=new GameThree();
			Class ca2=game3.getClass();
			System.out.println("ca2:"+ca2.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
class GameOne{
	public int size;
	public String str;
	private long num;
	public GameOne() {
		System.out.println("GameOne空参构造方法");
	}
	public GameOne(int size) {
		this.size=size;
		System.out.println("GameOne构造方法");
	}
	private GameOne(String str) {
		this.str=str;
		System.out.println("GameOne私有的构造方法");
	}
	GameOne(String str,int num) {
		this.str=str;
		System.out.println("GameOne私有的构造方法");
	}
	protected GameOne(int num,String str) {
		this.str=str;
		System.out.println("GameOne私有的构造方法");
	}
	public void test() {
		System.out.println(" public  test");
	}
	protected void test(int num) {
		System.out.println("protected  test");	
	}
	void test(String name) {
		System.out.println("默认 test");
	}
	private void test(long number,String name) {
		System.out.println("private test-"+number+"-"+name);
	}
	public void test2() {
		System.out.println("test2 ");
	}
}
class GameTwo extends GameOne{
	public String color="red";
}
class GameThree extends GameOne{
	public String color="white";
}