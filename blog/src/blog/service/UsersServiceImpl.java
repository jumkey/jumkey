package blog.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import blog.DAO.UsersDAO;
import blog.DAO.UsersDAOImpl;
import blog.pojo.Users;
import blog.util.MD5;

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

	@Override
	public String encoder(String name, String password) {
		String md5str=null;
		try {
			StringBuffer str=new StringBuffer();
			str.append(MD5.getMD5Str(name));
			str.append(MD5.getMD5Str(password));
			md5str=name+"#"+MD5.getMD5Str(MD5.getMD5Str(str.substring(16, 48)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return md5str;
	}

	/*
	 * * true 验证成功
	 * 
	 * @author Administrator
	 */
	@Override
	public boolean decoder(String str) {
		boolean t=false;
		String[] userstr=str.split("#");
		System.out.println(userstr[0]+"---------"+userstr[1]);
		UsersDAO usersdao=new UsersDAOImpl();
		Users user = usersdao.getUsersByName(userstr[0]);
		if(str.equals(encoder(user.getName(), user.getPassword()))){
			t=true;
		}
		return t;
	}

}
