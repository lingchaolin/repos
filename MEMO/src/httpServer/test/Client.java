package httpServer.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket client=new Socket("localHost",8888);
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String mString=dis.readUTF();
		System.out.println(mString);
		dis.close();
	}
}
