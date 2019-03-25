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
	//����JDBC//����������
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//�������ӣ����Ӷ����ڲ���ʵ������Socket������һ��Զ�̵����ӣ��ȽϺ�ʱ��
			//����connection��������һ��Ҫ�㣩
			//���������У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������
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
