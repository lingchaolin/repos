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
		//�������һ�У�����null--BufferedReader--newLine()---�·���
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
	//�·���-newLine
	public static void CharBufferIOout(File file) {
		try {
			//������
			BufferedWriter bw=new BufferedWriter(
					new FileWriter(file));
			bw.write('w');
			bw.newLine();//�зָ���
			bw.write("rgerg");
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
