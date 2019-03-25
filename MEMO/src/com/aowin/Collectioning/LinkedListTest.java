package com.aowin.Collectioning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * 	LinkedListTest
 * 有序
 * 可以重复
 * 
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		//增加对首尾的操作
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		Iterator it=list.iterator();//注意迭代器的位置，Iterator it之后若再添加，遍历的时候会出错
		while(it.hasNext()) {//判断是否有下一个元素
			System.out.print(it.next()+"    ");//迭代出下一个元素
		}
	}

}
