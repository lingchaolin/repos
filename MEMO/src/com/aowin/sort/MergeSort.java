package com.aowin.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {144, 27, 5, 324, 54, 23, 12, 56, 463, 4};
    	int[] arr = {1,2,3,4};
        MergeSort m=new MergeSort();
        System.out.println("ԭʼ˳��"+Arrays.toString(arr));
        m.remerge(arr,0,3);
        System.out.println("�鲢����"+Arrays.toString(arr));
    }
//    lowerBound ,upperBoundֻ�Ǵ���������±귶Χ��ͬ�����ݽ��в���
    public void remerge(int[]arr,int lowerBound,int upperBound){
        if(lowerBound==upperBound){
         return;
        }else {
            int mid = (upperBound+lowerBound) / 2;
            remerge(arr,lowerBound,mid);
            System.out.println("ǰһ�룺"+Arrays.toString(arr));
            remerge(arr,mid+1  ,upperBound);
            System.out.println("��һ�룺"+Arrays.toString(arr));
            merge(arr,lowerBound,mid+1,upperBound);
        }
    }
    public void merge(int[]arr,int lowPtr,int highPtr,int upperBound) {
    	int[]temp=new int[upperBound+1-lowPtr];
    	int count=0;
    	int an=lowPtr;
    	int bn=highPtr;
    	while(an<highPtr&&bn<upperBound) {
    		if(arr[an]<arr[bn]) {
    			temp[count++]=arr[an++];
    		}else {
    			temp[count++]=arr[bn++];
    		}
    	}
       	while(an<highPtr) {
    			temp[count++]=arr[an++];
    	}
       	while(bn<upperBound) {
    			temp[count++]=arr[bn++];
    	}
    System.arraycopy(temp, 0, arr, lowPtr, highPtr+1-lowPtr);
    }
    
}

