package com.aowin.forIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharBufferIO {
	public static void main(String[] args) {
		File file=new File("D:/Class/in2.txt");
		CharBufferIOout(file);
		CharBufferIOin(file);
	}
	public static void CharBufferIOin(File file) {
		//读到最后一行，返回null--BufferedReader--newLine()---新方法
		try {
			BufferedReader br=new BufferedReader(
					new FileReader(file));
			String str=null;
			while(null!=(str=br.readLine())) {
				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//新方法-newLine
	public static void CharBufferIOout(File file) {
		try {
			//创建流
			BufferedWriter bw=new BufferedWriter(
					new FileWriter(file));
			bw.write('w');
			bw.newLine();//行分隔符
			bw.write("rgerg");
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
