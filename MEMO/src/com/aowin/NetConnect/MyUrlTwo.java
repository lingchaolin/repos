package com.aowin.NetConnect;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
//import org.omg.CORBA.portable.InputStream;

/**
 * 获取资源：源代码
 * @author Administrator
 *
 */
public class MyUrlTwo {
	public static void main(String[]args) throws IOException{
		URL url=new URL("http://www.baidu.com");
		InputStream is=url.openStream();//打开的是输入流
		byte[]flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			System.out.println(new String(flush,0,len));
		}
		is.close();
	}
}
