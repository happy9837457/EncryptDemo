package com.palm.encrypt.rsa;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.palm.encrypt.util.Const;
import com.palm.encrypt.util.FileUtil;

/**
 * rsa数字签名
 * 
 * @author weixiang.qin
 * 
 */
public class RsaSignDemo {

	/**
	 * 私钥生成数字签名
	 * 
	 * @param data
	 * @return
	 */
	public String sign(String data) {
		try {
			String privateKey = FileUtil.read(Const.PRIVATE_PATH);
			Signature sig = Signature.getInstance("SHA1WithRSA");
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
					Base64.decodeBase64(privateKey));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyFactory.generatePrivate(priPKCS8);
			sig.initSign(priKey);
			sig.update(data.getBytes("UTF-8"));
			byte[] result = sig.sign();
			return new String(Base64.encodeBase64(result));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 公钥校验数字签名
	 * 
	 * @param signText
	 * @param signData
	 * @return
	 */
	public boolean verify(String signText, String signData) {
		try {
			String publicKey = FileUtil.read(Const.PUBLIC_PATH);
			Signature sig = Signature.getInstance("SHA1WithRSA");
			X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(
					Base64.decodeBase64(publicKey));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey pubKey = keyFactory.generatePublic(pubX509);
			sig.initVerify(pubKey);
			sig.update(signText.getBytes());
			boolean result = sig.verify(Base64.decodeBase64(signData));
			return result;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
