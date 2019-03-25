package com.aowin.Threading;
/**
 * 线程安全性问题
 * 多个线程共享同一个进程中的数据，如果对统一个数据产生竞争访问
 * --可能会导致数据紊乱
 * 同步方法：
 * 1.同步代码块
 * 2.同步方法
 * 
 * 过多的同步可能会导致死锁；
 * 尽量减少使用同步嵌套；若必须使用，要合理安排同步的顺序
 */
public class FourthSaleTicket {

	public static void main(String[] args) {
		Station2 sta=new Station2();
		Thread t1=new Thread(sta);
		Thread t2=new Thread(sta);
		Thread t3=new Thread(sta);
		t1.setName("火车站");
		t2.setName("app");
		t3.setName("黄牛");
		t1.start();
		t2.start();
		t3.start();
	//数据不一致
	}

}
class Station implements Runnable{
	int num=6;
	@Override
	public void run() {
		while(true) {
			if(num>0) {
				num--;
				System.out.println(Thread.currentThread().getName()+"卖出一张票,剩余:"+num);
			}
		}
	}
}

/**
  *实现同步的两种方式：
  *1.使用同步代码块
  *任何对象都可以作为对象锁，一个对象只有一把钥匙获取钥匙的线程执行，执行完会将钥匙还给对象
  *synchronized()并不是保护数据不被访问，只是保证同一时刻只有一个线程在运行。
  */
class Station2 implements Runnable{
	int num=6;
	@Override
	public void run() {
		//使用同步代码块
		synchronized(this) {//因为这里处理的对象都是Station2对象，这里用this代替
			while(true) {
//				if(num>0) {
//					num--;
//					System.out.println(Thread.currentThread().getName()+"卖出一张票,剩余:"+num);
//				}
				test();
			}
		}
	}
	public synchronized void test() {
		if(num>0) {
			num--;
			System.out.println(Thread.currentThread().getName()+"卖出一张票,剩余:"+num);
		}
	}
}
/**


/**同步方法
	class 类名{
		public synchonized 类型名称 方法名称(){
			......
		}
	}
 */