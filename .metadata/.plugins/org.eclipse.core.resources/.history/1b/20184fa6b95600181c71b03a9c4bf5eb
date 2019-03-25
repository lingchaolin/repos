package com.aowin.NetConnect;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
必须先启动服务器 后连接
1、创建服务器  指定端口   ServerSocket(int port) 
2、接收客户端连接  
3、发送数据+接收数据

接收多个客户端
* 
*/
/**聊天室原理；
 * 聊天室--中转站
 * 1.客户端-可以发送数据+接收数据  独立的
 * 2.每一个客户端  创建一个线程；
 * @author Administrator
 *
 */
public class TCP_MultiServer {
	public static void main(String[]args) throws IOException {
		//1.创建服务器，指定端口
		ServerSocket server=new ServerSocket(8888);
		//2.接收客户端连接 阻塞式
		while(true) {//死循环--一个server一个客户端 ；
			Socket socket=server.accept();
			
			System.out.println("一个客户端建立连接");
			String msg="欢迎使用";
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}
	}
}
