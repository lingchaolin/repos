package com.aowin.review;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;


public class Student {
	private String name="123";
	public Student() {
		System.out.println("�޲ι�����");
	}
	public Student(int num,String str) {
		System.out.println("������ int:"+num+"str:"+str);
	}
	public void method(String str) {
		System.out.println("����method����");
	}
	public static void main(String[] args) {
		/*try {
			Class c=Class.forName("com.aowin.review.Student");
			Student stu=(Student) c.newInstance();
			Field field=c.getDeclaredField("name");
			field.setAccessible(true);
			field.set(stu, "ceshi");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		ConcurrentHashMap cm=new ConcurrentHashMap();
		cm.put("a", 11);
		cm.put("b", 12);
		cm.put("c", 13);
		cm.put("d", 14);
		Set<Map.Entry<String, Integer>> entries=cm.entrySet();
		Iterator iterator=entries.iterator();
		while(iterator.hasNext()) {
			Integer num = (Integer) iterator.next();
			System.out.println(num);
		}
		cm.get("a");
		cm.get("d");*/
//		Scanner scanner=new Scanner(System.in);
//		Long num=scanner.nextLong();
//		
//		System.out.println("��ӡ�����");
//		System.out.println(num.toBinaryString(num>>>16));
		
	}

}