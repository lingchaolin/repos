package com.aowin.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aowin.cla.ClassA;
import com.aowin.cla.ClassB;
import com.aowin.cla.ClassC;
import com.aowin.cla.ClassD;
import com.aowin.cla.InterfaceOne;

class PeopleDaoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testBasicIOC() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springtest1.xml");
		ClassA classA=context.getBean("classa",ClassA.class);
		InterfaceOne intera=context.getBean("classa",InterfaceOne.class);
		ClassB classB=context.getBean("classb",ClassB.class);//名字必须与配置的一致，否则异常；
		classA.getInfo();
		intera.getInfo();
		classB.getInfo();
	}
	@Test  //setter注入+接口注入
	void testSetterIOC() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springtest2.xml");
		ClassC classC=context.getBean("classc",ClassC.class);
		classC.getInfo();
//		接口注入
		System.out.println(classC.getInterfaceOne());
	}
	@Test  //构造器注入
	void testConstruIOC() {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springtest3.xml");
		ClassD classD=context.getBean("classd",ClassD.class);
		System.out.println(classD);
	}

}
