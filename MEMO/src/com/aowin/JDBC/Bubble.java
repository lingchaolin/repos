package com.aowin.JDBC;

public class Bubble {
	// �鲢����--�ݹ�ʵ�ֹ鲢����--�������ݶ�����list1�У�
	public static void main(String[] args) {
		int arr[] = { 144, 27, 5, 324, 54, 23, 12, 56, 46653, 4 };
		sort(arr, 0, 9);
	}

	private static int[] sort(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(a, low, mid);
			sort(a, mid + 1, high);
			System.out.println(a);
			merge(a, low, mid, high);
		}
		return a;
	}

	public static void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		// �ѽ�С�������Ƶ���������
		while (i <= mid && j < high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];

			} else {
				temp[k++] = a[j++];
			}
		}
		// �����ʣ������Ƶ�����
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= high) {
			temp[k++] = a[j++];
		}
		// ���������е�������nums����
		for (int x = 0; x < temp.length; x++) {
			a[x + low] = temp[x];
		}
	}
}