package com.aowin.forIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIOOne {
	public static void main(String[] args) throws Exception {
		File dest=new File("D:/Class/in2.txt");
		CharIOin(dest);
		CharIOout(dest);
	}
	public static void CharIOin(File file) throws Exception {
			FileReader rs=new FileReader(file);
			char arr[]=new char[1024];
			int len;
			StringBuilder sb=new StringBuilder();
			while(-1!=(len=rs.read(arr))) {
				String Info=new String(arr,0,len);
				sb.append(Info);
			}
			System.out.println(sb);
			rs.close();
	}
	public static void CharIOout(File file) throws IOException {
			FileWriter ws=new FileWriter(file);
			ws.write("wefwef");
			ws.flush();
			ws.close();
	}
}