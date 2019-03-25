package com.aowin.junit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class AnotationTest {
	//异常expected=
	@Test(expected=ArithmeticException.class)
	public void testdiv() {
		assertEquals(5, new Two().div(15, 0));   
	}
//	@Test(timeout=190)--时间限制
//	@Ignore---skip
	@Ignore
	@Test(timeout=190)
	public void testWhile() {
		/*while(true) {
			System.out.println("run....");   
		}*/
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


}
