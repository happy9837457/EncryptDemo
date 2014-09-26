package com.palm.encrypt.jce.rsa;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.encrypt.jce.rsa.RsaSignDemo;

public class RsaSignDemoTest {
	public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANd8r2yi4E+H/oiPT80ttEjdkcH/niEdZcCOuILP3uNmzzNI+GmtUf9FF+1EFpkEwgJb+shahL1FhyGR6Yj5w54+WhJGv2R9GCuMkQINdBBgLJF6wVqEr5OlbwQUm7U6rxNaEq88xA5KuvozKFsOFfj4b9KiAb2Ipr1krzYsAemfAgMBAAECgYAD1J6VssuD/mni6ZFEl3Rl+zJVHYMlGY2uf5r+EE3pAvHZ+okX79HOVN8ZA6XXMIN2YUYy+5DygGLnkN1y5uW4SQxI+Q5x8C6T9bRhJlieo7Qatu1iuuDU6ckpK859bPZsiFMkhrTaLVCUh3iZB2J6hkWDwoWIuqcUxrpxyQkcyQJBAPipcAeyi0IyvkwSk1flxNED3wqEbGeoVv0dYDH+AaS3usCoTFLIXYrgqwCoOXA2kFmC0yjVBEBbj6eNnWRn60MCQQDd2J9QianY/1NCneM7pkAPw75MLZ+bef0EJ63H4cVJFuFVliXb1iPbl/s+jvbFUJiUXpkQu4BT+1FhArhRLsx1AkEAq2tLAtNvsvv+Ob0YfCC2lIyBpuNxQ+hFx4oHtY7wnRfXk1ax/uOHsOR+nh5aMmQ7EKniXaSzoJY+KviyRvRotwJBAJiM/3CYWY14db6XZ8x61A6DIfasYNa/GfejeWK7o7hQ3X7HEx2KsXmtlv07vgGNHH7aVhMlfGdDqIA3KJvavIkCQB78n7SJVZM0fKHscefsmib6MmfjVthv6aSiQqWFjoOrRFC6GjqeJjWGteEJrO1lHRLi2+pB3/PFuhwQnVxIds0=";
	public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXfK9souBPh/6Ij0/NLbRI3ZHB/54hHWXAjriCz97jZs8zSPhprVH/RRftRBaZBMICW/rIWoS9RYchkemI+cOePloSRr9kfRgrjJECDXQQYCyResFahK+TpW8EFJu1Oq8TWhKvPMQOSrr6MyhbDhX4+G/SogG9iKa9ZK82LAHpnwIDAQAB";
	private RsaSignDemo rsaSignDemo;

	@Before
	public void setUp() throws Exception {
		rsaSignDemo = new RsaSignDemo();
	}

	@Test
	public void testVerify() throws IOException {
		/**String sign = rsaSignDemo.sign("message",
				FileUtil.read(Const.PRIVATE_PATH));
		boolean result = rsaSignDemo.verify("message", sign,
				FileUtil.read(Const.PUBLIC_PATH));
		System.out.println("result:" + result);**/
		String sign = rsaSignDemo.sign("加密", PRIVATE_KEY);
		boolean result = rsaSignDemo.verify("加密", sign, PUBLIC_KEY);
		System.out.println("result:" + result);
	}

	@After
	public void tearDown() throws Exception {
		rsaSignDemo = null;
	}

}
