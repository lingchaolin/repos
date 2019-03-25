package com.aowin.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TestA {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String password="123456";
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
			//连接数据库
			//Connection 接口:负责和指定的数据库连接，
			Connection con=(Connection)DriverManager.getConnection(url, user,password);
			System.out.println("数据库连接成功:"+con);
			System.out.println("finish");
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载失败！原因是:"+e.getMessage());
		}catch(SQLException e) {
			System.err.println("数据库连接失败："+e.getMessage());
		}
		//连接数据库要提供的参数-url-用户名-密码
		//url--协议-jdbc：mysql://local:3306/数据库名
		//用户名-root  密码-
	}

}
