package com.aowin.Threading;

public class MyStaticProxy {

	
	public static void main(String[] args) {
		//������ʵ��ɫ
		threadrun t =new threadrun();
		//���������ɫ +��ʵ��ɫ������
		Thread r =new Thread(t,"AAA");
		Thread r1 =new Thread(t,"BBB");
		Thread r2 =new Thread(t,"CCC");
		//ִ������
		r.start();
		r1.start();
		r2.start();
	}

}
class threadrun implements Runnable{
	private int num=50;
	public void run(){
		while(true){
			if(num<0){
				break;
			}
//			��ʹ�������߳�sleep�����"AAA-1"���Ƶģ�--�̲߳���ȫ
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+num--);
		}
	}
}

	
