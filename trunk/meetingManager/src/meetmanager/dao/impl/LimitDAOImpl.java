package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.LimitDAO;
import meetmanager.model.Limit;
import meetmanager.utils.dao.GenericDAOHibernate;


public class LimitDAOImpl extends GenericDAOHibernate<Limit,Integer> implements LimitDAO {

    public List<Limit> findLimitByRoleId(Integer roleId) {
        String sql = "from Limit l,RoleLimit rl where 1=1 ";
        if (roleId != 0) {
            sql += " and l.id=rl.limitid and roleid=" + roleId;
        }
        return find(sql);
    }
}	
