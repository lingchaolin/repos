package httpServer.test;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	public static void main(String[] args) {
		int[]arr=Sort.ranArr();
		System.out.println(Arrays.toString(arr));
		Sort.numSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static int[] ranArr() {
		Random random=new Random();
		int[]arr=new int[10];
		for(int i=0;i<=9;i++) {
			arr[i]=(int)(random.nextDouble()*100);
		}
		return arr;
	}
	public static void numSort(int[]arr) {
		int temp=0;
		for(int i=1;i<arr.length;i++) {
			int idx=i;
			temp=arr[idx];
			while(idx>0&&arr[idx-1]>temp) {
				arr[idx]=arr[idx-1];
				idx-=1;
			}
			arr[idx]=temp;
		}
	}
}
