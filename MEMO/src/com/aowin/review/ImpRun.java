package com.aowin.review;

public class ImpRun {
	public static void main(String[] args) {
		ImThread i1=new ImThread();
		ImThread i2=new ImThread();
		Thread t1=new Thread(i1);
		Thread t2=new Thread(i2);
		t1.start();
		t2.start();
	}
}
class ImThread implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			//不能通过this获得当前线程
		}
	}
}
