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

	public static void CharIOin(File file) throws Exception {// �ַ�����ȡ
		BufferedReader br = new BufferedReader(
				new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String str;
        //	 ͨ����������readLine()����ֱ�Ӷ�ȡ�ַ����������ȡ�ַ�char[]����	
		while (null != (str = br.readLine())) {
			sb.append(str);
		}
		System.out.println(sb);
		br.close();
	}
	public static void CharIOout(File file) throws IOException {// �ַ���д��
		BufferedWriter bw=new BufferedWriter(
				new FileWriter(file)) ;
		bw.write("Write out test");
		bw.newLine();//�·���--����
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
