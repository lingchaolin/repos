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
		}//����һ���߳���ֹ�����еڶ����̣߳�
		th2.start();
	}
	//�ڶ���������ʹ��join����ʵ�ֵȴ������߳̽�����
	public void Method2(){
		WaitThreadStop th1=new WaitThreadStop();
		WaitThreadStop th2=new WaitThreadStop();
		th1.start();
		try {
			th1.join();//th1����join������//Waits for this thread to die.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th2.start();
	}
}