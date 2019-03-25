package com.aowin.javabasic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReferenceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReference() {
		System.out.println(Reference.reference());
	}
	@Test
	void testInstance() {
		/*new Reference().staticinstance();
		new Reference().staticinstance();
		new Reference().staticinstance();*/
		new  Reference().mathtest();
	}

}
