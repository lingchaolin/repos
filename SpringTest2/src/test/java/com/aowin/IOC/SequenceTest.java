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
		Rule rule=context.getBean("sequenceOne",Rule.class);//�ӿ�ע��
		sequenceOne.getInfo();
		rule.getInfo();//ͨ��xml�ļ����ã�Ч����ͬ��newһ������
	}
	@Test
	void testGetInfoTwo() {
		context=new ClassPathXmlApplicationContext("springTwo.xml");
		SequenceTwo sequenceTwo=context.getBean("sequenceTwo",SequenceTwo.class);
		System.out.println(sequenceTwo);
		sequenceTwo.getRule().getInfo();//��ߵĽӿ�ֻ����setterע�롣
	}
	@Test//������ע��
	void testGetInfoThree() {
		context=new ClassPathXmlApplicationContext("springThree.xml");
		SequenceThree sequenceThree=context.getBean("sequenceThree",SequenceThree.class);
		System.out.println(sequenceThree);
	}
	@Test//�ֶ�ע��
	void testGetInfoFour() {
		context=new ClassPathXmlApplicationContext("springFour.xml");
		SequenceFour springFour=context.getBean("sequenceFour",SequenceFour.class);
		springFour.getSequenceOne().getInfo();
	}
	@Test//�Զ�ע��
	void testGetInfoFive() {
		context=new ClassPathXmlApplicationContext("springFive.xml");
		SequenceFour sequenceFour=context.getBean("sequenceFour",SequenceFour.class);
		sequenceFour.getSequenceOne().getInfo();
	}
	@Test//ע��ע��
	void testGetInfoSix() {
		context=new ClassPathXmlApplicationContext("springSix.xml");
		SequenceSix sequenceSix=context.getBean("sequenceSix",SequenceSix.class);
		sequenceSix.getOne().getInfo();
		sequenceSix.getTwo().getInfo();
		sequenceSix.getThree().getInfo();
		sequenceSix.getFour().getInfo();
	}
	

}
