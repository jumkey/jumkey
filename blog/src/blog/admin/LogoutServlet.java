package blog.admin;

import java.io.IOException;

import javax.servlet.http.*;

import blog.BaseServlet;
import blog.util.Contains;

@SuppressWarnings("serial")
public class LogoutServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Cookie[] cookies=req.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				if("userauth".equals(cookies[i].getName())){
					cookies[i].setMaxAge(0);
					cookies[i].setPath("/");
					resp.addCookie(cookies[i]);
					break;
				}
			}
		}
		resp.sendRedirect(Contains.login);
	}
}
