package com.java.demo.encrypt.rsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.encrypt.rsa.KeyUtil;

public class KeyUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGenerateRsa() {
		KeyUtil.generateRsa();
	}

	@After
	public void tearDown() throws Exception {
	}

}
