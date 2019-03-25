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
			while(in>0&&arr[in-1]>=temp) {//�����˶�·���ܣ�in=0ʱ��������arr[in-1]�Ĳ���
				arr[in]=arr[in-1];
				in=in-1;
			}
			System.out.println(Arrays.toString(arr));
			arr[in]=temp;
		}
	}
}
