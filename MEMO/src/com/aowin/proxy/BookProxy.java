package com.aowin.proxy;

public class BookProxy implements Book{
	private Book people;
	public BookProxy (Book people) {
		super();
		this.people=people;
	}
	@Override
	public void findBook() {
		System.out.println("BookProxy.findBook:����������");
	}
	@Override
	public void checkBook() {
		System.out.println("BookProxy.checkBook������ȷ����");
	}
	@Override
	public void buyBook() {
		people.buyBook();
	}
}
