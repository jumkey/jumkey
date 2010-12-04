package com.onegrid.meetmanager.dao.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.UnitsDAO;
import com.onegrid.meetmanager.model.Units;

public class UnitsDAOImpl extends GenericDAOHibernate<Units, Integer> implements
		UnitsDAO {
	public List<Units> findUnitsByType(Integer typeid) {
		return find("from Units where unitsType.id=" + typeid);
	}
}
