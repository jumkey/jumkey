package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.RoleLimit;

public interface RoleLimitDAO extends GenericDAO<RoleLimit, Integer> {
	public List<RoleLimit> findRoleLimitByRoleIdAndLimitId(Integer roleId,
			Integer limitId);

	public List<RoleLimit> findByRoleId(Integer roleId);

}
