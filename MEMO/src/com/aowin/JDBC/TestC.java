package com.aowin.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestC {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String password="123456";
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection)DriverManager.getConnection(url, user,password);
			System.out.println("finish");
		} catch(Exception e) {
			System.err.println("："+e.getMessage());
		}
		String sql=null;
		Statement stm=null;
		try {
			stm=(Statement) con.createStatement();
//			con.setAutoCommit(false);//设为手动提交--默认为自动提交
			
			for(int i=0;i<200;i++) {
				sql="insert into student values("+(99999+i)+",'ACE',25,'男','math',5)";
				stm.addBatch(sql);
			}
			stm.executeBatch();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
