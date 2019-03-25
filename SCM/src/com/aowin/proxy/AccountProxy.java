package com.aowin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import com.aowin.util.Dbutil;

public class AccountProxy {
	private DaoInterface target;
	public AccountProxy(DaoInterface target) {
		this.target=target;
	}
	public DaoInterface getInstance() {
		return (DaoInterface)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Connection conn=Dbutil.getConn();
				Object r=method.invoke(target, args);
				return r;
			}
		});
	}
}
