package com.aowin.xmling;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**xml����չ�������
 * �洢�ʹ�������
 * ��չ�ԣ���ֲ�Ա�html����
 * java EE��̨�������������ļ��������ʹ��xml��ʽ�ĵ�
 * 	Android���� ��ҳ�沼���ļ�ȫ��ʹ�õ���xml��ʽ�ļ�
 * 
 * XML���� --��ȡxml�ĵ�������ֽ�Ϊ������Խ��з�����Ԫ��
 * ���ý�������DOM��SAX,JDOM,DOM4J;
 * DOM:	�ĵ�����ģ��(Document Object Model) w3cָ���ı�׼
 */
public class DomeOne {
	public static void main(String[] args) throws Exception {
		File file=new File("D:/Class/work/one.xml");
//		write(file);
		read(file);
	}
	//1.���ڴ��д����յ��ĵ�����������ǩ����ӵ��ĵ��������ĵ����������ļ�
	public static void write(File file) throws Exception {
		//�����ĵ���--����������//?����ģʽ
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();//--���ʵ��
//		������--ʹ��� XML �ĵ���ȡ DOM �ĵ�ʵ����ʹ�ô��࣬Ӧ�ó���Ա���Դ� XML ��ȡһ�� Document��
		DocumentBuilder builder=factory.newDocumentBuilder();//��ȡ DOM �ĵ�ʵ��-Document����
//	    �յ��ĵ���
		Document document=builder.newDocument();
//		������ǩ--����root��ǩ-����Ϊ��ǩ����
		Element root=document.createElement("classroom");
		Element student=document.createElement("student");
		//����ǩ�������ԣ�(�������ƣ�����ֵ)
		student.setAttribute("id", "1");//setAttribute(String name, Object value) �����û��ڵײ�ʵ���������ض����ԡ�
		
		//����no��ǩ
		Element no=document.createElement("no");
		//�����ı�����
		no.setTextContent("123");
		Element name=document.createElement("name");
		//�����ı�����
		name.setTextContent("hinata");
		Element age=document.createElement("age");
		//�����ı�����
		age.setTextContent("12");
		//���ñ�ǩ֮��Ĺ�ϵ
		student.appendChild(no);
		student.appendChild(name);
		student.appendChild(age);
		root.appendChild(student);
		document.appendChild(root);//��Ӹ�Ŀ¼
		//���ĵ�����������
		//���乤��
		TransformerFactory tf=TransformerFactory.newInstance();
		//������
		Transformer former=tf.newTransformer();
		//��documentתΪDOMSource
		DOMSource source=new DOMSource(document);
		//fileתΪStreamResult
		StreamResult result=new StreamResult(file);
		former.transform(source, result);
	}
	public static void read(File file) throws ParserConfigurationException, SAXException, IOException {
		//���ĵ�--����--����
		//��ȡ--�������ĵ���
		DocumentBuilder builder =DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document =builder.parse(file);
//		Document parse(File f)  �������ļ������ݽ���Ϊһ�� XML �ĵ������ҷ���һ���µ� DOM Document ���� 
		//������ʽ
//		1.�Ӹ��ڵ㿪ʼ����
		//��ȡ���ڵ�--Node getFirstChild()�˽ڵ�ĵ�һ���ӽڵ㡣���û�������Ľڵ㣬�򷵻� null�� 
		Node root=document.getFirstChild();
		//getChildNodes() �����˽ڵ�������ӽڵ�� NodeList
		NodeList studentList=root.getChildNodes();
		//����
		for(int i=0;i<studentList.getLength();i++) {
			Node student =studentList.item(i);//item(int index)--���ؼ����еĵ� index ���
			Element e=(Element)student;//ת��ΪElement
			String id=e.getAttribute("id");
			System.out.println("id=��"+id);
			NodeList childList=student.getChildNodes();//��ȡ�ӽڵ�
//			NodeList childList=e.getChildNodes();??
			for(int j=0;j<childList.getLength();j++) {
				Node child=childList.item(j);//Node--�ڵ�
//				getTextContent() �����Է��ش˽ڵ㼰�������ı����ݡ�--??������ı�����
				String content=child.getTextContent();
				System.out.println(content);
			}
		}
		
//		2.�����ǩ����
		NodeList studentList2=document.getElementsByTagName("student");
		for(int i=0;i<studentList2.getLength();i++) {
			Node student =studentList2.item(i);
			Element e=(Element)student;
			String id=e.getAttribute("id");
			System.out.println("id=��"+id);
			NodeList childList=student.getChildNodes();
			for(int j=0;j<childList.getLength();j++) {
				Node child=childList.item(j);
				String content=child.getTextContent();
				System.out.println(content);
			}
		}
	}

}
