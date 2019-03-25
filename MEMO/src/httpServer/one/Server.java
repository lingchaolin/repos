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
//				accept() - 侦听并接受到此套接字的连接。
				StringBuilder sb =new StringBuilder();
				String msg =null;
				BufferedReader br = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
//				接收服务器端的输入
				while((msg=br.readLine()).length()>0){//不为空--继续读取
					sb.append(msg);
					sb.append("\r\n");
					if(null==msg) {
						break;
					}
				}
				//接收客户端的请求信息
				String requestInfo =sb.toString().trim();		//处理从服务器接收的数据
				System.out.println(requestInfo);
				//响应
				StringBuilder responseContext =new StringBuilder();//准备要响应的正文
				responseContext.append("<html><head><title>HTTP响应示例</title>" +
						"</head><body>、Hello bjsxt!</body></html>");
				StringBuilder response =new StringBuilder();
				//1)  HTTP协议版本、状态代码、描述
				response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
				//2)  响应头(Response Head)
				response.append("Server:bjsxt Server/0.0.1").append(CRLF);
				response.append("Date:").append(new Date()).append(CRLF);
				response.append("Content-type:text/html;charset=GBK").append(CRLF);
				//正文长度 ：字节长度
				response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
				//3)正文之前
				response.append(CRLF);
				//4)正文
				response.append(responseContext);
				
				System.out.println(responseContext);
				
				//输出流
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
