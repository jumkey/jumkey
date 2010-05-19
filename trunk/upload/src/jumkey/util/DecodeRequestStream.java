package jumkey.util;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DecodeRequestStream {
	public static Hashtable Decode(HttpServletRequest req, int paramcount)
			throws java.io.IOException {
		byte[] body = null;
		int bodyLen = 0;
		byte[] bound = null;
		int boundLen = 0;
		int index = 0;
		int count = 0;

		bodyLen = req.getContentLength();
		body = new byte[bodyLen];
		BufferedInputStream dataIn = new BufferedInputStream(req.getInputStream());
		int readed = 0;
		int cur_read = 0;
		while (readed < bodyLen) {
			cur_read = dataIn.read(body, readed, bodyLen - readed);
			if (cur_read < 0) {
				break;
			}
			readed = readed + cur_read;
		}
		int i = 0;
		while (i <= bodyLen) {
			if (body[i] == 13 && body[i + 1] == 10)
				break;
			else
				i++;
		}
		if (i > bodyLen)
			return null;
		boundLen = i;
		bound = new byte[boundLen];
		for (int j = 0; j < boundLen; j++) {
			bound[j] = body[j + index]; // decode bound
		}
		i = i + 2; // plus 2 to skip the following bytes "0D 0A"
		index = i; // point to the beginning of first parameter
		Hashtable hashtable = new Hashtable();
		boolean moved = false;
		while (i < bodyLen) {
			if (!moved && count == paramcount) {
				i = bodyLen - boundLen - 5; // subst more than 4, but little
											// than 10
				moved = true;
			}
			if (!compareByteArray(copybyte(body, i, boundLen), bound)) {
				i++;
			} else {
				count++;
				int j = index;
				while ((j < i)
						&& (body[j] != 13 || body[j + 1] != 10
								|| body[j + 2] != 13 || body[j + 3] != 10)) {
					j++;
				}
				if (j >= i)
					break;
				String paramHeader = new String(body, index, j - index + 2);
				index = j;
				int m = paramHeader.indexOf("name=\"");
				if (m < 0)
					break;
				m = m + 6; // point to name value
				int n = paramHeader.indexOf("\"", m);
				if (n <= m)
					break;
				String name = paramHeader.substring(m, n); // get name
				boolean isFile = false;
				String filename = "";
				String filetype = "";
				m = paramHeader.indexOf("filename=\"", n + 1);
				if (m > n) {
					isFile = true;
					m = m + 10; // skip (filename=")
					n = paramHeader.indexOf("\"", m);
					if (n > m)
						filename = paramHeader.substring(m, n);
					m = paramHeader.indexOf("Content-Type: ", n + 1);
					if (m > n) {
						m = m + 14;
						n = m;
						while ((n < paramHeader.length())
								&& (paramHeader.charAt(n) != 13 || paramHeader.charAt(n + 1) != 10)) {
							n++;
						}
						if (n <= paramHeader.length())
							filetype = paramHeader.substring(m, n);
					}
				}
				/*
				 * status: j point to the start of end flag (0D 0A 0D 0A) of
				 * current parameter's header after j + 0D 0A 0D 0A, is the
				 * start of current parameter's value (byte format) i point to
				 * the start of next boundary, that is, "(current header) 0D 0A
				 * 0D 0A (current value) 0D 0A (next boundary)" ¡ü ¡ü ¡ü index j i
				 * the following code gets current value
				 */
				j = j + 4; // skip 0D 0A 0D 0A, point to parameter value;
				byte[] value = copybyte(body, j, i - j - 2);
				if (!isFile) {
					String tmpstr = new String(value);
					hashtable.put(name, tmpstr);
				} else {
					hashtable.put(name, value);
					hashtable.put("filename", filename);
					hashtable.put("filetype", filetype);
					break;
				}
				i = i + boundLen + 2;
				index = i;
			} // end else
		} // end while
		dataIn.close();
		return hashtable;
	}

	public static boolean compareByteArray(byte[] a, byte[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		return true;
	}

	public static byte[] copybyte(byte[] a, int from, int len) {
		int copylen = len;
		if ((a.length - from) < copylen)
			copylen = a.length - from;
		byte[] b = new byte[copylen];
		for (int i = 0; i < copylen; i++)
			b[i] = a[from + i];
		return b;
	}
}