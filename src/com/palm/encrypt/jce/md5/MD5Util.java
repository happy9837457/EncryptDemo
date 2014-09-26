package com.palm.encrypt.jce.md5;

import java.security.MessageDigest;

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
			return byteToHex(mdInst.digest());
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

	/**
	 * 把密文转换成十六进制的字符串形式
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHex(byte[] b) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		int len = b.length;
		char[] chars = new char[len * 2];
		int k = 0;
		for (int i = 0; i < len; i++) {
			byte byte0 = b[i];
			chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
			chars[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(chars);
	}
}
