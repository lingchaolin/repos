package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/**JDBC
 * Date
 * Time
 * TimeStamp
 * �����������
 * ȡ��ָ�����ڷ�Χ�ļ�¼
 */
public class MyTimeTypeOne {
	public  static void main(String[]args) {
		java.sql.Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			
			for(int i=0;i<1000;i++) {//�����������-����1000������
			ps1=con.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values(?,?,?,?)");
			ps1.setString(1, "ACE"+i);//-�˴�����������1��ʼ���𣬶�����0��
			ps1.setString(2, "123456");
			//Date--ʱ�����͸�ֵ
			int rand=100000000+new Random().nextInt(1000000000);
			java.sql.Date date=new java.sql.Date(System.currentTimeMillis()-rand);
			ps1.setObject(3, date);
			//Timestamp--ʱ������͸�ֵ
//			Timestamp stamp=new Timestamp(2018, 10, 20, 8, 15, 20, 12);
			Timestamp stamp=new Timestamp(System.currentTimeMillis()-rand);
			//ʹ��calendar�����ʱ��
			ps1.setObject(4, stamp);
//			�����������
			ps1.execute();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
