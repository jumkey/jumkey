import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * 一个简单的HTTP客户端，发送HTTP请求，模拟浏览器
 * 可打印服务器发送过来的HTTP消息
 */
public class HttpClient {
	private static String encoding = "GBK";

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			StringBuffer sb = new StringBuffer();
			sb.append("POST /gaeproxy HTTP/1.1\r\n");
			sb.append("Host: 127.0.0.1:8888\r\n");
			sb.append("Connection: Keep-Alive\r\n");
			//注，这是关键的关键，忘了这里让我搞了半个小时。这里一定要一个回车换行，表示消息头完，不然服务器会等待
			sb.append("\r\n");
			sb.append("ffffffffffffffffffffhhhhhhhhhhhhhhhhhhhhhhdddddddddddddddddddddgggggggggggddd\r\n");
			osw.write(sb.toString());
			osw.flush();

			//--输出服务器传回的消息的头信息
			InputStream is = s.getInputStream();
			BufferedReader input = new BufferedReader(new InputStreamReader(is));
			String line = null;
			int contentLength = 0;//服务器发送回来的消息长度
			// 读取所有服务器发送过来的请求参数头部信息
			do {
				line = input.readLine();
				//如果有Content-Length消息头时取出
				if (line.startsWith("Content-Length")) {
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				//打印请求部信息
				System.out.print(line);
				//如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!line.equals("\r\n"));

			//--输消息的体
			//System.out.print(readLine(is, contentLength));

			//关闭流
			is.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
