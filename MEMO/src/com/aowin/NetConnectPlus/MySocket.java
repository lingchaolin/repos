package com.aowin.NetConnectPlus;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class MySocket {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds=new DatagramSocket(8000);
//		接收
		byte[]buf2=new byte[1024];
		DatagramPacket rev=new DatagramPacket(buf2,buf2.length);
		ds.receive(rev);
		String msg=new String(buf2).trim();
		System.out.println("服务器收到消息："+msg);
//		发送
		byte[] buf="ok".getBytes();
		DatagramPacket send=new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),7000);
		ds.send(send);
		ds.close();
		
	}
}
