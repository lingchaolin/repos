package com.aowin.Collectioning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * 	LinkedListTest
 * ����
 * �����ظ�
 * 
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		//���Ӷ���β�Ĳ���
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		Iterator it=list.iterator();//ע���������λ�ã�Iterator it֮��������ӣ�������ʱ������
		while(it.hasNext()) {//�ж��Ƿ�����һ��Ԫ��
			System.out.print(it.next()+"    ");//��������һ��Ԫ��
		}
	}

}
