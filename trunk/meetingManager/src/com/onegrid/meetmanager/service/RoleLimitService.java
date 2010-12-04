package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.RoleLimit;

public interface RoleLimitService {

	public void addInstance(RoleLimit roleLimit);

	public void deleteInstance(RoleLimit roleLimit);

	public List<RoleLimit> getAllRoleLimit();

	public List<RoleLimit> findRoleLimitByRoleIdAndLimitId(Integer roleId,
			Integer limitId);

	public RoleLimit getInstance(RoleLimit roleLimit);

	public List<RoleLimit> getRoleLimitListByRoleId(Integer roleid);
}
