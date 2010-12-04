package meetmanager.dao;

import java.util.List;

import meetmanager.model.RoleLimit;


public interface RoleLimitDAO extends GenericDAO<RoleLimit, Integer> {
	public List<RoleLimit> findRoleLimitByRoleIdAndLimitId(Integer roleId,
			Integer limitId);

	public List<RoleLimit> findByRoleId(Integer roleId);

}