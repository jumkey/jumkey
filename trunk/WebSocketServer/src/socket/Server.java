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
		System.out.println("服务启动,等待客户端连接............");
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
			out.println("--- 欢迎进入随机聊天室  ---");
			out.println("请输入你的昵称:");
			System.out.println("客户建立连接中............");
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
					if (line.equals("list")) {//显示所有用户
						listOnlineUsers(out);
						line = in.readLine();
						continue;
					}
					if (flag++ == 0) {
						Username = line;
						onlineUser.add(Username);
						listOnlineUsers(out);
						threadList.add(this);
						pushMessage("[< " + Username + " 进入聊天室! >]");
						System.out.println(Username+" 已经登陆聊天室!");
					} else {
						pushMessage("<" + Username + ">" + line);
					}
					line = in.readLine();
				}
				out.println("--- See you, bye! ---");
				client.close();
				System.out.println(Username+" 已断开连接!");
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
			String s = "-+- 在线用户列表 -+-";
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
