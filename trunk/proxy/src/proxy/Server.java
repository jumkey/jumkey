package proxy;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	private ServerSocket _server;

	public Server(int port) throws IOException {
		// This statement will throw out IOException,
		// if the specified port is not available.
		_server = new ServerSocket(port);
	}

	public void run() {
		try {
			for (;;) {
				// Accept an incoming connection.
				Socket client = _server.accept();
				// Create a Service Thread to serve the client.
				Service service = new Service(client);
				service.start();
			}
		} catch (IOException e) {
			// Eat the IOException
		}
	}
}