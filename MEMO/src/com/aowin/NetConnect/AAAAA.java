package com.aowin.NetConnect;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class AAAAA {
/**网络编程--底层数据传输
 * URL-统一资源定位符
 * URI-统一资源
 * 
 * TCP--打电话--三次握手  面向连接，安全可靠--建立连接后传输数据，
 * 					效率低，消耗大，检查错误，失败重发
 * UDP--短信/邮件 非面向连接  效率高，消耗小，不检查错误
 * 
 * port端口号-握手点--(0-65535)；（1024以下的端口保留给系统）
 * 
 * 
 * TCP-流式socket-双向有序无重复
 * UDP-数据报式socket
 */
	
/**TCP连接方式--客户端的端口有计算机分配？所以只需要定义服务器端的端口
 服务器端:ServerSocket socket=new ServerSocket(8888);-指定端口
  Socket client=socket.accept();在服务器类中接受传过来的socket对象；socket可以看做传输的管道

输入流
 InputStream in=socket.getInputStream();//输入流，获得客户端传入的信息
 BufferedReader br=new BufferedReader(
				new InputStreamReader(in));//转换为字符流--这里都是字符操作；

 String str=br.reakLine();
 输出流
  OutputStream out=socket.getOutputStream();
 PrintWriter pw=new PrintWriter(out);输出信息
 pw.println("ok");要发送的内容
 pw.flush();强制刷新

 客户端:Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),8888);-指定服务器和端口
 
 客户端是输入输出与服务器端的类似
 */
/**UDP连接方式
  服务器端:DatagramSocket server=new DatagramSocket(8888);-指定端口
	byte[]container=new byte[1024];
	DatagramPacket packet=new DatagramPacket(container,container.length );
	server.receive(packet);--接受包含数据的package;
 客户端:DatagramSocket client=new DatagramSocket(6666);-指定客户端的端口
  	String msg="udp编程测试测试测试……测试";--要输出的信息
		byte[]data=msg.getBytes();
		//打包 DatagramPacket+服务器地址及端口
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress(InetAddress.getLocalHost(),8888));
		//发送数据
		client.send(packet);
		//		分析数据：data=packet.getData();
 */
/**
1.网络编程是基于Socket的编程
Socket是通信两端的抽象节点（电话）
2.两种Socket
	流式-TCP
		1.采用流式Socket
		2.先建立连接
		3.通信质量高
		4.
	
	数据报式-UDP协议，无连接的，不可靠的通信
		采用的是数据报式的Socket
		无需建立连接
		通信质量差
		效率高
 */
	public static void main(String[] args) {

	}

}
