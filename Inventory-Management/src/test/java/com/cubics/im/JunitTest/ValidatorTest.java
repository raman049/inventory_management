package com.cubics.im.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.AsynchronousServerSocketChannel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cubics.im.validator.Validator;

class ValidatorTest {

	Validator validator = new Validator();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void emailTest() {
		boolean result = validator.email("raman@yahoo.com");
		assertEquals(true, result);
		boolean result1 = validator.email("rama939n@yahoo.ckkom");
		assertEquals(true, result1);
		boolean result2 = validator.email("an@yahoo.com");
		assertEquals(true, result2);
		boolean result3 = validator.email("raman@yahoo.com");
		assertEquals(true, result3);
		boolean result4 = validator.email("ramanyahoo.com");
		assertEquals(false, result4);
		boolean result5 = validator.email("raman@yahoocom");
		assertEquals(false, result5);
		boolean result6 = validator.email("raman.com");
		assertEquals(false, result6);
	}

	@Test
	public void validNameTest() {
		boolean result = validator.validName("Raman");
		assertEquals(true, result);
		boolean result2 = validator.validName("Ra");
		assertEquals(false, result2);
		boolean result3 = validator.validName("Rkkesjksd90hkjhkjhkjhkjhkjhkjhkjhk");
		assertEquals(false, result3);
		boolean result4 = validator.validName("R4n");
		assertEquals(true, result4);
		boolean result5 = validator.validName("Raman Insurance Co");
		assertEquals(true, result5);
		boolean result6 = validator.validName("abcdefghijklmnopqrst");
		assertEquals(true, result6);
		boolean result7 = validator.validName("abcdefg hijklmno pqc rst");
		assertEquals(false, result7);
	}
	@Test
	public void vaidCodeTest() {
		boolean result = validator.validCode("ABCD");
		assertEquals(true, result);
		boolean result2 = validator.validCode("AAB9");
		assertEquals(true, result2);
		boolean result3 = validator.validCode("abcd");
		assertEquals(false, result3);
		boolean result4 = validator.validCode("a9");
		assertEquals(false, result4);
		boolean result5 = validator.validCode("1111");
		assertEquals(true, result5);
		boolean result6 = validator.validCode("AAAA");
		assertEquals(true, result6);
		boolean result7 = validator.validCode("AA3#");
		assertEquals(false, result7);
		boolean result8 = validator.validCode("11*8");
		assertEquals(false, result8);
	}
	
}
