package com.aowin.math;

import java.util.EmptyStackException;

public class MyStack {
	private Object[]obj;
	private int size;
	private Object top;
	public MyStack() {
		obj=new Object[] {};
		size=0;
		top=null;
	}
	public void push(Object data) {
		if(size==0) {
			obj=new Object[1];
			obj[0]=data;
			size++;
			top=obj[0];
		}else {
			Object[] newObj=new Object[obj.length+1];
			System.arraycopy(obj, 0, newObj, 0, obj.length);
			newObj[obj.length]=data;
			obj=newObj;
		}
	}
	public void pop() {
		if(size==0) {
			throw new EmptyStackException();
			
		}else if(size==1){
			
		}else {
			
		}
	}
	public String toString() {
		StringBuffer sb=new StringBuffer("[");
		for(Object tt:obj) {
			sb.append(tt+",");
		}
		String str=(String)sb.substring(0, sb.length()-1);
		return str+"]";
	}
	public static void main(String[] args) {
		MyStack m=new MyStack();
		m.push(123);
		m.push("sda");
		m.push(35);
		System.out.println(m);
	}

}
