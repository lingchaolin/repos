package com.aowin.RTTI;
/**
 * ����ͨ�������ȡ����ķ�ʽ
 * @author Administrator
 *
 *1.��ͳrtti;
 *2.reflection����
 *���䣺����->��
 *������Ƶ�Դͷ��Class����
 *Class�����Ƕ�ĳ����ͨclass�������
 *Class����һ���࣬�������ṩ���췽�����ṩһЩ����
 *��һ����ͨ�������ͨ��֮�󣬸����Class����ʼ���������ɵ�ͬ���ġ�class�ļ���
 *--��һ��ʹ�ø���ʱ������Ƿ��Ѽ��ء�����->���ã�δ����->����
 *���ֻ�ȡClass����ķ�ʽ��--��ȡ�Ķ�����ͬһ��
 *
 *��������ã�1.���䴴������ ��2���������Ľṹ�����ԣ���������
 */
public class ClassOne {
	public static void main(String[]args) {
		
		try {
			/**
			 * Class--������Ķ���Class��һ��������������ָ��·������
			 */
			//1 forName();
			//��Ҫ���ڼ���������������Ҫ��ǰӵ�ж���
			Class c1=Class.forName("com.aowin.RTTI.ClassOne");
			System.out.println("c1:"+c1.getName());
			
			//2  ����.getClass
			//��Ҫ�������ͼ��,��Ҫ��ǰӵ�ж���
			Class c22=c1.getClass();//class���'Class'����
			System.out.println("c2:"+c22.getName());
			/**
			 * ��ת�Ͳ���
			 */
			GameOne g1=new GameOne();
			Class c2=g1.getClass();
			System.out.println("c2:"+c2.getName());
			
			//3  ����.class
			//��Ҫ���ڲ������ݣ�ע���������Ҳ����ʹ�ã�
			Class c3=GameOne.class;
			System.out.println("c3:"+c3.getName());
		
			System.out.println(c1==c2);
			System.out.println(c1==c3);
			System.out.println(c2==c22);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			/**
			 * ��ת�Ͳ���--�õ������������
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
		System.out.println("GameOne�ղι��췽��");
	}
	public GameOne(int size) {
		this.size=size;
		System.out.println("GameOne���췽��");
	}
	private GameOne(String str) {
		this.str=str;
		System.out.println("GameOne˽�еĹ��췽��");
	}
	GameOne(String str,int num) {
		this.str=str;
		System.out.println("GameOne˽�еĹ��췽��");
	}
	protected GameOne(int num,String str) {
		this.str=str;
		System.out.println("GameOne˽�еĹ��췽��");
	}
	public void test() {
		System.out.println(" public  test");
	}
	protected void test(int num) {
		System.out.println("protected  test");	
	}
	void test(String name) {
		System.out.println("Ĭ�� test");
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