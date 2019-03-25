//package com.aowin.daobasic;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.ibatis.session.SqlSession;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.w3c.dom.ls.LSInput;
//
//import com.aowin.dao.TuserMapper;
//import com.aowin.model.People;
//import com.aowin.util.Dbutil;
//import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
///**
// * mybatis�����Ĳ���
// * @author Administrator
// *
// */
//class TuserMapperTest {
//	SqlSession sqlsession;
//	TuserMapper mapper;
//	@BeforeEach
//	void setUp() throws Exception {
//		sqlsession=Dbutil.openSession();
//		mapper=sqlsession.getMapper(TuserMapper.class);
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		sqlsession.commit();
//	}
//
//	@Test
//	void testInsertUser() {
//		People people=new People("����2018", 1, "home", 1231);
//		mapper.insertUser(people);
//	}
//
//	@Test
//	void testBatchInserta() {
//		//����id���������������������������
//		//����id������°��ո�����id��д���ݣ�
//		People people=new People("����2019", 1, "home", 1231);
//		People people2=new People(999,"����2019", 1, "home", 1231);
////		ArrayList<People> list=new ArrayList<>();
////		list.add(people);
////		list.add(people2);
////		mapper.batchInserta(list);
//	}
//
//	@Test
//	void testBatchInsertb() {
//
//	}
//
//	@Test
//	void testUpdateUser() {
//		People people=new People(143,"����2019", 1, "home", 1231);
//		Map<String, Object> map=new HashMap<>();
//		map.put("id", 143);
//		map.put("rename","lili");
//		mapper.updateUser(map);
//	}
//
//	@Test
//	void testDeleteUser() {
//		ArrayList<Integer> list=new ArrayList<>();
//		list.add(135);
//		list.add(136);
//		mapper.deleteUser(list);
//	}
//
//	@Test
//	void testSelectUser() {
//		ArrayList<People> list = mapper.selectUser(138, "����");
//		System.out.println(list);
//	}
//
//	@Test
//	void testSelectMapUser() {
//		
//	}
//
//	@Test
//	void testSelectLikeUser() {
//		Map<String,Object> map = new HashMap<>();
//		map.put("tablename", "people");
//		map.put("id", 138);
//		map.put("salary", "");
//		ArrayList<People> list = mapper.selectLikeUser(map);
//		System.out.println(list);
//	}
//
//	@Test   //where-������ѯ
//	void testSelectWhereUser() {
//		Map<String,Object> map = new HashMap<>();
//		map.put("tablename", "people");
////		map.put("id", 138);
////		map.put("salary", "");
//		ArrayList<People> list = mapper.selectWhereUser(map);
//		System.out.println(list);
//	}
//
//	@Test
//	void testSelectChooseUser() {
//		Map<String,Object> map = new HashMap<>();
//		map.put("tablename", "people");
////		map.put("id", 138);
////		map.put("salary", "");
//		map.put("type", 1);
//		ArrayList<People> list = mapper.selectChooseUser(map);
//		System.out.println(list);
//	}
//
//	@Test
//	void testSelectUriUser() {
//
//	}
//
//	@Test
//	void testSelectResultMap() {
//
//	}
//
//}