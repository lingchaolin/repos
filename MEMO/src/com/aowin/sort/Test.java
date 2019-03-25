package com.aowin.sort;

public class Test {
    public static void main(String[] args) {
        int arr[]=new int[1000];
        for (int i = 0; i <10000; i++) {
            arr[i] = (int) (1 + 1000 * Math.random());
        }
    }
    public void Bubble(int[]arr){
        for(int i=arr.length-1;i>0;i--) {
            for(int j=0;j<i;j++) {
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}

//测试类--反射和外包的类
class forRTTI{
	
}
