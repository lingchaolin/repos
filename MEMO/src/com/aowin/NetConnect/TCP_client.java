package com.aowin.NetConnect;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
1�������ͻ���   ����ָ��������+�˿�    ��ʱ��������
	Socket(String host, int port) 
2���������� +��������	
*
*/
public class TCP_client {
	public static void main(String[]args) throws UnknownHostException, IOException{
//		�ͻ��˵Ķ˿ڲ���Ҫָ����ϵͳ�Զ�����
		Socket client=new Socket("localhost",8888);//�������ĵ�ַ���˿�
		/*
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
						client.getInputStream()));
		String echo=br.readLine();//�н�����
		System.out.println(echo);
		*/
		System.out.println("һ���ͻ��˽���");
		DataInputStream dis=new DataInputStream(
				client.getInputStream());
		String msg=dis.readUTF();
		System.out.println(msg);
	}
}
