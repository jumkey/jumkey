package proxy;

import java.io.BufferedReader;
import java.io.IOException;

public class Encoder {
	public static String getEncodeStr(BufferedReader input) throws IOException{
		StringBuffer sb=new StringBuffer();
		int contentLength = 0;
		String line = input.readLine();
		while (line != null) {
			sb.append(line + "\r\n");
			if("".equals(line))
				break;
			line = input.readLine();
			// here to fix post no response bug
            if(line.startsWith("Content-Length")) {
                try {
                    contentLength = Integer.parseInt(line.substring(line.indexOf(':') + 1).trim());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		}
		char[] tmpPost = new char[contentLength];
		
		for(int i = 0; i < contentLength; i++) {
			tmpPost[i] = (char)input.read();
			line += String.valueOf(tmpPost[i]);
		}
		sb.append(line);
		
		StringBuffer s=new StringBuffer();
		s.append("POST /gaeproxy HTTP/1.1\r\n");
		s.append("Host: 127.0.0.1\r\n");
		s.append("Connection: keep-alive\r\n");
		s.append("\r\n");
		s.append("11111111111wwwwwwwwwwwwww");
		return s.toString();
	}
}
