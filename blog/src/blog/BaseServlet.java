package blog;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doAll(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doAll(req, resp);
	}
	public abstract void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException;
}
