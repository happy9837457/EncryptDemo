package com.palm.encrypt.codec.md5;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5工具类
 * 
 * @author weixiang.qin
 * 
 */
public class MD5Util {
	/**
	 * 32位MD5(默认使用UTF-8编码)
	 * 
	 * @param s
	 * @return
	 */
	public final static String getMD532(String s) {
		return DigestUtils.md5Hex(s).toUpperCase();
	}
}
