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
/**整理反射的作业
 * 
 */
/**DOM-读代码
 * 1.创建空的文档树
 * 	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();//--获得实例
 *	DocumentBuilder builder=factory.newDocumentBuilder();//获取 DOM 文档实例-Document类型
 *	Document document=builder.newDocument();
 * 2.创建标签--通过上边的Document对象来创建标签
 *  给标签设置属性-Element root=document.createElement("classroom");
 *	给标签设置属性-element.setAttribute("id", "1");
 *	设置文本内容-no.setTextContent("123")=
 *3.设置标签关系--谁的下级标签谁添加
 *	添加根目录-document.appendChild(root);
 *	添加下级标签student.appendChild(age);
 *4.将文档树传入数据
 *	TransformerFactory tf=TransformerFactory.newInstance();
 *	Transformer former=tf.newTransformer();
 *	--former.transform(source,result)
 *	将-源-文档树-转为DOMSource--DOMSource source=new DOMSource(document);
 *	将目标文件夹file转为StreamResult--StreamResult result=new StreamResult(file);
 *	former.transform(source, result);
 */
/**DOM-读代码
 * 
 * DocumentBuilder builder =DocumentBuilderFactory.newInstance().newDocumentBuilder();
	获取文档树Document document =builder.parse(file);
	2种遍历方式--获得某标签-然后遍历其下的元素
	1.从根节点开始遍历
	Node root=document.getFirstChild();//获取根节点
	NodeList studentList=root.getChildNodes();//获得根节点下的elementList
	2.随机标签访问--优点
	NodeList studentList2=document.getElementsByTagName("student");
	
	开始遍历
	for(int i=0;i<studentList.getLength();i++) {
		Node student =studentList.item(i);
		Element e=(Element)student;
		String id=e.getAttribute("id");
		System.out.println("id=："+id);
		NodeList childList=student.getChildNodes();
		for(int j=0;j<childList.getLength();j++) {
			Node child=childList.item(j);
			String content=child.getTextContent();
			System.out.println(content);
		}
	}
 * 
 */
/**DOM4j-写入到xml
 * 
 * 
 */
/**DOM4j-读代码
 * 
 */
	public static void main() throws ParserConfigurationException {
				
	}
}
