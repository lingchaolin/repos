package com.aowin.person;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.aowin.excep.Insufficient;
import com.aowin.excep.NoCommodity;
import com.aowin.food.Food;
import com.aowin.shop.Shop;
import com.aowin.util.ShopUtil;

public class Father {
	public static Food foods[];
	public Father() {
		foods = new Food[2];
		for (int i = 0; i < 2; i++) {
			foods[i] = new Food();
		}
	}
	public void eat(Shop shop,Father fa) {
		boolean bool=false;
		Food temps[]=new Food[2];
		temps[0]=new Food();
		temps[1]=new Food();
		
		int num=0;
		int num2=0;
		while(!bool) {
			ShopUtil.showList(fa.foods);
			num=shop.giveName("吃");
			if(num==-1) {
				break;
			}
			num2=shop.giveNumber(num, "吃");
			fa.foods[num].setNumber(fa.foods[num].getNumber()-num2);
			temps[num].setName(fa.foods[num].getName());
			temps[num].setNumber(temps[num].getNumber()+num2);
		}
		System.out.println("吃的东西如下:");
		ShopUtil.showList(temps);
	}

}
