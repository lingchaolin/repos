package com.aowin.Threading;

public class MyStaticProxy {

	
	public static void main(String[] args) {
		//创建真实角色
		threadrun t =new threadrun();
		//创建代理角色 +真实角色的引用
		Thread r =new Thread(t,"AAA");
		Thread r1 =new Thread(t,"BBB");
		Thread r2 =new Thread(t,"CCC");
		//执行任务
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
//			若使用下列线程sleep会出现"AAA-1"类似的；--线程不安全
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+num--);
		}
	}
}

	
