package com.aowin.sort;

import java.util.Arrays;

public class FindFastSort {

	public static void main(String[] args) {
		int[] arr = { 144, 27, 5, 324, 54, 23, 12, 56, 463, 4 };
		System.out.println(Arrays.toString(arr));
		fastSort(arr,0,9);
		System.out.println(Arrays.toString(arr));
	}
	public static void fastSort(int[]arr,int low, int high) {
		int i=low;
		int j=high;
		int mid;
		if(low<high-1) {
			mid=arr[low];
			while(low<high) {
				while(low<high&&mid<=arr[high--]) {
				}
				if(low<high) {
					arr[low]=arr[high];
				}
				while(low<high&&arr[low++]<=mid) {
				}
				if(low<high) {
					arr[high]=arr[low];
				}
			}
			arr[low]=mid;
			fastSort(arr,i,low-1);
			fastSort(arr,low+1,j);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void quickSort(int[] arr, int low, int high) {
		int i = low;// ��С������
		int j = high;// ��������
		int mid;// �����ٽ�ֵ
		if (low < high) {
			mid = arr[low];
			while (i < j) {
				while (i < high && arr[++i] <= mid)
					;// ����߿�ʼ���ң��ҵ������ٽ�ֵ������
				while (j > low && arr[j] >= mid)
					j--;// ���ұ߿�ʼ���ң��ҵ�С���ٽ�ֵ������
				if (i < j)// �����������������i��jλ���ϵ�ֵ----��ߵķ������ұߵķ���С��������Ҫ��
				{
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}//������ɺ󣬵����ߵ�����û�дﵽ�м�ֵʱ��Ӧ�ü���������
			}
			arr[low] = arr[j];//����ŵ�arr[low];��ĳ�������ϵ��м�ֵ��
			arr[j] = mid;//�ٽ�ֵ�ŵ��м�
			quickSort(arr, low, j - 1);// ���ٽ�ֵǰ�������������
			quickSort(arr, j + 1, high);// ���ٽ�ֵ���������������
		}
	}

}
