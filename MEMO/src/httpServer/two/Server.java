package httpServer.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
/**
 * ֻ�������������������Ϊ�ͻ���
 * @param args
 */

		private ServerSocket server;
//		��Ӧ
		public static final String CRLF="\r\n";
		public static final String BLANK=" ";
		
		public static void main(String[] args) {
			Server server = new Server();
			server.start();
		}
//		��������
		public void start(){		
			try {//Server server=new ServerSocke(8888)--������������ָ���˿�"8888"
				server = new ServerSocket(8888);
				this.receive();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		���տͻ���
		private void receive(){
			try {
				Socket client =server.accept();
				
				byte[] data=new byte[20480];
				int len =client.getInputStream().read(data);	
				//���տͻ��˵�������Ϣ
				String requestInfo=new String(data,0,len).trim();	
				System.out.println(requestInfo);
				//��Ӧ
				Response rep=new Response(client.getOutputStream());
//				������Ӧ����������
				rep.println("<html><head><title>HTTP��Ӧʾ��</title>");
				rep.println("</head><body>Hello server!</body></html>");
				rep.pushToClient(200);
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		
		public void stop(){
			
		}
		
}
