package com.palm.encrypt.jce.base64;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Base64UtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDecode() throws IOException {
		String origin = "中文";
		String dest = Base64Util.encode(origin);
		System.out.println("dest:" + dest + " decode:"
				+ Base64Util.decode(dest));
	}

	@After
	public void tearDown() throws Exception {
	}

}
