package com.aowin.forIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO��
 * @author Administrator
 *
 */
public class ByteFileIO {
	public static void main(String[]args) {
//		InputStream
		File file=new File("D:\\Class\\IOsrc/Back.jpg");
//		FileIn(file);
		File file2=new File("D:\\Class\\IOdest/Back.jpg");
//		FileOut(file2);
		FileCopy(file,file2);
//		FileInSigle(file);
	}
	public static void FileOut(File file) {
		OutputStream os=null;
		try {
			os=new FileOutputStream(file);
//			os=new FileOutputStream(file,true);ʹ������д������Ӷ����Ǹ���
			byte arr[]="afs".getBytes();
			os.write(arr,0,arr.length);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
//			�ر���
			try {
				if(os!=null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void FileIn(File file) {
		//������
		InputStream is=null;
		try {
			is = new FileInputStream(file);
			byte car[]=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
//			ѭ����ȡ
			while(-1!=(len=is.read(car))) {//������ĩβ�᷵��'-1';
				String info=new String(car,0,len).trim();//.trim()ȥ���հ׷�
				sb.append(info);
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//�ر�������
				if (null != is) {
					is.close();
				}
			} catch (Exception e2) {
				System.out.println("�ر��ļ�������ʧ��");
			}
		}
	}
	public static void FileInSigle(File file) {
		InputStream iis=null;
		try {
			iis=new FileInputStream(file);
			
			int i=-1;
			while(-1!=(i=iis.read())) {
				System.out.println((char)i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void FileCopy(File src,File dest) {
		InputStream is=null;
		OutputStream os=null;
		try {
			is = new FileInputStream(src);
			os=new FileOutputStream(dest,true);
			byte car[]=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
			while(-1!=(len=is.read(car))) {
				os.write(car);
			}
			os.flush();
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (null != is) {
					os.close();
					is.close();
				}
			} catch (Exception e2) {
				System.out.println("�ر��ļ�������ʧ��");
			}
		}
	}
}
