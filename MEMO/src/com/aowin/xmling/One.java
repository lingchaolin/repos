package com.aowin.xmling;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 1��дһ������3��ṹ��XML��Ҫ���ܹ���DOM����һ��xml�ĵ�ģ�ͣ�
 * ����д�뵽�ļ�config.xml��ȥ��
 * @author Administrator
 *
 */
public class One {

	public static void main(String[] args) {
		File file=new File("D:/Class/work/config.xml");
		try {
			write(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void write(File file) throws Exception {
		DocumentBuilder builder=DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document=builder.newDocument();
		Element root=document.createElement("databases");
		Element sub=document.createElement("database");
		Element url=document.createElement("url");
		url.setTextContent("jdbc:mysql://localhost:3306/test");
		Element user=document.createElement("user");
		user.setTextContent("root");
		Element password=document.createElement("password");
		password.setTextContent("123456");
		
		sub.appendChild(url);
		sub.appendChild(user);
		sub.appendChild(password);
		root.appendChild(sub);
		document.appendChild(root);
		
		Transformer trans=TransformerFactory.newInstance().newTransformer();
		DOMSource source=new DOMSource(document);
		StreamResult result=new StreamResult(file);
		trans.transform(source, result);
	}
}