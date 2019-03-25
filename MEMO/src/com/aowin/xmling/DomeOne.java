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

/**xml可扩展标记语言
 * 存储和传输数据
 * 扩展性，移植性比html更好
 * java EE后台服务器的配置文件绝大多数使用xml格式文档
 * 	Android开发 中页面布局文件全部使用的是xml格式文件
 * 
 * XML解析 --读取xml文档并将其分解为多个可以进行分析的元素
 * 常用解析器：DOM，SAX,JDOM,DOM4J;
 * DOM:	文档对象模型(Document Object Model) w3c指定的标准
 */
public class DomeOne {
	public static void main(String[] args) throws Exception {
		File file=new File("D:/Class/work/one.xml");
//		write(file);
		read(file);
	}
	//1.在内存中创建空的文档树，创建标签，添加到文档树，将文档树传输至文件
	public static void write(File file) throws Exception {
		//创建文档树--解析器创建//?工厂模式
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();//--获得实例
//		解析器--使其从 XML 文档获取 DOM 文档实例。使用此类，应用程序员可以从 XML 获取一个 Document。
		DocumentBuilder builder=factory.newDocumentBuilder();//获取 DOM 文档实例-Document类型
//	    空的文档树
		Document document=builder.newDocument();
//		创建标签--创建root标签-参数为标签名称
		Element root=document.createElement("classroom");
		Element student=document.createElement("student");
		//给标签设置属性：(属性名称，属性值)
		student.setAttribute("id", "1");//setAttribute(String name, Object value) 允许用户在底层实现上设置特定属性。
		
		//创建no标签
		Element no=document.createElement("no");
		//设置文本内容
		no.setTextContent("123");
		Element name=document.createElement("name");
		//设置文本内容
		name.setTextContent("hinata");
		Element age=document.createElement("age");
		//设置文本内容
		age.setTextContent("12");
		//设置标签之间的关系
		student.appendChild(no);
		student.appendChild(name);
		student.appendChild(age);
		root.appendChild(student);
		document.appendChild(root);//添加根目录
		//将文档树传入数据
		//传输工厂
		TransformerFactory tf=TransformerFactory.newInstance();
		//传输器
		Transformer former=tf.newTransformer();
		//将document转为DOMSource
		DOMSource source=new DOMSource(document);
		//file转为StreamResult
		StreamResult result=new StreamResult(file);
		former.transform(source, result);
	}
	public static void read(File file) throws ParserConfigurationException, SAXException, IOException {
		//读文档--解析--遍历
		//读取--解析成文档树
		DocumentBuilder builder =DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document =builder.parse(file);
//		Document parse(File f)  将给定文件的内容解析为一个 XML 文档，并且返回一个新的 DOM Document 对象。 
		//遍历方式
//		1.从根节点开始遍历
		//获取根节点--Node getFirstChild()此节点的第一个子节点。如果没有这样的节点，则返回 null。 
		Node root=document.getFirstChild();
		//getChildNodes() 包含此节点的所有子节点的 NodeList
		NodeList studentList=root.getChildNodes();
		//遍历
		for(int i=0;i<studentList.getLength();i++) {
			Node student =studentList.item(i);//item(int index)--返回集合中的第 index 个项。
			Element e=(Element)student;//转型为Element
			String id=e.getAttribute("id");
			System.out.println("id=："+id);
			NodeList childList=student.getChildNodes();//获取子节点
//			NodeList childList=e.getChildNodes();??
			for(int j=0;j<childList.getLength();j++) {
				Node child=childList.item(j);//Node--节点
//				getTextContent() 此属性返回此节点及其后代的文本内容。--??后代的文本？？
				String content=child.getTextContent();
				System.out.println(content);
			}
		}
		
//		2.随机标签访问
		NodeList studentList2=document.getElementsByTagName("student");
		for(int i=0;i<studentList2.getLength();i++) {
			Node student =studentList2.item(i);
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
	}

}
