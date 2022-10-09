package com.myshow.util;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

/**
 * @author BhargavRajJinka
 *
 */
public class PasswordEncryption {
	/**
	 * @param password
	 * @return
	 */
	public static String encryption(String password) {


	String encryptedPassword = null;
	try
	{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(password.getBytes());
		byte[] bytes = m.digest();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		encryptedPassword = s.toString();
	}catch(NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	return encryptedPassword;
	
}
	}
