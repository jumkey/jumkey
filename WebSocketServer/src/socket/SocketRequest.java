package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketRequest { // ��ָ����Socket��InputStream�ж�ȡ����

	private InputStream input;
	private String uri;
	private StringBuffer request = new StringBuffer(); // ���ڱ�����������
	private int CONTENT_LENGTH = 0; // ʵ�ʰ��������ݳ�
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

	public void ReadData() { // ���� ���InputStream������

		ReadHeader(); // ͷ��

		if (beChucked) // ΪChucked
		{
			int ChuckSize = 0;
			while ((ChuckSize = getChuckSize()) > 0) // ���Chucked
			{
				readLenData(ChuckSize + 2);// ��ȡ��������
			}
			readLenData(2); // ����2λ
		}

		if (CONTENT_LENGTH > 0) {
			readLenData(CONTENT_LENGTH);// ��ȡ��������
		}

		uri = "";// parseUri(new String(request));
	}

	private void readLenData(int size) // ��ȡ��������
	{
		int readed = 0; // �Ѿ���ȡ��
		try {
			int available = 0;// input.available(); //�ɶ���
			if (available > (size - readed))
				available = size - readed;
			while (readed < size) {
				while (available == 0) { // �ȵ������ݿɶ�
					available = input.available(); // �ɶ���
				}
				if (available > (size - readed))
					available = size - readed; // size-readed--ʣ����
				if (available > 2048)
					available = 2048; // size-readed--ʣ����
				byte[] buffer = new byte[available];
				int reading = input.read(buffer);
				request = request.append(new String(buffer, 0, reading)); // byte�������
				readed += reading; // �Ѷ��ַ�
			}
		} catch (IOException e) {
			System.out.println("Read readLenData Error!");
		}
	}

	private void ReadHeader() // ��ȡͷ�� ����ô�С
	{
		byte[] crlf = new byte[1];
		int crlfNum = 0; // �Ѿ����ӵĻس������� crlfNum=4Ϊͷ������
		try {
			while (input.read(crlf) != -1) // ��ȡͷ��
			{
				if (crlf[0] == crlf13 || crlf[0] == crlf10) {
					crlfNum++;
				} else {
					crlfNum = 0;
				} // ��������
				request = request.append(new String(crlf, 0, 1)); // byte�������
				if (crlfNum == 4)
					break;
			}
		} catch (IOException e) {
			System.out.println("Read Http Header Error!");
			return;
		}

		String tempStr = (new String(request)).toUpperCase();

		// ������ֻ������GET��POST����
		String strMethod = tempStr.substring(0, 4);
		if (strMethod.equals("GET ")) // ǰ
		{
			beGet = true;
		} else if (strMethod.equals("POST")) {
			bePost = true;
			getContentlen_Chucked(tempStr);
		} else {
			System.out.println("��֧�ֵ�HTTP������");

		} // �������������� �ݲ�֧��
	}

	private void getContentlen_Chucked(String tempStr) // ��ó��� CONTENT-LENGTH ��
														// �Ƿ�ΪCHUNKED��
	{
		String ss1 = "CONTENT-LENGTH:";
		String ss2 = new String("TRANSFER-ENCODING: CHUNKED");

		int clIndex = tempStr.indexOf(ss1);
		int chuckIndex = tempStr.indexOf(ss2); // ΪCHUNKED��
		byte requst[] = tempStr.getBytes();
		if (clIndex != -1) { // ��clIndex+1����\r\n
			StringBuffer sb = new StringBuffer();

			for (int i = (clIndex + 16);; i++) {
				if (requst[i] != (byte) 13 && requst[i] != (byte) 10) {
					sb.append((char) requst[i]);
				} else
					break;
			}

			CONTENT_LENGTH = Integer.parseInt(sb.toString()); // ��ʽ��HTML�ļ��Ĵ�С
			// System.out.println("CONTENT_LENGTH== "+CONTENT_LENGTH);
		}
		if (chuckIndex != -1)
			beChucked = true;
	}

	private int getChuckSize() // Chuck��С
	{
		byte[] crlf = new byte[1];
		StringBuffer sb1 = new StringBuffer();

		int crlfNum = 0; // �Ѿ����ӵĻس������� crlfNum=4Ϊͷ������

		try {
			while (input.read(crlf) != -1) // ��ȡͷ��
			{
				if (crlf[0] == crlf13 || crlf[0] == crlf10) {
					crlfNum++;
				} else {
					crlfNum = 0;
				} // ��������
				sb1.append((char) crlf[0]);
				request = request.append(new String(crlf, 0, 1)); // byte�������
				if (crlfNum == 2)
					break;
			}
		} catch (IOException e) {
			System.out.println("Read Http Package Error!");
			return 0;
		}

		return Integer.parseInt((sb1.toString()).trim(), 16); // 16������
	}

	// ͨ���������й��ˣ��Ƿ�Ϊ����Ŀ���������HTTP��
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