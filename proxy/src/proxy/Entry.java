package proxy;

import java.io.IOException;

public class Entry {
	public static void main(String[] args) {
		try {
			Server server = new Server(8580);
			server.run();
		} catch (IOException e) {
			System.err.println("Error binding the specified port.");
		}
	}
}