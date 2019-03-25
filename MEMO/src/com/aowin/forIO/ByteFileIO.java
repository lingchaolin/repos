package com.aowin.forIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO流
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
//			os=new FileOutputStream(file,true);使得数据写入是添加而不是覆盖
			byte arr[]="afs".getBytes();
			os.write(arr,0,arr.length);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
//			关闭流
			try {
				if(os!=null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void FileIn(File file) {
		//创建流
		InputStream is=null;
		try {
			is = new FileInputStream(file);
			byte car[]=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
//			循环读取
			while(-1!=(len=is.read(car))) {//读到流末尾会返回'-1';
				String info=new String(car,0,len).trim();//.trim()去掉空白符
				sb.append(info);
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭输入流
				if (null != is) {
					is.close();
				}
			} catch (Exception e2) {
				System.out.println("关闭文件输入流失败");
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
				System.out.println("关闭文件输入流失败");
			}
		}
	}
}
