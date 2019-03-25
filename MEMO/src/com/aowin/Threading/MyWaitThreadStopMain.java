package com.aowin.Threading;

class WaitThreadStop extends Thread{
	WaitThreadStop(){}
	WaitThreadStop(String name){
		super(name);
	}
	   public void run(){
	   		for(int count=1,row=1;row<10;row++,count++){
				for(int i=0;i<count;i++){
					System.out.print('*');
				}
				System.out.println();
			}
	   }

}
public class MyWaitThreadStopMain {
	public static void main(String[]args){
		MyWaitThreadStopMain test=new MyWaitThreadStopMain();
		test.Method1();
//		test.Method2();
	}
	public void Method1(){
		WaitThreadStop th1=new WaitThreadStop();
		WaitThreadStop th2=new WaitThreadStop();
		th1.start();
		while(th1.isAlive()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//当第一个线程终止后，运行第二个线程；
		th2.start();
	}
	//第二个方法，使用join方法实现等待其他线程结束；
	public void Method2(){
		WaitThreadStop th1=new WaitThreadStop();
		WaitThreadStop th2=new WaitThreadStop();
		th1.start();
		try {
			th1.join();//th1调用join方法；//Waits for this thread to die.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th2.start();
	}
}
