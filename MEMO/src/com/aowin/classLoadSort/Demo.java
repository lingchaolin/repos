package com.aowin.classLoadSort;

public class Demo {
	public static void main(String[] args) {
		LoadSon loadSon=new LoadSon();
	}
}
class LoadSort {
	static {
		System.out.println("这是父类静态代码块");
	}
	{
		System.out.println("这是父类普通代码块");
	}
	public LoadSort() {
		System.out.println("这是一个父类构造器！");
	}
}
class LoadSon extends LoadSort{
	static {
		System.out.println("这是子类静态代码块");
	}
	{
		System.out.println("这是子类普通代码块");
	}
	public LoadSon() {
		System.out.println("这是一个子类构造器！");
	}
}