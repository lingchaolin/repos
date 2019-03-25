package com.aowin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookHandler implements InvocationHandler {
	private Book people;
	public BookHandler(Book people) {
		this.people=people;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object=null;
		object=method.invoke(people, args);
		return object;
	}

}
