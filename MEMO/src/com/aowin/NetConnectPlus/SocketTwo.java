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
				new InputStreamReader(in));//读入的字节流转为字符流--不需要用bytep[]数组转换
		System.out.println("服务器端建立");
		while(true){
			String str=br.readLine();
			System.out.println("接受到的内容是："+str);
			if(str.equals("#")) {
				break;
			}
		}
		socket.close();
	}
}