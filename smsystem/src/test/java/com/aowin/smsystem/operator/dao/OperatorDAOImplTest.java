package com.aowin.smsystem.operator.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.aowin.smsystem.operator.pojo.Operators;

class OperatorDAOImplTest {
	private OperatorDAO operatordao;
	private FileSystemXmlApplicationContext context;
	@BeforeEach
	void setUp() throws Exception {
		context=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
		operatordao=context.getBean(OperatorDAO.class);
	}

	@AfterEach
	void tearDown() throws Exception {
		operatordao=null;
		context.close();
	}

	@Test
	void testInsertOperator() {
		Operators o=new Operators();
		o.setOperatorname("¹¤ºÅ9527");
		o.setUsername("ÕÅÈý");
		o.setUserpwd("123456");
		o.setIsadmin("N");
		o.setOperatorsex("1");
		
		try {
			assertEquals(operatordao.insertOperator(o), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetOperators() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTotalPages() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllOperators() {
		fail("Not yet implemented");
	}

	@Test
	void testGettotalrecords() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOperatorsById() {
		Operators o = operatordao.getOperatorsById(3);
		System.out.println("otest:"+o);
	}

	@Test
	void testUpdateOperators() {
		Operators o=new Operators();
		o.setOperatorid(10);
	}

	@Test
	void testDeleteOperator() {
		int operatorid=10;
		try {
			operatordao.deleteOperator(operatorid);			
			System.out.println("É¾³ý³É¹¦");
		} catch (Exception e) {
			System.out.println("É¾³ýÊ§°Ü");
			e.printStackTrace();
		}
	}

	@Test
	void testDeleteOperators() {
		 ArrayList<Integer> operatorids=new ArrayList<>();
		 operatorids.add(14);
		 operatorids.add(15);
		try {
			operatordao.deleteOperators(operatorids);
			System.out.println("É¾³ý³É¹¦");
		} catch (Exception e) {
			System.out.println("É¾³ýÊ§°Ü");
			e.printStackTrace();
		}
	}

	@Test
	void testgetoperatorbyusernameandpwd() {
		Operators o=new Operators();
		o.setUsername("Tom1");
		o.setUserpwd("12345678");
		try {
			System.out.println(operatordao.getoperatorbyusernameandpwd(o));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
