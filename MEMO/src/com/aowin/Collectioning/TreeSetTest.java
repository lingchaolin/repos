package com.aowin.Collectioning;

import java.util.TreeMap;

/**
 *TreeMap
 *���ݼ�����Ȼ˳������
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
		//�Զ����������Ϊ��ֵ��---null������Ϊ����������Ϊֵ
		tm.put(new Dog(1120,"naruto"), 202);
		tm.put(new Dog(1140,"lalala"), 206);
		tm.put(new Dog(1100,"zoro"), 205);
		System.out.println(tm);
		
	}
}
