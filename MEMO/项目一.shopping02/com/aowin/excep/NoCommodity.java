package com.aowin.excep;

public class NoCommodity extends Exception {

	public NoCommodity() {
		super("��Ǹ��û����Ҫ�������Ʒ��");
	}

	public NoCommodity(String message) {
		super(message);
	}

}
