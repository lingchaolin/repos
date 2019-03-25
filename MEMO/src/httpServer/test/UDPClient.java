package httpServer.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import com.aowin.classLoadSort.NewString;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket=new DatagramSocket(6666);
		byte[]data="数据报字节流".getBytes();
		DatagramPacket packet=new DatagramPacket(data, data.length, 
				new InetSocketAddress(InetAddress.getLocalHost(),8888));
		socket.send(packet);
		socket.close();
	}
}
