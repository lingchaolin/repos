package com.aowin.NetConnectPlus;
import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class SocketThree{
	public static void main(String[]args) throws IOException {
		ServerSocket server=new ServerSocket(8888);
//		System.out.println("等待连接SocketTwo");
		Socket socket=server.accept();
//		System.out.println("等待连接SocketThree");
		Socket socket2=server.accept();
		
		InputStream in=socket.getInputStream();
		BufferedReader br=new BufferedReader(
				new InputStreamReader(in));//读入的字节流转为字符流--不需要用bytep[]数组转换
//		转发
		PrintWriter pw=new PrintWriter(socket2.getOutputStream());
		while(true){
			String str=br.readLine();
			System.out.println("接受到的内容是："+str);
			pw.println(str);
			pw.flush();
			if(str.equals("#")) {
				break;
			}
		}
		socket.close();
	}
}