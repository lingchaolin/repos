package com.aowin.NetConnectPlus;
import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class SocketTwo{
	public static void main(String[]args) throws IOException {
		ServerSocket server=new ServerSocket(8888);
		Socket socket=server.accept();
		
		InputStream in=socket.getInputStream();
		BufferedReader br=new BufferedReader(
				new InputStreamReader(in));//������ֽ���תΪ�ַ���--����Ҫ��bytep[]����ת��
		System.out.println("�������˽���");
		while(true){
			String str=br.readLine();
			System.out.println("���ܵ��������ǣ�"+str);
			if(str.equals("#")) {
				break;
			}
		}
		socket.close();
	}
}