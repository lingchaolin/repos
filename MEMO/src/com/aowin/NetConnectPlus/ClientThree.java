package com.aowin.NetConnectPlus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
public class ClientThree{
	public static void main(String[]args) throws IOException {
		Socket s=new Socket(InetAddress.getByName("127.0.0.1"),8888);
		BufferedReader br=new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		
		while(true) {
			String msg=br.readLine();
			System.out.println("Ω” ‹£∫"+msg);
			if("#".equals(msg)) {
				break;
			}
		}
	}
}