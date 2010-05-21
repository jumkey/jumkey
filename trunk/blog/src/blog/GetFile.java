package blog;

import java.io.IOException;

import javax.servlet.http.*;

import blog.DAO.FileDAO;
import blog.DAO.FileDAOImpl;

@SuppressWarnings("serial")
public class GetFile extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		FileDAO fd=new FileDAOImpl();
		resp.setContentType("text/plain");
		System.out.println(fd.retrieve(5l).getFile());
	}
}
