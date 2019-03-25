package com.aowin.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aowin.model.People;
import com.aowin.util.Dbutil;

class PersonMapperTest {
	private SqlSession sqlSession;
	private PersonMapper mapper;
	@BeforeEach
	void setUp() throws Exception {
		sqlSession=Dbutil.openSession();
		mapper=sqlSession.getMapper(PersonMapper.class);
		System.out.println("setUp finish");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetMess() {
		People people=mapper.getMess(1);
		System.out.println(people);
	}

}