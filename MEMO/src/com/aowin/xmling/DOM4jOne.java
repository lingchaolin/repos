package com.aowin.xmling;

import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4jOne {

	public static void main(String[] args) throws Exception {
		File file=new File("D:/Class/work/two.xml");
		ArrayList<Student> aL = new ArrayList<Student>();
		aL.add(new Student(1,"张三",20));
		aL.add(new Student(2,"李四",22));
		aL.add(new Student(3,"王五",25));
		
//		写入方法一
//		WriteMethodOne(file);
//		写入方法一
		WriteMethodTwo(file);
//		集合写入方法
//		write(file,aL);
//		readMethodOne(file);
		//集合读取方法
		ArrayList<Student> list = read(file);  
		
		for(Student stu:list) {
			System.out.println(stu);   
		}
	}
	public static void readMethodOne(File file) throws DocumentException {
		SAXReader reader =new SAXReader();
		Document doc=reader.read(file);
//		第一种方式：标签的迭代器
		Element root=doc.getRootElement();
		Iterator<Element> it=root.elementIterator();
		while(it.hasNext()) {
			Element student=it.next();
			System.out.println("id="+student.attributeValue("id"));
			Iterator<Element> it2=student.elementIterator();
			while(it2.hasNext()) {
				Element child=it2.next();
				System.out.println(child.getText());
			}
		}
	}
	public static ArrayList read(File file) throws DocumentException {
		SAXReader reader =new SAXReader();
		Document doc=reader.read(file);
//		第一种方式：标签的迭代器
//		Element root=doc.getRootElement();
//		Iterator<Element> it=root.elementIterator();
//		while(it.hasNext()) {
//			Element student=it.next();
//			System.out.println("id="+student.attributeValue("id"));
//			Iterator<Element> it2=student.elementIterator();
//			while(it2.hasNext()) {
//				Element child=it2.next();
//				System.out.println(child.getText());
//			}
//		}
//		第二种方式：标签的list列表
		ArrayList<Student> al=new ArrayList<Student>();
		Element root=doc.getRootElement();
		List<Element>studentList=root.elements();
		for(Element student:studentList) {
			Student stu=new Student();
			List<Element>childList=student.elements();
			String no=childList.get(0).getText();
			stu.setNo(Integer.parseInt(no));
			stu.setName(childList.get(1).getText());
			
			String age=childList.get(2).getText();
			stu.setNo(Integer.parseInt(age));
			al.add(stu);
		}
		return al;//返回Arrayist列表
	}
	public static void WriteMethodOne(File file) throws IOException {
//		1.创建空的文档树
		Document doc=DocumentHelper.createDocument();
//		2.创建标签同时完成标签的添加--创建标签和设置标签之间的关系二合一；--谁的子标签谁添加
		Element root=doc.addElement("classroom");
//		设置标签属性
		Element student=root.addElement("student");
		student.addAttribute("id", "1");
		
		Element no=student.addAttribute("no", "100");
		no.setText("1234");
		student.addElement("name").setText("张三");
//		将文档写入文件--两种方式
//		1.借助于xmlWriter
		
//		创建OutputFormat
		OutputFormat format=new OutputFormat();
		format.setEncoding("utf-8");//设定编码方式
		FileWriter fw=new FileWriter(file);
		XMLWriter writer=new XMLWriter(fw,format);
		 writer.write(doc);
		 writer.flush();
		 writer.close();

		
	}
	public static void WriteMethodTwo(File file) throws IOException {
//		1.创建空的文档树
		Document doc=DocumentHelper.createDocument();
//		2.创建标签同时完成标签的添加--创建标签和设置标签之间的关系二合一；--谁的子标签谁添加
		Element root=doc.addElement("classroom");
//		设置标签属性
		Element student=root.addElement("student");
		student.addAttribute("id", "1");
		
		Element no=student.addAttribute("no", "100");
		no.setText("dgrgg");
		student.addElement("name").setText("张三");
//		2.document--字符流的方式
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file),"gbk"));
		doc.write(bw);
		bw.flush();
		bw.close();
	}
	//通过ArrayList导入
	public static void write(File file,ArrayList<Student> list) throws IOException {
		Document doc=DocumentHelper.createDocument();

		Element root=doc.addElement("classroom");
		int count=0;
		for(Student stu:list) {
			Element student=root.addElement("student");
	//		设置标签属性
			count++;
			student.addAttribute("id", String.valueOf(count));
	//		student的下级标签--设置文本内容
			Element no=student.addElement("no");
			no.setText(String.valueOf(stu.getNo()));
	//		student的下级标签--设置文本内容
			student.addElement("name").setText(stu.getName());;
			student.addElement("age").setText(String.valueOf(stu.getAge()));
		}
		//第二种方式：字符流
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file), "utf-8"));//  转换为utf-8数据
			doc.write(bw); 
			bw.flush();
			bw.close(); 
	}
}
class Student{
	private int no;
	private String name;
	private int age;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public Student(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
}