package com.aowin.NetConnectPlus;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class One {

	public static void main(String[] args) throws UnknownHostException {
			InetAddress Inet=InetAddress.getLocalHost();
			System.out.println("name:"+Inet.getHostName());
			System.out.println("ip:"+Inet.getHostAddress());
			System.out.println();
			InetAddress Inet2=InetAddress.getByName("192.168.1.154");
			System.out.println(Inet2.getHostName());
			System.out.println(Inet2.getHostAddress());
			System.out.println();
			InetAddress Inet3=InetAddress.getByName("HASEE-PC");
			System.out.println(Inet3.getHostName());
			System.out.println(Inet3.getHostAddress());
			
			System.out.println();//不变的本地地址
			InetAddress Inet4=InetAddress.getByName("127.0.0.1");
			System.out.println(Inet4.getHostName());
			System.out.println(Inet4.getHostAddress());
	}

}
