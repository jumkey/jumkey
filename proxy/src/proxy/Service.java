package proxy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Service extends Thread {
	private Socket _socket;

	public Service(Socket socket) {
		_socket = socket;
	}

	public void run() {
		try {
			// Wrapper the InputStream to BufferedReader
			BufferedReader input = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
			// Wrapper the OutputStream to BufferedWriter
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream()));

			StringBuffer sb=new StringBuffer();
			int contentLength = 0;
			String line = input.readLine();
			while (line != null) {
				sb.append(line + "\r\n");
				if("".equals(line))
					break;
				line = input.readLine();
				// here to fix post no response bug
                if(line.startsWith("Content-Length")) {
                    try {
                        contentLength = Integer.parseInt(line.substring(line.indexOf(':') + 1).trim());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
			}
			char[] tmpPost = new char[contentLength];
			
			for(int i = 0; i < contentLength; i++) {
				tmpPost[i] = (char)input.read();
				line += String.valueOf(tmpPost[i]);
			}
//			int i=input.read();
//			while(i!=-1){
//				line += String.valueOf((char)i);
//				i=input.read();
//			}
			
			sb.append(line);

			input.close();
			output.close();
		} catch (IOException e) {
			// Abandon the current connection.
			e.printStackTrace();
		} finally {
			try {
				// Close the connection.
				_socket.close();
			} catch (IOException e) {
				// Eat the IOException.
			}
		}
	}
}