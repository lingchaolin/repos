package com.aowin.xmling;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.*;

public class AAAAA {
/**���������ҵ
 * 
 */
/**DOM-������
 * 1.�����յ��ĵ���
 * 	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();//--���ʵ��
 *	DocumentBuilder builder=factory.newDocumentBuilder();//��ȡ DOM �ĵ�ʵ��-Document����
 *	Document document=builder.newDocument();
 * 2.������ǩ--ͨ���ϱߵ�Document������������ǩ
 *  ����ǩ��������-Element root=document.createElement("classroom");
 *	����ǩ��������-element.setAttribute("id", "1");
 *	�����ı�����-no.setTextContent("123")=
 *3.���ñ�ǩ��ϵ--˭���¼���ǩ˭���
 *	��Ӹ�Ŀ¼-document.appendChild(root);
 *	����¼���ǩstudent.appendChild(age);
 *4.���ĵ�����������
 *	TransformerFactory tf=TransformerFactory.newInstance();
 *	Transformer former=tf.newTransformer();
 *	--former.transform(source,result)
 *	��-Դ-�ĵ���-תΪDOMSource--DOMSource source=new DOMSource(document);
 *	��Ŀ���ļ���fileתΪStreamResult--StreamResult result=new StreamResult(file);
 *	former.transform(source, result);
 */
/**DOM-������
 * 
 * DocumentBuilder builder =DocumentBuilderFactory.newInstance().newDocumentBuilder();
	��ȡ�ĵ���Document document =builder.parse(file);
	2�ֱ�����ʽ--���ĳ��ǩ-Ȼ��������µ�Ԫ��
	1.�Ӹ��ڵ㿪ʼ����
	Node root=document.getFirstChild();//��ȡ���ڵ�
	NodeList studentList=root.getChildNodes();//��ø��ڵ��µ�elementList
	2.�����ǩ����--�ŵ�
	NodeList studentList2=document.getElementsByTagName("student");
	
	��ʼ����
	for(int i=0;i<studentList.getLength();i++) {
		Node student =studentList.item(i);
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
 * 
 */
/**DOM4j-д�뵽xml
 * 
 * 
 */
/**DOM4j-������
 * 
 */
	public static void main() throws ParserConfigurationException {
				
	}
}
