package socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 基于阻塞 模式的简单的java服务器
 * 
 * @author 衣旧 2010-06-06
 */
public class HttpServer {

	/**
	 * 监听本地端口
	 */
	private ServerSocket serverSocket;

	/**
	 * 根目录
	 */
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "wwwroot";
	/**
	 * 服务器监听端口, 默认为 80.
	 */
	public static int PORT = 80;

	/**
	 * 开始服务器 Socket 线程.
	 */
	public HttpServer() {
		try {
			serverSocket = new ServerSocket(PORT);
			while (true) {
				Socket client = serverSocket.accept();
				new IoHandler(client);
			}
		} catch (Exception e) {
			System.out.println("无法启动HTTP服务器:" + e.toString());
		}
		if (serverSocket == null)
			System.exit(1);// 无法开始服务器
		System.out.println("HTTP 服务器正在运行,端口:" + PORT);
	}

	/**
	 * 打印用途说明.
	 */
	private static void usage() {
		System.out.println("Usage: java serverSocket <port>\nDefault port is 80.");
	}

	/**
	 * 启动简易 HTTP 服务器
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				usage();
			} else if (args.length == 1) {
				PORT = Integer.parseInt(args[0]);
			}
		} catch (Exception ex) {
			System.err.println("初始端口. 必须是大于0的整数!\n" + ex.toString());
		}
		new HttpServer();
	}

	/**
	 * 响应http请求
	 * 
	 * @author liucf
	 * 
	 */
	class IoService {

		private IoProcessor request;
		private PrintWriter out;
		private PrintStream outs;
		private int BUFFER_SIZE = 1024;

		IoService(PrintWriter output, PrintStream outs) {
			this.out = output;
			this.outs = outs;
		}

		public IoProcessor getRequest() {
			return request;
		}

		public void setRequest(IoProcessor request) {
			this.request = request;
		}

		public void responseInfo() {
			if ("POST".equalsIgnoreCase(request.getMethod())
					&& request.getContentLength() > 0) {
//				System.out.println("以下内容为 POST 方式提交的表单数据");
//				for (int i = 0; i < request.getContentLength(); i++) {
//					try {
//						System.out.print((char) request.getIn().read());
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
			}

			if ("GET".equalsIgnoreCase(request.getMethod())) {
				doGet();
			}
		}

		public void doGet() {
			File file = new File(HttpServer.WEB_ROOT, request.getUri());
			if (file.isDirectory()) {
				out.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
				out.println("Content-Type:text/html;charset=GBK");
				out.println();
				out.println("<h1>不允许访问文件夹!!</h1>");
			} else if (file.exists()) {
				byte[] bytes = new byte[BUFFER_SIZE];
				FileInputStream fis = null;
				if (file.exists()) {
					try {
						fis = new FileInputStream(file);
						int ch = fis.read(bytes, 0, BUFFER_SIZE);
						while (ch != -1) {
							outs.write(bytes, 0, ch);
							ch = fis.read(bytes, 0, BUFFER_SIZE);
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				out.println("HTTP/1.0 404 Not found");// 返回应答消息,并结束应答
				out.println("Content-Type:text/html;charset=GBK");
				out.println();
				out.println("<h1>访问路径不存在!!</h1>");
			}
		}
	}

	/**
	 * 
	 * 封装处理http请求信息
	 * 
	 * @author liucf
	 * 
	 */
	class IoProcessor {
		private BufferedReader in;
		private String uri;
		private String method;
		private int contentLength;
		private Map http = new HashMap();

		public IoProcessor(BufferedReader in) {
			this.in = in;
			parseRequstInfo();
		}

		private void parseRequstInfo() {
			String line = null;
			try {
				line = in.readLine();
				// 读取第一行, 请求地址
				System.out.println(line);
				String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/') - 5);
				// 获得请求的资源的地址
				uri = URLDecoder.decode(resource, "UTF-8");// 反编码
				// 地址
				method = new StringTokenizer(line).nextElement().toString();// 获取请求方法,

				// 读取所有浏览器发送过来的请求参数头部信息
				while ((line = in.readLine()) != null) {
					if (line.equals(""))
						break;
					if (line.indexOf(":") != -1) {
						String key = line.substring(0, line.indexOf(':'))
								.trim();
						String value = line.substring(line.indexOf(':') + 1)
								.trim();
						http.put(key, value);
						// 读取 POST 等数据的内容长度
						if (line.startsWith("Content-Length")) {
							try {
								contentLength = Integer.parseInt(line
										.substring(line.indexOf(':') + 1)
										.trim());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			} catch (IOException e) {
				System.out.println("解析请求出错!");
				e.printStackTrace();
			}
		}

		public BufferedReader getIn() {
			return in;
		}

		public void setIn(BufferedReader in) {
			this.in = in;
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		public int getContentLength() {
			return contentLength;
		}

		public void setContentLength(int contentLength) {
			this.contentLength = contentLength;
		}

		public Map getHttp() {
			return http;
		}

		public void setHttp(Map http) {
			this.http = http;
		}
	}

	/**
	 * 响应客户端请求
	 * 
	 * @author liucf
	 * 
	 */
	class IoHandler implements Runnable {

		private Socket client;// 客户端连接

		private BufferedReader input;// 接收外部信息的流

		private PrintWriter printWriter;// 输出流

		private PrintStream printStream;

		public IoHandler(Socket socket) {
			this.client = socket;
			try {
				input = new BufferedReader(new InputStreamReader(client
						.getInputStream()));
				printWriter = new PrintWriter(new OutputStreamWriter(client
						.getOutputStream(), "GBK"), true);
				printStream = new PrintStream(client.getOutputStream(), true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.run();
		}

		public void run() {
			System.out.println("连接到服务器的用户:" + client);
			try {
				IoProcessor request = new IoProcessor(input);
				IoService response = new IoService(printWriter, printStream);
				response.setRequest(request);
				response.responseInfo();
				closeSocket(client);
			} catch (Exception e) {
				System.out.println("HTTP 服务器错误:" + e.toString());
			}
		}

		/**
		 * 关闭客户端 socket 并打印一条调试信息.
		 * 
		 * @param socket
		 *            客户端 socket.
		 */
		public void closeSocket(Socket socket) {
			try {
				printWriter.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			System.out.println(socket + "离开了HTTP服务器!\n");
		}
	}
}
