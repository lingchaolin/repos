package com.aowin.forIO;

import java.io.*;

public class ByteFileDataIO {
/**
 * Data--���java�л�������
 * Object --��Զ���--ͨ��ʹ���ļ�ʵ�ֳ־û�����--���л�
 * @param args
 */
	//ע���д˳��һ��--��ôд����ô��
	public static void main(String[] args) {
		File file=new File("D:/Class/in2.txt");
		write(file);
		read(file);
	}

	//д����
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
