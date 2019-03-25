 package com.aowin.review;

import java.io.File;

import javax.lang.model.element.Element;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

public class Dom4JIODemo {
	//将xml文档树内容写入指定路径下
	public static void main(String[] args) throws Exception {
		File file=new File("D:/Class/work/one.xml");
		new Dom4JIODemo().dom4jWrite(file);
	}
	public void dom4jWrite(File file) throws Exception {
		Document document=DocumentHelper.createDocument();
		
	}
	public void dom4jRead(File file) throws Exception {
	
	}
}
