package com.aowin.util;

import com.aowin.food.Food;

public class ShopUtil {
	public static void showList(Food []foods) {
		System.out.println("------------------------------------------------------------");
			System.out.println("0.�˳�");
		for(int i=0;i<foods.length ;i++) {
			if(foods[i]!=null&&foods[i].getName()!=null) {
				System.out.println((i+1)+"."+foods[i].getName()+":"+foods[i].getNumber());
			}
		}
		System.out.println("------------------------------------------------------------");
	}
	public static boolean CheckisFood(Food []foods,int num) {
		if(num>=foods.length) {
			System.out.println("û�и���Ʒ������������");
			return false;
		}
		return true;
	}
	public static boolean CheckEnough(Food foods,int num) {
		if(num>=foods.getNumber()) {
			System.out.println("��Ǹ�����������������ȷ�����������룡");
			return false;
		}
		return true;
	}
}
