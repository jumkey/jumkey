package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static socket.Test.*;

public class MultiUser extends Thread {
	private Socket client;
	private byte crlf13 = (byte) 13; // '\r'
	private byte crlf10 = (byte) 10; // '\n'

	public MultiUser(Socket c) {
		this.client = c;
	}

	public void run() {
		try {
			InputStream input = client.getInputStream();
			OutputStream out = client.getOutputStream();
			// Mutil User but can't parallel
			StringBuffer header = new StringBuffer();
			byte[] content = new byte[8];
			byte[] crlf = new byte[1];
			int crlfNum = 0; // 已经连接的回车换行数 crlfNum=4为头部结束
			
			// 读取头部
			while (input.read(crlf) != -1){
				if (crlf[0] == crlf13 || crlf[0] == crlf10) {
					crlfNum++;
				} else {
					crlfNum = 0;
				} // 不是则清
				header.append(new String(crlf, 0, 1)); // byte数组相加
				if (crlfNum == 4) {
					input.read(content);
					break;
				}
			}

			Map<String, String> http = new HashMap<String, String>();
			String[] hhh=header.toString().split("\r\n");
			http.put("Method", hhh[0].split(" ")[0]);
			http.put("Path", hhh[0].split(" ")[1]);
			http.put("Http-Protocol", hhh[0].split(" ")[2]);
			
			for(int i=1;i<hhh.length;i++){
				http.put(hhh[i].split(": ")[0], hhh[i].split(": ")[1]);
			}
			
//			http.put("Upgrade", "");
//			http.put("Connection", "");
//			http.put("Host", "");
//			http.put("Origin", "");
//			http.put("Sec-WebSocket-Key1", "");
//			http.put("Sec-WebSocket-Key2", "");
			
			http.put("Content", new String(content,"UTF-8"));
			
			
			String key1=http.get("Sec-WebSocket-Key1");
			String key2=http.get("Sec-WebSocket-Key2");
			long a = Long.parseLong(filterNonNumeric(key1)) / filterNonSpace(key1).length();
			long b = Long.parseLong(filterNonNumeric(key2)) / filterNonSpace(key2).length();
	        
			String ekey1=Long.toHexString(a).toUpperCase();
			String ekey2=Long.toHexString(b).toUpperCase();
			String ekey3=byte2HexStr(content);
			
			while (ekey1.length() < 8)
				ekey1 = "0" + ekey1;
			while (ekey2.length() < 8)
				ekey2 = "0" + ekey2;
			while (ekey3.length() < 8)
				ekey3 = "0" + ekey3;
			
			byte[] bb = hexStr2Bytes(ekey1+ekey2+ekey3);
			byte[] dbb = MessageDigest.getInstance("MD5").digest(bb);
			
			
			out.write("HTTP/1.1 101 WebSocket Protocol Handshake\r\n".getBytes());
			out.write("Upgrade: WebSocket\r\n".getBytes());
			out.write("Connection: Upgrade\r\n".getBytes());
			out.write(("Sec-WebSocket-Origin: "+http.get("Origin")+"\r\n").getBytes());
			out.write(("Sec-WebSocket-Location: ws://"+http.get("Host")+http.get("Path")+"\r\n\r\n").getBytes());
			out.write(dbb);
			out.flush();
			
			
			byte[] bbbb=new byte[]{};
			while(input.read(crlf)!=-1){
				//处理任务
				if(crlf[0]==(byte)0){
					bbbb=new byte[]{};
				}else if(crlf[0]==(byte)255){
					System.out.println(new String(bbbb,"UTF-8"));
					out.write((byte)0);
					out.write("收到".getBytes("UTF-8"));
					out.write((byte)255);
					out.flush();
				}else{
					bbbb=addByte(bbbb,crlf);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			try {
				 client.close();
				 //out.close();
			} catch (IOException e) {
				 e.printStackTrace();
			}
		}
	}

	/**
	 * 数组相加
	 * 
	 * @param target
	 *            目标数组
	 * @param nb
	 *            加入数组
	 * @return 相加后的结果
	 */
	public static byte[] addByte(byte[] target, byte[] nb) {
		byte[] a = new byte[target.length + nb.length];
		for (int i = 0; i < target.length; i++) {
			a[i] = target[i];
		}
		for (int j = target.length; j < a.length; j++) {
			a[j] = nb[j - target.length];
		}
		return a;
	}

	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(5678);
			System.out.println("服务启动成功");
			while (true) {
				// transfer location change Single User or Multi User
				MultiUser mu = new MultiUser(server.accept());
				mu.start();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}