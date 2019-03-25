package com.aowin.util;

import com.aowin.food.Food;

public class ShopUtil {
	public static void showList(Food []foods) {
		System.out.println("------------------------------------------------------------");
			System.out.println("0.退出");
		for(int i=0;i<foods.length ;i++) {
			if(foods[i]!=null&&foods[i].getName()!=null) {
				System.out.println((i+1)+"."+foods[i].getName()+":"+foods[i].getNumber());
			}
		}
		System.out.println("------------------------------------------------------------");
	}
	public static boolean CheckisFood(Food []foods,int num) {
		if(num>=foods.length) {
			System.out.println("没有该商品，请重新输入");
			return false;
		}
		return true;
	}
	public static boolean CheckEnough(Food foods,int num) {
		if(num>=foods.getNumber()) {
			System.out.println("抱歉！您输入的数量不正确，请重新输入！");
			return false;
		}
		return true;
	}
}
