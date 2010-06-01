package MyServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Processor extends Thread {

	private InputStream input;
	private PrintStream out;
	private static final String WEB_ROOT = "D:\\MyServer\\WebRoot";

	public Processor(Socket socket) {
		// 初始化进程
		try {
			input = socket.getInputStream();
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		String fileName;
		try {
			fileName = parse(input);
			readFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String parse(InputStream input) throws IOException {
		// 根据HTTP协议，分析HTTP请求

		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String httpRequest = in.readLine();
		if (httpRequest == null || httpRequest.length() == 0) {
			sendError(400, "Client Request Error");
			return null;
		}

		String[] requestContent = httpRequest.split(" ");
		if (requestContent.length != 3) {
			sendError(400, "Client Request Error");
		}
		String statusCode = requestContent[0];
		String requestFileName = requestContent[1];
		String protocolVersion = requestContent[2];
		System.out.println("Protocal Version :" + protocolVersion
				+ "\n Request Status Code : " + statusCode
				+ "\n Request File Name :" + requestFileName);

		in.close();

		return requestFileName;

	}

	// 文件读写
	public void readFile(String fileName) throws IOException {
		// 生成一个文件对象
		File file = new File(Processor.WEB_ROOT + fileName);
		// 判断文件对象是否存在
		if (!file.exists()) {
			sendError(404, "File Not Found");
		}
		// 把文件读入输入流
		InputStream in = new FileInputStream(file);
		// 创建一个与文件长度相等二进制数组，把文件读入
		byte[] inputContent = new byte[(int) file.length()];
		in.read(inputContent);
		out.println("HTTP/1.0 200 sendFile");
		out.println("Content-length: " + inputContent.length);
		out.println();
		// 把文件从输入流中有输出流读出
		out.write(inputContent);
		out.flush();
		out.close();
		in.close();
	}

	public void sendError(int statusCode, String ErrorMessage) {
		// 发送错误信息，HTTP请求是否正确，请求的文件是否是授权访问的，文件是否存在
		System.out.println("Error Status :" + statusCode);
		System.out.println("Error Message :" + ErrorMessage);
	}

}