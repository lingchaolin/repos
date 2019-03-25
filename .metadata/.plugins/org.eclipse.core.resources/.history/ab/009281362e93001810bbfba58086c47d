package com.aowin.Threading;
/**
 * 多线程不同步的原因；
 * @author Administrator
 *（类似）A/B售票员将火车票误卖个两个人的问题；
 *在下列程序运行过程中：
 *在“Share.lData="这是第1个线程";”赋值 和打印之间存在时间差，导致两个进程交互运行的时候，拿错了数据；
 *
 *Synchronized--暂未实验；
 */
public class MyThreadNoSynchronized {
	public static void main(String[]args){
		ShareData Share=new ShareData();
		ThreadDemo th1=new ThreadDemo("Thread1",Share);
		ThreadDemo th2=new ThreadDemo("Thread2",Share);
		th1.start();
		th2.start();
	}
}
class ShareData{
	public static String lData="";
}
class ThreadDemo extends Thread{
	private ShareData Share;
	ThreadDemo(){}
	ThreadDemo(String Name,ShareData Share){
		super(Name);
		this.Share=Share;
	}
	public void run(){
		for(int i=0;i<5;i++){
			if(this.getName().equals("Thread1")){
				Share.lData="这是第1个线程";
				try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
				}
				System.out.println(this.getName()+":"+Share.lData);
			}else if(this.getName().equals("Thread2")){
				Share.lData="这是第2个线程";
				try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
				}
				System.out.println(this.getName()+":"+Share.lData);
			}
		}
	}
}

/**同步格式：
 * class类名{
 * 		public synchonized 类型名称 方法名称（）{
 * 
 * 		}
 * }
 *
 *同步块
 *synchonized（obj){
 *	}
 *k
 */
