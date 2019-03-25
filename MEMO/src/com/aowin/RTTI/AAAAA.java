package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//运行时刻类型判定
public class AAAAA {
/**分类
 * 1.传统的rtti
 * 2.reflection机制(反射机制)
 * 	反射的优点：
 * 		提高了程序的灵活性和扩展性
 * 		降低了程序的耦合性，提高自适应能力
 * 		运行程序创建和控制任何类的对象,无需提前硬编码目标类；
 * 反射的缺点：
 * 		1.使用反射是一种解释型操作，用于字段和方法接入时远慢于直接代码
 * 			-因此多用于对灵活性或扩展性要求较高的系统框架；
 * 		2.使用反射会模糊程序内部逻辑，程序员希望能够在源代码中看到程序的逻辑，
 * 			-但反射绕过了源代码，反射代码比相应的直接代码更复杂，维护难度更大。
 */
/**类的组成部分：
 * 构造方法
 * 变量
 * 方法
 * A类的Class对象即Class的一个实例；该实例用于描述A类的详细信息；
 * class编译完成后会产生一个该类的Class文件，存储于.class文件；
 * 	执行期间：Class未装载-JVM根据名称找到.class--装载
 * 		   ： 已装载--产生该类型的对象；
 */
/**反射获取Class对象的3种方法：
 * 1.Class.forName(包名.类名);
 * Class c=Class.forName("com.aowin.reflection.GameOne");
 * 2.已有对象时--类名.class();
 * 3.对象名.getClass();
 */
/**获取构造函数以及创建对象-假设'clazz'为目类的Class对象
 * 1.通过无参构造器创建对象-clazz.newInstance();
 * 2.通过有参构造器创建对象
 * 		-Constructor con=class.getDeclaredConstructor(int.class);
 * 		-GameOne one=(GameOne)con.newInstance(12);
 * 	
 * 获得构造器集合；
 * 	获得全部构造器：-Constructor cons[]=clazz.getDeclaredConstructors();
 * 	获得公共权限的构造器：						 =clazz.getConstructors();
 * 								
 * 方法中没有'Declared'的只能获得非公开属性的**；
 */
/**获取属性
 * 	获得属性集合
 * 		clazz.getDeclaredFields()
 * 		clazz.getFields()
 *  获得属性--根据字段名称
 * 		clazz.getDeclaredField("size")
 * 		clazz.getField("size")
 * 	利用反射设置属性
 * 		GameOne c=clazz.newInstance();--c是GameOne类的一个对象
 * 		Field ff=c.getDeclaredField("size")--ff是该类的一个属性
 * 		ff.setInt(c,12);--可能存在该类的多个对象，所以,设置属性时指定对象；
 */
/**方法
 * 获取方法
 * 		clazz.getMethod("test");--没有参数时写'null'或不写；
 * 		clazz.getDeclaredMethod("test");
 * 	调用方法
 * 		Method me=clazz.getDeclaredMethod("test");
 * 		me.invoke(c);--得到方法后，与设置字段类似，要指明对象；
 * 	调用私有方法：
 * 		me.setAccessible(true);--私有方法不能调用，需要设置；
 */
/**习题
 * 5、有如下类，请写方法调用test方法来执行
	public class Outter {
	private Inner in;
	public Outter(){
		in = new Inner();
	}
		private class Inner{
			private void test(){
				System.out.println("test");
			}
		}
	}
 * @throws ClassNotFoundException 
 */
	public static void main(String[] args) throws Exception {
//		方法一；
		Class in=Class.forName("com.aowin.RTTI.Outter$Inner");
		
//		直接调用内部类的构造器
		Constructor cons[]=in.getDeclaredConstructors();
		for(Constructor con:cons) {
			System.out.println(con);
		}
//		得到构造器
//		private com.aowin.RTTI.Outter$Inner(com.aowin.RTTI.Outter)
//		com.aowin.RTTI.Outter$Inner(com.aowin.RTTI.Outter,com.aowin.RTTI.Outter$Inner)
//简单一点的，传入外部类的对象
		Constructor con=in.getDeclaredConstructor(Outter.class);
		con.setAccessible(true);
//		内部类对象的创建--con.newInstance(外部类的对象);
//		外部类对象的创建--Outter.class.newInstance();
		Method me=in.getDeclaredMethod("test");
		me.setAccessible(true);
		me.invoke(con.newInstance(Outter.class.newInstance()));
		
//		方法二；
		//1-外部类对象
		Class co = Outter.class;
		//2-建好了一个内部类对象
		Field fIn = co.getDeclaredField("in");
		fIn.setAccessible(true); 
		Object obj = fIn.get(co.newInstance());
		
		//3
		Class ci = obj.getClass();//得到的是子类对像的类，此处即内部类；
		//4
		Method mTest = ci.getDeclaredMethod("test");//根据内部类得到方法；
		mTest.setAccessible(true); 
		mTest.invoke(obj);  //调用方法--指定对象
	}

}
class Outter {
	private Inner in;
	public Outter(){
		in = new Inner();
	}
	private class Inner{
		private void test(){
			System.out.println("test");
		}
	}
	}