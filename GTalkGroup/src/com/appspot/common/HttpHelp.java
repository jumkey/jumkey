package com.appspot.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;

/**
 * http公共处理类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class HttpHelp {
	public static String readBufferedContent(BufferedReader bufferedReader) {
		if (bufferedReader == null)
			return null;
		StringBuffer result = new StringBuffer();
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			return null;
		}
		return result.toString();
	}

	/**
	 * 对发布的消息进行处理(目前主要为处理消息中的短地址)
	 * 
	 * @param publishContent，发布的消息
	 * @return，处理后的消息
	 */
	public static String processContent(String publishContent) {
		Pattern pattern = Pattern
				.compile(
						"(((www\\.)|(http://)|(ftp://))[A-Z,a-z,0-9,\\p{Punct},\\+]+)\\s",
						Pattern.MULTILINE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(publishContent);
		String url = "";
		while (matcher.find()) {
			url += matcher.group();
		}
		url = url.trim();
		if (url.length() > 0) {
			String tinyurl = tinyUrl(url);
			publishContent = replace(publishContent, url, tinyurl);
		}
		return publishContent;
	}

	/**
	 * 利用短地址服务，处理URL地址
	 * 
	 * @param url，原始地址
	 * @return，处理后的短地址
	 */
	private static String tinyUrl(String url) {
		HttpURLConnection httpURLConnection = null;
		OutputStream httpOutputStream = null;
		String responseStr = null;
		try {
			URLConnection con = new URL("http://is.gd/api.php?longurl=" + url)
					.openConnection();
			if (con != null) {
				httpURLConnection = (HttpURLConnection) con;
			} else {
				return url;
			}
			httpURLConnection.setRequestMethod("get");
			httpURLConnection.setDoOutput(true);
			httpOutputStream = httpURLConnection.getOutputStream();

			BufferedReader httpBufferedReader = new BufferedReader(
					new InputStreamReader(httpURLConnection.getInputStream()));
			responseStr = HttpHelp.readBufferedContent(httpBufferedReader);

			if (responseStr != null && responseStr.length() > 0
					&& responseStr.indexOf("http") != -1) {
				return responseStr;
			}
		} catch (Exception e) {
		} finally {
			try {
				httpOutputStream.close();
				httpURLConnection.disconnect();
			} catch (Exception e) {
			}
		}
		return url;
	}

	/**
	 * 字符串替换函数
	 * 
	 * @param line，需要替换的字符串
	 * @param oldString，替换前的字符串
	 * @param newString，替换后的字符串
	 * @return，处理后的字符串
	 */
	private static String replace(String line, String oldString,
			String newString) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}
}
