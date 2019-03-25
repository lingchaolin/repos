package com.aowin.sort;

public class InsertSort {
    public static void main(String[] args) {
        int arr[]={144,27,5,324,54,23,12,56,46653,4};
        System.out.println("本来的顺序");
        for(int temp:arr) {
            System.out.print(temp+"  ");
        }
        System.out.println();
        int in = 0;
//       从out开始，向左
        int out;
//        未排序的最左端--游标右侧第一个
        for (out = 1; out < 10; out++) {
            long temp=arr[out];
            while(in>0&&arr[in-1]>temp){
                arr[in]=arr[in-1];
                in--;
            }
        }
        System.out.println("本来的顺序");
        for(int temp:arr) {
            System.out.print(temp+"  ");
        }
    }
}
