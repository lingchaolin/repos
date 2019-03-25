package com.aowin.Threading;
/**
 *	静态代理模式？？
 * 真实角色--代理角色-->二者需要有相同接口；
 * 代理角色要有真实角色的引用
 * @author Administrator
 *
 */
public class MyStaticModel{
	public static void main(String[]args){
//		System.out.println("HelloWorld!");
		You you=new You();
		WeddingCompany company=new WeddingCompany(you);
		company.marry();
	}
}
//共同接口
interface Marry{
	public abstract void marry();
}
//真实角色；
class You implements Marry{
	public void marry(){
		System.out.println("结婚!");
	}
}
//代理角色；
class WeddingCompany implements Marry{
	private Marry you;
	
	public WeddingCompany() {
		super();
	}

	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}
	private void before(){
		System.out.println("整理!");
	}
	private void after(){
		System.out.println("收尾!");
	}
	public void marry(){
		before();
		you.marry();
		after();
	}
}