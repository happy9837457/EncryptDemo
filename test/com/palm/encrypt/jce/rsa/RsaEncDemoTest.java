package com.palm.encrypt.jce.rsa;

import java.security.KeyPair;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.encrypt.jce.rsa.KeyUtil;
import com.palm.encrypt.jce.rsa.RsaEncDemo;

public class RsaEncDemoTest {
	private RsaEncDemo rsaEncDemo;
	private KeyPair keyPair;

	@Before
	public void setUp() throws Exception {
		rsaEncDemo = new RsaEncDemo();
		keyPair = KeyUtil.generateKeyPair();
	}

//	@Test
	public void testPublicEncrypt() {
		
	}

//	@Test
	public void testPrivateDecrypt() throws Exception {
		byte[] encrypt = rsaEncDemo.publicEncrypt(keyPair, "message");
		byte[] decrypt = rsaEncDemo.privateDecrypt(keyPair, encrypt);
		System.out.println(new String(decrypt, "UTF-8"));
	}
	
//	@Test
	public void testPrivateEncrypt() {
		
	}
	
	@Test
	public void testPublicDecrypt() throws Exception {
		byte[] encrypt = rsaEncDemo.privateEncrypt(keyPair, "success");
		byte[] decrypt = rsaEncDemo.publicDecrypt(keyPair, encrypt);
		System.out.println(new String(decrypt, "UTF-8"));
	}

	@After
	public void tearDown() throws Exception {
		keyPair = null;
	}
}
