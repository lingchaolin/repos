package com.aowin.JDBC;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/**JDBC
 * 取出指定日期范围的记录
 */
public class MyTimeTypeTwo {
	/**
	 * 将字符串代表的信息转为long类型（yy-MM-dd hh:mm:ss)
	 * @param dateStr
	 * @return
	 */
	public static long strDate(String dateStr){
		DateFormat format=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public  static void main(String[]args) {
		java.sql.Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
//			 取出指定日期范围的记录
//			ps=con.prepareStatement("select * from t_user where regTime>? and regTime<?");
			
//			java.sql.Date start=new java.sql.Date(strDate("2018-4-14 11:22:33"));
//			java.sql.Date end=new java.sql.Date(strDate("2018-4-18 11:22:33"));
//			ps.setObject(1, start);
//			ps.setObject(2, end);
			ps=con.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime<? order by lastLoginTime");
			Timestamp start=new Timestamp(strDate("2018-4-14 22:22:33"));
			Timestamp end=new Timestamp(strDate("2018-4-18 01:11:33"));
			
			ps.setObject(1, start);
			ps.setObject(2, end);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+rs.getString("username")+rs.getTimestamp("lastLoginTime"));
			}
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
