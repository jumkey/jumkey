package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.GenericDAOHibernate;
import meetmanager.dao.RoleLimitDAO;
import meetmanager.model.RoleLimit;


public class RoleLimitDAOImpl extends GenericDAOHibernate<RoleLimit, Integer>
		implements RoleLimitDAO {

	public List<RoleLimit> findRoleLimitByRoleIdAndLimitId(Integer roleId,
			Integer limitId) {
		String sql = "from RoleLimit where 1=1 ";
		if (roleId != 0 && limitId != 0) {

			sql += " and roleid=" + roleId + " and limitid=" + limitId;
		}
		return find(sql);
	}

	public List<RoleLimit> findByRoleId(Integer roleId) {
		String sql = "from RoleLimit where 1=1 ";
		if (roleId != 0) {
			sql += " and roleid=" + roleId;
		}
		return find(sql);
	}

}
