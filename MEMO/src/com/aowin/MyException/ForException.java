package com.aowin.MyException;

import java.io.IOException;
import java.util.Scanner;
//system.exit(0);--�˳�Java�����
/**
 * �쳣�ǳ��������⵼���ж���������ָ������һ������
 * Throwable����������ĸ���--error��Exception
 * 
 * Exception--�����쳣�ĸ��࣬�����г�RuntimeException��
 * 	���Ǳ������쳣���粻������ͨ�����룬���봦��
 * 1.����ʱ�쳣--RuntimeException������;
 * --��������ϵͳ���Զ�����Ĭ�ϴ������ᵼ�³�����ǰ����
 * 
 * 2.�������쳣
 * @author Administrator
 *
 *���������쳣�ص㣻
 *
 *�쳣����ķ�ʽ��
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
		System.out.println("����");
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
		System.out.println("������");
		
			System.in.read(buf);
		String str=new String(buf).trim();
		d=Double.parseDouble(str);
		return d;
		
	}
	public static int getInt() {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("������һ��������");
//			Scanner scan=new Scanner(System.in);
			try {
				int num=scan.nextInt();
				return num;
			} catch (java.util.InputMismatchException e) {
				System.out.println("���Ͳ�ƥ�䣬���������룺");
				scan.nextLine();
				
			}
			
		}
	}
}
