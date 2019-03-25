package com.aowin.math;

public class MyLinkedList {
	private Node head;
	private int size;
	public MyLinkedList() {
		
	}
	public void add(Object data) {
		if(head==null) {
			head=new Node(data);
			size++;
		}else {
			Node node=new Node(data);
			Node tmp=head;
			while(tmp.next!=null) {
				tmp=tmp.next;
			}
			tmp.next=node;
			size++;
		}
	}
	public void add(int index,Object data) {
		if(index<0||index>size) {
			throw new IndexOutOfBoundsException();
		}else if( index==1){
			Node node=new Node(data);
			node.next=head;
			head=node;
			size++;
		}else {
			Node node=new Node(data);
			node.next=getNode(index);
			getNode(index-1).next=node;
			size++;
		}
	}
	public Node getNode(int index) {
		int i=0;
		Node tmp=head;
		while(i<index) {
			tmp=tmp.next;
			i++;
		}
		return tmp;
	}
	public int size() {
		return size;
	}
	public void remove(int index) {
		if(index<0||index>size) {
			throw new IndexOutOfBoundsException();
		}else {
			int i=0;
		}
	}
	public void remove(Object obj) {
		
	}
	public String toString() {
		String str="[";
		Node tmp=head;
		while(tmp!=null) {
			str+=tmp.data+",";
			tmp=tmp.next;
		}
		str=str.substring(0,str.length()-1);
		return str+="]";
	}
	public static void main(String[] args) {
		MyLinkedList m=new MyLinkedList();
		m.add(123);
		m.add("Sfsf");
		System.out.println(m);
	}

}
class Node{
	Object data;
	Node next;
	public Node(Object data) {
		super();
		this.data=data;
	}
}