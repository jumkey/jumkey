package blog;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import blog.DAO.ContentsDAO;
import blog.DAO.ContentsDAOImpl;
import blog.pojo.Article;

@SuppressWarnings("serial")
public class AddArticleServlet extends BaseServlet {
	@Override
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		Article article=new Article(title,content,new Date());
		ContentsDAO contentsdao=new ContentsDAOImpl();
		contentsdao.addArticle(article);
		try {
			req.getRequestDispatcher("blog").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
