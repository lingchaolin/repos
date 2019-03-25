package com.aowin.NetConnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * .服务器端
	-创建服务端 DatagramSocket类 +指定端口
	-准备接受的容器 字节数组  封装DatagramSocket
	-包  接受数据
	-分析
	-释放资源
 * @author Administrator
 *
 */
public class MyUDPServer {
	public static void main(String[]args) throws IOException{
		//-创建服务端 DatagramSocket类 +指定端口
		DatagramSocket server=new DatagramSocket(8888);
		//准备接受的容器 
		byte[]data=new byte[1024];
		//封装成包DatagramPacket(byte[] buf,int length)
		DatagramPacket packet=new DatagramPacket(data,data.length );
		//接收数据
		System.out.println("等待数据……");
		server.receive(packet);
		System.out.println("数据接收完毕！");
		//分析数据
		data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
		//释放
		server.close();
	}
}
