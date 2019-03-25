package com.aowin.excep;

public class Insufficient extends Exception {
	public Insufficient() {
		super("抱歉！该商品库存不足！");
	}

	public Insufficient(String message) {
		super(message);
	}

}
