package com.luxitec.nucleo.seguridad;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/**
 * @author Danielle Delgado
 *
 */
public class EncripUtil {
	public static final String DEFAULT_ENCRYPTION_KEY = "This is a fairly long phrase used to encrypt";

	private static final String STRING_ENCODING = "UTF-8";

	private static final String encryptionScheme = "DES";

	/**
	 * @param encryptionKey
	 * @param mode
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws Exception
	 */
	public static Cipher getCipher(String encryptionKey, int mode) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException  {
		if (encryptionKey == null)
			throw new IllegalArgumentException("encryption key was null");
		if (encryptionKey.trim().length() < 24)
			throw new IllegalArgumentException("encryption key was less than 24 characters");

		byte[] keyAsBytes = encryptionKey.getBytes(STRING_ENCODING);

		KeySpec keySpec = new DESKeySpec(keyAsBytes);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
		Cipher cipher = Cipher.getInstance(encryptionScheme);

		SecretKey key = keyFactory.generateSecret(keySpec);
		cipher.init(mode, key);

		return cipher;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.modlost.crypt.CryptService#encrypt(java.lang.String,
	 * java.lang.String)
	 */
	public static String encrypt(String encryptionKey, String unencryptedString) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException{
		if (unencryptedString == null || unencryptedString.trim().length() == 0)
			return unencryptedString;

		Cipher cipher = getCipher(encryptionKey, Cipher.ENCRYPT_MODE);

		byte[] cleartext = unencryptedString.getBytes(STRING_ENCODING);
		byte[] ciphertext = cipher.doFinal(cleartext);

		return new String(Base64.encode(ciphertext));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.modlost.crypt.CryptService#decrypt(java.lang.String,
	 * java.lang.String)
	 */
	public static String decrypt(String encryptionKey, String encryptedString) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		if (encryptedString == null || encryptedString.trim().length() <= 0)
			return encryptedString;

		Cipher cipher = getCipher(encryptionKey, Cipher.DECRYPT_MODE);

		byte[] cleartext = Base64.decode(encryptedString);

		byte[] ciphertext = cipher.doFinal(cleartext);

		return bytes2String(ciphertext);
	}

	private static String bytes2String(byte[] bytes) {
		StringBuilder stringBuffer = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}
}
