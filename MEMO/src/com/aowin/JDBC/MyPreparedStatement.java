package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**JDBC
 *����PreparedStatement��
 *
 */
public class MyPreparedStatement {
	public  static void main(String[]args){
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			String sql="insert into t_user(username,pwd,regTime) values(?,?,?)";//�����Ŀ���ռλ������Ҫ����һ��
			//?ռλ��-���Ա���sqlע��
			ps=con.prepareStatement(sql);
			ps.setString(1, "·��");//-�˴�����������1��ʼ���𣬶�����0��
			ps.setString(2, "123456");
			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
//			sql�й������ʱ��������java.sql.Date();Ҫע��
//			ps.setObject(parameterIndex, x);//Object--��������
			System.out.println("�����¼");
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
