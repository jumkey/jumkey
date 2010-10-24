package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends ServerSocket {
	private static ArrayList onlineUser = new ArrayList();
	private static ArrayList threadList = new ArrayList();
	protected static final int SERVER_PORT = 10000;

	public Server() throws FileNotFoundException, IOException {
		super(SERVER_PORT);
		System.out.println("��������,�ȴ��ͻ�������............");
		try {
			while (true) {
				Socket socket = accept();
				new CreateServerThread(socket);
			}
		} finally {
			close();
		}
	}

	public static void main(String[] args) throws IOException {
		new Server();
	}

	class PostMessageThread extends Thread{
		
		public String message;
		public PostMessageThread(String message){
			this.message = message;
			start();
		}
		public void run(){
			pushAllClient(message);
		}
		
		public void pushAllClient(String message){
			for (int i = 0; i < threadList.size(); i++) {
				CreateServerThread client = (CreateServerThread) threadList
						.get(i);
				client.sendMessage(message);
			}
		}
	}
	class CreateServerThread extends Thread {
		private Socket client;
		private BufferedReader in;
		private PrintWriter out;
		private String Username;

		public CreateServerThread(Socket s) throws IOException {
			client = s;
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out=new PrintWriter(new OutputStreamWriter(client.getOutputStream(),"GBK"),true);
			out.println("--- ��ӭ�������������  ---");
			out.println("����������ǳ�:");
			System.out.println("�ͻ�����������............");
			start();
		}

		public void sendMessage(String msg) {
			out.println(msg);
		}

		public void run() {
			try {
				int flag = 0;
				String line = in.readLine();
				while (line!= null && !line.equals("bye")) {
					if (line.equals("list")) {//��ʾ�����û�
						listOnlineUsers(out);
						line = in.readLine();
						continue;
					}
					if (flag++ == 0) {
						Username = line;
						onlineUser.add(Username);
						listOnlineUsers(out);
						threadList.add(this);
						pushMessage("[< " + Username + " ����������! >]");
						System.out.println(Username+" �Ѿ���½������!");
					} else {
						pushMessage("<" + Username + ">" + line);
					}
					line = in.readLine();
				}
				out.println("--- See you, bye! ---");
				client.close();
				System.out.println(Username+" �ѶϿ�����!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					client.close();
				} catch (IOException e) {
				}
				threadList.remove(this);
				onlineUser.remove(Username);
				pushMessage("[< " + Username + " left>]");
			}
		}

		private String listOnlineUsers(PrintWriter out) {
			String s = "-+- �����û��б� -+-";
			out.println(s);
			for (int i = 0; i < onlineUser.size(); i++) {
				out.println("[" + onlineUser.get(i) + "]");
			}
			out.println("-+------------------+-");
			return s;
		}

		private void pushMessage(String msg) {
			new PostMessageThread(msg);
		}
	}
}
