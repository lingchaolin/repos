package com.aowin.Threading;
/**
 * 死锁
 * @author Administrator
 *
 */
public class FiveLocking {
	public static void main(String[]args) {
		Object o1=new Object();
		Object o2=new Object();
		ThreadFiveOne t1=new ThreadFiveOne(o1,o2);
		ThreadFiveTwo t2=new ThreadFiveTwo(o1,o2);
		t1.start();
		t2.start();
	}
}
class ThreadFiveOne extends Thread{
	Object o1;
	Object o2;
	public ThreadFiveOne(Object o1, Object o2) {
		super();
		this.o1 = o1;
		this.o2 = o2;
	}
	public void run() {
		synchronized(o1){
			System.out.println("Thread1访问o1");
			synchronized(o2){
				System.out.println("Thread1访问o2");
			}
		}
	}
}
class ThreadFiveTwo extends Thread{
	Object o1;
	Object o2;
	public ThreadFiveTwo(Object o1, Object o2) {
		super();
		this.o1 = o1;
		this.o2 = o2;
	}
	public void run() {
		synchronized(o2){
			System.out.println("Thread2访问o2");
			synchronized(o1){
				System.out.println("Thread2访问o1");
			}
		}
	}
}