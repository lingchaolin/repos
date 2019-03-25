package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.manager.model.AccountMessage;
import com.aowin.util.Dbutil;

public class AccountUserDao {
	private static AccountUserDao aud;
	private AccountUserDao() {}
	public synchronized static AccountUserDao getInstance() {
		if(aud==null) {
			aud=new AccountUserDao();
		}
		return aud;
	}
	//single-不获取重复值
	public static ArrayList<AccountMessage> getAccountSingleSql(Connection conn,String str) {
		//Connection conn=Dbutil.getConn();
		String sql="select scmuser.account,name,createdate,status,modelname,count(DISTINCT usermodel.account) from scmuser,systemmodel,usermodel \r\n" + 
				"where  systemmodel.ModelCode=usermodel.ModelCode \r\n" + 
				"and usermodel.Account=scmuser.Account "+str+" GROUP BY usermodel.account";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<AccountMessage> list=new ArrayList<AccountMessage>();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String account=rs.getString(1);
				String name=rs.getString(2);
				String createDate=rs.getString(3);
				String status="0".equals(rs.getString(4))?"否":"是";
				String modelName=rs.getString(5);
				AccountMessage am=new AccountMessage(account, name, createDate, status, modelName);
				list.add(am);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, null);
		}
		return list;
	}
	//single-不获取重复limit
	public static ArrayList<AccountMessage> getAccountSingleSqlLimit(Connection conn,String str,int startNum) {
		//Connection conn=Dbutil.getConn();
		String sql="select scmuser.account,name,createdate,status,modelname,count(DISTINCT usermodel.account) from scmuser,systemmodel,usermodel \r\n" + 
				"where  systemmodel.ModelCode=usermodel.ModelCode \r\n" + 
				"and usermodel.Account=scmuser.Account "+str+" GROUP BY usermodel.account limit ?,5";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<AccountMessage> list=new ArrayList<AccountMessage>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, startNum);
			rs=ps.executeQuery();
			while(rs.next()) {
				String account=rs.getString(1);
				String name=rs.getString(2);
				String createDate=rs.getString(3);
				String status="0".equals(rs.getString(4))?"否":"是";
				String modelName=rs.getString(5);
				AccountMessage am=new AccountMessage(account, name, createDate, status, modelName);
				list.add(am);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, null);
		}
		return list;
	}
	
	public static ArrayList<AccountMessage> getAccountSql(String str) {
		Connection conn=Dbutil.getConn();
		String sql="select scmuser.account,name,createdate,status,modelname from scmuser,systemmodel,usermodel where systemmodel.ModelCode=usermodel.ModelCode and usermodel.Account=scmuser.Account"+str;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<AccountMessage> list=new ArrayList<AccountMessage>();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String account=rs.getString(1);
				String name=rs.getString(2);
				String createDate=rs.getString(3);
				String status="0".equals(rs.getString(4))?"否":"是";
				String modelName=rs.getString(5);
				AccountMessage am=new AccountMessage(account, name, createDate, status, modelName);
				list.add(am);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return list;
	}
	public static ArrayList<AccountMessage> getAccountSqlLimit(String str,int startNum) {
		Connection conn=Dbutil.getConn();
		String sql="select scmuser.account,name,createdate,status,modelname from scmuser,systemmodel,usermodel where systemmodel.ModelCode=usermodel.ModelCode and usermodel.Account=scmuser.Account"+str+" limit ?,5";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<AccountMessage> list=new ArrayList<AccountMessage>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, startNum);
			rs=ps.executeQuery();
			while(rs.next()) {
				String account=rs.getString(1);
				String name=rs.getString(2);
				String createDate=rs.getString(3);
				String status="0".equals(rs.getString(4))?"否":"是";
				String modelName=rs.getString(5);
				AccountMessage am=new AccountMessage(account, name, createDate, status, modelName);
				list.add(am);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return list;
	}
	public static void addAccountSqlScmuser(AccountMessage am) {
		Connection conn=Dbutil.getConn();
		String sql="insert into scmuser VALUES(?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, am.getAccount());
			ps.setString(2, am.getAccount());
			ps.setString(3, am.getName());
			ps.setString(4, am.getCreateDate());
			ps.setString(5, "是".equals(am.getStatus())?"1":"0");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(null, ps, conn);
		}
	}
	public static void addAccountSqlUsermodel(AccountMessage am) {
		Connection conn=Dbutil.getConn();
		String sql="insert into usermodel VALUES(?,?)";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, am.getAccount());
			String code = null;
			if("管理员".equals(am.getModelName())) {
				code="01";
			}else if("采购".equals(am.getModelName())) {
				code="02";
			}else if("仓管".equals(am.getModelName())) {
				code="03";
			}else if("财务".equals(am.getModelName())) {
				code="04";
			}else if("销售".equals(am.getModelName())) {
				code="05";
			}
			ps.setString(2,code);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(null, ps, conn);
		}
	}
	public static void modifyAccountSqlScmuser(AccountMessage am) {
		Connection conn=Dbutil.getConn();
		String sql="update scmuser set name=? , status=? where account=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, am.getName());
			ps.setString(2, "是".equals(am.getStatus())?"1":"0");
			ps.setString(3, am.getAccount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(null, ps, conn);
		}
	}
	
	/*public static void modifyAccountSqlUsermodel(AccountMessage am) {
		Connection conn=Dbutil.getConn();
		String sql="update usermodel set modelcode=? where account=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			String code = null;
			if("管理员".equals(am.getModelName())) {
				code="01";
			}else if("采购".equals(am.getModelName())) {
				code="02";
			}else if("仓管".equals(am.getModelName())) {
				code="03";
			}else if("财务".equals(am.getModelName())) {
				code="04";
			}else if("销售".equals(am.getModelName())) {
				code="05";
			}
			ps.setString(1, code);
			ps.setString(2, am.getAccount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(null, ps, conn);
		}
	}*/
	//删除旧的
	public static void deleteAccountSqlUsermodel(AccountMessage am) {
		Connection conn=Dbutil.getConn();
		String sql="delete from usermodel where account=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			String code = null;
			if("管理员".equals(am.getModelName())) {
				code="01";
			}else if("采购".equals(am.getModelName())) {
				code="02";
			}else if("仓管".equals(am.getModelName())) {
				code="03";
			}else if("财务".equals(am.getModelName())) {
				code="04";
			}else if("销售".equals(am.getModelName())) {
				code="05";
			}
			ps.setString(1, am.getAccount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(null, ps, conn);
		}
	}
		public static void deleteAccountFromScmuser(String account) {
			Connection conn=Dbutil.getConn();
			String sql="delete from scmuser where account=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, account);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		public static void deleteAccountFromUsermodel(String account) {
			Connection conn=Dbutil.getConn();
			String sql="delete from usermodel where account=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, account);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
	}
		//是否有相关销售单未了结
		public static boolean isSomainUnFinish(String str) {
			Connection conn=Dbutil.getConn();
			String sql="select * from somain where account=?  and (status=1 or status=2 or status=3 or status=5)";
			PreparedStatement ps=null;
			ResultSet rs=null;
			boolean flag=false;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, str);
				rs=ps.executeQuery();
				if(rs.next()) {
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return flag;
		}
		//是否有相关采购单未了结
		public static boolean isPomainUnFinish(String str) {
			Connection conn=Dbutil.getConn();
			String sql="select * from pomain where account=?  and (status=1 or status=2 or status=3 or status=5)";
			PreparedStatement ps=null;
			ResultSet rs=null;
			boolean flag=false;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, str);
				rs=ps.executeQuery();
				if(rs.next()) {
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return flag;
		}
		//根据存入的账户获取用户名
		public static String getUserName(Connection conn,String str) {
			String sql="select name from scmuser where account=? ";
			PreparedStatement ps=null;
			ResultSet rs=null;
			String name=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, str);
				rs=ps.executeQuery();
				if(rs.next()) {
					name=rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, null);
			}
			return name;
		}
		//查看是否有指定权限
		public static boolean getAuth(String account,String auth) {
			Connection conn=Dbutil.getConn();
			String sql="select * from usermodel where account=? and modelcode=?";
			PreparedStatement ps=null;
			ResultSet rs=null;
			boolean flag=false;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, account);
				ps.setString(2, auth);
				rs=ps.executeQuery();
				if(rs.next()) {
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return flag;
		}
		//获取权限名
		public static ArrayList<String> getAuthName(Connection conn,String account) {
			String sql="select modelname from usermodel,systemmodel where usermodel.ModelCode=systemmodel.ModelCode and account=?";
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<String> list=new ArrayList<String>();
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, account);
				rs=ps.executeQuery();
				while(rs.next()) {
					String string=rs.getString(1);
					list.add(string);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, null);
			}
			return list;
		}
}
