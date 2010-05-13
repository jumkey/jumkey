package blog.service;

public interface UsersService {
	public void installAddUser(String name, String password,String screenName,String mail,String url);
	public boolean hasUsers();
	public boolean login(String name, String password);
	public String encoder(String name, String password);
}
