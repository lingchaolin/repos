package com.aowin.Threading;
/**
 * �߳����������ӣ�
 * @author Administrator
 *
 */
public class MyThreadSleep {
	public static void main(String[]args){
		SubThread test=new SubThread();
		test.start();
	}
}
class SubThread extends Thread{
	SubThread(){}
	SubThread(String name){
		super(name);
	}
	public void run(){
		for(int count=1,row=1;row<10;row++,count++){
			for(int i=0;i<count;i++){
				System.out.print('*');
			}
			try {
				Thread.sleep(1000);
				System.out.println("\t wait()");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();		}
	}
}