package httpServer.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		DatagramSocket server=new DatagramSocket(8888);
		byte[]data=new byte[1024];
		DatagramPacket packet=new DatagramPacket(data, data.length);
		System.out.println("µÈ´ý¡­¡­");
		server.receive(packet);
		System.out.println("½âÎö¡­¡­");
		data=packet.getData();
		int len=packet.getLength();
		System.out.println("data:"+new String(data, 0,len));
		System.out.println("len:"+len);
		
		server.close();
	}
}
