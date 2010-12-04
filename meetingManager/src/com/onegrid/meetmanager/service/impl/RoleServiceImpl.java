package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.RoleDAO;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.Role;
import com.onegrid.meetmanager.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public void addInstance(Role Role) {
		roleDAO.save(Role);
	}

	public Role updateInstance(Role role) {
		Role u = roleDAO.get(role.getId());
		u.setName(role.getName());
		return u;
	}

	public void deleteInstance(Role role) {
		roleDAO.delete(roleDAO.get(role.getId()));
	}

	public void deleteSelectInstance(Integer[] selected) {
		for (int id : selected) {
			roleDAO.delete(roleDAO.get(id));
		}
	}

	public List<Role> getAllRole() {
		return roleDAO.findAll();
	}

	public List<Role> getPageRole(Page page) {
		page.setTotalNum(roleDAO.getCountByQuery("from Role"));
		return roleDAO.findByPagination("from Role", page);
	}
}
