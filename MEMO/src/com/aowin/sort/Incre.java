package com.aowin.sort;

public class Incre {

	//ð������
	public static void main(String[]args){
		//A(1);
		print(1000);
	}
	public static void A(int num) {
		switch(num) {
		case 1001:
			return;
		default:
			System.out.println(num);
			A(num+1);
		}
	}
	public static int print(int num) {
		int x=num==1?1:print(--num);
		System.out.println(num);
		return x;
	}
}