package com.aowin.forIO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStyle {

	public static void main(String[]args) throws IOException{
		System.out.println("test");
		PrintStream ps=System.out;
		ps.println("awe");
		//������ļ�
		File src=new File("D:/Class/work/Test/IoOUT.java");
		ps=new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(src)));
		ps.println("is so easy");
		ps.close();
	}

}
