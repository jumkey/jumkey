package blog;

import java.io.IOException;

import javax.servlet.http.*;

import blog.pojo.Metas;
import blog.service.ArticleServiceImpl;

@SuppressWarnings("serial")
public class TestServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ArticleServiceImpl articleser = new ArticleServiceImpl();
		resp.setContentType("text/plain");
		Metas meta = new Metas();
		meta.setName("jumkey");
		articleser.create(meta);
		System.out.println(articleser.getMetas().get(0).getName());
	}
}
