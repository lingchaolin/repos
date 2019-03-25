package httpServer.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example {
	public static void main(String[] args) throws Exception {
		File src = new File("D:/Class/in.txt");
		File dest = new File("D:/Class/in2.txt");
//		CharIOin(dest);
//		CharIOout(dest);
		CharCopy(src,dest);
	}

	public static void CharIOin(File file) throws Exception {// 字符流读取
		BufferedReader br = new BufferedReader(
				new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String str;
        //	 通过缓冲流的readLine()方法直接读取字符串，代替读取字符char[]数组	
		while (null != (str = br.readLine())) {
			sb.append(str);
		}
		System.out.println(sb);
		br.close();
	}
	public static void CharIOout(File file) throws IOException {// 字符流写出
		BufferedWriter bw=new BufferedWriter(
				new FileWriter(file)) ;
		bw.write("Write out test");
		bw.newLine();//新方法--换行
		bw.write("Write out test again");
		bw.flush();
		bw.close();
	}
	public static void CharCopy(File src,File dest) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(src));
		BufferedWriter bw=new BufferedWriter(new FileWriter(dest));
		String msString;
		while(null!=(msString=br.readLine())) {
			bw.write(msString);
		}
		bw.flush();
		bw.close();
		System.out.println("finish");
	}
}
