package com.aowin.excep;

public class ircorrect extends Exception {

	public ircorrect() {
			super("抱歉！您输入的数量不正确，请重新输入！");
		}
	
	public ircorrect(String message) {
		super(message);
	}
	
}