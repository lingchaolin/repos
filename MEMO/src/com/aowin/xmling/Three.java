package com.aowin.xmling;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 * 3、使用 DOM4j对上述xml文件进行读写操作。
 *
 */
public class Three {
	static File file;
	public static void main(String[] args) throws Exception {
		file=new File("D:/Class/work/config.xml");
//		write(file);
		read(file);
	}
	public static void write(File file) throws Exception {
		Document doc=DocumentHelper.createDocument();
		
		Element root=doc.addElement("databases");
		Element database=root.addElement("database");
		Element url=database.addElement("url");
		url.setText("jdbc:mysql://localhost:3306/test");
		Element user=database.addElement("user");
		user.setText("root");
		Element password=database.addElement("password");
		password.setText("123456");
		
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file),"utf-8"));
		doc.write(bw);
		bw.flush();
		bw.close();
	}
	public static Map read(File file) throws Exception {
		Map map=new HashMap();
		SAXReader reader=new SAXReader();
		Document doc=reader.read(file);
		Element root=doc.getRootElement();
		Iterator<Element> it=root.elementIterator();
		while(it.hasNext()) {
			Element student=it.next();
			Iterator<Element> it2=student.elementIterator();
			while(it2.hasNext()) {
				Element child=it2.next();
//				System.out.println(child.getName()+":"+child.getText());
				map.put(child.getName(), child.getText());
			}
		}
		return map;
	}
	public static String getName() {
		Map map=new HashMap();
		try {
			map=read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) map.get("name");
	}
	public static String getPassword() {
		Map map=new HashMap();
		try {
			map=read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) map.get("name");
	}
}
