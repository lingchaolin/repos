package com.aowin.NetConnect;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP_ServerNew {
	
	public TCP_ServerNew() {
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ServerSocket server;
		try {
			server = new ServerSocket(8888);
			System.out.println("����˷���");
			Socket socket=server.accept();
			String msString="123445678";
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msString);
			dos.flush();
			
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			String msString2=dis.readUTF();
			System.out.println(msString2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
