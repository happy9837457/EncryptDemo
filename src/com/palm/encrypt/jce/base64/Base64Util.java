package com.palm.encrypt.jce.base64;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
		return new String(new BASE64Encoder().encode(origin.getBytes()));
	}

	/**
	 * 解密
	 * 
	 * @param dest
	 * @return
	 * @throws IOException
	 */
	public static String decode(String dest) throws IOException {
		return new String(new BASE64Decoder().decodeBuffer(dest));
	}
}
