package blog.admin;

import java.io.IOException;

import javax.servlet.http.*;

import blog.BaseServlet;
import blog.util.MD5;

@SuppressWarnings("serial")
public class IndexServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Cookie[] cookies=req.getCookies();
		String str=null;
		for(int i=0;i<cookies.length;i++){
			if("userauth".equals(cookies[i].getName())){
				str=cookies[i].getValue();
				break;
			}
		}
	}
}
