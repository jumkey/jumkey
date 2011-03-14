package meetmanager.service;

import java.util.List;

import meetmanager.model.User;
import meetmanager.utils.dao.Page;


public interface UserService {
	public List<User> getPageUser(Page page);

	public void addInstance(User user);

	public User updateInstance(User user);

	public void deleteInstance(User user);

	public void deleteSelectInstance(Integer[] selected);

	public List<User> findUserForSeach(Page page, Integer unitsId,
			String name);
	public List<User> findUserByUnits(Integer unitsId);
}
