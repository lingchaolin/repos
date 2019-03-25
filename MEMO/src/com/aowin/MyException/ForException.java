package com.aowin.MyException;

import java.io.IOException;
import java.util.Scanner;
//system.exit(0);--退出Java虚拟机
/**
 * 异常是程序中意外导致中断了正常的指令流的一件事情
 * Throwable是所有意外的父类--error和Exception
 * 
 * Exception--所有异常的父类，子类中除RuntimeException外
 * 	都是编译期异常，如不处理不能通过编译，必须处理。
 * 1.运行时异常--RuntimeException的子类;
 * --若不处理，系统会自动进行默认处理，但会导致程序提前结束
 * 
 * 2.编译期异常
 * @author Administrator
 *
 *整理两类异常特点；
 *
 *异常处理的方式？
 *		try-catch-finally
 *		throws
 *		throw
 */
public class ForException {
	public static void main(String[]args) throws Exception {
		int a=4;
		int b=0;
		long arr[]=new long[5];
//		getD();
		System.out.println(getD2());
		
		
	}
	public static double getD() {
		double d=0.0;
		byte[]buf=new byte[1024];
		System.out.println("输入");
		try {
			System.in.read(buf);
			String str=new String(buf).trim();
			d=Double.parseDouble(str);
			return d;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public static double getD2() throws Exception {
		double d=0.0;
		byte[]buf=new byte[1024];
		System.out.println("请输入");
		
			System.in.read(buf);
		String str=new String(buf).trim();
		d=Double.parseDouble(str);
		return d;
		
	}
	public static int getInt() {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("请输入一个整数：");
//			Scanner scan=new Scanner(System.in);
			try {
				int num=scan.nextInt();
				return num;
			} catch (java.util.InputMismatchException e) {
				System.out.println("类型不匹配，请重新输入：");
				scan.nextLine();
				
			}
			
		}
	}
}
