package com.aowin.MyException;

public class MyExceptionTest {
	int money=100;
	public static void main(String[]args) {
//		System.out.w
		MyExceptionTest m=new MyExceptionTest();
		try {
			m.take(10);
			System.out.println("取钱成功");
		} catch (MyException e) {
			System.out.println("取钱失败");
			e.printStackTrace();
		}
	}
	public void take(int money) throws MyException  {
		if(money>100) {
			throw new MyException("惨那！");
		}else {
//			System.out.println("ok");
		}
	}
}
