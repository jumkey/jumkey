package blog.admin;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import blog.BaseServlet;
import blog.db.PMF;
import blog.pojo.Users;

@SuppressWarnings("serial")
public class LoginServlet extends BaseServlet {
	@SuppressWarnings("unchecked")
	public void doAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String querystr = "select from " + Users.class.getName()+" where name=="+name+"&&password=="+password;
	    Query query = pm.newQuery(querystr);
	    try{
	        List<Users> users = (List<Users>) query.execute();
	        pm.detachCopyAll(users);
	        System.out.println(users);
	    }finally{
	        query.closeAll();
	        pm.close();
	    }
	}
}
