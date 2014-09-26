package com.palm.encrypt.bouncy.base64;

import org.bouncycastle.util.encoders.Base64;

/**
 * Base64工具类
 * 
 * @author weixiang.qin
 * 
 */
public class Base64Util {
	/**
	 * 加密
	 * 
	 * @param origin
	 * @return
	 */
	public static String encode(String origin) {
		return new String(Base64.encode(origin.getBytes()));
	}

	/**
	 * 解密
	 * 
	 * @param dest
	 * @return
	 */
	public static String decode(String dest) {
		return new String(Base64.decode(dest));
	}
}
