package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Limit;

public interface LimitDAO extends GenericDAO<Limit,Integer> {
    public List<Limit> findLimitByRoleId(Integer roleId);
}
