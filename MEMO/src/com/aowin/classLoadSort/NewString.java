package com.aowin.classLoadSort;

public class NewString {

	public NewString() {
		
	}
	public static void main(String[] args) {
		String str1="abc";
		String str2="abc";
		System.out.println(str1==(str2));
		String str3="a"+"bc";
		String str4="bc";
		String str5="a"+str4;
		System.out.println(str1==(str3));
		System.out.println(str1==(str5));
		String str6=new String("abc");
		System.out.println(str1==(str6));
		System.out.println(str1==("a"+"bc"));
	}
}