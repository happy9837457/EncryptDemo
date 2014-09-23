package com.palm.encrypt.aes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.encrypt.util.Const;

public class AESUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDecrypt() {
		AESUtil aesUtil = new AESUtil(Const.AES_KEY);
		String dest = aesUtil.encrypt("中文");
		System.out.println(dest);
		System.out.println(aesUtil.decrypt(dest));
	}

	@After
	public void tearDown() throws Exception {
	}

}
