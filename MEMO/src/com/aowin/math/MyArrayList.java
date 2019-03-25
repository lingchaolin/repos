package com.aowin.math;

import java.util.ArrayList;

public class MyArrayList {
	private int size;
	Object[]obj= {};
	public void add(Object data) {
		if(size==0) {
			obj=new Object[1];
		}else {
			Object[] newObj=new Object[obj.length+1];
			System.arraycopy(obj, 0, newObj, 0, obj.length);
			newObj[obj.length]=data;
			size++;
			obj=newObj;//赋值给obj
		}
	}
	public String toString() {
		StringBuffer str1=new StringBuffer("[");
		for(Object t:obj) {
			str1.append(String.valueOf(t)+",");
		}
		String str=str1.substring(0,str1.length()-1);
		str=str+"]";
		return str;
		
	}
	public void add(int index,Object data) {
		if(index>obj.length||index<0) {
			throw new IndexOutOfBoundsException();
		}else {
			Object[] newObj=new Object[obj.length+1];
			System.arraycopy(obj, 0, newObj, 0, index);
			newObj[index]=data;
			System.arraycopy(obj, index, newObj, index+1,obj.length-index );
			size++;
			obj=newObj;//赋值给obj
		}
	}
	public void remove(int index) {
		if(index>obj.length||index<0) {
			throw new IndexOutOfBoundsException();
		}else {
			Object[] newObj=new Object[obj.length-1];
			System.arraycopy(obj, 0, newObj, 0, index);
			System.arraycopy(obj, index+1, newObj, index,obj.length-index-1 );
			size--;
			obj=newObj;//赋值给obj
		}
	}
	public static void main(String[] args) {
		ArrayList list;
		MyArrayList ml=new MyArrayList();
		ml.add(123);
		ml.add("wer");
	}
}
