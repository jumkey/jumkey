package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.GenericDAOHibernate;
import meetmanager.dao.UnitsDAO;
import meetmanager.model.Units;


public class UnitsDAOImpl extends GenericDAOHibernate<Units, Integer> implements
		UnitsDAO {
	public List<Units> findUnitsByType(Integer typeid) {
		return find("from Units where unitsType.id=" + typeid);
	}
}
