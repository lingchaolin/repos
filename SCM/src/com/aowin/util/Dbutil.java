package com.aowin.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbutil {
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功");
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动异常，原因是:"+e.getMessage());
		}
	}
	public static Connection getConn() {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scm","root","123456");
			return conn;
		} catch (SQLException e) {
			System.err.println("connection连接数据库异常，原因是:"+e.getMessage());
			return null;
		}
	}
	public static void close(ResultSet rs,Statement stat,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
