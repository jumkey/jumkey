package blog.admin;

import java.io.IOException;

import javax.servlet.http.*;

import blog.BaseServlet;
import blog.service.UsersService;
import blog.service.UsersServiceImpl;

@SuppressWarnings("serial")
public class IndexServlet extends BaseServlet {
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Cookie[] cookies=req.getCookies();
		String str=null;
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				if("userauth".equals(cookies[i].getName())){
					str=cookies[i].getValue();
					break;
				}
			}
		}
		UsersService usersser=new UsersServiceImpl();
		boolean t=usersser.decoder(str);
		System.out.println(t);
	}
}
