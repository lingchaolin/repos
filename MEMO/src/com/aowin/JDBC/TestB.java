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
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
			//连接数据库
			con=DriverManager.getConnection(url, user,password);
			System.out.println("数据库连接成功:"+con);
			System.out.println("finish");
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载失败！原因是:"+e.getMessage());
		}catch(SQLException e) {
			System.err.println("数据库连接失败："+e.getMessage());
		}
		//发送sql指令到数据库
		Statement stm=null;
		String sql=null;
		String sql2=null;
		ResultSet rs=null;
		try {
			stm= con.createStatement();
			//增
//			sql=" insert into student (id,name,age) values (08801,'hinata',15)";
			//删
//			sql2="delete from student where id=08801";
			
//			int i=stm.executeUpdate(sql2);
//			stm.executeUpdate(sql2);
//			System.out.println(i+"--操作成功");
			//executeUpdate--增加删除修改
			//executeQuery--返回结果集
			
			//获取数据
			sql="select * from student where age <23";
			rs=stm.executeQuery(sql);//返回结果集
			while(rs.next()) {//rs.next()返回值-有下一个，返回true
				int id=rs.getInt(1);
//				int age=rs.getInt("age");//通过列名获取，或者根据该列在表中的列数获取
				int age=rs.getInt(3);
				String name=rs.getString(2);
				String sex=rs.getString("sex");
				System.out.println("id="+id+",age="+age+",name="+name+",sex="+sex);
				
			}
			//查询语句--用executeQuery返回
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("操作失败"+e.getMessage()+"\r\n检查sql--"+sql);
		}finally {
			//关闭流-后打开的先关闭
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stm!=null) {
					stm.close();
				}//应该把它们分开，避免第一个关闭失败导致其他流都不关闭的情况
				System.out.println("数据库关闭成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
