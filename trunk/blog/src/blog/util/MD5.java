package blog.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	/**
	 * 利用MD5进行加密
	 * 
	 * @author Jumkey
	 * @param s
	 *            待加密的字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 *             没有这种产生消息摘要的算法
	 * @throws UnsupportedEncodingException
	 */
	public final static String getMD5(String s)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 用来将字节转换成 16 进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		byte[] btInput = s.getBytes("UTF-8");
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		mdInst.update(btInput);
		byte[] md = mdInst.digest();// MD5 的计算结果是一个 128 位的长整数，
		// 用字节表示就是 16 个字节
		int j = md.length;
		char str[] = new char[j * 2];// 每个字节用 16 进制表示的话，使用两个字符，
		// 所以表示成 16 进制需要 32 个字符
		int k = 0;
		for (int i = 0; i < j; i++) {// 从第一个字节开始，对 MD5 的每一个字节
			// 转换成 16 进制字符的转换
			byte byte0 = md[i];// 取第 i 个字节
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,
			// >>> 为逻辑右移，将符号位一起右移
			str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换
		}
		return new String(str);// 换后的结果转换为字符串
	}

	/**
	 * MD5 加密
	 * 
	 * @author Jumkey
	 * @param str
	 *            待加密的字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public final static String getMD5Str(String str)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();
		messageDigest.update(str.getBytes("UTF-8"));
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}
}
