package com.aowin.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**JDBC
 * Connection con=DriverManager.getConnection("jdbc:mysql://
 * 		host:port/database","user","password");
 * @author Administrator
 *
 */
public class MyConnect {
	public  static void main(String[]args){
	//加载JDBC//加载驱动类
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接，比较耗时；
			//这是connection对象管理的一个要点）
			//真正开发中，为了提高效率，都会使用连接池来管理对象
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			System.out.println(con);
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
