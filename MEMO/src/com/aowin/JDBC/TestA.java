package com.aowin.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TestA {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String password="123456";
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
			//�������ݿ�
			//Connection �ӿ�:�����ָ�������ݿ����ӣ�
			Connection con=(Connection)DriverManager.getConnection(url, user,password);
			System.out.println("���ݿ����ӳɹ�:"+con);
			System.out.println("finish");
		} catch (ClassNotFoundException e) {
			System.err.println("��������ʧ�ܣ�ԭ����:"+e.getMessage());
		}catch(SQLException e) {
			System.err.println("���ݿ�����ʧ�ܣ�"+e.getMessage());
		}
		//�������ݿ�Ҫ�ṩ�Ĳ���-url-�û���-����
		//url--Э��-jdbc��mysql://local:3306/���ݿ���
		//�û���-root  ����-
	}

}
