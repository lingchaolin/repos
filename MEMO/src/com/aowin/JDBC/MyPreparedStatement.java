package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**JDBC
 *测试PreparedStatement；
 *
 */
public class MyPreparedStatement {
	public  static void main(String[]args){
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			String sql="insert into t_user(username,pwd,regTime) values(?,?,?)";//插入的目标和占位符数量要保持一致
			//?占位符-可以避免sql注入
			ps=con.prepareStatement(sql);
			ps.setString(1, "路飞");//-此处参数索引从1开始算起，而不是0；
			ps.setString(2, "123456");
			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
//			sql中国插入的时间类型是java.sql.Date();要注意
//			ps.setObject(parameterIndex, x);//Object--忽略类型
			System.out.println("插入记录");
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
				ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) {
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
