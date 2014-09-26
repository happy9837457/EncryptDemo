package com.palm.encrypt.jce.rsa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.apache.commons.codec.binary.Base64;

import com.palm.encrypt.jce.util.Const;
import com.palm.encrypt.jce.util.FileUtil;

/**
 * 生成密钥对
 * 
 * @author weixiang.qin
 * 
 */
public class KeyUtil {
	/**
	 * 生成公钥和私钥对文件
	 */
	public static void generateRsa() {
		try {
			Key key = generateKey();
			String privateKey = new String(Base64.encodeBase64(key.privateKey.getEncoded()));
			String publicKey = new String(Base64.encodeBase64(key.publicKey.getEncoded()));
			FileUtil.write(Const.PRIVATE_PATH, privateKey);
			FileUtil.write(Const.PUBLIC_PATH, publicKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成公钥和私钥对
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static Key generateKey() throws NoSuchAlgorithmException {
		KeyPair keyPair = generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
		Key key = new Key();
		key.privateKey = privateKey;
		key.publicKey = publicKey;
		return key;
	}

	/**
	 * 生成KeyPair
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		return keyGen.generateKeyPair();
	}
	
	static class Key {
		public PrivateKey privateKey;
		public PublicKey publicKey;
	}
}
