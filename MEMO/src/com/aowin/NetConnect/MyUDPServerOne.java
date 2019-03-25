package com.aowin.NetConnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**UDP：以数据为中心，非面向连接 不安全 数据可能丢失 效率高
一.类DatagramSocket
1.客户端
-创建客户端 DatagramSocket类 +指定端口--发送端口
-准备数据 字节数组
-打包 DatagramPacket+服务器地址及端口
-发送
-释放资源
2.服务器端
-创建服务端 DatagramSocket类 +指定端口
-准备接受的容器 字节数组  封装DatagramSocket--接收端口
-包  接受数据
-分析
-释放资源
*/
public class MyUDPServerOne {
	public  static void main(String[]args) {
		try {
//		创建服务端和端口
			DatagramSocket server=new DatagramSocket(8888);
//			准备接受容器
			byte[]container=new byte[1024];
//			封装成包
			DatagramPacket packet=new DatagramPacket(container,container.length);
//			接收数据
			server.receive(packet);
//			分析数据
			byte[]data=packet.getData();
			int len=packet.getLength();
			System.out.println(new String(data,0,len));
//			释放
			server.close();
			
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
