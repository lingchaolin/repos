package com.aowin.NetConnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * .��������
	-��������� DatagramSocket�� +ָ���˿�
	-׼�����ܵ����� �ֽ�����  ��װDatagramSocket
	-��  ��������
	-����
	-�ͷ���Դ
 * @author Administrator
 *
 */
public class MyUDPServer {
	public static void main(String[]args) throws IOException{
		//-��������� DatagramSocket�� +ָ���˿�
		DatagramSocket server=new DatagramSocket(8888);
		//׼�����ܵ����� 
		byte[]data=new byte[1024];
		//��װ�ɰ�DatagramPacket(byte[] buf,int length)
		DatagramPacket packet=new DatagramPacket(data,data.length );
		//��������
		System.out.println("�ȴ����ݡ���");
		server.receive(packet);
		System.out.println("���ݽ�����ϣ�");
		//��������
		data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
		//�ͷ�
		server.close();
	}
}
