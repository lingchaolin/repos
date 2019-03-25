package com.aowin.IOC;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SequenceTest {
	ClassPathXmlApplicationContext context;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		context.close();
	}

	@Test
	void testSequenceOne() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInfoOne() {
		context=new ClassPathXmlApplicationContext("springOne.xml");
		SequenceOne sequenceOne=context.getBean("sequenceOne",SequenceOne.class);
		Rule rule=context.getBean("sequenceOne",Rule.class);//接口注入
		sequenceOne.getInfo();
		rule.getInfo();//通过xml文件配置，效果等同于new一个对象。
	}
	@Test
	void testGetInfoTwo() {
		context=new ClassPathXmlApplicationContext("springTwo.xml");
		SequenceTwo sequenceTwo=context.getBean("sequenceTwo",SequenceTwo.class);
		System.out.println(sequenceTwo);
		sequenceTwo.getRule().getInfo();//里边的接口只能算setter注入。
	}
	@Test//构造器注入
	void testGetInfoThree() {
		context=new ClassPathXmlApplicationContext("springThree.xml");
		SequenceThree sequenceThree=context.getBean("sequenceThree",SequenceThree.class);
		System.out.println(sequenceThree);
	}
	@Test//手动注入
	void testGetInfoFour() {
		context=new ClassPathXmlApplicationContext("springFour.xml");
		SequenceFour springFour=context.getBean("sequenceFour",SequenceFour.class);
		springFour.getSequenceOne().getInfo();
	}
	@Test//自动注入
	void testGetInfoFive() {
		context=new ClassPathXmlApplicationContext("springFive.xml");
		SequenceFour sequenceFour=context.getBean("sequenceFour",SequenceFour.class);
		sequenceFour.getSequenceOne().getInfo();
	}
	@Test//注解注入
	void testGetInfoSix() {
		context=new ClassPathXmlApplicationContext("springSix.xml");
		SequenceSix sequenceSix=context.getBean("sequenceSix",SequenceSix.class);
		sequenceSix.getOne().getInfo();
		sequenceSix.getTwo().getInfo();
		sequenceSix.getThree().getInfo();
		sequenceSix.getFour().getInfo();
	}
	

}
