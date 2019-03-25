package com.aowin.Collectioning;

import java.util.TreeMap;

/**
 *TreeMap
 *根据键的自然顺序排序；
 * @author Administrator
 *
 */
public class TreeSetTest {

	public static void main(String[] args) {
		TreeMap tm=new TreeMap();
//		tm.put(101, "aaa");
//		tm.put(103, "bbb");
//		tm.put(102, "ccc");
//		tm.put(101, 202);
		//自定义类对象作为键值；---null不能作为键，可以作为值
		tm.put(new Dog(1120,"naruto"), 202);
		tm.put(new Dog(1140,"lalala"), 206);
		tm.put(new Dog(1100,"zoro"), 205);
		System.out.println(tm);
		
	}
}
