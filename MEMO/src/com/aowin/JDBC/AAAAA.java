package com.aowin.JDBC;

public class AAAAA {
/**JDBC--Java DataBase Connectivity
 * JDBC API-
 * 		DriverManager--JDBC Driver的管理器
 * 				JABC Driver连接到不同的数据库
 * 		Connection
 * 		Statement
 * 			Statement
 * 			PreparedStatement
 * 			CallableStatement
 * 		ResultSet
 */
/**
 * 四大物件
 * 		DriverManager--根据数据库的不同，调用正确的Driver
 * 		Connection--由Driver产生，连接数据库，负责和数据库的连接，进行信息的传输；
 * 		Statement--由Connection产生，负责传输SQL指令到服务器
 * 		ResultSet--负责接受Statement(sql指令)执行的后果 
 * @param args
 */
	/**连接数据库的步骤
	 * Load Drivermanger
	 * Create Connection
	 * Create SQL Statement
	 * Return Results
	 * Retrieve Data--从ResutSet中获取数据
	 * @param args
	 */
	/**
	 * select A,B,C from student where id=?       ----可以查到A,B,C多项的数据
	 * @param args
	 */
	public static void main(String[] args) {

		
	}

}
