package com.aowin.IOC;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aowin.aop.TestDao;
import com.aowin.aop.TestDaoImpl;

class SequenceAopTest {
	ClassPathXmlApplicationContext context;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		context.close();
	}
	@Test
	void testAopOne() {
		context=new ClassPathXmlApplicationContext("springAopOne.xml");
		TestDao testDaoImpl=context.getBean("proxy",TestDao.class);
		System.out.println(testDaoImpl.getInfo("张三", 12));
	}
	@Test
	void testAopTwo() {
		context=new ClassPathXmlApplicationContext("springAopTwo.xml");
		TestDao testDao=context.getBean("testDaoImpl",TestDao.class);
		System.out.println(testDao.getInfo("张三", 12));
	}
	@Test
	void testAopThree() {
		context=new ClassPathXmlApplicationContext("springAopThree.xml");
		TestDao testDao=context.getBean("testDaoImpl",TestDao.class);
		System.out.println(testDao.getInfo("张三", 12));
	}
	@Test
	void testAopCountTime() {
		context=new ClassPathXmlApplicationContext("springAopFourCountTime.xml");
		TestDao testDao=context.getBean("testDaoImpl",TestDao.class);
		System.out.println(testDao.getInfo("张三", 12));
	}

}
