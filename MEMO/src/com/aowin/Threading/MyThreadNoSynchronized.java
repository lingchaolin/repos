package com.aowin.Threading;
/**
 * ���̲߳�ͬ����ԭ��
 * @author Administrator
 *�����ƣ�A/B��ƱԱ����Ʊ�����������˵����⣻
 *�����г������й����У�
 *�ڡ�Share.lData="���ǵ�1���߳�";����ֵ �ʹ�ӡ֮�����ʱ�������������̽������е�ʱ���ô������ݣ�
 *
 *Synchronized--��δʵ�飻
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
				Share.lData="���ǵ�1���߳�";
				try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
				}
				System.out.println(this.getName()+":"+Share.lData);
			}else if(this.getName().equals("Thread2")){
				Share.lData="���ǵ�2���߳�";
				try {
					Thread.sleep((int)Math.random()*100);
				} catch (InterruptedException e) {
				}
				System.out.println(this.getName()+":"+Share.lData);
			}
		}
	}
}

/**ͬ����ʽ��
 * class����{
 * 		public synchonized �������� �������ƣ���{
 * 
 * 		}
 * }
 *
 *ͬ����
 *synchonized��obj){
 *	}
 *k
 */
