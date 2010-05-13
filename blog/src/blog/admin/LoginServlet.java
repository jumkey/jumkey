package blog.admin;

import java.io.IOException;

import javax.servlet.http.*;

import blog.BaseServlet;
import blog.service.UsersService;
import blog.service.UsersServiceImpl;

@SuppressWarnings("serial")
public class LoginServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		UsersService usersser = new UsersServiceImpl();
		if(usersser.login(name, password)){
			String md5str=usersser.encoder(name, password);
			//添加cookies
			Cookie cookie = new Cookie("userauth", md5str);
			cookie.setMaxAge(60*60*24);
			cookie.setPath("/");
			//cookie.setSecure(false);
			resp.addCookie(cookie);
		}
	}
}
