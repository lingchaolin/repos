package com.aowin.NetConnect;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
/**
 * 基于tcp：面向连接 安全可靠 效率低--打电话 
 *一。面向连接--请求-响应：Request--Response
 *
 *二.Socket编程
 *1.服务器端：ServeSocket
 *		-
 *2.客户端：
 *
 */
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
/**不同额协议端口可以重复
必须先启动服务器 后连接--安全可靠-效率低
面向连接，请求响应；Reauest--response;
1、创建服务器  指定端口   ServerSocket(int port) 
2、接收客户端连接  
3、发送数据+接收数据
* 
*/
public class TCP_serve {
	public static void main(String[]args) throws IOException{
		//1.创建服务器，指定端口
		ServerSocket server=new ServerSocket(8888);
		//2.接收客户端连接--阻塞式--等待响应
		Socket socket=server.accept();//socket--代表管道
		System.out.println("一个服务端建立连接");
		String msg="欢迎使用";
		/*
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();//行结束符--否则可能会失败
		bw.flush();
		*/
//		输出流--不能关
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
	}
}
