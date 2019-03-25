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
 * 只创建服务器，浏览器作为客户端
 * @param args
 */

		private ServerSocket server;
//		响应
		public static final String CRLF="\r\n";
		public static final String BLANK=" ";
		
		public static void main(String[] args) {
			Server server = new Server();
			server.start();
		}
//		启动方法
		public void start(){		
			try {//Server server=new ServerSocke(8888)--创建服务器，指定端口"8888"
				server = new ServerSocket(8888);
				this.receive();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		接收客户端
		private void receive(){
			try {
				Socket client =server.accept();
				
				byte[] data=new byte[20480];
				int len =client.getInputStream().read(data);	
				//接收客户端的请求信息
				String requestInfo=new String(data,0,len).trim();	
				System.out.println(requestInfo);
				//响应
				Response rep=new Response(client.getOutputStream());
//				用于响应的正文内容
				rep.println("<html><head><title>HTTP响应示例</title>");
				rep.println("</head><body>Hello server!</body></html>");
				rep.pushToClient(200);
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		
		public void stop(){
			
		}
		
}
