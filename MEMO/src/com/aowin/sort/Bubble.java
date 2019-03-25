package com.aowin.sort;

public class Bubble {
	//冒泡排序
	public static void main(String[]args){
		int arr[]={144,27,5,324,54,23,12,56,46653,4};
		System.out.println("本来的顺序");
		for(int temp:arr) {
			System.out.print(temp+"  ");
		}
		System.out.println();
		for(int i=9;i>0;i--) {
//			i=0时，将最大的数字放到a[9]
//			i=1时，将第二大的数字放到a[8];……
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("排序后的顺序");
		for(int temp:arr) {
			System.out.print(temp+"  ");
		}
	}
}
