package com.palm.encrypt.jce.des;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.encrypt.jce.des.DESECBUtil;
import com.palm.encrypt.jce.util.Const;

public class DESECBUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDecode() {
		String origin = "中文";
		DESECBUtil desUtil = new DESECBUtil(Const.DES_EBC_KEY);
		String dest = desUtil.encrypt(origin);
		System.out.println("dest:" + dest + " result:" + desUtil.decrypt(dest));
	}

	@After
	public void tearDown() throws Exception {
	}

}
