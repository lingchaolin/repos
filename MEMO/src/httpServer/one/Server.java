package httpServer.one;

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
//				accept() - ���������ܵ����׽��ֵ����ӡ�
				StringBuilder sb =new StringBuilder();
				String msg =null;
				BufferedReader br = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
//				���շ������˵�����
				while((msg=br.readLine()).length()>0){//��Ϊ��--������ȡ
					sb.append(msg);
					sb.append("\r\n");
					if(null==msg) {
						break;
					}
				}
				//���տͻ��˵�������Ϣ
				String requestInfo =sb.toString().trim();		//�����ӷ��������յ�����
				System.out.println(requestInfo);
				//��Ӧ
				StringBuilder responseContext =new StringBuilder();//׼��Ҫ��Ӧ������
				responseContext.append("<html><head><title>HTTP��Ӧʾ��</title>" +
						"</head><body>��Hello bjsxt!</body></html>");
				StringBuilder response =new StringBuilder();
				//1)  HTTPЭ��汾��״̬���롢����
				response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
				//2)  ��Ӧͷ(Response Head)
				response.append("Server:bjsxt Server/0.0.1").append(CRLF);
				response.append("Date:").append(new Date()).append(CRLF);
				response.append("Content-type:text/html;charset=GBK").append(CRLF);
				//���ĳ��� ���ֽڳ���
				response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
				//3)����֮ǰ
				response.append(CRLF);
				//4)����
				response.append(responseContext);
				
				System.out.println(responseContext);
				
				//�����
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				bw.write(response.toString());
				bw.flush();
				bw.close();
			} catch (IOException e) {
			}
		}
		
		public void stop(){
			
		}
		
}