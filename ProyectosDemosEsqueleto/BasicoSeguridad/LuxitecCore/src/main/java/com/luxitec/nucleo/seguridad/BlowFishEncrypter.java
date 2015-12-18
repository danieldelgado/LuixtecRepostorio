package com.luxitec.nucleo.seguridad;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.luxitec.utilitarios.config.Config;

/**
 * @author Danielle Delgado
 *
 */
public class BlowFishEncrypter {

	private static Base64 base64 = new Base64(true);
	private static String key = Config.getPropiedad("luxitec.proyecto.ecryptacion");

	public static String encriptar(String data) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		return encriptar(data, key);
	}

	public static String desEncriptar(String data) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		return desEncriptar(data, key);
	}

	private static String encriptar(String data, String strkey) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		SecretKeySpec key = new SecretKeySpec(strkey.getBytes("ISO-8859-1"), "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return base64.encodeToString(cipher.doFinal(data.getBytes("ISO-8859-1")));
	}

	@SuppressWarnings("static-access")
	private static String desEncriptar(String encrypted, String strkey) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		byte[] encryptedData = base64.decodeBase64(encrypted);
		SecretKeySpec key = new SecretKeySpec(strkey.getBytes("ISO-8859-1"), "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decrypted = cipher.doFinal(encryptedData);
		return new String(decrypted);

	}

}
