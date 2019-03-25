package com.aowin.Threading;
/**
 * 等待队列
 * @author Administrator
 *10.5.2--共享队列
 *Page22
 */
public class MyThreadCommunication {
	public static void main(String[]args){
		Queue q=new Queue();
		
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		
		c.start();
		p.start();
	}
}

class Queue{
	int value=0;
	boolean isEmpty=true;
	public synchronized void put(int v){
		if(!isEmpty){//true-->未被消费--生产者等待；
			try {
				System.out.println("生产者等待");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value+=v;
		isEmpty=false;
		System.out.println("生产者生产数量为"+v);
		notify();//唤醒消费者？？//目标指向
	}

	public synchronized int get(){
		if(isEmpty){//true-->未被消费--生产者等待；
			try {
				System.out.println("消费者等待");
				wait();/**notify唤醒的是谁？？若有3个以上进程同时运行，
						如何确定谁该被唤醒？？或者应该主动避免该情况？？*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		value--;
		isEmpty=true;
		System.out.println("消费了一个，剩下"+value);
		notify();//唤醒消费者？？
		return value;
	}
}

class Producer extends Thread{
	Queue q;
	
	Producer(Queue q){
		this.q=q;
	}
	public void run(){
		for(int i=1;i<5;i++){
			q.put(i);
		}
	}
}
class Consumer extends Thread{
	Queue q;
	
	Consumer(Queue q){
		this.q=q;
	}
	public void run(){
		while(true){
			q.get();
		}
	}
}
