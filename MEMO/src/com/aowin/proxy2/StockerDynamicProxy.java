package com.aowin.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StockerDynamicProxy {
	private static StdStocker instance;
	public StockerDynamicProxy(StdStocker stocker) {
		this.instance=stocker;
	}
	public StdStocker getProxyInstance() {
		return (StdStocker)Proxy.newProxyInstance(instance.getClass().getClassLoader(),
				instance.getClass().getInterfaces(),new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("开启代理");
					Object object=method.invoke(instance, args);
					System.out.println("关闭代理");
					return null;
				}
			});
	}
}
