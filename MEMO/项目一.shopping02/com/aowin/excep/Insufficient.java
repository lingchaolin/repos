package com.aowin.excep;

public class Insufficient extends Exception {
	public Insufficient() {
		super("��Ǹ������Ʒ��治�㣡");
	}

	public Insufficient(String message) {
		super(message);
	}

}
