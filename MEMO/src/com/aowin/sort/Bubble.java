package com.aowin.sort;

public class Bubble {
	//ð������
	public static void main(String[]args){
		int arr[]={144,27,5,324,54,23,12,56,46653,4};
		System.out.println("������˳��");
		for(int temp:arr) {
			System.out.print(temp+"  ");
		}
		System.out.println();
		for(int i=9;i>0;i--) {
//			i=0ʱ�����������ַŵ�a[9]
//			i=1ʱ�����ڶ�������ַŵ�a[8];����
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("������˳��");
		for(int temp:arr) {
			System.out.print(temp+"  ");
		}
	}
}
