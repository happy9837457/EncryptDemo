package com.palm.encrypt.bouncy.md5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MD5UtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(MD5Util.getMD532("12345"));
	}

	@After
	public void tearDown() throws Exception {
	}

}
