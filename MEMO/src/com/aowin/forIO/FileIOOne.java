package com.aowin.forIO;

import java.io.File;

public class FileIOOne {

	public static void main(String[] args) {
		System.out.println("��ͬ����ϵͳ�ķָ�����һ����ͬ");
		System.out.println("·���ָ���:"+File.pathSeparator);
		System.out.println("���Ʒָ��� :"+File.separator);
		//·����ʾ��ʽ
		String path ="D:/Class/in.txt";
		path="E:"+File.separator+"xp"+File.separator+"test"+File.separator+"2.jpg";
		//�Ƽ���ʽ
		path="E:/xp/test/2.jpg";
				
//		File��ʾ�ļ��ķ�ʽ
//		-����·��-���̷���ͷ
		File src =new File("D:/Class/in.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
//		-���·��-��Թ��̸�Ŀ¼
		src =new File("D:\\Class","in.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		src =new File(new File("D:\\Class"),"in.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//û���̷�: �� user.dir����--?
		src =new File("in.txt");//���ļ�����Ŀ¼�µ�
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		src =new File(".");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
//		UTF-8��	Ӣ��-1���ֽ�: ����-3���ֽ�
//		GBK��	Ӣ��-1���ֽ�: ����-2���ֽ�
		
	}

}
