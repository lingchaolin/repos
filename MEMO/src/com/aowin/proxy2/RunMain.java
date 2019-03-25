package com.aowin.proxy2;

public class RunMain {
	public static void main(String[] args) {
		Stocker stocker=new Stocker();
//		StockerProxy stockerProxy=new StockerProxy(stocker);
		StdStocker stockerProxy= new StockerDynamicProxy(stocker).getProxyInstance();
		stockerProxy.methodOne();
		stockerProxy.methodTwo();
	}
}
