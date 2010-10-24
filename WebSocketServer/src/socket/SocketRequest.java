package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketRequest { // 从指定的Socket的InputStream中读取数据

	private InputStream input;
	private String uri;
	private StringBuffer request = new StringBuffer(); // 用于保存所有内容
	private int CONTENT_LENGTH = 0; // 实际包内容数据长
	private boolean bePost = false;
	private boolean beHttpResponse = false;
	private boolean beChucked = false;
	private boolean beGet = false;
	private byte crlf13 = (byte) 13; // '\r'
	private byte crlf10 = (byte) 10; // '\n'

	public SocketRequest(InputStream input) {
		this.input = input;
	}

	public SocketRequest(Socket socket) throws IOException {
		this.input = socket.getInputStream();
	}

	public void ReadData() { // 解析 获得InputStream的数据

		ReadHeader(); // 头部

		if (beChucked) // 为Chucked
		{
			int ChuckSize = 0;
			while ((ChuckSize = getChuckSize()) > 0) // 多个Chucked
			{
				readLenData(ChuckSize + 2);// 读取定长数据
			}
			readLenData(2); // 最后的2位
		}

		if (CONTENT_LENGTH > 0) {
			readLenData(CONTENT_LENGTH);// 读取定长数据
		}

		uri = "";// parseUri(new String(request));
	}

	private void readLenData(int size) // 读取定长数据
	{
		int readed = 0; // 已经读取数
		try {
			int available = 0;// input.available(); //可读数
			if (available > (size - readed))
				available = size - readed;
			while (readed < size) {
				while (available == 0) { // 等到有数据可读
					available = input.available(); // 可读数
				}
				if (available > (size - readed))
					available = size - readed; // size-readed--剩余数
				if (available > 2048)
					available = 2048; // size-readed--剩余数
				byte[] buffer = new byte[available];
				int reading = input.read(buffer);
				request = request.append(new String(buffer, 0, reading)); // byte数组相加
				readed += reading; // 已读字符
			}
		} catch (IOException e) {
			System.out.println("Read readLenData Error!");
		}
	}

	private void ReadHeader() // 读取头部 并获得大小
	{
		byte[] crlf = new byte[1];
		int crlfNum = 0; // 已经连接的回车换行数 crlfNum=4为头部结束
		try {
			while (input.read(crlf) != -1) // 读取头部
			{
				if (crlf[0] == crlf13 || crlf[0] == crlf10) {
					crlfNum++;
				} else {
					crlfNum = 0;
				} // 不是则清
				request = request.append(new String(crlf, 0, 1)); // byte数组相加
				if (crlfNum == 4)
					break;
			}
		} catch (IOException e) {
			System.out.println("Read Http Header Error!");
			return;
		}

		String tempStr = (new String(request)).toUpperCase();

		// 这里我只处理了GET与POST方法
		String strMethod = tempStr.substring(0, 4);
		if (strMethod.equals("GET ")) // 前
		{
			beGet = true;
		} else if (strMethod.equals("POST")) {
			bePost = true;
			getContentlen_Chucked(tempStr);
		} else {
			System.out.println("不支持的HTTP包类型");

		} // 其它的其它类型 暂不支持
	}

	private void getContentlen_Chucked(String tempStr) // 获得长度 CONTENT-LENGTH 或
														// 是否为CHUNKED型
	{
		String ss1 = "CONTENT-LENGTH:";
		String ss2 = new String("TRANSFER-ENCODING: CHUNKED");

		int clIndex = tempStr.indexOf(ss1);
		int chuckIndex = tempStr.indexOf(ss2); // 为CHUNKED型
		byte requst[] = tempStr.getBytes();
		if (clIndex != -1) { // 从clIndex+1起至\r\n
			StringBuffer sb = new StringBuffer();

			for (int i = (clIndex + 16);; i++) {
				if (requst[i] != (byte) 13 && requst[i] != (byte) 10) {
					sb.append((char) requst[i]);
				} else
					break;
			}

			CONTENT_LENGTH = Integer.parseInt(sb.toString()); // 正式的HTML文件的大小
			// System.out.println("CONTENT_LENGTH== "+CONTENT_LENGTH);
		}
		if (chuckIndex != -1)
			beChucked = true;
	}

	private int getChuckSize() // Chuck大小
	{
		byte[] crlf = new byte[1];
		StringBuffer sb1 = new StringBuffer();

		int crlfNum = 0; // 已经连接的回车换行数 crlfNum=4为头部结束

		try {
			while (input.read(crlf) != -1) // 读取头部
			{
				if (crlf[0] == crlf13 || crlf[0] == crlf10) {
					crlfNum++;
				} else {
					crlfNum = 0;
				} // 不是则清
				sb1.append((char) crlf[0]);
				request = request.append(new String(crlf, 0, 1)); // byte数组相加
				if (crlfNum == 2)
					break;
			}
		} catch (IOException e) {
			System.out.println("Read Http Package Error!");
			return 0;
		}

		return Integer.parseInt((sb1.toString()).trim(), 16); // 16进控制
	}

	// 通过此来进行过滤，是否为发至目标服务器的HTTP包
	private String parseUri(String requestString) {
		int index1, index2;
		index1 = requestString.indexOf(' ');
		if (index1 != -1) {
			index2 = requestString.indexOf(' ', index1 + 1);
			if (index2 > index1)
				return requestString.substring(index1 + 1, index2);
		}
		return null;
	}

	public String getData() {
		return request.toString();
	}
}