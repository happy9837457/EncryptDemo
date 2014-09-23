package com.palm.encrypt.sha;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * SHA工具类
 * 
 * @author weixiang.qin
 * 
 */
public class SHAUtil {
	/**
	 * sha1加密
	 * 
	 * @param origin
	 * @return
	 */
	public static String sha1(String origin) {
		return DigestUtils.sha1Hex(origin);
	}
	
	/**
	 * sha256加密
	 * 
	 * @param origin
	 * @return
	 */
	public static String sha256(String origin) {
		return DigestUtils.sha256Hex(origin);
	}
	
	/**
	 * sha384加密
	 * 
	 * @param origin
	 * @return
	 */
	public static String sha384(String origin) {
		return DigestUtils.sha384Hex(origin);
	}
	
	/**
	 * sha512加密
	 * 
	 * @param origin
	 * @return
	 */
	public static String sha512(String origin) {
		return DigestUtils.sha512Hex(origin);
	}
}
