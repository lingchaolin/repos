package com.aowin.proxy;

public class BookProxy implements Book{
	private Book people;
	public BookProxy (Book people) {
		super();
		this.people=people;
	}
	@Override
	public void findBook() {
		System.out.println("BookProxy.findBook:代理商找书");
	}
	@Override
	public void checkBook() {
		System.out.println("BookProxy.checkBook代理商确认书");
	}
	@Override
	public void buyBook() {
		people.buyBook();
	}
}
