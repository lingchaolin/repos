package com.aowin.NetConnect;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
/**
 * ����tcp���������� ��ȫ�ɿ� Ч�ʵ�--��绰 
 *һ����������--����-��Ӧ��Request--Response
 *
 *��.Socket���
 *1.�������ˣ�ServeSocket
 *		-
 *2.�ͻ��ˣ�
 *
 */
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
/**��ͬ��Э��˿ڿ����ظ�
���������������� ������--��ȫ�ɿ�-Ч�ʵ�
�������ӣ�������Ӧ��Reauest--response;
1������������  ָ���˿�   ServerSocket(int port) 
2�����տͻ�������  
3����������+��������
* 
*/
public class TCP_serve {
	public static void main(String[]args) throws IOException{
		//1.������������ָ���˿�
		ServerSocket server=new ServerSocket(8888);
		//2.���տͻ�������--����ʽ--�ȴ���Ӧ
		Socket socket=server.accept();//socket--����ܵ�
		System.out.println("һ������˽�������");
		String msg="��ӭʹ��";
		/*
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();//�н�����--������ܻ�ʧ��
		bw.flush();
		*/
//		�����--���ܹ�
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
	}
}
