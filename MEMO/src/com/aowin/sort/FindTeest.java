package com.aowin.sort;

import java.util.Arrays;
import java.util.Random;

public class FindTeest {

	public static void main(String[] args) {
//		Scanner scan=new Scaner
		int x=98;
		int arr[]=new int[100];
		Random r=new Random();
		for(int i=0;i<100;i++) {
			arr[i]=r.nextInt(100)+1;
		}
		Arrays.sort(arr);
		System.out.println("数组为："+Arrays.toString(arr));
		findOne(arr, x);
		findTwo(arr,x);
	}
	public static void findOne(int arr[],int x) {
		int count=0;
		for(int a:arr) {
			count++;
			if(a==x) {
				System.out.println("找到了，找了"+count+"次");
				return;
			}
		}
		System.out.println("没找到");
		return;
	}
	public static void findTwo(int arr[],int x) {
		int count=0;
		int start = 0;
		int end=arr.length-1;
		while(start<end-1) {
			count++;
			int mid=(start+end)/2;
			if(x>arr[mid] ){
				start=mid;
			}else if(x<arr[mid]) {
				end=mid;
			}else {
				System.out.println("找到了，找了"+count+"次");
				return;
			}
		}
		System.out.println("没找到");
		return;
	}

}
