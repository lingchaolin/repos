package com.aowin.javabasic;

public class Reference {

	public Reference() {
		// TODO Auto-generated constructor stub
	}

	public static String reference() {
		final StringBuffer stringBuffer=new StringBuffer("123");
		stringBuffer.append("456");
		return String.valueOf(stringBuffer);
	}
	public static int staticVar=0;
	public  int instanceVar=0;
	public  void staticinstance() {
		staticVar++;
		instanceVar++;
		System.out.println("staticVar:"+staticVar+",instanceVar:"+instanceVar);
	}
	public void mathtest() {
		System.out.println("Math.round(2.6):		"+Math.round(2.6));
		System.out.println("Math.round(2.4):		"+Math.round(2.4));
		System.out.println();
		System.out.println("Math.ceil(2.6):			"+Math.ceil(2.6));
		System.out.println("Math.ceil(2.4):			"+Math.ceil(2.4));
		System.out.println();
		System.out.println("Math.floor(2.6):		"+Math.floor(2.6));
		System.out.println("Math.floor(2.4):		"+Math.floor(2.4));
	}
}
