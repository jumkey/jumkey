package org.cafeboy.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.cafeboy.util.ValidateCode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SendPostMethod {

	public static void main(String[] args) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) new URL("http://www.ems.com.cn/ems/rand?d=" + Math.random()).openConnection();
		conn.setRequestMethod("GET");
		InputStream input = conn.getInputStream();
		File storeFile = new File("C:/temp.jpg");
		FileOutputStream output = new FileOutputStream(storeFile);
		// 得到网络资源的字节数组,并写入文件
		byte[] buffer = new byte[1024]; // Adjust if you want
		int bytesRead;
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}

		output.close();
		String s = new ValidateCode().crackValidateCode("C:/temp.jpg");
		System.out.println(s);
		conn.disconnect();

		String url = "http://www.ems.com.cn/ems/order/multiQuery_t";
		// String url = "http://www.ems.com.cn/ems/order/singleQuery_t";
		Map<String, String> cc = getCookies(conn);
		Map<String, String> map = new HashMap<String, String>();
		map.put("mailNum", "");
		map.put("muMailNum", "");
		map.put("checkCode", s);
		Document doc = Jsoup.connect(url).data(map).cookies(cc).post();
		Elements newsHeadlines = doc.select(".body_content_container");
		String response = newsHeadlines.html();

		System.out.println(response);
	}

	public static Map<String, String> getCookies(HttpURLConnection conn) {
		Map<String, String> cookies = new HashMap<String, String>();
		String headName;
		for (int i = 1; (headName = conn.getHeaderField(i)) != null; i++) {
			String key = conn.getHeaderFieldKey(i);
			if (key.equalsIgnoreCase("set-cookie")) {
				String[] cookie = headName.substring(0, headName.indexOf(";")).split("=");
				cookies.put(cookie[0].trim(), cookie[1].trim());
			}
		}
		return cookies;
	}
}