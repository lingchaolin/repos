package com.aowin.aop;

public class TestDaoImpl implements TestDao{
	public TestDaoImpl() {
		
	}
	@Override
	public String getInfo(String name, int age) {
		return "������" + name + "���䣺" + String.valueOf(age);
	}
	@Override
	public String insertInfo(String name, int age) {
		return "������" + name + "���䣺" + String.valueOf(age);
	}
	@Override
	public String updateInfo(String name, int age) {
		return "������" + name + "���䣺" + String.valueOf(age);
	}
	@Override
	public String deleteInfo(String name, int age) {
		return "������" + name + "���䣺" + String.valueOf(age);
	}
}
