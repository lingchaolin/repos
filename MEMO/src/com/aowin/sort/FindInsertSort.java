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
			int temp=arr[out];//�����Ϊ1�ĵ����Ϊ9�����ν��в���
			in=out;
			/*��Ҫ�����������a[out]�ŵ�temp�У����Ѿ��ź�˳������Ҷ˿�ʼ��
			 * ������temp�Ƚϣ���temp��С����Ŀ����������������һλ��temp
			 * ��������һ�����Ƚϣ�֪��temp�ϴ�򵽴������Ϊֹ��*/	
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
				//�����˶�·���ܣ�in=0ʱ��������arr[in-1]�Ĳ���
				arr[in]=arr[in-1];
				in=in-1;
			}
			System.out.println(Arrays.toString(arr));
			arr[in]=temp;
		}
	}
}
