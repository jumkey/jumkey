package proxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Redirect {
	public static void sendHttp(String sb) {
		try{
			Socket s = new Socket("127.0.0.1", 8888);
			BufferedWriter soutput = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			BufferedReader sinput = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			soutput.write(sb.toString());
			soutput.flush();
			
			String line = null;
			int contentLength = 0;//服务器发送回来的消息长度
			// 读取所有服务器发送过来的请求参数头部信息
			do {
				line = sinput.readLine();
				//如果有Content-Length消息头时取出
				if (line.startsWith("Content-Length")) {
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				//打印请求部信息
				System.out.print(line+"\r\n");
				//如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!"".equals(line));
			
			soutput.close();
			sinput.close();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
