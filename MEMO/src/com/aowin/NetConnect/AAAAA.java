package com.aowin.NetConnect;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class AAAAA {
/**������--�ײ����ݴ���
 * URL-ͳһ��Դ��λ��
 * URI-ͳһ��Դ
 * 
 * TCP--��绰--��������  �������ӣ���ȫ�ɿ�--�������Ӻ������ݣ�
 * 					Ч�ʵͣ����Ĵ󣬼�����ʧ���ط�
 * UDP--����/�ʼ� ����������  Ч�ʸߣ�����С����������
 * 
 * port�˿ں�-���ֵ�--(0-65535)����1024���µĶ˿ڱ�����ϵͳ��
 * 
 * 
 * TCP-��ʽsocket-˫���������ظ�
 * UDP-���ݱ�ʽsocket
 */
	
/**TCP���ӷ�ʽ--�ͻ��˵Ķ˿��м�������䣿����ֻ��Ҫ����������˵Ķ˿�
 ��������:ServerSocket socket=new ServerSocket(8888);-ָ���˿�
  Socket client=socket.accept();�ڷ��������н��ܴ�������socket����socket���Կ�������Ĺܵ�

������
 InputStream in=socket.getInputStream();//����������ÿͻ��˴������Ϣ
 BufferedReader br=new BufferedReader(
				new InputStreamReader(in));//ת��Ϊ�ַ���--���ﶼ���ַ�������

 String str=br.reakLine();
 �����
  OutputStream out=socket.getOutputStream();
 PrintWriter pw=new PrintWriter(out);�����Ϣ
 pw.println("ok");Ҫ���͵�����
 pw.flush();ǿ��ˢ��

 �ͻ���:Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),8888);-ָ���������Ͷ˿�
 
 �ͻ��������������������˵�����
 */
/**UDP���ӷ�ʽ
  ��������:DatagramSocket server=new DatagramSocket(8888);-ָ���˿�
	byte[]container=new byte[1024];
	DatagramPacket packet=new DatagramPacket(container,container.length );
	server.receive(packet);--���ܰ������ݵ�package;
 �ͻ���:DatagramSocket client=new DatagramSocket(6666);-ָ���ͻ��˵Ķ˿�
  	String msg="udp��̲��Բ��Բ��ԡ�������";--Ҫ�������Ϣ
		byte[]data=msg.getBytes();
		//��� DatagramPacket+��������ַ���˿�
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress(InetAddress.getLocalHost(),8888));
		//��������
		client.send(packet);
		//		�������ݣ�data=packet.getData();
 */
/**
1.�������ǻ���Socket�ı��
Socket��ͨ�����˵ĳ���ڵ㣨�绰��
2.����Socket
	��ʽ-TCP
		1.������ʽSocket
		2.�Ƚ�������
		3.ͨ��������
		4.
	
	���ݱ�ʽ-UDPЭ�飬�����ӵģ����ɿ���ͨ��
		���õ������ݱ�ʽ��Socket
		���轨������
		ͨ��������
		Ч�ʸ�
 */
	public static void main(String[] args) {

	}

}
