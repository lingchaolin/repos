package com.aowin.Collectioning;

import java.util.TreeSet;

//对具有自然顺序的元素排序--二叉树支持的
public class TreesSetTest {
	@SuppressWarnings("all")
	public static  void main(String[] args) {
		//创建一个空的TreeSet
		
		TreeSet ts=new TreeSet();
//		ts.add( "hello");
//		ts.add("test");
//		ts.add("asd");
//		System.out.println(ts);
		
//		Cat c1=new Cat(1001,"aaa");
//		Cat c2=new Cat(1203,"bbb");
//		Cat c3=new Cat(1014,"ccc");
//		Cat c4=new Cat(1099,"ddd");
//		Cat c5=new Cat(1026,"eee");
//		Cat c6=new Cat(1101,"hhh");
//		ts.add(c1);
//		ts.add(c2);
//		ts.add(c3);
//		ts.add(c4);
//		ts.add(c5);
//		ts.add(c6);
//		ts.add(new Dog(1000,"saber"));
		System.out.println(ts);
		TreeSet ts2=new TreeSet();
		ts2.add(new Dog(1000,"saber"));
		ts2.add(new Dog(1090,"archr"));
		ts2.add(new Dog(1044,"Room"));
		ts2.add(new Dog(1067,"Ace"));
		ts2.add(new Dog(1022,"zoro"));
		ts2.add(new Dog(1100,"ichigo"));
		System.out.println(ts2);
	}

}
//负整数、零或正整数，根据此对象是小于、等于还是大于指定对象。 
class Cat implements Comparable{
	int no;
	String name;
	public Cat(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	@Override
	public int compareTo(Object o) {
		Cat c=(Cat) o;
		
		return this.no -c.no;
	}
	@Override
	public String toString() {
		return "Cat [no=" + no + ", name=" + name + "]\r\n";
	}
}
class Dog implements Comparable{
	int num;
	String name;
	public Dog(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [num=" + num + ", name=" + name + "]\r\n";
	}
	@Override
	public int compareTo(Object o) {
		Dog d=(Dog) o;
		int len1=name.length();
		int len2=d.name.length();
		int lim=Math.min(len1,len2);
		char ch1[]=name.toCharArray();
		
		char ch2[]=d.name.toCharArray();
		
		for(int i=0;i<lim;i++) {
			char c1=ch1[i];
			char c2=ch2[i];
			if(c1!=c2) {
				return c1-c2;
			}
		}
		return len1-len2;
		
//		return num-d.num;
	}
	
}