package com.aowin.NetConnect;

import java.net.MalformedURLException;
import java.net.URL;

public class MyUrlOne {
	public static void main(String[]args) throws MalformedURLException{
		URL url=new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");
		System.out.println("协议"+url.getProtocol());
		System.out.println("域名"+url.getHost());
		System.out.println("端口"+url.getPort());
		System.out.println("资源"+url.getFile());
		System.out.println("相对路径"+url.getPath());
		System.out.println("锚点"+url.getRef());
		System.out.println("参数"+url.getQuery());//若有锚点，则参数被视为锚点的一部分;参数为null;
	}
}
