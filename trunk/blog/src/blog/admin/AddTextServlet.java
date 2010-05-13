package blog.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Text;

import blog.BaseServlet;
import blog.service.ContentsService;
import blog.service.ContentsServiceImpl;
import blog.util.Contains;

@SuppressWarnings("serial")
public class AddTextServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String title=req.getParameter("title");
		String slug=req.getParameter("slug");
		String uri=req.getParameter("uri");
		String textstr=req.getParameter("text");
		String tags=req.getParameter("tags");
		String meta=req.getParameter("meta");
		Text text=new Text(textstr);
		ContentsService contentsser=new ContentsServiceImpl();
		contentsser.addText(title,slug,uri,text,tags,1);
		req.setAttribute("addsec", true);
		try {
			req.getRequestDispatcher(Contains.main).forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
