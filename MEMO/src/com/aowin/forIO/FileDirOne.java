package com.aowin.forIO;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FileDirOne {

	public static void main(String[] args) {
//		�ж��ļ���Ŀ¼
		File dir=new File("D:/Class");
		boolean b1=dir.isFile();
		System.out.println("���ļ���\t"+b1);
		boolean b2=dir.isDirectory();
		System.out.println("��Ŀ¼��\t"+b2);
//		��ʾָ���ļ����µ��ļ�����Ŀ¼
		System.out.println("��ʾָ��Ŀ¼�µ������ļ�");
		File[] files=dir.listFiles();
		for(File f:files) {
			System.out.println(f);
		}
//		����ָ���ļ���--����
		System.out.println("������ .txt ��β���ļ�");
		files=dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
//				����β��ָ���Ĳ�ͬ-����false--ֻ����ָ����׺�����ļ�
				return file.getName().endsWith(".txt");
			}
		});
		for(File f:files) {
			System.out.println(f);
		}
//		����Ŀ¼�������ļ�
		dir=new File("D:/Class");
		File[] roots=File.listRoots();
		System.out.println(Arrays.toString(roots));
		printName(dir);
	}
	public static void printName(File dir) {
		if(dir==null||!dir.exists())
			return;
		System.out.println(dir.getAbsolutePath());
		if(dir.isDirectory()) {
			for( File sub:dir.listFiles())
				printName(sub);
		}
	}
}