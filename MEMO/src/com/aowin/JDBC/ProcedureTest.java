package com.aowin.JDBC;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProcedureTest {

	public ProcedureTest() {
		
	}
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
			cs=(CallableStatement) conn.prepareCall("{call profour(?)}");
			cs.setInt(1, 22);
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cs!=null)
					cs.close();
			} catch (Exception e2) {
			}
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
