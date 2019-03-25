package com.aowin.Threading;
/**
 * notify
 * wait
 * --必须放在同步中
 * @author Administrator
 *唤醒在此对象监视器上等待的所有线程。线程通过调用其中一个 wait 方法，
 *在对象的监视器上等待。 
 */
public class SixWait {

	public static void main(String[] args) {
		Object o=new Object();
		
		Thread1 t1=new Thread1();
		Thread2 t2=new Thread2();
		Thread3 t3=new Thread3();
		t1.o=o;
		t2.o=o;
//		t3.o=o;
		t3.setName("momo");
		t1.setName("lili");
		t2.setName("sasa");
		t1.start();
		t2.start();
		t3.start();
	}

}
class Thread1 extends Thread{
	Object o;
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(getName()+"--"+i);
			if(i==20) {
				synchronized(o) {
					try {
						System.out.println("lili says:i am tired,sleep for a second");
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class Thread2 extends Thread{
	Object o;
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(getName()+"--"+i);
			if(i==40) {
				synchronized(o) {
					o.notify();
					System.out.println("sasa says:weak up");
				}
			}
		}
	}
}

class Thread3 extends Thread{
	Object o=new Object();
	public void run() {
		for(int i=0;i<50;i++) {
			try {
				sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(getName()+"--"+i);
			if(i==20) {
				synchronized(o) {
					try {
						System.out.println("momo says:i am tired,sleep for a second");
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
