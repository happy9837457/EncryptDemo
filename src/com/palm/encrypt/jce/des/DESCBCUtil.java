package com.palm.encrypt.jce.des;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * DES工具类
 * secretKey必须是8位
 * @author weixiang.qin
 * 
 */
public class DESCBCUtil {
	private static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
	private static final String CHARSET = "UTF-8";
	private String secretKey;

	public DESCBCUtil(String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * 加密
	 * 
	 * @param origin
	 * @return
	 */
	public String encrypt(String origin) {
		try {
			Key key = SecretKeyFactory.getInstance("DES").generateSecret(
					new DESKeySpec(secretKey.getBytes()));
			// DES/CBC/NoPadding,若采用NoPadding模式，doFinal参数data长度必须是8的倍数
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
			IvParameterSpec iv = new IvParameterSpec(secretKey.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);
			return byte2hex(cipher.doFinal(origin.getBytes(CHARSET)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param dest
	 * @return
	 */
	public String decrypt(String dest) {
		try {
			Key key = SecretKeyFactory.getInstance("DES").generateSecret(
					new DESKeySpec(secretKey.getBytes()));
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
			IvParameterSpec iv = new IvParameterSpec(secretKey.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, key, iv);
			return new String(cipher.doFinal(hex2byte(dest.getBytes())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String byte2hex(byte[] b) {
		StringBuilder hs = new StringBuilder();
		String stmp;
		for (int n = 0; b != null && n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1)
				hs.append('0');
			hs.append(stmp);
		}
		return hs.toString().toUpperCase();
	}

	private byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException();
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}
}
