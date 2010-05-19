package jumkey.util;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.servlet.*;
import javax.activation.*;
import javax.servlet.http.*;

/**
 * @author 2002/7/10 zty
 * 
 * <p>
 * ¡¾Ê¹ÓÃÀý¡¿
 * <p>
 * try {
 * </p>
 * <p>
 * Upload load=new Upload();
 * </p>
 * <p>
 * 	load.setDir("i:\\ztytest\\");
 * </p>
 * <p>
 * 	load.doUpload(req,res); //HttpServletRequest req //HttpServletResponse res
 * </p>
 * <p> }
 * </p>
 * <p>
 * catch( Exception e ) {
 * </p>
 * <p>
 * 	return;
 * </p>
 * <p> }
 * </p>
 */

@SuppressWarnings("serial")
public class Upload extends HttpServlet {
	public String strDir;

	public Upload() {
	}

	public void doUpload(HttpServletRequest req, HttpServletResponse res)
			throws IOException, MessagingException {
		String boundary = req.getHeader("Content-Type");
		int pos = boundary.indexOf('=');
		boundary = boundary.substring(pos + 1);
		boundary = "--" + boundary;
		ServletInputStream in = req.getInputStream();
		byte[] bytes = new byte[512];
		int state = 0;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		String name = null;
		String value = null;
		String filename = null;
		String contentType = null;

		int i = in.readLine(bytes, 0, 512);

		while (-1 != i) {
			String st = new String(bytes, 0, i);
			if (st.startsWith(boundary)) {
				state = 0;
				System.out.println(filename);
				if (null != name) {
					if (buffer.size() > 2) {
						FileOutputStream outStream = new FileOutputStream(
								strDir + filename);
						outStream.write(buffer.toByteArray(), 0, buffer
								.toByteArray().length);
						outStream.close();
					}
					name = null;
					value = null;
					filename = null;
					contentType = null;
					buffer = new ByteArrayOutputStream();
				}
			}// end of st.startsWith(boundary)
			else if (st.startsWith("Content-Disposition: form-data")
					&& state == 0) {
				StringTokenizer tokenizer = new StringTokenizer(st, ";=\"");
				while (tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken();
					if (token.trim().startsWith("name")) {
						name = tokenizer.nextToken();
						state = 2;
					} else if (token.trim().startsWith("filename")) {
						filename = tokenizer.nextToken();
						StringTokenizer ftokenizer = new StringTokenizer(
								filename, "\\");
						filename = ftokenizer.nextToken();
						while (ftokenizer.hasMoreTokens())
							filename = ftokenizer.nextToken();
						state = 1;
						break;
					}
				}
			}// end state=0
			else if (st.startsWith("Content-Type") && state == 1) {
				pos = st.indexOf(":");
				contentType = st.substring(pos + 2, st.length() - 2);

			}// end state=1
			else if (state == 1)
				state = 3;
			else if (st.equals("\r\n") && state == 2)
				state = 4;
			else if (state == 3)
				buffer.write(bytes, 0, i);
			else if (state == 4)
				value = value == null ? st : value + st;

			i = in.readLine(bytes, 0, 512);
		}// end while

	}

	public void setDir(String strSavePath) {
		strDir = strSavePath;
	}

	class ByteDataSource implements DataSource {
		byte[] bytes;
		String contentType;
		String name;

		ByteDataSource(byte[] bytes, String contentType, String name) {
			this.bytes = bytes;
			this.contentType = contentType;
			this.name = name;
		}

		public String getContentType() {
			return contentType;
		}

		public InputStream getInputStream() {
			return new ByteArrayInputStream(bytes, 0, bytes.length - 2);
		}

		public String getName() {
			return name;
		}

		public OutputStream getOutputStream() throws IOException {
			throw new FileNotFoundException();
		}
	} // end of class
}