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
		int i = low;// 最小的索引
		int j = high;// 最大的索引
		int mid;// 保存临界值
		if (low < high) {
			mid = arr[low];
			while (i < j) {
				while (i < high && arr[++i] <= mid)
					;// 从左边开始查找，找到大于临界值的索引
				while (j > low && arr[j] >= mid)
					j--;// 从右边开始查找，找到小于临界值的索引
				if (i < j)// 如果满足条件，交换i和j位置上的值----左边的反而大，右边的反而小，不符合要求；
				{
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}//交换完成后，当两边的索引没有达到中间值时，应该继续调整；
			}
			arr[low] = arr[j];//枢轴放到arr[low];（某种意义上的中间值）
			arr[j] = mid;//临界值放到中间
			quickSort(arr, low, j - 1);// 对临界值前面的数进行排序
			quickSort(arr, j + 1, high);// 对临界值后面的数进行排序
		}
	}

}
