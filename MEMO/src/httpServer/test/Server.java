package httpServer.test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(8888);
		Socket client =server.accept();
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("·þÎñ¶ËÏìÓ¦");
		dos.flush();
		dos.close();
	}
}
