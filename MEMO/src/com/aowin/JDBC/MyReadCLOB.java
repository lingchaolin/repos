package com.aowin.JDBC;

import java.io.*;
import java.sql.*;

public class MyReadCLOB {
	public  static void main(String[]args) {
		java.sql.Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			ps=con.prepareStatement("insert into fighter (username,myInfo) values (?,?)");
			ps.setString(1, "Ace");
//			ps.setClob(2, new File("D:/Class/in.txt"));
			ps.setClob(2, new FileReader(new File("D:/Class/in.txt")));
			ps.executeUpdate();
			ps=con.prepareStatement("select * from fighter where id=?");
			ps.setObject(1, 238);
			rs=ps.executeQuery();
//			¥Ú”°
			while(rs.next()) {
				Clob c=rs.getClob("myInfo");
				int temp=0;
				Reader r=c.getCharacterStream();
				while(-1!=(temp=r.read())) {
					System.out.println((char)temp);
				}
			}
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
