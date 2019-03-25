package com.aowin.sort;

import java.util.Arrays;

public class FindShellSort {

	public static void main(String[] args) {
		int[] arr = {144, 27, 5, 324, 54, 23, 12, 56, 463, 4};
		System.out.println(Arrays.toString(arr));
		ShellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void ShellSort(int[]arr) {
		int out;
		int in;
		int h=1;
		while(h<arr.length/3) {
			h=h*3+1;
		}
		for(out=1;out<arr.length;out++) {
			int temp=arr[out];
			in=out;
			while(in>0&&arr[in-1]>=temp) {//利用了短路功能；in=0时，跳过了arr[in-1]的步骤
				arr[in]=arr[in-1];
				in=in-1;
			}
			System.out.println(Arrays.toString(arr));
			arr[in]=temp;
		}
	}
}
