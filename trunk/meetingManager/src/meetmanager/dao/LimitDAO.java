package meetmanager.dao;

import java.util.List;

import meetmanager.model.Limit;
import meetmanager.utils.dao.GenericDAO;


public interface LimitDAO extends GenericDAO<Limit,Integer> {
    public List<Limit> findLimitByRoleId(Integer roleId);
}
