package com.aowin.NetConnectPlus;
import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class SocketThree{
	public static void main(String[]args) throws IOException {
		ServerSocket server=new ServerSocket(8888);
//		System.out.println("�ȴ�����SocketTwo");
		Socket socket=server.accept();
//		System.out.println("�ȴ�����SocketThree");
		Socket socket2=server.accept();
		
		InputStream in=socket.getInputStream();
		BufferedReader br=new BufferedReader(
				new InputStreamReader(in));//������ֽ���תΪ�ַ���--����Ҫ��bytep[]����ת��
//		ת��
		PrintWriter pw=new PrintWriter(socket2.getOutputStream());
		while(true){
			String str=br.readLine();
			System.out.println("���ܵ��������ǣ�"+str);
			pw.println(str);
			pw.flush();
			if(str.equals("#")) {
				break;
			}
		}
		socket.close();
	}
}