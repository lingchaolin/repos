package com.aowin.forIO;

import java.io.File;

public class FileIOOne {

	public static void main(String[] args) {
		System.out.println("不同操作系统的分隔符不一定相同");
		System.out.println("路径分隔符:"+File.pathSeparator);
		System.out.println("名称分隔符 :"+File.separator);
		//路径表示形式
		String path ="D:/Class/in.txt";
		path="E:"+File.separator+"xp"+File.separator+"test"+File.separator+"2.jpg";
		//推荐方式
		path="E:/xp/test/2.jpg";
				
//		File表示文件的方式
//		-绝对路径-以盘符开头
		File src =new File("D:/Class/in.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
//		-相对路径-相对工程根目录
		src =new File("D:\\Class","in.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		src =new File(new File("D:\\Class"),"in.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//没有盘符: 以 user.dir构建--?
		src =new File("in.txt");//该文件所在目录下的
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		src =new File(".");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
//		UTF-8：	英文-1个字节: 中文-3个字节
//		GBK：	英文-1个字节: 中文-2个字节
		
	}

}
