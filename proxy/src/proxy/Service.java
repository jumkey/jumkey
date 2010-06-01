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
		try {
			// Wrapper the InputStream to BufferedReader
			BufferedReader input = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			// Wrapper the OutputStream to BufferedWriter
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream()));
			
			System.out.print(Encoder.getEncodeStr(input));
			//Redirect.sendHttp(Encoder.getEncodeStr(input));
			
			/*response*/
			PrintWriter out = new PrintWriter(output,true);
			out.println("HTTP/1.1 200 OK");//返回应答消息,并结束应答
			out.println("Content-Type: text/html; charset=utf-8");
			out.println();// 根据 HTTP 协议, 空行将结束头信息
			out.println("<h1> Hello Http Server空行</h1>");
			
			input.close();
			output.close();
		} catch (IOException e) {
			// Abandon the current connection.
			e.printStackTrace();
		} finally {
			try {
				// Close the connection.
				_socket.close();
			} catch (IOException e) {
				// Eat the IOException.
			}
		}
	}
}