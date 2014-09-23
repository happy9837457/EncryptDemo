package com.palm.encrypt.base64;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64工具类 
 * 算法:把3个8位字节转化为4个6位的字节,之后在6位的前面补两个0,形成8位一个字节的形式
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
		return new String(Base64.encodeBase64(origin.getBytes()));
	}

	/**
	 * 解密
	 * 
	 * @param dest
	 * @return
	 */
	public static String decode(String dest) {
		return new String(Base64.decodeBase64(dest.getBytes()));
	}
}
