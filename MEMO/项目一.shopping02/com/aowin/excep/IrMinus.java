package com.aowin.excep;

public class IrMinus extends Exception {
	public IrMinus() {
		super("输入的数必须为正整数,请重新输入！");
	}

	public IrMinus(String message) {
		super(message);
	}
}
