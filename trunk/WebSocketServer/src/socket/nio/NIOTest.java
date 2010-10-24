/*
 * Created on 2005-2-1
 *
 * CopyRight by lxleaves_zhang
 */
package socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

public class NIOTest {
	public static SocketChannel createSocketChannel(String host, int port)
			throws IOException {
		SocketChannel sc = SocketChannel.open(new InetSocketAddress(host, port));
		sc.configureBlocking(false);
		return sc;
	}

	public static final String host = "www.163.com";

	public static final String path = "/";

	public static final int port = 80;

	public static final byte[] req = ("GET " + path + " HTTP/1.0\r\nHost:" + host + "\r\n\r\n").getBytes();

	public static void main(String[] args) {
		Selector sel = null;
		ByteBuffer buf = ByteBuffer.allocate(256);
		SocketChannel sc[] = new SocketChannel[2];
		try {
			sel = SelectorProvider.provider().openSelector();
			sc[0] = createSocketChannel(host, port);
			sc[1] = createSocketChannel(host, port);
			buf.put(req);
			buf.flip();
			sc[0].write(buf);
			buf.flip();
			sc[1].write(buf);
			sc[0].register(sel, sc[0].validOps());
			sc[1].register(sel, sc[1].validOps());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (sel.isOpen()) {
			try {
				sel.select();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Iterator it = sel.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey sk = (SelectionKey) it.next();
				it.remove();
				SocketChannel next = (SocketChannel) sk.channel();
				buf.clear();
				try {
					// check whether finish
					if (next.read(buf) == -1) {
						sk.cancel();
						next.close();

						if (!it.hasNext()) {
							sel.close();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				buf.flip();
				if (buf.limit() == 0)
					continue;
				byte b[] = new byte[buf.limit()];
				buf.get(b);
				// System.out.println(next == sc[0]);
				if (next == sc[0])
					System.out.print(new String(b));
				else
					System.err.print(new String(b));
			}
		}
	}
}