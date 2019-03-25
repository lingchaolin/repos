package com.aowin.Collectioning;

import java.util.Stack;
/**
 * pop()
 * push()
 * search()
 * peek()
 * @author Administrator
 *
 */
public class StackTest {

	public static void main(String[] args) {

		Stack<String> st=new Stack();
		st.push("123");
		st.push("efsefw");
		st.push("12422");
		st.push("afg");
		System.out.println(st);
		st.pop();
		System.out.println(st);
		
		//查看栈顶元素，但不出栈；
		System.out.println(st.peek());
		//查看指定元素search()--返回距离栈顶的位置；
		System.out.println(st.search("123"));
		System.out.println(st.search("efsefw"));
		System.out.println(st.search("12422"));
		System.out.println(st);
	}

}
