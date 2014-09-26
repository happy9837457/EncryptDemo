package com.palm.encrypt.jce.sha;

import java.security.MessageDigest;

import com.palm.encrypt.util.HexUtil;

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
		try {
			byte[] btInput = origin.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("SHA-1");
			mdInst.update(btInput);
			return HexUtil.byteToHex(mdInst.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
