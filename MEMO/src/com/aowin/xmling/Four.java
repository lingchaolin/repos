package com.aowin.xmling;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

/**
 * ��ȡXML�ĵ��е����ݲ����뵽���ݿ��У�������ݲ��Ϸ�Ҫ����ʾ��
 *
 */
public class Four {

	public static void main(String[] args) {
		File file=new File("D:/Class/work/message.xml");
		File file2=new File("D:/Class/work/config.xml");
//		��ȡXML�ĵ��е�����--�ŵ�ArrayList��
		try {
			ArrayList<Message> list=read(file);
//			��ӡ��֤
			for(Message sub:list) {
				System.out.println(sub);
			}
//		�����뵽���ݿ��У�
//		������ݲ��Ϸ�Ҫ����ʾ������������
//			list����Ŀ�����ݿ�--ͬʱҪ�������ļ�������
			save(file2,list);
		} catch (DocumentException e) {
			e.printStackTrace();
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(SAXException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Message> read(File file) throws DocumentException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read(file);
		ArrayList<Message> list=new ArrayList<Message>();
		Element root=doc.getRootElement();
		List<Element> dataList=root.elements();
		List<Element> subList=dataList.get(0).elements();
		
		for(int i=3;i<subList.size();i++) {
			Message mes=new Message();
			String id=subList.get(i).attributeValue("id");
			String name=subList.get(i).attributeValue("name");
			int age=Integer.parseInt(subList.get(i).attributeValue("age"));
			mes.setId(id);
			mes.setName(name);
			mes.setAge(age);
			list.add(mes);
		}
		return list;
	
	}
	public static void save(File file,ArrayList<Message> list) throws ParserConfigurationException, SAXException, IOException  {
		//ͨ��Two��ȡ
		GetJdbc jd=Two.getJdbc(file);
		Connection con=DbUtil.getCon(jd);
		PreparedStatement ps=null;
		String sql;
//		Statement sta=null;
		sql="insert into Message values (?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			for(int i=0;i<list.size();i++) {
				ps.setString(1, list.get(i).getId());
				ps.setString(2, list.get(i).getName());
				ps.setInt(3, list.get(i).getAge());
				ps.addBatch();
			}
//			����������ˣ�����������
			ps.executeBatch();
//			����������ˣ�����������
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.Close(null, ps, con);
	}

}
class Message{
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	private String id;
	private String name;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Message(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Message() {
		super();
	}
	
}
