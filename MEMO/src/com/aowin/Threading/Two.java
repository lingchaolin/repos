package com.aowin.Threading;

public class Two {

	public static void main(String[] args) {
		TwoThreadOne t1=new TwoThreadOne();
		Thread d1=new Thread(t1);
		d1.start();
		TwoThreadTwo t2=new TwoThreadTwo();
		Thread d2=new Thread(t2);
//		d2.setDaemon(on);
		d2.start();
		TwoThreadThree t3=new TwoThreadThree();
		Thread d3=new Thread(t3);
		d3.start();
//		yield--����--����
//		join--����--�쵼����
//		��̨�߳�-setDaemon-��̨�߳���ר��Ϊǰ̨�̷߳���ģ�
		
	}

}

class TwoThreadOne implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("�߳�1��"+i);
			
		}
		
	}
	
}

class TwoThreadTwo implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("�߳�2��"+i);
		}
	}
	
}

class TwoThreadThree implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("�߳�3��"+i);
		}
	}
	
}