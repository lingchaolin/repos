package com.aowin.NetConnectPlus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
public class ClientOne{
//    public static void main(String[]args) throws UnknownHostException, IOException{
//        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),8888);
//        OutputStream os=socket.getOutputStream();
//        os.write("hello".getBytes());
//        os.flush();
////        输入流
//        InputStream in=socket.getInputStream();
//        byte[]buf=new byte[2048];
//        in.read(buf);
//        String str=new String(buf).trim();
//        System.out.println("服务器的响应:"+str);
//        socket.close();
//    }
	public static void main(String[]args) throws IOException {
		Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),8888);
		
//		先输出
		OutputStream out=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(out);
		pw.println("hello");
		pw.flush();
//		out.write("我来了".getBytes());
//		out.flush();
	
//		后读入
		InputStream in=socket.getInputStream();
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(in));//读入的字节流转为字符流--不需要用bytep[]数组转换
		String str=br.readLine();
//		byte []car=new byte[2048];
//		in.read(car);
//		String str=new String(car).trim();
		System.out.println("接受到的内容是："+str);
		
		socket.close();
	}
}