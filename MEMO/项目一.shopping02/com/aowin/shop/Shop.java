package com.aowin.shop;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.aowin.excep.Insufficient;
import com.aowin.excep.NoCommodity;
import com.aowin.excep.ircorrect;
import com.aowin.food.Apple;
import com.aowin.food.Food;
import com.aowin.food.Pear;
import com.aowin.person.Father;
import com.aowin.person.Son;
import com.aowin.util.ShopUtil;
import com.aowin.util.getInput;
/**
 * 
 */
public class Shop {
	Food foods[];//�����ֿ�
	Father fa;
	Son son;
	
	public Food[] getFoods() {
		return foods;
	}
	public void setFoods(Food[] foods) {
		this.foods = foods;
	}
	public Shop() {
		foods=new Food[2];
		foods[0]=new Apple("apple",999);
		foods[1]=new Pear("pear",999);
		fa=new Father();
		son=new Son();
	}
	public static void main(String[]args) {
		Shop shop=new Shop();
		
		Scanner scanner=new Scanner(System.in);
		boolean bool=false;
		while(!bool) {
			System.out.println("��ӭ���٣�����Ҫ����ʲô����! 1.���� 2.�ۻ� 3.���׳Զ��� 4.���ӳԶ��� exit:�˳�");
			String str=scanner.nextLine();
			switch(str) {
			case "1":
				shop.Stock(shop);
				break;
			case "2":
				shop.Saler(shop);	
				break;
			case "3":
				shop.fa.eat(shop,shop.fa);
				break;
			case "4":
				shop.son.eat(shop, shop.fa);
				break;
			case "exit":
				bool=true;
				break;	
			default:
				
				break;
			}
		}
		
		
	}
	public void Stock(Shop shop) {
		boolean bool=false;
		Food temps[]=new Food[2];
		temps[0]=new Food();
		temps[1]=new Food();
		
		int num=0;
		int num2=0;
		while(!bool) {
			ShopUtil.showList(shop.foods);
			num=shop.giveName("����");
			if(num==-1) {
				break;
			}
			num2=shop.giveNumber(num, "����");
			foods[num].setNumber(foods[num].getNumber()-num2);
			temps[num].setName(foods[num].getName());
			temps[num].setNumber(temps[num].getNumber()+num2);
		}
		System.out.println("��������:");
		ShopUtil.showList(temps);
		System.arraycopy(temps, 0, foods, 0, temps.length);
		temps=null;
	}
	public void Saler(Shop shop) {
		boolean bool=false;
		Food temps[]=new Food[2];
		temps[0]=new Food();
		temps[1]=new Food();
		
		int num=0;
		int num2=0;
		while(!bool) {
			ShopUtil.showList(shop.foods);
			num=shop.giveName("�ۻ�");
			if(num==-1) {
				break;
			}
			num2=shop.giveNumber(num, "�ۻ�");
			foods[num].setNumber(foods[num].getNumber()-num2);
			temps[num].setName(foods[num].getName());
			temps[num].setNumber(temps[num].getNumber()+num2);
		}
		System.out.println("�ۻ�����:");
		ShopUtil.showList(temps);
		System.arraycopy(temps, 0, fa.foods, 0, temps.length);
		temps=null;
	}
	public int giveName(String str) {
		int num=0;
		while(true) {
			System.out.println("������Ҫ"+str+"����Ʒ");
			num=getInput.getNum();
				if(num==0) {
					return -1;
				}
			if(ShopUtil.CheckisFood(foods,num-1)) {
				break;
			}
		}
		return num-1;
	}
	public int giveNumber(int idx,String str) {
		int num2=0;
		while(true) {
			System.out.println("������Ҫ"+str+"������");
			num2=getInput.getNum();
			if(ShopUtil.CheckEnough(foods[idx],num2)) {
				break;
			}
		}
		return num2;
	}
}
