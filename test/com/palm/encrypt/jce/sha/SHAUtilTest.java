package com.palm.encrypt.jce.sha;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SHAUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSha1() {
		String origin = "123456";
		System.out.println(SHAUtil.sha1(origin));
	}

	@After
	public void tearDown() throws Exception {
	}

}
