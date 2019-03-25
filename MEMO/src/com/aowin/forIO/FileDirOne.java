package com.aowin.forIO;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FileDirOne {

	public static void main(String[] args) {
//		判断文件、目录
		File dir=new File("D:/Class");
		boolean b1=dir.isFile();
		System.out.println("是文件？\t"+b1);
		boolean b2=dir.isDirectory();
		System.out.println("是目录？\t"+b2);
//		显示指定文件夹下的文件和子目录
		System.out.println("显示指定目录下的所有文件");
		File[] files=dir.listFiles();
		for(File f:files) {
			System.out.println(f);
		}
//		查找指定文件名--过滤
		System.out.println("查找以 .txt 结尾的文件");
		files=dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
//				若结尾与指定的不同-返回false--只返回指定后缀名的文件
				return file.getName().endsWith(".txt");
			}
		});
		for(File f:files) {
			System.out.println(f);
		}
//		查找目录下所有文件
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
