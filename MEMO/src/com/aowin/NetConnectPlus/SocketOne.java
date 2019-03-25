package com.aowin.NetConnectPlus;
import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class SocketOne{
//    public static void main(String[]args) throws IOException{
//        ServerSocket socket=new ServerSocket(8888);
//        Socket client=socket.accept();
//        
////        先接受，后响应
//        InputStream in=client.getInputStream();
//        byte []buf=new byte[2048];
//        in.read(buf);
//        String str=new String(buf).trim();
//        System.out.println("有客户端进来了："+str);
//        OutputStream os=client.getOutputStream();
//        os.write("欢迎".getBytes());
//        os.flush();
//        client.close();
//    }
	public static void main(String[]args) throws IOException {
		ServerSocket server=new ServerSocket(8888);
		Socket socket=server.accept();
		
		InputStream in=socket.getInputStream();
		BufferedReader br=new BufferedReader(
				new InputStreamReader(in));//读入的字节流转为字符流--不需要用bytep[]数组转换
//		BufferedReader(Reader in)  创建一个使用默认大小输入缓冲区的缓冲字符输入流。
        
//		byte []car=new byte[2048];
//		in.read(car);
//		String str=new String(car).trim();
		String str=br.readLine();
		System.out.println("接受到的内容是："+str);
//		输出
		OutputStream out=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(out);
		pw.println("ok");
		pw.flush();
//		out.write("欢迎回来".getBytes());
//		out.flush();
		pw.close();
		socket.close();
	}
}