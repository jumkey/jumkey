package meetmanager.dao;

import java.util.List;

import meetmanager.model.Limit;


public interface LimitDAO extends GenericDAO<Limit,Integer> {
    public List<Limit> findLimitByRoleId(Integer roleId);
}
