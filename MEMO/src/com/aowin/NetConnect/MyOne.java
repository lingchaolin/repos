package com.aowin.NetConnect;
/**
1.InetAddress-封装IP及DNS
URL
TCP
UDP
方法：
getHostAdress();--ip地址
getHostName();----返回域名|计算机名
InetAddress.getLocalHost();
InetAddress.getByname("ip地址|域名");

2.InetSocketAddress-封装端口
(1)创建对象
InetSocketAddress(String hostname,int port);
InetSocketAddress(InetAddress addr,int port);
(2)方法：
 getAddress();
getHostName();
*/
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class MyOne {
	public static void main(String[]args) throws IOException{
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println("addr.getHostName()--"+addr.getHostName());
		System.out.println("addr.getHostAddress()--"+addr.getHostAddress());
		
		InetAddress addr2=InetAddress.getByName("127.0.0.1");
		System.out.println("addr.getHostName()--"+addr.getHostName());
		System.out.println("addr.getHostAddress()--"+addr.getHostAddress());
		
		InetAddress addr3=InetAddress.getByName("CXAS-20161109DZ");
		System.out.println("addr.getHostName()--"+addr3.getHostName());
		System.out.println("addr.getHostAddress()--"+addr3.getHostAddress());
		
		InetSocketAddress addr4=new InetSocketAddress("127.0.0.1", 9999);
		System.out.println("addr.getHostName()--"+addr4.getHostName());
		System.out.println("addr.getAddress()--"+addr4.getAddress());
		System.out.println("addr.getPort()--"+addr4.getPort());
		
	}
}
