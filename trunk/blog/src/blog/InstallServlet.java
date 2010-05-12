package blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import blog.service.UsersService;
import blog.service.UsersServiceImpl;

@SuppressWarnings("serial")
public class InstallServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UsersService usersser = new UsersServiceImpl();
		//检测是否已经存在Users
		if(usersser.hasUsers()){
			resp.setContentType("text/html");
			resp.getWriter().println("非法安装！");
		}else{
			String name=req.getParameter("name");
			String password=req.getParameter("password");
			String screenName=req.getParameter("screenName");
			String mail=req.getParameter("mail");
			String url=req.getParameter("url");
			usersser.installAddUser(name, password, screenName, mail, url);
			try {
				req.getRequestDispatcher("index").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
