package blog.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.*;

import blog.BaseServlet;
import blog.service.UsersService;
import blog.service.UsersServiceImpl;
import blog.util.MD5;

@SuppressWarnings("serial")
public class LoginServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		UsersService usersser = new UsersServiceImpl();
		if(usersser.login(name, password)){
			try {
				//添加cookies
				StringBuffer str=new StringBuffer();
				str.append(MD5.getMD5Str(name));
				str.append(MD5.getMD5Str(password));
				String md5str=MD5.getMD5Str(MD5.getMD5Str(str.substring(16, 48)));
				Cookie cookie = new Cookie("userauth", md5str);
				cookie.setMaxAge(60*60*24);
				resp.addCookie(cookie);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
}
