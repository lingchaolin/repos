package com.aowin.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.aowin.excep.IrMinus;
import com.aowin.excep.NoCommodity;
import com.aowin.food.Food;

public class getInput {
	public static String getString() {
		String str = null;
		return str;
	}
	public static int getNum() {
		int num=0;
		while(true) {
			try {
				Scanner scan=new Scanner(System.in);
				String str=scan.nextLine();
				num=Integer.parseInt(str);
				if(num<0) {
					throw new IrMinus();
				}
				return num;
			} catch (IrMinus e) {
				System.out.println("请输入正整数！");
			}catch(NumberFormatException e) {
				System.out.println("请输入正整数！");
			}
		}
	}
	public static void main(String[]args) {
		System.out.println(getNum());
	}
}