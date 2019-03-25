package com.aowin.sort;

import java.util.Arrays;
import java.util.Random;

public class FindTest2 {

	public static void main(String[] args) {
		//有一个101长度的数组，里面有1-100之间的数，第101位放1-100之间的随机数
				//设计算法找到这个重复的数
		int[]arr=getArr();
		System.out.println("数组为："+Arrays.toString(arr));
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
		System.out.println("没找到"+arr[100]);
	}
	//生成数组的方法
		public static int[] getArr() {
			int[] arr = new int[101];
			for(int i=0;i<100;i++) {
				arr[i] = i+1;
			}
			//随机生成一个数放到101位
			Random r = new Random();
			arr[100] = r.nextInt(100)+1;
			
			//打乱顺序
			for(int i=0;i<1000;i++) {
				int index = r.nextInt(101);//随机生成0-100的索引
				//交换arr[0]和arr[index]
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
