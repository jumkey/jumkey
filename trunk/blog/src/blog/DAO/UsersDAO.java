package blog.DAO;

import java.util.List;

import blog.pojo.Users;

public interface UsersDAO {
	public Users getUsersByNP(String name, String password);
	
	public Users getUsersByName(String name);

	public List<Users> getAllUsers();

	public void create(Users users);

	public Users retrieve(Long id);

	public void update(Users users);

	public void delete(Long id);
}
