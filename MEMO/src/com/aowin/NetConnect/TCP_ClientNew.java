package com.aowin.NetConnect;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCP_ClientNew {

	public TCP_ClientNew() {
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		try {
			Socket client=new Socket("localhost", 8888);
			System.out.println("�ͻ��˷���");
			DataInputStream dis=new DataInputStream(client.getInputStream());
			String msString=dis.readUTF();
			System.out.println("���յ���Ϣ��"+msString);
			
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			dos.writeUTF(scanner.nextLine());
			dos.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}