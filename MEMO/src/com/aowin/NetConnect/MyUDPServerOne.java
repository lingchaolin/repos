package com.aowin.NetConnect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**UDP��������Ϊ���ģ����������� ����ȫ ���ݿ��ܶ�ʧ Ч�ʸ�
һ.��DatagramSocket
1.�ͻ���
-�����ͻ��� DatagramSocket�� +ָ���˿�--���Ͷ˿�
-׼������ �ֽ�����
-��� DatagramPacket+��������ַ���˿�
-����
-�ͷ���Դ
2.��������
-��������� DatagramSocket�� +ָ���˿�
-׼�����ܵ����� �ֽ�����  ��װDatagramSocket--���ն˿�
-��  ��������
-����
-�ͷ���Դ
*/
public class MyUDPServerOne {
	public  static void main(String[]args) {
		try {
//		��������˺Ͷ˿�
			DatagramSocket server=new DatagramSocket(8888);
//			׼����������
			byte[]container=new byte[1024];
//			��װ�ɰ�
			DatagramPacket packet=new DatagramPacket(container,container.length);
//			��������
			server.receive(packet);
//			��������
			byte[]data=packet.getData();
			int len=packet.getLength();
			System.out.println(new String(data,0,len));
//			�ͷ�
			server.close();
			
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
