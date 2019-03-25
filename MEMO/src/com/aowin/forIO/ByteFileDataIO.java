package com.aowin.forIO;

import java.io.*;

public class ByteFileDataIO {
/**
 * Data--针对java中基本数据
 * Object --针对对象--通过使用文件实现持久化保存--序列化
 * @param args
 */
	//注意读写顺序一致--怎么写，怎么读
	public static void main(String[] args) {
		File file=new File("D:/Class/in2.txt");
		write(file);
		read(file);
	}

	//写数据
	public static void write(File dest) {
		DataOutputStream dos=null;
		try {
			dos=new DataOutputStream(new FileOutputStream(dest));
			double dd=25;
			dos.writeDouble(dd);
			dos.writeUTF("aefsefsef");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read(File dest) {
		DataInputStream dis=null;
		try {
			dis=new DataInputStream(new FileInputStream(dest));
			double d=dis.readDouble();
			String str=dis.readUTF();
			System.out.println(d);
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
