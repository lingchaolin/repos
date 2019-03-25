package com.aowin.review;

import java.lang.reflect.Constructor;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MyOuter{
	public static void main(String[] args) {
		B b=new B() {
			@Override
			public int getNum() {
				return 1;
			}
		};
//		Class class1=forRTTI.class;
		MyOuter myOuter=new MyOuter();
		Class m=myOuter.getClass();
	}
}
class A {
	
		
}
interface 	B{
	public int getNum();
}