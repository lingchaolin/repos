package com.aowin.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {144, 27, 5, 324, 54, 23, 12, 56, 46653, 4};
        System.out.println("本来的顺序");
        for(int temp:arr) {
            System.out.print(temp+"  ");
        }
        for (int i = 0; i <10; i++) {
            int idx=i;
            for (int j = i; j <9; j++) {
                if(arr[idx]<arr[j+1]){
                    idx=j+1;
                }
            }
            int temp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=temp;
        }
        System.out.println("排序后的顺序");
        for(int temp:arr) {
            System.out.print(temp+"  ");
        }
    }
}
