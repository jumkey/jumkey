package meetmanager.dao;

import java.util.List;

import meetmanager.model.Units;


public interface UnitsDAO extends GenericDAO<Units,Integer> {
	public List<Units> findUnitsByType(Integer typeid);
}
