package com.aowin.excep;

public class IrMinus extends Exception {
	public IrMinus() {
		super("�����������Ϊ������,���������룡");
	}

	public IrMinus(String message) {
		super(message);
	}
}
