package com.palm.encrypt.aes;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES工具类
 * AES可以使用128、192、和256位密钥，并且用128位分组加密和解密数据
 * @author weixiang.qin
 * 
 */
public class AESUtil {
	private static final int KEYSIZE = 128;
	private static final String CHARSET = "UTF-8";
	private String secretKey;

	public AESUtil(String secretKey) {
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
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
            secureRandom.setSeed(secretKey.getBytes());  
			kgen.init(KEYSIZE, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
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
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
            secureRandom.setSeed(secretKey.getBytes());  
			kgen.init(KEYSIZE, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
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
