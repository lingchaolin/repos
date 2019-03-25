package com.aowin.Threading;
/**
 * 创建多个线程
 * @author Administrator
 *
 */
public class MyThreadOne {
	public static void main(String[]args){
		ThreadTest test=new ThreadTest();
		ThreadTest test1=new ThreadTest();
		ThreadTest test2=new ThreadTest();
		test.start();
		test1.start();
		test2.start();
	}
}
class ThreadTest extends  Thread{
	   public void run(){
	   	for(int count=1,row=1;row<10;row++,count++){
				for(int i=0;i<count;i++){
					System.out.print('*');
				}
				System.out.println();
			}
	   }
}
