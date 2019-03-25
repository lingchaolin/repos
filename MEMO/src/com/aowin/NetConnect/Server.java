package com.aowin.NetConnect;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * .��������
	-��������� DatagramSocket�� +ָ���˿�
	-׼�����ܵ����� �ֽ����� -->double ����--  ��װDatagramSocket
	-��  ��������
	-����
	-�ͷ���Դ
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[]args) throws IOException{
		//-��������� DatagramSocket�� +ָ���˿�
		DatagramSocket server=new DatagramSocket(8888);
		//׼�����ܵ����� 
		byte[]container=new byte[1024];
		//��װ�ɰ�DatagramPacket(byte[] buf,int length)
		DatagramPacket packet=new DatagramPacket(container,container.length );
		//��������
		System.out.println("�ȴ����ݡ���");
		server.receive(packet);
		System.out.println("���ݽ�����ϣ�");
		//��������
//		byte[]data=packet.getData();
		double data=convert(packet.getData());
//		int len=packet.getLength();
//		System.out.println(new String(data,0,len));
		System.out.println(data);
		
		//�ͷ�
		server.close();
	}
	public static double convert(byte[]data) throws IOException {
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(data));
		double num=dis.readDouble();
		dis.close();
		return num;
	}
}
