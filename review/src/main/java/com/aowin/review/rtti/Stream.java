package com.aowin.review.rtti;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Stream {

	public Stream() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		new Stream().fileInStream();
		new Stream().fileOutStream();
	}
	/**
	 * 读入
	 * @throws FileNotFoundException 
	 */
	public void fileInStream() throws Exception {
		File file=new File("D:\\Class\\in.txt");
		FileInputStream is=new FileInputStream(file);
		byte[] bt=new byte[1024];
		int len=0;
		StringBuffer sb=new StringBuffer();
		while(-1!=(len=is.read(bt))) {
			String info=new String(bt, 0, len).trim();
			sb.append(info);
		}
		System.out.println(sb);
		is.close();
	}
	public void bufferInStream() throws Exception {
		File file=new File("D:\\Class\\in.txt");
		FileInputStream is=new FileInputStream(file);
		BufferedInputStream bis=new BufferedInputStream(is);
		byte[] bt=new byte[1024];
		int len=0;
		StringBuffer sb=new StringBuffer();
		while(-1!=(len=bis.read(bt))) {
			String info=new String(bt, 0, len).trim();
			sb.append(info);
		}
		System.out.println(sb);
		is.close();
	}
	/**
	 * 写出
	 */
	public void fileOutStream() throws Exception {
		File file=new File("D:/Class/in2.txt");
		FileOutputStream os=new FileOutputStream(file,true);
		byte[]car="被召唤出的哥布林中的一员".getBytes();
		os.write(car, 0, car.length);
		os.flush();
		os.close();
	}
	public void bufferOutStream() throws Exception {
		File file=new File("D:/Class/in2.txt");
		FileOutputStream os=new FileOutputStream(file);
		BufferedOutputStream bos=new BufferedOutputStream(os);
		byte[]car="被召唤出的哥布林中的一员".getBytes();
		bos.write(car, 0, car.length);
		bos.flush();
		bos.close();
	}
	public void fileTransfer() throws Exception{
		File src=new File("D:/Class/in.txt");
		File dest=new File("D:/Class/in2.txt");
		FileInputStream is=new FileInputStream(src);
		FileOutputStream os=new FileOutputStream(dest);
		byte[]car=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(car))) {
			os.write(car, 0, len);
			os.flush();
		}
		os.close();
		is.close();
		System.out.println("传输结束");
	}
	public void dataInStream() throws Exception{
		File file=new File("D:/Class/in2.txt");
		DataInputStream dis=new DataInputStream(new FileInputStream(file));
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
	}
	public void dataOutStream() throws Exception{
		File file=new File("D:/Class/in2.txt");
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(file));
		double d=25;
		dos.writeDouble(d);
		dos.writeUTF("测试测试！");
		dos.flush();
		dos.close();
	}
}
