package com.appspot.common;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * DES加密解密类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class DesEncrypt {
	private static Key key = null;

	private static Key getKey() {
		if (key == null) {
			try {
				String strKey = "******";
				KeyGenerator generator = KeyGenerator.getInstance("DES");
				generator.init(new SecureRandom(strKey.getBytes()));
				key = generator.generateKey();
			} catch (Exception e) {
			}
		}
		return key;
	}

	public static String getEncString(String str) {
		return byte2hex(getEncCode(str.getBytes()));
	}

	public static String getDesString(String str) {
		return new String(getDesCode(hex2byte(str.getBytes())));
	}

	private static byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, getKey());
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	private static byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, getKey());
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	private static byte[] hex2byte(byte[] b) {
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}
}
