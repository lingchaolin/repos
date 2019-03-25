package com.aowin.review;


public class Singleton {
	private static class SingleInner{
		private static Singleton instance=new Singleton();
	}
	private Singleton() {}
	private static synchronized Singleton getInstance() {
		return new SingleInner().instance;
	}
	public static void main(String[] args) {
		Singleton t1=Singleton.getInstance();
		System.out.println(t1);
		Singleton t2=Singleton.getInstance();
		System.out.println(t2);
	}
}
