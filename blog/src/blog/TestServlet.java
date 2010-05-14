package blog;

import java.io.IOException;

import javax.servlet.http.*;

import blog.service.ContentsServiceImpl;

@SuppressWarnings("serial")
public class TestServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ContentsServiceImpl contentsser = new ContentsServiceImpl();
		resp.setContentType("text/plain");
		System.out.println(contentsser.getAllText().get(0).getText());
	}
}
