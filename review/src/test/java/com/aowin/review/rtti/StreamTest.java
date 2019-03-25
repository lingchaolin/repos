package com.aowin.review.rtti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StreamTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFileInStream() throws Exception {
		new Stream().fileInStream();
	}
	@Test
	void testbufferInStream() throws Exception {
		new Stream().bufferInStream();
	}

	@Test
	void testFileOutStream() throws Exception {
		new Stream().fileOutStream();
	}
	@Test
	void testbufferOutStream() throws Exception {
		new Stream().bufferOutStream();
	}
	@Test
	void testFileTransfer() throws Exception {
		new Stream().fileTransfer();
	}
	@Test
	void dataInStream() throws Exception {
		new Stream().dataInStream();
	}
	@Test
	void dataOutStream() throws Exception {
		new Stream().dataOutStream();
	}
	@Test
	void testObjectIn() throws Exception {
		new ObjectIO().objIn();
	}
	@Test
	void testObjectOut() throws Exception {
		new ObjectIO().objOut();
	}

}
