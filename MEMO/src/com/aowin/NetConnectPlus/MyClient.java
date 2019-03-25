package com.aowin.NetConnectPlus;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
public class MyClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds=new DatagramSocket(7000);
//		发送
		byte[] buf="hello".getBytes();
		DatagramPacket send=new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),8000);
		ds.send(send);
		
//		接收
		byte[]buf2=new byte[1024];
		DatagramPacket rev=new DatagramPacket(buf2,buf2.length);
		ds.receive(rev);
		String msg=new String(buf2).trim();
		System.out.println("客户端接收响应:"+msg);
		ds.close();
	}

}
