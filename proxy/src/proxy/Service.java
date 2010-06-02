package proxy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Service extends Thread {
	private Socket _socket;

	public Service(Socket socket) {
		_socket = socket;
	}

	public void run() {
		Socket s = null;
		try {
			// Wrapper the InputStream to BufferedReader
			BufferedReader input = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			// Wrapper the OutputStream to BufferedWriter
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream()));
			
			//System.out.print(Encoder.getEncodeStr(input));
			//Redirect.sendHttp(Encoder.getEncodeStr(input));
			

			s = new Socket("127.0.0.1", 8888);
			BufferedWriter soutput = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			BufferedReader sinput = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			soutput.write(Encoder.getEncodeStr(input).toString());
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
			
			
			
			
			/*response*/
			PrintWriter out = new PrintWriter(output,true);
			out.println("HTTP/1.1 200 OK");//返回应答消息,并结束应答
			out.println("Content-Type: text/html; charset=utf-8");
			out.println();// 根据 HTTP 协议, 空行将结束头信息
			out.println("<h1> Hello Http Server空行</h1>");
			
			input.close();
			output.close();
			soutput.close();
			sinput.close();
		} catch (IOException e) {
			// Abandon the current connection.
			e.printStackTrace();
		} finally {
			try {
				// Close the connection.
				_socket.close();
				s.close();
			} catch (IOException e) {
				// Eat the IOException.
			}
		}
	}
}