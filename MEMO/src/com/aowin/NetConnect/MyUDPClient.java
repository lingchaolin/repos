package com.aowin.NetConnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 1.客户端
	-创建客户端 DatagramSocket类 +指定端口
	-准备数据 字节数组
	-打包 DatagramPacket+服务器地址及端口(发送地点+端口)
	-发送
	-释放资源
 * @author Administrator
 *
 */
public class MyUDPClient {
	public static void main(String[]args) throws IOException{
		//-创建客户端 DatagramSocket类 +指定端口
		DatagramSocket client=new DatagramSocket(6666);
		//准备数据
		String msg="udp编程测试测试测试……测试";
		byte[]data=msg.getBytes();
		//打包 DatagramPacket+服务器地址及端口
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress(InetAddress.getLocalHost(),8888));
//		发送数据
		client.send(packet);
//		分析数据
		data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
//		-释放资源
		client.close();
	}
}
