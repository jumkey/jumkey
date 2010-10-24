package socket;

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
 * @author ������
 * modi by jzj
 *
 */
public class SimpleHttpServer implements Runnable {

	ServerSocket serverSocket;//������Socket

	public static int PORT = 80;//��׼HTTP�˿�

	public String encoding = "GBK";

	public SimpleHttpServer() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		new Thread(this).start();
		System.out.println("HTTP��������������,�˿�:" + PORT);
	}

	public void run() {
		while (true) {
			try {
				Socket client = serverSocket.accept();//�ͻ���(������ IE �������)�Ѿ����ӵ���ǰ������
				if (client != null) {
					System.out.println("���ӵ����������û�:" + client);
					try {
						// ��һ�׶�: ��������
						InputStream is = client.getInputStream();

						System.out.println("�ͻ��˷��͵�������Ϣ: >>>>>>>>>>>>>>>>>>>>>>>>>");
						// ��ȡ��һ��, �����ַ
						String line = readLine(is, 0);
						//��ӡ������
						System.out.print(line);
						// < Method > < URL > < HTTP Version > <\r\n>  ȡ����URL����
						String resource = line.substring(line.indexOf('/'), line
								.lastIndexOf('/') - 5);
						//����������Դ�ĵ�ַ
						resource = URLDecoder.decode(resource, encoding);//������ URL ��ַ
						String method = new StringTokenizer(line).nextElement()
								.toString();// ��ȡ���󷽷�, GET ���� POST
						int contentLength = 0;//���ΪPOST�������������Ϣ�峤��

						// ��ȡ������������͹������������ͷ����Ϣ
						do {
							line = readLine(is, 0);
							//�����Content-Length��Ϣͷʱȡ��
							if (line.startsWith("Content-Length")) {
								contentLength = Integer.parseInt(line.split(":")[1]
										.trim());
							}
							//��ӡ������Ϣ
							System.out.print(line);
							//���������һ�������Ļس����У����ʾ����ͷ����
						} while (!line.equals("\r\n"));
						//�����POST��������������
						if ("POST".equalsIgnoreCase(method)) {
							//ע������ֻ�Ǽ򵥵Ĵ�����ύ�Ĳ������������ϴ��ļ������ǲ�����������ģ�
							//��Ϊ�ϴ����ļ�ʱ��Ϣ�岻ֻ��һ�У����ж�����Ϣ��
							System.out.print(readLine(is, contentLength));
							System.out.println();
						}

						System.out.println("�ͻ��˷��͵�������Ϣ���� <<<<<<<<<<<<<<<<<<<<<<<<<<");
						System.out.println("�û��������Դ��:" + resource);
						System.out.println("�����������: " + method);
						System.out.println();

						//����������ļ�
						if (resource.startsWith("/download")) {
							fileDownload("test.txt", client);
							closeSocket(client);
							continue;
						}

						// GIF ͼƬ�Ͷ�ȡһ����ʵ��ͼƬ���ݲ����ظ��ͻ���
						if (resource.endsWith(".gif")) {
							imgDownload("test.gif", client);
							closeSocket(client);
							continue;
						}

						// ���� JPG ��ʽ�ͱ��� 404
						if (resource.endsWith(".jpg")) {
							PrintWriter out = new PrintWriter(client.getOutputStream(),
									true);
							out.println("HTTP/1.0 404 Not found");//����Ӧ����Ϣ,������Ӧ��
							out.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ
							out.close();
							closeSocket(client);
							continue;
						} else {
							// �� writer �Կͻ��� socket ���һ�� HTML ����
							PrintWriter out = new PrintWriter(client.getOutputStream(),
									true);
							out.println("HTTP/1.0 200 OK");//����Ӧ����Ϣ,������Ӧ��
							out.println("Content-Type:text/html;charset=" + encoding);
							out.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ

							out.println("<h1> Hello Http Server</h1>");
							out.println("���, ����һ�� Java HTTP ������ demo Ӧ��.<br>");
							out.println("�������·����: " + resource + "<br>");
							out.println("�������ҳ�溬��ͼƬ:<img src='test.gif'><br>"
									+ "<a href='test.gif'>�ֶ������test.gifͼƬ�ļ�.</a>");
							out.println("<br>��������֧��jpg��ʽͼƬ��������ʾXX:"
									+ "<img src='test.jpg'><br><a href='test.jpg'>"
									+ "�ֶ������test.jpg������ת��һҳ�棬���ҷ��񷵻�Ϊ404����</a><br>");
							out
									.println("<form method=post action='/path?qryParm=POST URL��ѯ����' > POST �� "
											+ "<input name=username value='�û�'> "
											+ "<input name=submit type=submit value=submit></form>");
							out
									.println("<form method=get action='/path?qryParm=GET URL��ѯ����' >&nbsp;GET �� "
											+ "<input name=username value='�û�'> "
											+ "<input name=submit type=submit value=submit></form>");

							out
									.println("<form method=post action='/path?qryParm=POST URL��ѯ����'"
											+ " enctype='multipart/form-data' >"
											+ "�ļ��ϴ�&nbsp; <input type='file' name=file1 ><br>"
											+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
											+ "<input type='file' name=file2 ><br>"
											+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
											+ "<input name=username value='�û�'> "
											+ "<input name=submit type=submit value=submit></form>");
							out.println("<a href='/download'>����˴�ģ���ļ�����</a>");

							out.close();

							closeSocket(client);
						}
					} catch (Exception e) {
						System.out.println("HTTP����������:" + e.getLocalizedMessage());
					}
				}
				//System.out.println(client+"���ӵ�HTTP������");//���������һ��,��������Ӧ�ٶȻ����
			} catch (Exception e) {
				System.out.println("HTTP����������:" + e.getLocalizedMessage());
			}
		}
	}

	/*
	 * ���������Լ�ģ���ȡһ�У���Ϊ���ʹ��API�е�BufferedReaderʱ�����Ƕ�ȡ��һ���س����к�
	 * �ŷ��أ��������û�ж�ȡ����һֱ��������͵������ΪPOST����ʱ�����е�Ԫ�ػ�����Ϣ�崫�ͣ�
	 * ��ʱ����Ϣ����ĩ����׼��û�лس����еģ������ʱ��ʹ��BufferedReader����ʱ����POST�ύ
	 * ʱ�������������POST�ύʱ���ǰ�����Ϣ��ĳ���Content-Length����ȡ��Ϣ�壬�����Ͳ�������
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
			} while (total < contentLe);//��Ϣ�����δ����
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
		/* http�����header����һ��Referer���ԣ�������Ե���˼���������ǰ�����Ǵӱ��ҳ�����ӹ�
		 * ���ģ��Ǹ����Ծ����Ǹ�ҳ���url����������url��ֱ�Ӵ��������ַ������ľ�û�����ֵ����
		 * �����ֵ����ʵ�ֺܶ����õĹ��ܣ��������������¼������Դ�Լ���ס�ղŷ��ʵ����ӵȡ����⣬�
		 * �����������Referer����ʱ����̶���UTF-8����ģ�������GBK�³������룬�������������һ��
		 */
		if (tmpStr.startsWith("Referer")) {//�����Refererͷʱ��ʹ��UTF-8����
			tmpStr = new String(tmpByteArr, "UTF-8");
		}
		return tmpStr;
	}

	/**
	* �رտͻ��� socket ����ӡһ��������Ϣ.
	* @param socket �ͻ��� socket.
	*/
	void closeSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println(socket + "�뿪��HTTP������");
	}

	/**
	* ��ȡһ��ͼ���ļ������ݲ����ظ��������.
	* @param fileName �ļ���
	* @param socket �ͻ��� socket.
	*/
	void imgDownload(String fileName, Socket socket) {

		try {
			PrintStream out = new PrintStream(socket.getOutputStream(), true);
			File fileToSend = new File(fileName);
			if (fileToSend.exists() && !fileToSend.isDirectory()) {
				out.println("HTTP/1.0 200 OK");//����Ӧ����Ϣ,������Ӧ��
				out.println("Content-Type: application/octet-stream");
				out.println("Content-Length: " + fileToSend.length());// ���������ֽ���
				out.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ

				FileInputStream fis = new FileInputStream(fileToSend);
				byte data[] = new byte[fis.available()];
				fis.read(data);
				out.write(data);
				//�ļ��������ر�socket������socket��û�йر�
				out.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* ��ȡһ���ļ������ݲ����ظ��������.
	* @param fileName �ļ���
	* @param socket �ͻ��� socket.
	*/
	void fileDownload(String fileName, Socket socket) {
		try {
			PrintStream out = new PrintStream(socket.getOutputStream(), true);
			File fileToSend = new File(fileName);
			if (fileToSend.exists() && !fileToSend.isDirectory()) {
				out.println("HTTP/1.0 200 OK");//����Ӧ����Ϣ,������Ӧ��
				out.println("Content-Type: application/octet-stream;charset=" + encoding);

				/* Content-Disposition���Ǳ�׼�������鿴һ��HTTP/1.1�Ĺ淶�ĵ���������������Ľ��ʹ������£�
				 * Content-Disposition����������Ϊ���ڿͻ�������ļ�ʱ�ṩһ��������ļ��������ǿ��ǵ���ȫ��ԭ��
				 * �ʹӹ淶��ȥ��������������������ںܶ�������Ѿ��ܹ�֧���������������ֻ���ڹ淶�ĵ����г�������Ҫ
				 * ע���������HTTP/1.1�ı�׼��������ֵΪ��attachment������ô��������ļ��Ǻ����ͣ������������ʾ��
				 * �����ش��ļ�����Ϊ��ʱ����Ϊ�������Ϣ����һ����������������Ҫ��������������ˡ�
				 */
				out.println("Content-Disposition: attachment;filename=���������ļ�.txt");
				//				out.println("Accept-Ranges: bytes");
				out.println("Content-Length: " + fileToSend.length());// ���������ֽ���
				out.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ

				FileInputStream fis = new FileInputStream(fileToSend);
				byte[] tmpByteArr = new byte[10];//����Ϊ�˲��Կ����ؽ���������������С��
				while (fis.available() > 0) {
					int readCount = fis.read(tmpByteArr);
					out.write(tmpByteArr, 0, readCount);
				}

				//�ļ��������ر�socket��
				out.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PORT = 5678;
		new SimpleHttpServer();
	}
}