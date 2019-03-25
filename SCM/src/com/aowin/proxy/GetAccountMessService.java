package com.aowin.proxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aowin.dao.AccountUserDao;
import com.aowin.manager.model.AccountMessage;
import com.aowin.util.Dbutil;
import com.mysql.jdbc.Statement;

public class GetAccountMessService implements DaoInterface {
	AccountUserDao aud=AccountUserDao.getInstance();
	@Override
	public void addSql() {
		
	}
	@Override
	public void deleteSql() {
		
	}

	@Override
	public void updateSql() {

	}
	@Override
	public ArrayList<AccountMessage> selectSql(String str,int startNum) {
		Connection conn=Dbutil.getConn();	
		ArrayList<AccountMessage> sizeList=aud.getAccountSingleSqlLimit(conn,str,startNum);
		
		Dbutil.close(null, null, conn);
		return sizeList;
	}
	@Override
	public ArrayList<AccountMessage> selectSizeSql() {
		Connection conn=Dbutil.getConn();	
		ArrayList<AccountMessage> sizeList=aud.getAccountSingleSql(conn,"");
		Dbutil.close(null, null, conn);
		return sizeList;
	}
	@Override
	public String selectUserName(String account) {
		Connection conn=Dbutil.getConn();	
		String name=aud.getUserName(conn,account);
		Dbutil.close(null, null, conn);
		return name;
	}
	@Override
	public ArrayList<String> selectAuthName(String account) {
		Connection conn=Dbutil.getConn();	
		ArrayList<String> list=aud.getAuthName(conn,account);
		Dbutil.close(null, null, conn);
		return list;
	}
	@Override
	public boolean isSomainExist(String account) {
		Connection conn=Dbutil.getConn();	
		boolean flag=aud.isSomainUnFinish(account);
		Dbutil.close(null, null, conn);
		return flag;
	}
	@Override
	public boolean isPomainExist(String account) {
		Connection conn=Dbutil.getConn();	
		boolean flag=aud.isPomainUnFinish(account);
		Dbutil.close(null, null, conn);
		return flag;
	}

}
