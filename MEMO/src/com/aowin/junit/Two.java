package com.aowin.junit;
/**
 * 测试方法用@test修饰
 * 
 * 
 * 测试目录下的包结构和源文件目录保持一致
 * 测试类类名以Test结尾
 * 测试方法名以test开头
 * 
 * Failure-是由于断言失败导致的，期望结果和运行结果不一致导致的
 * Error-由于测试代码和或被测试代码中的bug导致的
 *
 *
 *
 */
public class Two {

	public static void main(String[] args) {
		Two t=new Two();
		t.te();
		System.out.println("");
	}
	public void te() {
		for(int i=0;i<100;i++) {
			i++;
		}
	}
	public int add(int a,int b) {
		return a+b;
	}
	public int minus(int a,int b) {
		return a-b;
	}
	public int multiply(int a,int b) {
		return a*b;
	}
	public int div(int a,int b) {
		return a/b;
	}
}
