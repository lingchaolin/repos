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
		
		//�鿴ջ��Ԫ�أ�������ջ��
		System.out.println(st.peek());
		//�鿴ָ��Ԫ��search()--���ؾ���ջ����λ�ã�
		System.out.println(st.search("123"));
		System.out.println(st.search("efsefw"));
		System.out.println(st.search("12422"));
		System.out.println(st);
	}

}
