package com.aowin.Collectioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 	ArrayList
 * 有序
 * 可以重复
 * 
 * @author Administrator
 *数组和集合的区别
 *数组可以存放基本数据类型也可以存放对象，--集合专门也能够与存放对象
 *数组要定义数据类型，集合可以存放任意对象
 *数组长度固定，一旦确定不能修改，集合长度可以自动改变
 *
 *集合的类型：List,Set,Map
 *Colection接口是集合库最上层的一个接口，定义了一些基本操作；有两个子接口
 *List:有序-可重复
 *	ArrayList:-可变数组--实现List接口的类，底层实现的是动态数组；
 *	LinkedList:-链表--
 *	Vector:
 *Set
 */
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		System.out.println(list.isEmpty());
		//添加
		list.add("asd");
		list.add(0, null);
		list.add(2,123);//123为int型，自动装箱为Integer类--对象类
		list.add("sfsef");
		list.add("234");
		list.add(2);
		list.add(12345.98);
		
		//输出集合：
		System.out.println("list="+list);
		//删除
		list.remove(2);//remove(Object obj)--删除首个符合的元素
		list.remove((Integer)2);//自己加包或者转型
//		list.remove(new Integer(2));
		System.out.println("list="+list);
		
		
		//修改
		list.set(2, "hahaha");
		System.out.println("list="+list);
		//查询
		System.out.println(list.get(2));
		
		//遍历方式
		System.out.println("foreach");
		for(Object obj:list) {
			System.out.print(obj+"    ");
		}
		System.out.println("for循环");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"    ");
		}
		//迭代
		System.out.println("迭代器表示");
		Iterator it=list.iterator();//注意迭代器的位置，Iterator it之后若再添加，遍历的时候会出错
		while(it.hasNext()) {//判断是否有下一个元素
			System.out.print(it.next()+"    ");//迭代出下一个元素
		}
	}

}
