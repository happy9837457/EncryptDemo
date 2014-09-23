package com.palm.encrypt.des;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.encrypt.util.Const;

public class DESCBCUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDecode() {
		String origin = "中文";
		DESCBCUtil desUtil = new DESCBCUtil(Const.DES_CBC_KEY);
		String dest = desUtil.encrypt(origin);
		System.out.println("dest:" + dest + " result:" + desUtil.decrypt(dest));
	}

	@After
	public void tearDown() throws Exception {
	}

}
