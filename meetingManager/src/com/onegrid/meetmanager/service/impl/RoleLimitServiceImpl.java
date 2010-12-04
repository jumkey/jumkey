package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.RoleLimitDAO;
import com.onegrid.meetmanager.model.RoleLimit;
import com.onegrid.meetmanager.service.RoleLimitService;

public class RoleLimitServiceImpl implements RoleLimitService {
	private RoleLimitDAO roleLimitDAO;

	public RoleLimitDAO getRoleLimitDAO() {
		return roleLimitDAO;
	}

	public void setRoleLimitDAO(RoleLimitDAO roleLimitDAO) {
		this.roleLimitDAO = roleLimitDAO;
	}

	public void addInstance(RoleLimit roleLimit) {
		roleLimitDAO.save(roleLimit);
	}

	public List<RoleLimit> getAllRoleLimit() {
		return roleLimitDAO.findAll();
	}

	public List<RoleLimit> findRoleLimitByRoleIdAndLimitId(Integer roleId,
			Integer limitId) {
		return roleLimitDAO.findRoleLimitByRoleIdAndLimitId(roleId, limitId);
	}

	public RoleLimit getInstance(RoleLimit roleLimit) {
		return roleLimitDAO.get(roleLimit.getId());
	}

	public List<RoleLimit> getRoleLimitListByRoleId(Integer roleid) {
		return roleLimitDAO.findByRoleId(roleid);
	}

	public void deleteInstance(RoleLimit roleLimit) {
		roleLimitDAO.delete(roleLimit);
	}
}
