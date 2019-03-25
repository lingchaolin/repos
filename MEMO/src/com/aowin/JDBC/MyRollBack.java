package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/**JDBC
 * 事务--同时成功/同时失败--处理单元
 * 开始于：连接到数据库，并执行一条DML语句
 * 
 * 结束于：DDL/DCL/断开连接/COMMIT-提交/ROLLBACK回滚
 * 
 * 测试事务
 */
public class MyRollBack {
	public  static void main(String[]args) {
		java.sql.Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
//		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			
			con.setAutoCommit(false);//默认自动提交
//			String sql="insert into t_user (username,pwd) values (?,?)";
			ps1=con.prepareStatement("insert into t_user_2 (username,pwd) values(?,?)");
//			insert into t_user(username,pwd,regTime) values(?,?,?)
			ps1.setString(1, "太一");//-此处参数索引从1开始算起，而不是0；
			ps1.setString(2, "123456");
			ps1.execute();
			System.out.println("插入一个用户");
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps2=con.prepareStatement("insert into t_user_2 (username,pwd) values (?,?,?)");
			ps2.setObject(1, "second");
			ps2.setObject(2, "124432");
			ps2.execute();
			System.out.println("在插入一个用户");
			con.commit();
//			rs=ps1.executeQuery();//--返回结果集
//			while(rs.next()) {
//				System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3));
//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				con.rollback();//出现异常--回滚，都不成功
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			/**
			 * 关闭顺序：resultset-->statement-->connection这样的关闭顺序；不能合并
			 */
			try {
				if(ps2!=null) {
					ps2.close();
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ps1!=null) {
				ps1.close();
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
