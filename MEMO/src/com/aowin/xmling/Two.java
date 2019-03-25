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
 * 2���ܹ���DOM�Ը�����xml�ĵ����н�����
 * �����config.xml����jdbc��dbconnection�����ݿ⡢�û����������ֵ��
 * ʹ�����ͨ���ԡ�
 * @author Administrator
 *
 */
public class Two {

	public static void main(String[] args) {
		File file=new File("D:/Class/work/config.xml");
		try {
			GetJdbc jd=getJdbc(file);//�õ�jdbc������
			Connection con=DbUtil.getCon(jd);
			ResultSet rs=null;
			String sql="select * from Message";
			Statement sta=con.createStatement();
			rs=sta.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			//�������ݿ�
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ͨ��xml��ȡ���� ���ݿ����Ϣ
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
