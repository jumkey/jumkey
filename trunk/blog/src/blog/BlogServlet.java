package blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import blog.DAO.ArticleDAO;
import blog.pojo.Article;

@SuppressWarnings("serial")
public class BlogServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ArticleDAO articledao=new ArticleDAO();
		resp.setContentType("text/plain");
		List<Article> articles=articledao.getArticles();
		req.setAttribute("artlist", articles);
		try {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
