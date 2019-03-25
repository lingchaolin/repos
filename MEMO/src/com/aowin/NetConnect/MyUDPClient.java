package com.aowin.NetConnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 1.�ͻ���
	-�����ͻ��� DatagramSocket�� +ָ���˿�
	-׼������ �ֽ�����
	-��� DatagramPacket+��������ַ���˿�(���͵ص�+�˿�)
	-����
	-�ͷ���Դ
 * @author Administrator
 *
 */
public class MyUDPClient {
	public static void main(String[]args) throws IOException{
		//-�����ͻ��� DatagramSocket�� +ָ���˿�
		DatagramSocket client=new DatagramSocket(6666);
		//׼������
		String msg="udp��̲��Բ��Բ��ԡ�������";
		byte[]data=msg.getBytes();
		//��� DatagramPacket+��������ַ���˿�
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress(InetAddress.getLocalHost(),8888));
//		��������
		client.send(packet);
//		��������
		data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
//		-�ͷ���Դ
		client.close();
	}
}
