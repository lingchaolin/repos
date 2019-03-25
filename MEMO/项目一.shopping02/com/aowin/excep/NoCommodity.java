package com.aowin.excep;

public class NoCommodity extends Exception {

	public NoCommodity() {
		super("抱歉！没有您要购买的商品！");
	}

	public NoCommodity(String message) {
		super(message);
	}

}
