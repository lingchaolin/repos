package com.aowin.NetConnect;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 1.�ͻ���
	-�����ͻ��� DatagramSocket�� +ָ���˿�
	-׼������--double --> �ֽ�����--�ֽ����������
	-��� DatagramPacket+��������ַ���˿�(���͵ص�+�˿�)
	-����
	-�ͷ���Դ
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[]args) throws IOException{
		//-�����ͻ��� DatagramSocket�� +ָ���˿�
		DatagramSocket client=new DatagramSocket(6666);
		//  DatagramSocket(int port) 
//        �������ݱ��׽��ֲ�����󶨵����������ϵ�ָ���˿ڡ� 
		
		//-׼������ �ֽ�����
//		String msg="udp��̲��Բ��Բ��ԡ�������";
		double num=89.12;
		byte[]data=convert(num);
		//��� DatagramPacket+��������ַ���˿�
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress(InetAddress.getLocalHost(),8888));
//		DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
//        �������ݱ���������������Ϊ length ƫ����Ϊ offset �İ����͵�ָ�������ϵ�ָ���˿ںš�
		
		
		//��������
		client.send(packet);
//		send(DatagramPacket p) 
//        �Ӵ��׽��ַ������ݱ�����
		
		
		//��������
//		data=packet.getData();
//		int len=packet.getLength();
//		System.out.println(new String(data,0,len));
//		//-�ͷ���Դ
		client.close();
	}
	public static byte[]convert(double num) throws IOException{
		byte[]data=null;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		data=bos.toByteArray();
		dos.close();
		
		return data;
	}
}
