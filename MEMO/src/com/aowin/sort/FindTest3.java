package com.aowin.sort;

import java.util.Arrays;

public class FindTest3 {

	public static void main(String[] args) {
//		int no=plus(100);
//		System.out.println(no);
//		for(int i=1;i<11;i++) {
//			System.out.println("ì³²¨ÄÇ-"+i+"-"+fibo(i));
//		}
		 int[] arr = {144, 27, 5, 324, 54, 23, 12, 56, 463, 4};
		 System.out.println(Arrays.toString(arr));
		Bubble(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static int plus(int num) {
		if(num==1) {
			return 1;
		}else {
			return num+plus(num-1);
		}
	}
	public static int fibo(int num) {
		if(num==1||num==2) {
			return 1;
		}else {
			return fibo(num-1)+fibo(num-2);
		}
	}
	public static void Bubble(int[]arr) {
		for(int i=arr.length;i>=0;i--) {
			for(int j=0;j<i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}
