package com.aowin.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoTest {

	
	@Test
	public void testadd() {
		assertEquals(6,new Two().add(2,4));
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testminus() {
		assertEquals(6,new Two().minus(10,4));
	}
	@Test
	public void testmultiply() {
		assertEquals(8,new Two().multiply(2,4));
	}
	@Test
	public void testdiv() {
		assertEquals(3,new Two().div(15,5));
	}
}
