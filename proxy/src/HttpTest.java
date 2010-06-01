import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpTest {
	public static void main(String argv[]) throws Exception {
		final int HTTP_PORT = 8580;

		Socket socket = new Socket("192.168.90.146", HTTP_PORT);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.write("POST");
		out.flush();

		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = in.readLine()) != null) {
			sb.append(line + "rn");
		}
		out.close();
		in.close();
		System.out.println(sb.toString());
	}
}