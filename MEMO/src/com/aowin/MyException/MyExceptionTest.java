package com.aowin.MyException;

public class MyExceptionTest {
	int money=100;
	public static void main(String[]args) {
//		System.out.w
		MyExceptionTest m=new MyExceptionTest();
		try {
			m.take(10);
			System.out.println("ȡǮ�ɹ�");
		} catch (MyException e) {
			System.out.println("ȡǮʧ��");
			e.printStackTrace();
		}
	}
	public void take(int money) throws MyException  {
		if(money>100) {
			throw new MyException("���ǣ�");
		}else {
//			System.out.println("ok");
		}
	}
}
