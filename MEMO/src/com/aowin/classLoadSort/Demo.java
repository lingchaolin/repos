package com.aowin.classLoadSort;

public class Demo {
	public static void main(String[] args) {
		LoadSon loadSon=new LoadSon();
	}
}
class LoadSort {
	static {
		System.out.println("���Ǹ��ྲ̬�����");
	}
	{
		System.out.println("���Ǹ�����ͨ�����");
	}
	public LoadSort() {
		System.out.println("����һ�����๹������");
	}
}
class LoadSon extends LoadSort{
	static {
		System.out.println("�������ྲ̬�����");
	}
	{
		System.out.println("����������ͨ�����");
	}
	public LoadSon() {
		System.out.println("����һ�����๹������");
	}
}