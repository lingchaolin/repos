package com.aowin.NetConnect;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 1.客户端
	-创建客户端 DatagramSocket类 +指定端口
	-准备数据--double --> 字节数组--字节数组输出流
	-打包 DatagramPacket+服务器地址及端口(发送地点+端口)
	-发送
	-释放资源
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[]args) throws IOException{
		//-创建客户端 DatagramSocket类 +指定端口
		DatagramSocket client=new DatagramSocket(6666);
		//  DatagramSocket(int port) 
//        创建数据报套接字并将其绑定到本地主机上的指定端口。 
		
		//-准备数据 字节数组
//		String msg="udp编程测试测试测试……测试";
		double num=89.12;
		byte[]data=convert(num);
		//打包 DatagramPacket+服务器地址及端口
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress(InetAddress.getLocalHost(),8888));
//		DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
//        构造数据报包，用来将长度为 length 偏移量为 offset 的包发送到指定主机上的指定端口号。
		
		
		//发送数据
		client.send(packet);
//		send(DatagramPacket p) 
//        从此套接字发送数据报包。
		
		
		//分析数据
//		data=packet.getData();
//		int len=packet.getLength();
//		System.out.println(new String(data,0,len));
//		//-释放资源
		client.close();
	}
	public static byte[]convert(double num) throws IOException{
		byte[]data=null;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		data=bos.toByteArray();
		dos.close();
		
		return data;
	}
}
