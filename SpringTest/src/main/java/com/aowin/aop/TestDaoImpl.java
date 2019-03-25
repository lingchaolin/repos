package com.aowin.aop;

public class TestDaoImpl implements TestDao{

	public TestDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInfo(String name, int age) {
		return "–’√˚£∫" + name + "ƒÍ¡‰£∫" + String.valueOf(age);
	}
	@Override
	public String getInfo2(String name, int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertInfo(String name, int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateInfo(String name, int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteInfo(String name, int age) {
		// TODO Auto-generated method stub
		return null;
	}

}
