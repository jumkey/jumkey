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
 * �������� ģʽ�ļ򵥵�java������
 * 
 * @author �¾� 2010-06-06
 */
public class HttpServer {

	/**
	 * �������ض˿�
	 */
	private ServerSocket serverSocket;

	/**
	 * ��Ŀ¼
	 */
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "wwwroot";
	/**
	 * �����������˿�, Ĭ��Ϊ 80.
	 */
	public static int PORT = 80;

	/**
	 * ��ʼ������ Socket �߳�.
	 */
	public HttpServer() {
		try {
			serverSocket = new ServerSocket(PORT);
			while (true) {
				Socket client = serverSocket.accept();
				new IoHandler(client);
			}
		} catch (Exception e) {
			System.out.println("�޷�����HTTP������:" + e.toString());
		}
		if (serverSocket == null)
			System.exit(1);// �޷���ʼ������
		System.out.println("HTTP ��������������,�˿�:" + PORT);
	}

	/**
	 * ��ӡ��;˵��.
	 */
	private static void usage() {
		System.out.println("Usage: java serverSocket <port>\nDefault port is 80.");
	}

	/**
	 * �������� HTTP ������
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
			System.err.println("��ʼ�˿�. �����Ǵ���0������!\n" + ex.toString());
		}
		new HttpServer();
	}

	/**
	 * ��Ӧhttp����
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
//				System.out.println("��������Ϊ POST ��ʽ�ύ�ı�����");
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
				out.println("HTTP/1.0 200 OK");// ����Ӧ����Ϣ,������Ӧ��
				out.println("Content-Type:text/html;charset=GBK");
				out.println();
				out.println("<h1>����������ļ���!!</h1>");
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
				out.println("HTTP/1.0 404 Not found");// ����Ӧ����Ϣ,������Ӧ��
				out.println("Content-Type:text/html;charset=GBK");
				out.println();
				out.println("<h1>����·��������!!</h1>");
			}
		}
	}

	/**
	 * 
	 * ��װ����http������Ϣ
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
				// ��ȡ��һ��, �����ַ
				System.out.println(line);
				String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/') - 5);
				// ����������Դ�ĵ�ַ
				uri = URLDecoder.decode(resource, "UTF-8");// ������
				// ��ַ
				method = new StringTokenizer(line).nextElement().toString();// ��ȡ���󷽷�,

				// ��ȡ������������͹������������ͷ����Ϣ
				while ((line = in.readLine()) != null) {
					if (line.equals(""))
						break;
					if (line.indexOf(":") != -1) {
						String key = line.substring(0, line.indexOf(':'))
								.trim();
						String value = line.substring(line.indexOf(':') + 1)
								.trim();
						http.put(key, value);
						// ��ȡ POST �����ݵ����ݳ���
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
				System.out.println("�����������!");
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
	 * ��Ӧ�ͻ�������
	 * 
	 * @author liucf
	 * 
	 */
	class IoHandler implements Runnable {

		private Socket client;// �ͻ�������

		private BufferedReader input;// �����ⲿ��Ϣ����

		private PrintWriter printWriter;// �����

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
			System.out.println("���ӵ����������û�:" + client);
			try {
				IoProcessor request = new IoProcessor(input);
				IoService response = new IoService(printWriter, printStream);
				response.setRequest(request);
				response.responseInfo();
				closeSocket(client);
			} catch (Exception e) {
				System.out.println("HTTP ����������:" + e.toString());
			}
		}

		/**
		 * �رտͻ��� socket ����ӡһ��������Ϣ.
		 * 
		 * @param socket
		 *            �ͻ��� socket.
		 */
		public void closeSocket(Socket socket) {
			try {
				printWriter.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			System.out.println(socket + "�뿪��HTTP������!\n");
		}
	}
}
