package com.aowin.classLoadSort;

public class Test2 {

	public static void main(String[] args) {
		A(500);
	}
	public static void A(int num) {
			System.out.println(num);
		switch(num) {
		case 1:
			return;
		default:
			A(--num);
		}
	}
}

