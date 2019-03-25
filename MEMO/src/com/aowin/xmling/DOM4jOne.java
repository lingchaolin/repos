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
		aL.add(new Student(1,"����",20));
		aL.add(new Student(2,"����",22));
		aL.add(new Student(3,"����",25));
		
//		д�뷽��һ
//		WriteMethodOne(file);
//		д�뷽��һ
		WriteMethodTwo(file);
//		����д�뷽��
//		write(file,aL);
//		readMethodOne(file);
		//���϶�ȡ����
		ArrayList<Student> list = read(file);  
		
		for(Student stu:list) {
			System.out.println(stu);   
		}
	}
	public static void readMethodOne(File file) throws DocumentException {
		SAXReader reader =new SAXReader();
		Document doc=reader.read(file);
//		��һ�ַ�ʽ����ǩ�ĵ�����
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
//		��һ�ַ�ʽ����ǩ�ĵ�����
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
//		�ڶ��ַ�ʽ����ǩ��list�б�
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
		return al;//����Arrayist�б�
	}
	public static void WriteMethodOne(File file) throws IOException {
//		1.�����յ��ĵ���
		Document doc=DocumentHelper.createDocument();
//		2.������ǩͬʱ��ɱ�ǩ�����--������ǩ�����ñ�ǩ֮��Ĺ�ϵ����һ��--˭���ӱ�ǩ˭���
		Element root=doc.addElement("classroom");
//		���ñ�ǩ����
		Element student=root.addElement("student");
		student.addAttribute("id", "1");
		
		Element no=student.addAttribute("no", "100");
		no.setText("1234");
		student.addElement("name").setText("����");
//		���ĵ�д���ļ�--���ַ�ʽ
//		1.������xmlWriter
		
//		����OutputFormat
		OutputFormat format=new OutputFormat();
		format.setEncoding("utf-8");//�趨���뷽ʽ
		FileWriter fw=new FileWriter(file);
		XMLWriter writer=new XMLWriter(fw,format);
		 writer.write(doc);
		 writer.flush();
		 writer.close();

		
	}
	public static void WriteMethodTwo(File file) throws IOException {
//		1.�����յ��ĵ���
		Document doc=DocumentHelper.createDocument();
//		2.������ǩͬʱ��ɱ�ǩ�����--������ǩ�����ñ�ǩ֮��Ĺ�ϵ����һ��--˭���ӱ�ǩ˭���
		Element root=doc.addElement("classroom");
//		���ñ�ǩ����
		Element student=root.addElement("student");
		student.addAttribute("id", "1");
		
		Element no=student.addAttribute("no", "100");
		no.setText("dgrgg");
		student.addElement("name").setText("����");
//		2.document--�ַ����ķ�ʽ
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file),"gbk"));
		doc.write(bw);
		bw.flush();
		bw.close();
	}
	//ͨ��ArrayList����
	public static void write(File file,ArrayList<Student> list) throws IOException {
		Document doc=DocumentHelper.createDocument();

		Element root=doc.addElement("classroom");
		int count=0;
		for(Student stu:list) {
			Element student=root.addElement("student");
	//		���ñ�ǩ����
			count++;
			student.addAttribute("id", String.valueOf(count));
	//		student���¼���ǩ--�����ı�����
			Element no=student.addElement("no");
			no.setText(String.valueOf(stu.getNo()));
	//		student���¼���ǩ--�����ı�����
			student.addElement("name").setText(stu.getName());;
			student.addElement("age").setText(String.valueOf(stu.getAge()));
		}
		//�ڶ��ַ�ʽ���ַ���
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file), "utf-8"));//  ת��Ϊutf-8����
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