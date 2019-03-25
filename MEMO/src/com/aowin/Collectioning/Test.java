package com.aowin.Collectioning;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String arr[]=new String[5];
		Object brr[]=new Object[5];
		arr[0]="123";
		arr[1]="123";
		arr[2]="123";
		arr[3]="123";
		arr[4]="123";
	
		brr=Arrays.copyOf(arr, 5, Object[].class);
		System.out.println("123");
	}

}
