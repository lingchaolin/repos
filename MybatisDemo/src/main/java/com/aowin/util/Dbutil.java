package com.aowin.util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Dbutil {
	private static SqlSessionFactory  sqlSessionFactory;
	static {
		Resources.setCharset(Charset.forName("utf-8"));
		InputStream inputStream;
		
		try {
			inputStream=Resources.getResourceAsStream("Mybatis.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}
	public static void closeSession(SqlSession sqlSession) {
		if(sqlSession!=null) {
			sqlSession.close();
		}
	}
}
