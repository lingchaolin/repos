package com.aowin.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**JDBC
 *����ִ��SQL��䣬�Լ�SQLע�����⣻
 *
 */
public class MyStateMent {
	public  static void main(String[]args){
	//����JDBC//����������
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			stmt=(Statement) con.createStatement();
			String name="���� ";
			String sql="insert into t_user(username,pwd,regTime)values('"+name+"',5555,now())";
			//�ɹ������ݼ��˽�ȥ
			//Statement���׷���SQLע���Σ��
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
