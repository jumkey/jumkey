package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Units;

public interface UnitsDAO extends GenericDAO<Units,Integer> {
	public List<Units> findUnitsByType(Integer typeid);
}
