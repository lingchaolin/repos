package com.aowin.Threading;
/**
 * 线程和进程
 * 进程？
 * 		进行中的应用程序
 * 线程？
 * 		进程的组成者，一个进程至少要有一个线程
 * 多线程？
 * 		程序中多个代码片段同时运行-多线程；
 * 		cpu在多个线程之间切换
 * @author Administrator
 *两种方法
 *	extends Thread
 *	implements Runnable
 *多线程
 */
public class One {
/**
 * 优先级：1-10；  5-中等
 * @param args
 */
	public static void main(String[] args) {
		ThreadTestOne t1=new ThreadTestOne();
		ThreadTestTwo t2=new ThreadTestTwo();
		ThreadTestThree t3=new ThreadTestThree();
		ThreadTestFourth t4=new ThreadTestFourth();
		//获取线程名称
		t1.getName();
		System.out.println("t1的线程名为："+t1.getName());
		//设置名字
		System.out.println("设置t1的线程名为：aaa");
		t1.setName("aaa");
		System.out.println("t1的线程名为："+t1.getName());
		//获取优先级
		t1.getPriority();
		System.out.println("t1线程的优先级为："+t1.getPriority());
		//设置优先级
		System.out.println("设置t1的优先级为：4");
		t1.setPriority(4);
		System.out.println("t1线程的优先级为："+t1.getPriority());
		//currentThread--获取当前线程
		System.out.println("获取main线程");
		Thread now=Thread.currentThread();
		System.out.println("main线程名为："+now.getName());
		System.out.println("main线程优先级为："+now.getPriority());
		t3.t=t1;//join对象
		t1.start();
		t2.start();
		t3.start();
		t4.setDaemon(true);
		t4.start();
	}

}
class ThreadTestOne extends Thread{
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("线程1："+i);
			if(i==20) {
				System.out.println("礼让");
				yield();
			}
		}
	}
}
class ThreadTestThree extends Thread{
	Thread t;
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("线程3："+i);
			if(i==20) {
				try {
					t.join();//先让目标线程执行完
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class ThreadTestTwo extends Thread{
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("线程2："+i);
		}
	}
}
class ThreadTestFourth extends Thread{
	public void run() {
		while(true) {  
			try {
				//sleep(long) 线程休眠
				sleep(10);//单位是毫秒   
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
			System.out.println(getName()+"=>"+".....");     
//			System.out.println("....."); 
		}	
	}
}