package com.palm.encrypt.bouncy.base64;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Base64UtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDecode() {
		String origin = "中文";
		String dest = Base64Util.encode(origin);
		System.out.println("dest:" + dest + " decode:"
				+ Base64Util.decode(dest));
	}

	@After
	public void tearDown() throws Exception {
	}

}
