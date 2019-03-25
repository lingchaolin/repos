package com.aowin.proxy;

import java.util.ArrayList;

import com.aowin.manager.model.AccountMessage;

public interface DaoInterface {
	public void addSql();
	public void deleteSql();
	public void updateSql();
	public ArrayList<AccountMessage> selectSizeSql();
	public ArrayList<AccountMessage> selectSql(String str,int startNum);
	public String selectUserName(String account);
	public ArrayList<String> selectAuthName(String account);
	public boolean isSomainExist(String account);
	public boolean isPomainExist(String account);

}
