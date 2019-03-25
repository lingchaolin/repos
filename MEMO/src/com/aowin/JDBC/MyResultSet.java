package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**JDBC
 *����PreparedStatement��
 *-excute();--����bollean����
 *-excute();--���ؽ����
 *-excuteUpdate();--���ظ��µ�����
 */
public class MyResultSet {
	public  static void main(String[]args){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			String sql="select id,username,pwd from t_user where id>?";//���¼
			ps=con.prepareStatement(sql);
			ps.setObject(1, 2);
			rs=ps.executeQuery();//--���ؽ����
			while(rs.next()) {
//				int num=test(rs);
				int num=rs.getInt(1);
				System.out.println(num);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			/**
			 * �ر�˳��resultset-->statement-->connection�����Ĺر�˳�򣻲��ܺϲ�
			 */
			try {
				if(rs!=null) {
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	public static int  test(ResultSet rs) {
		try {
			System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3));
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Integer) null;
	}
}
