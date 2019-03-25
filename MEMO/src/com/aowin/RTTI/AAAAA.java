package com.aowin.RTTI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//����ʱ�������ж�
public class AAAAA {
/**����
 * 1.��ͳ��rtti
 * 2.reflection����(�������)
 * 	������ŵ㣺
 * 		����˳��������Ժ���չ��
 * 		�����˳��������ԣ��������Ӧ����
 * 		���г��򴴽��Ϳ����κ���Ķ���,������ǰӲ����Ŀ���ࣻ
 * �����ȱ�㣺
 * 		1.ʹ�÷�����һ�ֽ����Ͳ����������ֶκͷ�������ʱԶ����ֱ�Ӵ���
 * 			-��˶����ڶ�����Ի���չ��Ҫ��ϸߵ�ϵͳ��ܣ�
 * 		2.ʹ�÷����ģ�������ڲ��߼�������Աϣ���ܹ���Դ�����п���������߼���
 * 			-�������ƹ���Դ���룬����������Ӧ��ֱ�Ӵ�������ӣ�ά���Ѷȸ���
 */
/**�����ɲ��֣�
 * ���췽��
 * ����
 * ����
 * A���Class����Class��һ��ʵ������ʵ����������A�����ϸ��Ϣ��
 * class������ɺ�����һ�������Class�ļ����洢��.class�ļ���
 * 	ִ���ڼ䣺Classδװ��-JVM���������ҵ�.class--װ��
 * 		   �� ��װ��--���������͵Ķ���
 */
/**�����ȡClass�����3�ַ�����
 * 1.Class.forName(����.����);
 * Class c=Class.forName("com.aowin.reflection.GameOne");
 * 2.���ж���ʱ--����.class();
 * 3.������.getClass();
 */
/**��ȡ���캯���Լ���������-����'clazz'ΪĿ���Class����
 * 1.ͨ���޲ι�������������-clazz.newInstance();
 * 2.ͨ���вι�������������
 * 		-Constructor con=class.getDeclaredConstructor(int.class);
 * 		-GameOne one=(GameOne)con.newInstance(12);
 * 	
 * ��ù��������ϣ�
 * 	���ȫ����������-Constructor cons[]=clazz.getDeclaredConstructors();
 * 	��ù���Ȩ�޵Ĺ�������						 =clazz.getConstructors();
 * 								
 * ������û��'Declared'��ֻ�ܻ�÷ǹ������Ե�**��
 */
/**��ȡ����
 * 	������Լ���
 * 		clazz.getDeclaredFields()
 * 		clazz.getFields()
 *  �������--�����ֶ�����
 * 		clazz.getDeclaredField("size")
 * 		clazz.getField("size")
 * 	���÷�����������
 * 		GameOne c=clazz.newInstance();--c��GameOne���һ������
 * 		Field ff=c.getDeclaredField("size")--ff�Ǹ����һ������
 * 		ff.setInt(c,12);--���ܴ��ڸ���Ķ����������,��������ʱָ������
 */
/**����
 * ��ȡ����
 * 		clazz.getMethod("test");--û�в���ʱд'null'��д��
 * 		clazz.getDeclaredMethod("test");
 * 	���÷���
 * 		Method me=clazz.getDeclaredMethod("test");
 * 		me.invoke(c);--�õ��������������ֶ����ƣ�Ҫָ������
 * 	����˽�з�����
 * 		me.setAccessible(true);--˽�з������ܵ��ã���Ҫ���ã�
 */
/**ϰ��
 * 5���������࣬��д��������test������ִ��
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
//		����һ��
		Class in=Class.forName("com.aowin.RTTI.Outter$Inner");
		
//		ֱ�ӵ����ڲ���Ĺ�����
		Constructor cons[]=in.getDeclaredConstructors();
		for(Constructor con:cons) {
			System.out.println(con);
		}
//		�õ�������
//		private com.aowin.RTTI.Outter$Inner(com.aowin.RTTI.Outter)
//		com.aowin.RTTI.Outter$Inner(com.aowin.RTTI.Outter,com.aowin.RTTI.Outter$Inner)
//��һ��ģ������ⲿ��Ķ���
		Constructor con=in.getDeclaredConstructor(Outter.class);
		con.setAccessible(true);
//		�ڲ������Ĵ���--con.newInstance(�ⲿ��Ķ���);
//		�ⲿ�����Ĵ���--Outter.class.newInstance();
		Method me=in.getDeclaredMethod("test");
		me.setAccessible(true);
		me.invoke(con.newInstance(Outter.class.newInstance()));
		
//		��������
		//1-�ⲿ�����
		Class co = Outter.class;
		//2-������һ���ڲ������
		Field fIn = co.getDeclaredField("in");
		fIn.setAccessible(true); 
		Object obj = fIn.get(co.newInstance());
		
		//3
		Class ci = obj.getClass();//�õ��������������࣬�˴����ڲ��ࣻ
		//4
		Method mTest = ci.getDeclaredMethod("test");//�����ڲ���õ�������
		mTest.setAccessible(true); 
		mTest.invoke(obj);  //���÷���--ָ������
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