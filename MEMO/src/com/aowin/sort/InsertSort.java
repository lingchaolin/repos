package com.aowin.sort;

public class InsertSort {
    public static void main(String[] args) {
        int arr[]={144,27,5,324,54,23,12,56,46653,4};
        System.out.println("������˳��");
        for(int temp:arr) {
            System.out.print(temp+"  ");
        }
        System.out.println();
        int in = 0;
//       ��out��ʼ������
        int out;
//        δ����������--�α��Ҳ��һ��
        for (out = 1; out < 10; out++) {
            long temp=arr[out];
            while(in>0&&arr[in-1]>temp){
                arr[in]=arr[in-1];
                in--;
            }
        }
        System.out.println("������˳��");
        for(int temp:arr) {
            System.out.print(temp+"  ");
        }
    }
}
