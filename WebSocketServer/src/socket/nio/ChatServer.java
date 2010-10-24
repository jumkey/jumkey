package socket.nio;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.io.IOException;
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.nio.charset.*;
import java.nio.*;

public class ChatServer {

	private int port = 13;
	private Selector selector;
	private ServerSocketChannel ssc;
	private ServerSocket server;
	private InetSocketAddress address;
	private ArrayList connectKey = new ArrayList();

	public ChatServer() {
		// initServer
		try {
			ssc = ServerSocketChannel.open();
			server = ssc.socket();
			address = new InetSocketAddress(port);
			server.bind(address);
			selector = Selector.open();
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("============================================================");
			System.out.println("=                                                          =");
			System.out.println("=                                                          =");
			System.out.println("=                   水底沙聊天室-version1.0                   =");
			System.out.println("=                                                          =");
			System.out.println("=                    QQ:247095340(交 流)                    =");
			System.out.println("============================================================");
			System.out.println("Listening the port 13...");
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}

	public void startServer() throws IOException {
		while (true) {
			int i = selector.select();
			// System.out.print(i);
			Iterator keys = selector.selectedKeys().iterator();

			while (keys.hasNext()) {
				SelectionKey key = (SelectionKey) keys.next();
				keys.remove();
				try {
					if (key.isAcceptable()) {
						ServerSocketChannel ssc = (ServerSocketChannel) key
								.channel();
						SocketChannel channel = ssc.accept();// return null
																// if there's no
																// request
						System.out.println(channel + " has accepted");
						channel.configureBlocking(false);
						SelectionKey clientKey = channel.register(selector,
								SelectionKey.OP_READ);
					}// else
					if (key.isWritable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						ByteBuffer buffer = (ByteBuffer) key.attachment();

						if (buffer != null) {
							key.attach(null);// avoid the return twice

							// check info:the login or the message
							// buffer.flip();
							String checkBuffer = this.decode(buffer);
							System.out.println("write:" + checkBuffer);

							if (checkBuffer.equals("LOGIN:OK")) {
								// return LOGIN:OK then add into the connectKey
								// array!
								System.out.println("ok" + buffer);
								buffer.flip();
								// while(buffer.hasRemaining()&channel.write(buffer)!=-1);
								channel.write(buffer);
								key.interestOps(SelectionKey.OP_READ
										| SelectionKey.OP_WRITE);
								connectKey.add(key);// add to the connectKey
													// array
								System.out.println("here");
							} else if (checkBuffer.equals("LOGIN:ERROR")) {
								// return LOGIN:ERROR the client should close
								// the channel
								// warning:method:key.channel();
								// Returns the channel for which this key was
								// created.
								// This method will continue to return the
								// channel even after the key is cancelled.
								while (buffer.hasRemaining()
										& channel.write(buffer) != -1)
									;
								key.cancel();
							} else // if(checkBuffer.indexOf("SENTO:")!=-1){
							{

								// return the message to everyone
								// while(buffer.hasRemaining()&channel.write(buffer)!=-1);

								System.out.println("sento" + buffer);
								buffer.flip();
								channel.write(buffer);
								System.out.println("send over");
							}
						}
					}// else
					if (key.isReadable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						ByteBuffer buffer = ByteBuffer.allocate(50);
						System.out.println("read...");

						channel.read(buffer);

						buffer.flip();
						String checkBuffer = this.decode(buffer);
						System.out.println("read:" + checkBuffer);

						// while(buffer.hasRemaining()&&channel.read(buffer)!=-1);

						// check the buffer
						// buffer.flip();

						// String checkBuffer = this.decode(buffer);
						// System.out.println("read:"+checkBuffer);

						if (checkBuffer.startsWith("LOGIN:")) {
							// get info of the user & pass then check for
							// it,return feedback!
							// the format is LOGIN:user&pass
							int p1 = checkBuffer.length();
							int p2 = checkBuffer.indexOf("&");

							String user = checkBuffer.substring(6, p2);
							String pass = checkBuffer.substring(p2 + 1, p1);
							System.out.println(user + pass);

							// todo check from the database!!!
							// assume the user is legal
							ByteBuffer feedback = ByteBuffer.allocate(20);
							feedback = ByteBuffer.wrap("LOGIN:OK".getBytes());
							key.interestOps(SelectionKey.OP_WRITE);
							key.attach(feedback);
						} else if (checkBuffer.startsWith("SENTO:")) {
							String message = checkBuffer.substring(6);
							System.out.println("sentto:" + message);
							ByteBuffer buffer1 = ByteBuffer.allocate(50);
							buffer1 = ByteBuffer.wrap(message.getBytes());
							Iterator it = connectKey.iterator();
							// key.interestOps(SelectionKey.OP_WRITE);
							while (it.hasNext()) {
								((SelectionKey) it.next()).attach(buffer1
										.duplicate());
							}
							System.out.println("here1");
							// for(int i=0;i<connectKey.add.;i++){
							// connectKey[i].attach(buffer.duplicate());
							// }
						}
					}
				} catch (IOException ex) {
					key.cancel();
					// System.exit(-1);
					try {
						key.channel().close();
					} catch (IOException cex) {
					}
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

	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
		try {
			cs.startServer();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}
}