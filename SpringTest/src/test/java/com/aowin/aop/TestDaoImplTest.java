package com.aowin.aop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aowin.cla.ClassA;
import com.aowin.cla.ClassB;
import com.aowin.cla.InterfaceOne;

class TestDaoImplTest {
	ClassPathXmlApplicationContext context;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		context.close();
	}

	@Test
	void testGetInfo() {
		context=new ClassPathXmlApplicationContext("springAop.xml");
		TestDao td=context.getBean("proxy",TestDao.class);
		td.getInfo("张三", 12);
	}
	@Test
	void testIOCGetInfo() {
		context=new ClassPathXmlApplicationContext("springAop.xml");
		TestDao td=context.getBean("proxy",TestDao.class);
		td.getInfo("张三", 12);
		
	}
	@Test
	void testAutoGetInfo() {
		context=new ClassPathXmlApplicationContext("springAopAutoProxy.xml");
		TestDao td=context.getBean("testdaoimpl",TestDao.class);
		td.getInfo("张三", 12);
	}
	@Test
	void testAnnotationGetInfo() {
		context=new ClassPathXmlApplicationContext("springAopAnnotation.xml");
		TestDao td=context.getBean("testdaoimpl",TestDao.class);
		td.getInfo("张三", 12);
	}
	@Test
	void testTime() {
		context=new ClassPathXmlApplicationContext("springCountTime.xml");
		TestDao td=context.getBean("testdaoimpl",TestDao.class);
		td.getInfo("张三", 12);
	}

	@Test
	void testGetInfo2() {
		fail("Not yet implemented");
	}

	@Test
	void testInsertInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteInfo() {
		fail("Not yet implemented");
	}

}
