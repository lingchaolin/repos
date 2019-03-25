package com.aowin.NetConnectPlus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class ClientFour {

	public ClientFour() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket(InetAddress.getByName("127.0.0.1"), 8888);
		BufferedReader br=new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter pw=new PrintWriter(socket.getOutputStream());
		System.out.println("客户端建立");
		pw.write("客户端发送信息");
		pw.flush();
		Scanner scanner=new Scanner(System.in);
		while(true) {
//			String msg=br.readLine();
//			System.out.println("客户端读取的内容是："+msg);
			pw.write(scanner.nextLine());
			pw.flush();
		}
	}
}
