package com.aowin.JDBC;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/**JDBC
 * 以流的方式处理
 * CLOB(Character Large Object)--存储大量的文本数据
 * BLOB(Binary 二进制大对象；
 */
public class MyReadBLOB {
	public  static void main(String[]args) {
		java.sql.Connection con=null;
		PreparedStatement ps=null;
//		ResultSet rs=null;
//		Reader r=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			ps=con.prepareStatement("insert into fighter (username,headImg) values (?,?)");
			ps.setString(1, "ace");
//			ps.setBlob(2, new FileInputStream("D:/Class/Back.jpg"));
//			ps.executeUpdate();
//			ps.setBlob(2, new FileInputStream("D:/Class/in.txt"));
			ps.setBlob(2, new FileInputStream("D:/Class/Back.jpg"));
//			ps.setClob(2, new FileReader(new File("D:/Class/in.txt")));
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
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
