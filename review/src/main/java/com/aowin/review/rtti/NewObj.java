package com.aowin.review.rtti;

public class NewObj {
	public  static void write() {
		System.out.println("类的静态方法");
	}
	public NewObj() {
		System.out.println("类构造器");
	}
	public static void main(String[] args) {
		System.out.println("main方法");
	}
}
