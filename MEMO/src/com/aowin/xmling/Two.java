package com.aowin.xmling;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 2、能够用DOM对给定的xml文档进行解析，
 * 如根据config.xml完善jdbc中dbconnection中数据库、用户名、密码的值，
 * 使其具有通用性。
 * @author Administrator
 *
 */
public class Two {

	public static void main(String[] args) {
		File file=new File("D:/Class/work/config.xml");
		try {
			GetJdbc jd=getJdbc(file);//得到jdbc配置类
			Connection con=DbUtil.getCon(jd);
			ResultSet rs=null;
			String sql="select * from Message";
			Statement sta=con.createStatement();
			rs=sta.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			//连接数据库
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//通过xml获取连接 数据库的信息
	public static GetJdbc getJdbc(File file) throws ParserConfigurationException, SAXException, IOException  {
		GetJdbc jd=new GetJdbc();
		DocumentBuilder builder=DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc=builder.parse(file);
		Node root=builder.parse(file);
		NodeList studentList=root.getChildNodes();
		for(int i=0;i<studentList.getLength();i++) {
			Node student=studentList.item(i);
			NodeList childList=student.getChildNodes();
			for(int j=0;j<childList.getLength();j++) {
				Node child=childList.item(j);
				jd.setUrl(child.getChildNodes().item(0).getTextContent());
				jd.setUser(child.getChildNodes().item(1).getTextContent());
				jd.setPassword(child.getChildNodes().item(2).getTextContent());
//				System.out.println("url-"+child.getChildNodes().item(0).getTextContent());
//				System.out.println("user-"+child.getChildNodes().item(1).getTextContent());
//				System.out.println("password-"+child.getChildNodes().item(2).getTextContent());
			}
		}
		return jd;
	}
	
}
