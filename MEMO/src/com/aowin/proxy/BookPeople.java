package com.aowin.proxy;

public class BookPeople implements Book{
	@Override
	public void findBook() {
		System.out.println("BookPeople.findBook:买书的人找书");
	}
	@Override
	public void checkBook() {
		System.out.println("BookPeople.checkBook:买书的人确认书");
	}
	@Override
	public void buyBook() {
		System.out.println("BookPeople.buyBook:买书的人付账");
	}
}
