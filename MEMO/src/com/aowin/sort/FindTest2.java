package com.aowin.sort;

import java.util.Arrays;
import java.util.Random;

public class FindTest2 {

	public static void main(String[] args) {
		//��һ��101���ȵ����飬������1-100֮���������101λ��1-100֮��������
				//����㷨�ҵ�����ظ�����
		int[]arr=getArr();
		System.out.println("����Ϊ��"+Arrays.toString(arr));
//		print(arr);
		One(arr);
		
	}
	public static void One(int arr[]) {
		for(int i=0;i<100;i++) {
			for(int j=1;j<100;j++) {
				if(arr[i]==arr[j]) {
					System.out.println(arr[i]);
					return;
				}
			}
		}
		System.out.println("û�ҵ�"+arr[100]);
	}
	//��������ķ���
		public static int[] getArr() {
			int[] arr = new int[101];
			for(int i=0;i<100;i++) {
				arr[i] = i+1;
			}
			//�������һ�����ŵ�101λ
			Random r = new Random();
			arr[100] = r.nextInt(100)+1;
			
			//����˳��
			for(int i=0;i<1000;i++) {
				int index = r.nextInt(101);//�������0-100������
				//����arr[0]��arr[index]
				int tmp= arr[0];
				arr[0] = arr[index];
				arr[index] = tmp;
			}
			return arr;
		}
		public static void print(int[] arr) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+",\t");
				if(i%10==0&&i!=0) {
					System.out.println();
				}
			}
		}

}
