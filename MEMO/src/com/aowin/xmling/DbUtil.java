package com.aowin.xmling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
static {
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载失败！原因是:"+e.getMessage());
		}
	}
	public static Connection getCon(GetJdbc jd) {
//		String url="jdbc:mysql://localhost:3306/test";
//		String user="root";
//		String password="123456";
		String url=jd.getUrl();
		String user=jd.getUser();
		String password=jd.getPassword();
		Connection con=null;
		try {
			con=DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			System.out.println("数据库连接失败:"+e.getMessage());
			System.out.println("检查代码:\r\nurl:"+url+"\r\nuser:"+user+"\r\npassword:"+password);
		}
		return con;
	}
	public static void Close(ResultSet rs,Statement stat,Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("rs关闭失败:"+e.getMessage());
		}
		try {
			if(stat!=null) {
				stat.close();
			}
		} catch (SQLException e) {
			System.out.println("stat关闭失败:"+e.getMessage());
		}
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("con关闭失败:"+e.getMessage());
		}
	
	}
}
class GetJdbc{
	private String url;
	private String user;
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public GetJdbc(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public GetJdbc() {
		super();
	}
}