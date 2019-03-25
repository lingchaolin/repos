package com.aowin.MyException;
//自定义异常
/**
 * 1.编译异常
 * 2.
 * @author Administrator
 *
 */
public class MyException  extends Exception{
	public  MyException(){
		super("自定义MyException!");
	}
	public  MyException(String str){
		super(str);
	}
}
