package com.aowin.NetConnect;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
1、创建客户端   必须指定服务器+端口    此时就在连接
	Socket(String host, int port) 
2、接收数据 +发送数据	
*
*/
public class TCP_client {
	public static void main(String[]args) throws UnknownHostException, IOException{
//		客户端的端口不需要指定，系统自动分配
		Socket client=new Socket("localhost",8888);//服务器的地址及端口
		/*
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
						client.getInputStream()));
		String echo=br.readLine();//行结束符
		System.out.println(echo);
		*/
		System.out.println("一个客户端建立");
		DataInputStream dis=new DataInputStream(
				client.getInputStream());
		String msg=dis.readUTF();
		System.out.println(msg);
	}
}
