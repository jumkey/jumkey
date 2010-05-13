package blog;

import java.io.IOException;

import javax.servlet.http.*;

import blog.pojo.Metas;
import blog.service.ContentsServiceImpl;

@SuppressWarnings("serial")
public class TestServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ContentsServiceImpl contentsser = new ContentsServiceImpl();
		resp.setContentType("text/plain");
		Metas meta = new Metas();
		meta.setName("jumkey");
		contentsser.create(meta);
		System.out.println(contentsser.getMetas().get(0).getName());
	}
}
