package com.aowin.Collectioning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * 自定义HashSet；
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class MyHashSet {
	HashMap map;
	private static final Object PRESENT=new Object();
	public MyHashSet(){
		map=new HashMap();
	}
	public void add(Object obj){
		map.put(obj, PRESENT);//set不可重复，利用了map_key的不可重复性；
	}
	public static void main(String[]args){
		Set s=new HashSet();
		s.add("000");
//		s.add("000");
		s.add("111");
		s.add(new String("000"));//equals 相等
		System.out.println(s.size());
	}
}
