import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 刘长炯
 * modi by jzj
 *
 */
public class SimpleHttpServer implements Runnable {

	ServerSocket serverSocket;//服务器Socket

	public static int PORT = 80;//标准HTTP端口

	public String encoding = "GBK";

	public SimpleHttpServer() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		new Thread(this).start();
		System.out.println("HTTP服务器正在运行,端口:" + PORT);
	}

	public void run() {
		while (true) {
			try {
				Socket client = serverSocket.accept();//客户机(这里是 IE 等浏览器)已经连接到当前服务器
				if (client != null) {
					System.out.println("连接到服务器的用户:" + client);
					try {
						// 第一阶段: 打开输入流
						InputStream is = client.getInputStream();

						System.out.println("客户端发送的请求信息: >>>>>>>>>>>>>>>>>>>>>>>>>");
						// 读取第一行, 请求地址
						String line = readLine(is, 0);
						//打印请求行
						System.out.print(line);
						// < Method > < URL > < HTTP Version > <\r\n>  取的是URL部分
						String resource = line.substring(line.indexOf('/'), line
								.lastIndexOf('/') - 5);
						//获得请求的资源的地址
						resource = URLDecoder.decode(resource, encoding);//反编码 URL 地址
						String method = new StringTokenizer(line).nextElement()
								.toString();// 获取请求方法, GET 或者 POST
						int contentLength = 0;//如果为POST方法，则会有消息体长度

						// 读取所有浏览器发送过来的请求参数头部信息
						do {
							line = readLine(is, 0);
							//如果有Content-Length消息头时取出
							if (line.startsWith("Content-Length")) {
								contentLength = Integer.parseInt(line.split(":")[1]
										.trim());
							}
							//打印请求部信息
							System.out.print(line);
							//如果遇到了一个单独的回车换行，则表示请求头结束
						} while (!line.equals("\r\n"));
						//如果是POST请求，则有请求体
						if ("POST".equalsIgnoreCase(method)) {
							//注，这里只是简单的处理表单提交的参数，而对于上传文件这里是不能这样处理的，
							//因为上传的文件时消息体不只是一行，会有多行消息体
							System.out.print(readLine(is, contentLength));
							System.out.println();
						}

						System.out.println("客户端发送的请求信息结束 <<<<<<<<<<<<<<<<<<<<<<<<<<");
						System.out.println("用户请求的资源是:" + resource);
						System.out.println("请求的类型是: " + method);
						System.out.println();

						//如果是下载文件
						if (resource.startsWith("/download")) {
							fileDownload("test.txt", client);
							closeSocket(client);
							continue;
						}

						// GIF 图片就读取一个真实的图片数据并返回给客户端
						if (resource.endsWith(".gif")) {
							imgDownload("test.gif", client);
							closeSocket(client);
							continue;
						}

						// 请求 JPG 格式就报错 404
						if (resource.endsWith(".jpg")) {
							PrintWriter out = new PrintWriter(client.getOutputStream(),
									true);
							out.println("HTTP/1.0 404 Not found");//返回应答消息,并结束应答
							out.println();// 根据 HTTP 协议, 空行将结束头信息
							out.close();
							closeSocket(client);
							continue;
						} else {
							// 用 writer 对客户端 socket 输出一段 HTML 代码
							PrintWriter out = new PrintWriter(client.getOutputStream(),
									true);
							out.println("HTTP/1.0 200 OK");//返回应答消息,并结束应答
							out.println("Content-Type:text/html;charset=" + encoding);
							out.println();// 根据 HTTP 协议, 空行将结束头信息

							out.println("<h1> Hello Http Server</h1>");
							out.println("你好, 这是一个 Java HTTP 服务器 demo 应用.<br>");
							out.println("您请求的路径是: " + resource + "<br>");
							out.println("你请求的页面含有图片:<img src='test.gif'><br>"
									+ "<a href='test.gif'>手动点击打开test.gif图片文件.</a>");
							out.println("<br>服务器不支持jpg格式图片，所以显示XX:"
									+ "<img src='test.jpg'><br><a href='test.jpg'>"
									+ "手动点击打开test.jpg，会跳转另一页面，并且服务返回为404错误</a><br>");
							out
									.println("<form method=post action='/path?qryParm=POST URL查询参数' > POST 表单 "
											+ "<input name=username value='用户'> "
											+ "<input name=submit type=submit value=submit></form>");
							out
									.println("<form method=get action='/path?qryParm=GET URL查询参数' >&nbsp;GET 表单 "
											+ "<input name=username value='用户'> "
											+ "<input name=submit type=submit value=submit></form>");

							out
									.println("<form method=post action='/path?qryParm=POST URL查询参数'"
											+ " enctype='multipart/form-data' >"
											+ "文件上传&nbsp; <input type='file' name=file1 ><br>"
											+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
											+ "<input type='file' name=file2 ><br>"
											+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
											+ "<input name=username value='用户'> "
											+ "<input name=submit type=submit value=submit></form>");
							out.println("<a href='/download'>点击此处模拟文件下载</a>");

							out.close();

							closeSocket(client);
						}
					} catch (Exception e) {
						System.out.println("HTTP服务器错误:" + e.getLocalizedMessage());
					}
				}
				//System.out.println(client+"连接到HTTP服务器");//如果加入这一句,服务器响应速度会很慢
			} catch (Exception e) {
				System.out.println("HTTP服务器错误:" + e.getLocalizedMessage());
			}
		}
	}

	/*
	 * 这里我们自己模拟读取一行，因为如果使用API中的BufferedReader时，它是读取到一个回车换行后
	 * 才返回，否则如果没有读取，则一直阻塞，这就导致如果为POST请求时，表单中的元素会以消息体传送，
	 * 这时，消息体最末按标准是没有回车换行的，如果此时还使用BufferedReader来读时，则POST提交
	 * 时会阻塞。如果是POST提交时我们按照消息体的长度Content-Length来截取消息体，这样就不会阻塞
	 */
	private String readLine(InputStream is, int contentLe) throws IOException {
		ArrayList lineByteList = new ArrayList();
		byte readByte;
		int total = 0;
		if (contentLe != 0) {
			do {
				readByte = (byte) is.read();
				lineByteList.add(Byte.valueOf(readByte));
				total++;
			} while (total < contentLe);//消息体读还未读完
		} else {
			do {
				readByte = (byte) is.read();
				lineByteList.add(Byte.valueOf(readByte));
			} while (readByte != 10);
		}

		byte[] tmpByteArr = new byte[lineByteList.size()];
		for (int i = 0; i < lineByteList.size(); i++) {
			tmpByteArr[i] = ((Byte) lineByteList.get(i)).byteValue();
		}
		lineByteList.clear();

		String tmpStr = new String(tmpByteArr, encoding);
		/* http请求的header中有一个Referer属性，这个属性的意思就是如果当前请求是从别的页面链接过
		 * 来的，那个属性就是那个页面的url，如果请求的url是直接从浏览器地址栏输入的就没有这个值。得
		 * 到这个值可以实现很多有用的功能，例如防盗链，记录访问来源以及记住刚才访问的链接等。另外，浏
		 * 览器发送这个Referer链接时好像固定用UTF-8编码的，所以在GBK下出现乱码，我们在这里纠正一下
		 */
		if (tmpStr.startsWith("Referer")) {//如果有Referer头时，使用UTF-8编码
			tmpStr = new String(tmpByteArr, "UTF-8");
		}
		return tmpStr;
	}

	/**
	* 关闭客户端 socket 并打印一条调试信息.
	* @param socket 客户端 socket.
	*/
	void closeSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println(socket + "离开了HTTP服务器");
	}

	/**
	* 读取一个图像文件的内容并返回给浏览器端.
	* @param fileName 文件名
	* @param socket 客户端 socket.
	*/
	void imgDownload(String fileName, Socket socket) {

		try {
			PrintStream out = new PrintStream(socket.getOutputStream(), true);
			File fileToSend = new File(fileName);
			if (fileToSend.exists() && !fileToSend.isDirectory()) {
				out.println("HTTP/1.0 200 OK");//返回应答消息,并结束应答
				out.println("Content-Type: application/octet-stream");
				out.println("Content-Length: " + fileToSend.length());// 返回内容字节数
				out.println();// 根据 HTTP 协议, 空行将结束头信息

				FileInputStream fis = new FileInputStream(fileToSend);
				byte data[] = new byte[fis.available()];
				fis.read(data);
				out.write(data);
				//文件下载完后关闭socket流，但socket还没有关闭
				out.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* 读取一个文件的内容并返回给浏览器端.
	* @param fileName 文件名
	* @param socket 客户端 socket.
	*/
	void fileDownload(String fileName, Socket socket) {
		try {
			PrintStream out = new PrintStream(socket.getOutputStream(), true);
			File fileToSend = new File(fileName);
			if (fileToSend.exists() && !fileToSend.isDirectory()) {
				out.println("HTTP/1.0 200 OK");//返回应答消息,并结束应答
				out.println("Content-Type: application/octet-stream;charset=" + encoding);

				/* Content-Disposition不是标准参数，查看一下HTTP/1.1的规范文档，对于这个参数的解释大意如下：
				 * Content-Disposition参数本来是为了在客户端另存文件时提供一个建议的文件名，但是考虑到安全的原因，
				 * 就从规范中去掉了这个参数。但是由于很多浏览器已经能够支持这个参数，所以只是在规范文档中列出，但是要
				 * 注意这个不是HTTP/1.1的标准参数。其值为“attachment”，那么无论这个文件是何类型，浏览器都会提示我
				 * 们下载此文件，因为此时它认为后面的消息体是一个“附件”，不需要由浏览器来处理了。
				 */
				out.println("Content-Disposition: attachment;filename=测试下载文件.txt");
				//				out.println("Accept-Ranges: bytes");
				out.println("Content-Length: " + fileToSend.length());// 返回内容字节数
				out.println();// 根据 HTTP 协议, 空行将结束头信息

				FileInputStream fis = new FileInputStream(fileToSend);
				byte[] tmpByteArr = new byte[10];//这里为了测试看下载进度条，所以设置小点
				while (fis.available() > 0) {
					int readCount = fis.read(tmpByteArr);
					out.write(tmpByteArr, 0, readCount);
				}

				//文件下载完后关闭socket流
				out.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PORT = 1998;
		new SimpleHttpServer();
	}
}