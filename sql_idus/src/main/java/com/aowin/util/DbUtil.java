package com.aowin.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

public class DbUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			//1.读取配置文件 默认是从classpath路径下读取
			Resources.setCharset(Charset.forName("utf-8"));
			InputStream inputStream;
				inputStream = Resources.getResourceAsStream("mybatis.xml");
			
			//2.创建SqlSessionFactory对象  通过builder设计模式创建
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession openSession() {
		System.out.println("sqlSessionFactory:"+sqlSessionFactory);
		System.out.println(sqlSessionFactory.openSession());
		return sqlSessionFactory.openSession();
	}
	public static void close(SqlSession sqlSession) {
		if(sqlSession!=null)sqlSession.close();
	}
}
