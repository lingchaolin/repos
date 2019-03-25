package com.aowin.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**JDBC
 *测试执行SQL语句，以及SQL注入问题；
 *
 */
public class MyStateMent {
	public  static void main(String[]args){
	//加载JDBC//加载驱动类
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			stmt=(Statement) con.createStatement();
			String name="周期 ";
			String sql="insert into t_user(username,pwd,regTime)values('"+name+"',5555,now())";
			//成功将数据加了进去
			//Statement容易发生SQL注入的危险
			stmt.execute(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {
				stmt.close();
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
