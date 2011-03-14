package meetmanager.service;

import java.util.List;

import meetmanager.model.Role;
import meetmanager.utils.dao.Page;


public interface RoleService {
	public List<Role> getAllRole();

	public List<Role> getPageRole(Page page);

	public void addInstance(Role role);

	public Role updateInstance(Role role);

	public void deleteInstance(Role role);

	public void deleteSelectInstance(Integer[] selected);
}
