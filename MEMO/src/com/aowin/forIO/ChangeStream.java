package com.aowin.forIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//×ª»»Á÷
public class ChangeStream {
	public static void main(String[] args) {
		File file=new File("D:/Class/in2.txt");
//		ChangeStreamOut(file);
		ChangeStreamIn(file);
	}
	public static void ChangeStreamIn(File file) {
		try {
			BufferedReader br=new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
		String str=null;
		while(null!=(str=br.readLine())) {
			System.out.println(str);
		}
		
		br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ChangeStreamOut(File file) {
		OutputStreamWriter os=null;
		try {
			os=new OutputStreamWriter(new FileOutputStream(file));
			BufferedWriter bw=new BufferedWriter(os);
			bw.write("gerg");
			bw.newLine();
			bw.write("gerg");
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
