package com.aowin.Collectioning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * �Զ���HashSet��
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
		map.put(obj, PRESENT);//set�����ظ���������map_key�Ĳ����ظ��ԣ�
	}
	public static void main(String[]args){
		Set s=new HashSet();
		s.add("000");
//		s.add("000");
		s.add("111");
		s.add(new String("000"));//equals ���
		System.out.println(s.size());
	}
}
