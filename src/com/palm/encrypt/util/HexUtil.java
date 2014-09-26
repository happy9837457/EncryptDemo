package com.palm.encrypt.util;

/**
 * 十六进制转换
 * 
 * @author weixiang.qin
 * 
 */
public class HexUtil {
	/**
	 * 把密文转换成十六进制的字符串形式
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToHex(byte[] b) {
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
