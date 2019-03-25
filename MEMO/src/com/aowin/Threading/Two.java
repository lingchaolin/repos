package com.aowin.Threading;

public class Two {

	public static void main(String[] args) {
		TwoThreadOne t1=new TwoThreadOne();
		Thread d1=new Thread(t1);
		d1.start();
		TwoThreadTwo t2=new TwoThreadTwo();
		Thread d2=new Thread(t2);
//		d2.setDaemon(on);
		d2.start();
		TwoThreadThree t3=new TwoThreadThree();
		Thread d3=new Thread(t3);
		d3.start();
//		yield--礼让--熟人
//		join--加入--领导优先
//		后台线程-setDaemon-后台线程是专门为前台线程服务的，
		
	}

}

class TwoThreadOne implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("线程1："+i);
			
		}
		
	}
	
}

class TwoThreadTwo implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("线程2："+i);
		}
	}
	
}

class TwoThreadThree implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("线程3："+i);
		}
	}
	
}