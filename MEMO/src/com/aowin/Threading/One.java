package com.aowin.Threading;
/**
 * �̺߳ͽ���
 * ���̣�
 * 		�����е�Ӧ�ó���
 * �̣߳�
 * 		���̵�����ߣ�һ����������Ҫ��һ���߳�
 * ���̣߳�
 * 		�����ж������Ƭ��ͬʱ����-���̣߳�
 * 		cpu�ڶ���߳�֮���л�
 * @author Administrator
 *���ַ���
 *	extends Thread
 *	implements Runnable
 *���߳�
 */
public class One {
/**
 * ���ȼ���1-10��  5-�е�
 * @param args
 */
	public static void main(String[] args) {
		ThreadTestOne t1=new ThreadTestOne();
		ThreadTestTwo t2=new ThreadTestTwo();
		ThreadTestThree t3=new ThreadTestThree();
		ThreadTestFourth t4=new ThreadTestFourth();
		//��ȡ�߳�����
		t1.getName();
		System.out.println("t1���߳���Ϊ��"+t1.getName());
		//��������
		System.out.println("����t1���߳���Ϊ��aaa");
		t1.setName("aaa");
		System.out.println("t1���߳���Ϊ��"+t1.getName());
		//��ȡ���ȼ�
		t1.getPriority();
		System.out.println("t1�̵߳����ȼ�Ϊ��"+t1.getPriority());
		//�������ȼ�
		System.out.println("����t1�����ȼ�Ϊ��4");
		t1.setPriority(4);
		System.out.println("t1�̵߳����ȼ�Ϊ��"+t1.getPriority());
		//currentThread--��ȡ��ǰ�߳�
		System.out.println("��ȡmain�߳�");
		Thread now=Thread.currentThread();
		System.out.println("main�߳���Ϊ��"+now.getName());
		System.out.println("main�߳����ȼ�Ϊ��"+now.getPriority());
		t3.t=t1;//join����
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
			System.out.println("�߳�1��"+i);
			if(i==20) {
				System.out.println("����");
				yield();
			}
		}
	}
}
class ThreadTestThree extends Thread{
	Thread t;
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("�߳�3��"+i);
			if(i==20) {
				try {
					t.join();//����Ŀ���߳�ִ����
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
			System.out.println("�߳�2��"+i);
		}
	}
}
class ThreadTestFourth extends Thread{
	public void run() {
		while(true) {  
			try {
				//sleep(long) �߳�����
				sleep(10);//��λ�Ǻ���   
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
			System.out.println(getName()+"=>"+".....");     
//			System.out.println("....."); 
		}	
	}
}