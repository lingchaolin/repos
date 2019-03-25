package com.aowin.daobasic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aowin.dao.AppraiseMapper;
import com.aowin.model.Appraise;
import com.aowin.util.Dbutil;

class AppraiseMapperTest {
	SqlSession sqlsession;
	AppraiseMapper mapper;
	@BeforeEach
	void setUp() throws Exception {
		sqlsession=Dbutil.openSession();
		mapper=sqlsession.getMapper(AppraiseMapper.class);
	}

	@AfterEach
	void tearDown() throws Exception {
		sqlsession.commit();
	}

	@Test
	void test() {
//		String appraiseId="10108";
//		ArrayList<Map<String, Object>> list=mapper.selectAppraise(appraiseId);
//		for(Map<String, Object> li:list) {
//			System.out.println(li.keySet());
//			System.out.println(li.values());
//		}
//		Appraise appraise=new Appraise();
//		for(char ch='a';ch<'p';ch++) {
//			appraise.setAppraiseId(ch);
//			appraise.setOrderNo(ch+ch+ch+"No");
//			appraise.setObjId(ch+ch+ch+"obj");
//			appraise.setStarClass(0.12);
//			appraise.setUserId(ch+ch+ch+"user");
//			appraise.setIsHavePic(ch+1);
//			appraise.setIsReply(ch+0);
//			mapper.insertAppraise(appraise);
//		}
		char ch = 'x';
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("appraiseId","id");
		map.put("orderNo",ch+ch+ch+"No");
		map.put("objId",ch+ch+ch+"obj");
		map.put("isHavePic",0.12);
		map.put("userId",ch+ch+ch+"user");
		map.put("starClass",0.13);
		map.put("isReply",ch+0);
		mapper.insertAppraiseMap(map);
		System.out.println("finish");
	}
	@Test
	void test2() {
		int appraiseId=104;
		ArrayList<Appraise> list=mapper.selectAppraise(appraiseId);
		for(Appraise li:list) {
			System.out.println(li);
		}
		System.out.println(list);
		System.out.println("finish");
	}
}
