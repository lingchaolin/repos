package httpServer2.one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Date;

public class Server {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	public static void main(String[] args) {
		Server server=new Server();
		server.receive();
		
	}
	public void receive() {
		try {
//			server=new ServerSocket(8888);
			Socket client=server.accept();
			
			byte[]data=new byte[20480];
			int len=client.getInputStream().read(data);
			String requestInfo=new String(data,0,len).trim();
			System.out.println(requestInfo);
		
			Response rep=new Response(client.getOutputStream());
			rep.print("<html><head><title>HTTP��Ӧʾ��</title>");
			rep.pushToClient(200);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() {
		try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stop() {
		
	}
}