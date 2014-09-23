package com.palm.encrypt.rsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RsaSignDemoTest {
	private RsaSignDemo rsaSignDemo;

	@Before
	public void setUp() throws Exception {
		rsaSignDemo = new RsaSignDemo();
	}

//	@Test
	public void testSign() {
		String sign = rsaSignDemo.sign("message");
		System.out.println("sign:" + sign);
	}
	
	@Test
	public void testVerify() {
		String sign = rsaSignDemo.sign("message");
		boolean result = rsaSignDemo.verify("message", sign);
		System.out.println("result:" + result);
	}

	@After
	public void tearDown() throws Exception {
		rsaSignDemo = null;
	}

}
