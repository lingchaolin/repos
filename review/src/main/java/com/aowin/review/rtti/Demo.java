package com.aowin.review.rtti;

import java.util.Scanner;

public class Demo {
	static String a1=null;
	static String a2="";
	static String a3;
	static 
	String b1=null;
	String b2="";
	String b3;
	public void method() {
		String c1=null;
		String c2="";
		String c3;
		System.out.println("a1=null:"+a1);
		System.out.println("a2=\"\":"+a2);
		System.out.println("a3=Î´¸³Öµ:"+a3);
		System.out.println("b1=null:"+b1);
		System.out.println("b2=\"\":"+b2);
		System.out.println("b3=Î´¸³Öµ:"+b3);
		System.out.println("c1=null:"+c1);
		System.out.println("c2=\"\":"+c2);
//		System.out.println("c3=Î´¸³Öµ:"+c3);
		System.out.println(a1==a3);
		System.out.println(a1==b1);
		System.out.println(a3==b3);
		System.out.println(b1==b3);
		System.out.println("**********run finish***********");
	}
	public void method2() {
		String str1="abcdefg";
		String str2="abcdefg";
		String str3=new String("abcdefg");
		String str4=new String("abcdefg");
		String str5="abc"+"defg";
		
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str2==str4);
		System.out.println(str1==str5);
	}
	public void method3() {
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(Double.NEGATIVE_INFINITY);
		System.out.println(Double.NaN!=Double.NaN);
		Scanner scanner=new Scanner(System.in);
		String string=scanner.next();
		System.out.println(string);
		StringBuffer stringBuffer;
		StringBuilder stringBuilder;
	}
	public static void main(String[] args) {
		Demo demo=new Demo();
		demo.method3();
	}
}
class NewString{
//	private final char value[];
/*	public NewString() {
		
	}*/
}