package com.aowin.Threading;

public class Three {

	public static void main(String[] args) {
		TwoThreadOne t1=new TwoThreadOne();
		Thread d1=new Thread(t1);
		d1.start();
		TwoThreadTwo t2=new TwoThreadTwo();
		Thread d2=new Thread(t2);
		d2.start();
		TwoThreadThree t3=new TwoThreadThree();
		Thread d3=new Thread(t3);
		d3.start();
		
//		yield--礼让--熟人
//		join--领导优先
	}

}
