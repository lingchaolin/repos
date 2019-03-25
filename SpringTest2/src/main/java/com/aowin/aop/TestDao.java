package com.aowin.aop;

public interface TestDao {
	public String getInfo(String name,int age);
	public String insertInfo(String name,int age);
	public String updateInfo(String name,int age);
	public String deleteInfo(String name,int age);
}
