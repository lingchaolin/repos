package com.aowin.cla;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String[] args) {
		String str1="abc";
		String str2=new String("abc");
		String str3=new String("abc");
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str2==str3);
		System.out.println(str1=="abc");
		System.out.println(str2=="abc");
		String str4="a";
		String str5="a"+"bc";
		System.out.println(str5=="abc");
		str5=str4+"bc";
		System.out.println(str5=="abc");
		Map map=new ConcurrentHashMap<>();
	}
	public Test() {
	}

}
