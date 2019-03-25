package com.aowin.testspring.jdbc.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aowin.testspring.jdbc.pojo.Students;

class StudentDAOImplTest {
	
	private StudentDAO sd;
	private ClassPathXmlApplicationContext context;

	@BeforeEach
	void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("springJDBC.xml");
		sd = context.getBean("studentdaoimpl", StudentDAO.class);
	}

	@AfterEach
	void tearDown() throws Exception {
		sd = null;
		context.close();
	}

	@Test
	void testInsertStudent() {
		Students s = new Students();
		s.setStudentbirthday(Date.valueOf("1997-12-23"));
		s.setStudentname("ÀöÀö");
		s.setStudentsex("0");
		
		assertTrue(sd.insertStudent(s));
	}

}
