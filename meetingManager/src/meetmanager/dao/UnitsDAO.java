package meetmanager.dao;

import java.util.List;

import meetmanager.model.Units;
import meetmanager.utils.dao.GenericDAO;


public interface UnitsDAO extends GenericDAO<Units,Integer> {
	public List<Units> findUnitsByType(Integer typeid);
}
