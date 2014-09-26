package com.palm.encrypt.bouncy.md5;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;

import com.palm.encrypt.util.HexUtil;

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
	public static String getMD532(String s) {
		Digest md = new MD5Digest();
		byte[] message = s.getBytes();
		md.update(message, 0, message.length);
		byte[] digest = new byte[md.getDigestSize()];
		md.doFinal(digest, 0);
		return HexUtil.byteToHex(digest);
	}

}
