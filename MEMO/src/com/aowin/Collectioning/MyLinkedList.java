package com.aowin.Collectioning;


import java.util.LinkedList;
//import java.util.LinkedList.Node;

public class MyLinkedList {
	private static int size;
	Node first;
	Node last;
	
	public int size(){
		return size;
	}
	public void add(Object o){
		Node n=new Node();
		if(first==null){
			n.previous=null;
			n.obj=o;
			n.next=null;
			
			first=n;
			last=n;
		}else{
			n.previous=last;
			n.obj=o;
			n.next=null;
			
			last.next=n;
			last=n;
			
		}
		size++;
	}
	
	public void rangeCheck(int index){
		if(index<0||index>=size){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public Node node(int index){
		Node temp=null;
/**
		if(first!=null){
			if(index<(size>>1)){
				temp=first;
				for(int i=0;i<index;i++){
					temp=temp.next;
				}
			}
			else{
				temp=last;
				for(int i=size-1;i>index-1;i--){
					temp=temp.next;
				}
				
			}
		}
*/
		if(first!=null){
			temp=first;
			for(int i=0;i<index;i++){
				temp=temp.next;
			}
		}
		return temp;
	}
	public Object get(int index){
		rangeCheck(index);
		Node temp=node(index);
		if(temp!=null){
			return temp.obj;
		}
		return null;
		
	}
	public void remove(int index){
		rangeCheck(index);
		Node temp=node(index);
		
		Node up=new Node();
		Node down=new Node();
		up=temp.previous;
		down=temp.next;
		up.next=down;
		down.previous=up;
	}
	
	public void add(int index,Object o){
		rangeCheck(index);
		Node temp=node(index);
		Node up=temp.previous;
		Node newnode=new Node();
		newnode.obj=o;
		newnode.previous=up;
		newnode.next=temp;
		up.next=newnode;
		temp.previous=newnode;
	}
	public static void main(String[]args){
		MyLinkedList list=new MyLinkedList();
		list.add("000");
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		list.add(2, "hhh");
//		list.remove(1);
		System.out.println(list.size);
		for(int i=0;i<size;i++){
		System.out.println(list.get(i));
		}
	}
}


class Node{
	Node previous;
	Object obj;
	Node next;
	public Node(){
		
	}
	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}
	
	
}

