package com.aowin.NetConnectPlus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
public class ClientTwo{
	public static void main(String[]args) throws IOException {
		Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),8888);
//		�����
		OutputStream out=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(out);
//		pw.println("hello");
//		pw.flush();
//		�ӿ���̨��ȡ���ݵ�������
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));//������ֽ���תΪ�ַ���--����Ҫ��bytep[]����ת��
		System.out.println("�ͻ��˽���");
		while(true){
			System.out.println("������Ҫ���͵�����");
			String msg=br.readLine();
			pw.println(msg);
			pw.flush();
			if(msg.equals("#")) {
				break;
			}
		}
//		System.out.println("���ܵ��������ǣ�");
		
		socket.close();
	}
}