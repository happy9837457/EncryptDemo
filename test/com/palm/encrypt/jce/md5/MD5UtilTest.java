package com.palm.encrypt.jce.md5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MD5UtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMD516() {
		System.out.println(MD5Util.getMD516("123456"));
	}

	@Test
	public void testGetMD532() {
		System.out.println(MD5Util.getMD532("中文"));
	}

	@After
	public void tearDown() throws Exception {
	}

}
