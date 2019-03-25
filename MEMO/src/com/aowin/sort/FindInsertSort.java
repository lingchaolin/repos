package com.aowin.sort;

import java.util.Arrays;

public class FindInsertSort {

	public static void main(String[] args) {
		int[] arr = {144, 27, 5, 324, 54, 23, 12, 56, 463, 4};
		System.out.println(Arrays.toString(arr));
		InsertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void inserttest(int[]arr) {
		int out;
		int in;
		for(out =1;out<arr.length;out++) {
			int temp=arr[out];//从序号为1的到序号为9的依次进行操作
			in=out;
			/*将要进行排序的数a[out]放到temp中，从已经排好顺序的最右端开始，
			 * 依次与temp比较，若temp较小，则目标数在数组中右移一位，temp
			 * 继续与下一个数比较，知道temp较大或到达最左端为止。*/	
			while(in>0&&arr[in-1]>=temp) {
				arr[in]=arr[in-1];
				in=in-1;
			}
			System.out.println(Arrays.toString(arr));
			arr[in]=temp;
		}
	}
	public static void InsertSort(int[]arr) {
		int out;
		int in;
		for(out=1;out<arr.length;out++) {
			int temp=arr[out];
			in=out;
			while(in>0&&arr[in-1]>=temp) {
				//利用了短路功能；in=0时，跳过了arr[in-1]的步骤
				arr[in]=arr[in-1];
				in=in-1;
			}
			System.out.println(Arrays.toString(arr));
			arr[in]=temp;
		}
	}
}
