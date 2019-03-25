package com.aowin.proxy2;

public class StockerProxy implements StdStocker{
	Stocker stocker;
	public StockerProxy(Stocker stocker) {
		this.stocker=stocker;
	}
	@Override
	public void methodOne() {
		System.out.println("代理开启");
		stocker.methodOne();
		System.out.println("代理关闭");
	}
	@Override
	public void methodTwo() {
		System.out.println("代理开启");
		stocker.methodTwo();
		System.out.println("代理关闭");
		
	}

}
