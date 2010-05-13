package blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import blog.pojo.Contents;
import blog.service.ContentsService;
import blog.service.ContentsServiceImpl;

@SuppressWarnings("serial")
public class BlogServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ContentsService contentsser=new ContentsServiceImpl();

		List<Contents> contents=contentsser.getAllText();
		req.setAttribute("contentslist", contents);
		try {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
