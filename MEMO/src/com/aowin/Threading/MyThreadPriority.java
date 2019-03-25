package com.aowin.Threading;
/**
 * Priority
 * 线程优先级；
 * @author Administrator
 *……结果和文档上的结果不同
 */
public class MyThreadPriority {
	public static void main(String[]args){
		InheritThread itd=new InheritThread();
		Thread rtd=new Thread(new RunnableThread002());
		itd.setPriority(1);
		rtd.setPriority(10);
		itd.start();
		rtd.start();
	}
}
class InheritThread extends Thread{
	public  void run(){
		System.out.println("InheritThread is running");
		for(int i=0;i<10;i++){
			System.out.println("InheritThread:i="+i);
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}
}
class RunnableThread002 implements Runnable{
	public void run(){
		System.out.println("Runnable Thread is running");
		for(int i=0;i<10;i++){
			System.out.println("RunnableThread:i="+i);
			try {
				Thread.sleep((int)Math.random()*1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}
}