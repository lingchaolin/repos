package com.aowin.junit;

public class Two3 {

	public static void main(String[] args) {
		Two3 t=new Two3();
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
