package com.palm.encrypt.md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MD5UtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMD516() {
//		System.out.println(MD5Util.getInstance().getMD516("123456"));
	}

	@Test
	public void testGetMD532() {
		System.out.println(MD5Util.getMD532("中文"));
		System.out.println(DigestUtils.md5Hex("中文").toUpperCase());// 默认UTF-8编码
		System.out.println(DigestUtils.md2Hex("中文").toUpperCase());// MD2
		
	}

	@After
	public void tearDown() throws Exception {
	}

}
