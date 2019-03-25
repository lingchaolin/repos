package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
//失败，原因未知
/**JDBC
 * 测试批处理--避免使用preparedStatement;--预编译空间有限
 */
public class MyBatchStatement {
	public  static void main(String[]args){
		java.sql.Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			con.setAutoCommit(false);//设为手动提交
			long start=System.currentTimeMillis();
			stmt=(Statement) con.createStatement();
			for(int i=0;i<200;i++) {
				stmt.addBatch("insert into t_user_2(username,pwd,regTime) values ('gao',666666,now())");
			}
			stmt.executeBatch();
			con.commit();//提交事务
			long end=System.currentTimeMillis();
			System.out.println(end-start);
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
