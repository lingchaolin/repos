package com.aowin.NetConnectPlus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerFour {

	public ServerFour() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(8888);
		Socket socket=server.accept();

		BufferedReader br=new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter pw=new PrintWriter(socket.getOutputStream());
		System.out.println("服务器端建立");
		while(true) {
			String str=br.readLine();
			str=br.readLine();
			System.out.println("接受到的内容是："+str);
			if(str.equals("#")) {
				break;
			}
		}
		socket.close();
	}
}
