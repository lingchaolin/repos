package com.aowin.NetConnectPlus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
public class ClientTwo{
	public static void main(String[]args) throws IOException {
		Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),8888);
//		先输出
		OutputStream out=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(out);
//		pw.println("hello");
//		pw.flush();
//		从控制台获取数据的输入流
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));//读入的字节流转为字符流--不需要用bytep[]数组转换
		System.out.println("客户端建立");
		while(true){
			System.out.println("请输入要发送的数据");
			String msg=br.readLine();
			pw.println(msg);
			pw.flush();
			if(msg.equals("#")) {
				break;
			}
		}
//		System.out.println("接受到的内容是：");
		
		socket.close();
	}
}