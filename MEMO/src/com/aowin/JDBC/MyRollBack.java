package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/**JDBC
 * ����--ͬʱ�ɹ�/ͬʱʧ��--����Ԫ
 * ��ʼ�ڣ����ӵ����ݿ⣬��ִ��һ��DML���
 * 
 * �����ڣ�DDL/DCL/�Ͽ�����/COMMIT-�ύ/ROLLBACK�ع�
 * 
 * ��������
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
			
			con.setAutoCommit(false);//Ĭ���Զ��ύ
//			String sql="insert into t_user (username,pwd) values (?,?)";
			ps1=con.prepareStatement("insert into t_user_2 (username,pwd) values(?,?)");
//			insert into t_user(username,pwd,regTime) values(?,?,?)
			ps1.setString(1, "̫һ");//-�˴�����������1��ʼ���𣬶�����0��
			ps1.setString(2, "123456");
			ps1.execute();
			System.out.println("����һ���û�");
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
			System.out.println("�ڲ���һ���û�");
			con.commit();
//			rs=ps1.executeQuery();//--���ؽ����
//			while(rs.next()) {
//				System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3));
//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				con.rollback();//�����쳣--�ع��������ɹ�
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			/**
			 * �ر�˳��resultset-->statement-->connection�����Ĺر�˳�򣻲��ܺϲ�
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
