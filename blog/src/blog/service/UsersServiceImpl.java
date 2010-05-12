package blog.service;

import java.util.Date;
import java.util.List;

import blog.DAO.UsersDAO;
import blog.DAO.UsersDAOImpl;
import blog.pojo.Users;

public class UsersServiceImpl implements UsersService {

	public void installAddUser(String name, String password,String screenName,String mail,String url) {
		Users users=new Users();
		users.setName(name);
		users.setPassword(password);
		users.setScreenName(screenName);
		users.setMail(mail);
		users.setUrl(url);
		users.setCreated(new Date().getTime());
		users.setGroup("administrator");
		UsersDAO usersdao=new UsersDAOImpl();
		usersdao.create(users);
	}

	public boolean hasUsers() {
		UsersDAO usersdao=new UsersDAOImpl();
		List<Users> list=usersdao.getAllUsers();
		if(list!=null&&list.size()!=0){
			return true;
		}
		return false;
	}

	public boolean login(String name, String password) {
		UsersDAO usersdao=new UsersDAOImpl();
		Users user=usersdao.getUsersByNP(name, password);
		boolean t=false;
		if(user!=null){
			t=true;
		}
		return t;
	}

}
