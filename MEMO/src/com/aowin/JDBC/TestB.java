package com.aowin.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Administrator
 *
 */
//import com.mysql.jdbc.Statement;

public class TestB {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String password="123456";
		Connection con = null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
			//�������ݿ�
			con=DriverManager.getConnection(url, user,password);
			System.out.println("���ݿ����ӳɹ�:"+con);
			System.out.println("finish");
		} catch (ClassNotFoundException e) {
			System.err.println("��������ʧ�ܣ�ԭ����:"+e.getMessage());
		}catch(SQLException e) {
			System.err.println("���ݿ�����ʧ�ܣ�"+e.getMessage());
		}
		//����sqlָ����ݿ�
		Statement stm=null;
		String sql=null;
		String sql2=null;
		ResultSet rs=null;
		try {
			stm= con.createStatement();
			//��
//			sql=" insert into student (id,name,age) values (08801,'hinata',15)";
			//ɾ
//			sql2="delete from student where id=08801";
			
//			int i=stm.executeUpdate(sql2);
//			stm.executeUpdate(sql2);
//			System.out.println(i+"--�����ɹ�");
			//executeUpdate--����ɾ���޸�
			//executeQuery--���ؽ����
			
			//��ȡ����
			sql="select * from student where age <23";
			rs=stm.executeQuery(sql);//���ؽ����
			while(rs.next()) {//rs.next()����ֵ-����һ��������true
				int id=rs.getInt(1);
//				int age=rs.getInt("age");//ͨ��������ȡ�����߸��ݸ����ڱ��е�������ȡ
				int age=rs.getInt(3);
				String name=rs.getString(2);
				String sex=rs.getString("sex");
				System.out.println("id="+id+",age="+age+",name="+name+",sex="+sex);
				
			}
			//��ѯ���--��executeQuery����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ��"+e.getMessage()+"\r\n���sql--"+sql);
		}finally {
			//�ر���-��򿪵��ȹر�
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stm!=null) {
					stm.close();
				}//Ӧ�ð����Ƿֿ��������һ���ر�ʧ�ܵ��������������رյ����
				System.out.println("���ݿ�رճɹ�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
