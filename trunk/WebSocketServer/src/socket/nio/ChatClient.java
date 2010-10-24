package socket.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.io.BufferedReader;
import java.io.*;
import java.lang.Thread;
import java.nio.charset.*;
import java.nio.charset.CharsetDecoder;

public class ChatClient {

	private InetSocketAddress address = new InetSocketAddress("localhost", 13);
	private SocketChannel client = null;
	private String user = null;
	private String pass = null;
	private BufferedReader in = null;
	private Thread t = null;

	public ChatClient() {
		try {
			client = SocketChannel.open();
			System.out.println("connecting...");

			client.connect(address);
			System.out.println("connected with " + address.getHostName());
			client.configureBlocking(false);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		this.start();
	}

	public void start() {
		this.receiveMessage();
		this.sendMessage();
	}

	public void sendMessage() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out
					.println("Input the Info then check it out on the server");
			System.out.print("Your Name:");
			user = in.readLine();
			System.out.println("Password:");
			pass = in.readLine();

			ByteBuffer buffer = ByteBuffer.allocate(50);
			String message = new String("LOGIN:" + user + "&" + pass);
			buffer = ByteBuffer.wrap(message.getBytes());
			while (buffer.hasRemaining() & client.write(buffer) != -1)
				;
			System.out.println(message + " has been send");

			buffer.flip();
			Charset charset = Charset.forName("gb2312");
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buffer);
			// System.out.println("receive:"+charBuffer+"
			// length:"+charBuffer.limit());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		this.waitFor(2000);

		System.out.println("WELCOME TO THE KING 'S CHAT ROOM!");
		System.out.println("Input the Info(exit is to leave out)");
		while (true) {
			System.out.print(">");

			ByteBuffer buffer = ByteBuffer.allocate(100);
			in = new BufferedReader(new InputStreamReader(System.in));
			try {
				String read = in.readLine();
				if (read.equals("exit")) {
					break;
				}
				String message1 = "SENTO:" + read;
				buffer = ByteBuffer.wrap(message1.getBytes());
				// buffer.flip();
				System.out.println("before");
				while (buffer.hasRemaining() & client.write(buffer) != -1)
					;
				// buffer.flip();
				System.out.println(message1 + " has been send");
				this.waitFor(500);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Welcome to use this soft!---King");
		System.exit(-1);

	}

	public void waitFor(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void receiveMessage() {
		t = new ReceiveThread(client);
		t.start();
	}

	public static void main(String[] args) {
		ChatClient cc = new ChatClient();

	}

	class ReceiveThread extends Thread {
		SocketChannel client = null;
		ByteBuffer buffer = ByteBuffer.allocate(50);
		private boolean val = true;

		public ReceiveThread(SocketChannel client) {
			this.client = client;
		}

		public void run() {
			while (val) {
				try {
					while (client.read(buffer) > 0) {
						buffer.flip();
						String result = decode(buffer);
						System.out.println(">(back)" + result);
						buffer.flip();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
					return;
				}

			}
		}
	}

	public String decode(ByteBuffer buffer) {
		Charset charset = null;
		CharsetDecoder decoder = null;
		CharBuffer charBuffer = null;
		try {
			charset = Charset.forName("gb2312");
			decoder = charset.newDecoder();
			charBuffer = decoder.decode(buffer);
			return charBuffer.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}

	}
}