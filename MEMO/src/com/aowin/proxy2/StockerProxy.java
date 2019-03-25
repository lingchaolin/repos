package com.aowin.proxy2;

public class StockerProxy implements StdStocker{
	Stocker stocker;
	public StockerProxy(Stocker stocker) {
		this.stocker=stocker;
	}
	@Override
	public void methodOne() {
		System.out.println("������");
		stocker.methodOne();
		System.out.println("����ر�");
	}
	@Override
	public void methodTwo() {
		System.out.println("������");
		stocker.methodTwo();
		System.out.println("����ر�");
		
	}

}
