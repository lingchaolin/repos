package com.aowin.xmling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Five {
	public static void main(String[] args) {
		File file=new File("D:/Class/work/message.xml");
		File file2=new File("D:/Class/work/config.xml");

		try {
			ArrayList<Message> list=new ArrayList<Message>();
//			从数据库中取数据
			System.out.println("从数据库中获取数据");
			list=getMseeage(file2);
			System.out.println("将数据写入文件");
			write(file,list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Message> getMseeage(File file) throws Exception {
		ArrayList<Message> list=new ArrayList<Message>();
		GetJdbc jd=Two.getJdbc(file);
		Connection con=DbUtil.getCon(jd);
		Statement sta=con.createStatement();
		ResultSet rs=null;
		String sql;
		sql="select *from Message";
		rs=sta.executeQuery(sql);
		while(rs.next()) {
			Message mes=new Message();
			mes.setId(rs.getString(1));
			mes.setName(rs.getString(2));
			mes.setAge(rs.getInt(3));
			list.add(mes);
		
		}
		return list;
	}
	public static void write(File file,ArrayList<Message> list) throws Exception {
		Document doc=DocumentHelper.createDocument();
		
		Element root=doc.addElement("databases");
		Element database=root.addElement("database");
		Element url=database.addElement("url");
		url.setText("jdbc:mysql://localhost:3306/test");
		Element user=database.addElement("user");
		user.setText("root");
		Element password=database.addElement("password");
		password.setText("123456");
		for(Message sub:list) {
			Element message=database.addElement("message");
			message.addAttribute("id",sub.getId());
			message.addAttribute("name",sub.getName());
			message.addAttribute("age",String.valueOf(sub.getAge()));
		}
		
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file),"utf-8"));
		doc.write(bw);
		bw.flush();
		bw.close();
	}
}
