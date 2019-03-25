package com.aowin.proxy;

import com.aowin.classLoadSort.Test2;

public class ThreadTest {
	public static void main(String[] args) {
		ThreadTwo t22=new ThreadTwo();
		Thread t1=new Thread(t22);
		Thread t2=new Thread(t22);
		Thread t3=new Thread(t22);
		t1.setName("ÕÅÈý");
		t2.setName("Lucygrgg");
		t3.setName("423423234234");
		t1.start();
		t2.start();
		t3.start();
	}
}
class ThreadTwo implements  Runnable{
	int num=100000;
	@Override
	public void run() {
		synchronized (this) {
			while(num>0) {
				System.out.println(Thread.currentThread().getName()+"£º"+num);
				num--;
			}
		}
	}
}
class ThreadOne extends Thread{
	int num=10;
	@Override
	public void run() {
		while(num>0) {
			System.out.println(this.getName()+"£º"+num);
			num--;
		}
		System.out.println(num+"");
	}
}
class ThreadThree extends Thread{
	Object o;
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(this.getName()+"£º"+i);
			synchronized(o) {
				if(i==50) {
					try {
						o.notify();
						System.out.println("wake up£¡");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
