package com.aowin.Threading;

public class  MyRunnableTwo {
	public static void main(String[]argv){
		ThreadTest222 test=new ThreadTest222();
		Thread t=new Thread(test);
		t.start();
		ThreadTest222 test2=new ThreadTest222();
		Thread t2=new Thread(test2);
		t2.start();
		ThreadTest222 test3=new ThreadTest222();
		Thread t3=new Thread(test3);
		t3.start();
	}
	
}
class ThreadTest222 implements Runnable{
	   public void run(){
	   		for(int count=1,row=1;row<10;row++,count++){
				for(int i=0;i<count;i++){
					System.out.print('*');
				}
				System.out.println();
			}
	   }
}