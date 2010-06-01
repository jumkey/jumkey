package MyServer;

/****************************************
 * This a simple java http server ..
 * Daniel Sun @ 公元2008.10.25
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	private ServerSocket serverSocket;
	private static final int HTTP_PORT = 1998;

	public void startSever(int port) {
		// 启动

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("My Server has Started at port :" + port);
			while (true) {
				Socket socket = serverSocket.accept();
				// Socket socket = serverSocket.accept();
				new Processor(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		MyServer server = new MyServer();
		if (args.length == 1) {
			// new MyServer().startSever(Integer.parseInt(args[0]));
			server.startSever(Integer.parseInt(args[0]));
		} else {
			// new MyServer().startSever(HTTP_PORT);
			server.startSever(MyServer.HTTP_PORT);
		}

	}

}