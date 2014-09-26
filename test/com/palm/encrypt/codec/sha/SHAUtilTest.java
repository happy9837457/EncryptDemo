package com.palm.encrypt.codec.sha;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.encrypt.codec.sha.SHAUtil;

public class SHAUtilTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testSha1() {
		String origin = "123456";
		System.out.println(SHAUtil.sha1(origin));
	}
	
	@Test
	public void testSha256() {
		String origin = "123456";
		System.out.println(SHAUtil.sha256(origin));
	}
	
	@Test
	public void testSha384() {
		String origin = "123456";
		System.out.println(SHAUtil.sha384(origin));
	}
	
	@Test
	public void testSha512() {
		String origin = "123456";
		System.out.println(SHAUtil.sha512(origin));
	}

	@After
	public void tearDown() throws Exception {
	}

	

}
