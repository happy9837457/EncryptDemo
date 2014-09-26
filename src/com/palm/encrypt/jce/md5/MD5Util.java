package com.palm.encrypt.jce.md5;

import java.security.MessageDigest;

import com.palm.encrypt.util.HexUtil;

/**
 * MD5工具类
 * 
 * @author weixiang.qin
 * 
 */
public class MD5Util {
	private static final String CHARSET = "UTF-8";

	/**
	 * 32位MD5
	 * 
	 * @param s
	 * @return
	 */
	public final static String getMD532(String s) {
		try {
			byte[] btInput = s.getBytes(CHARSET);
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			return HexUtil.byteToHex(mdInst.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 16位MD5(前十六位)
	 * 
	 * @param str
	 * @return
	 */
	public static String getMD516(String str) {
		String result = getMD532(str);
		if (result == null) {
			return null;
		}
		return result.substring(0, 16);
	}

}
