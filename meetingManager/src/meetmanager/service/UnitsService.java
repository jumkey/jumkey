package meetmanager.service;

import java.util.List;

import meetmanager.model.Units;
import meetmanager.model.UnitsType;
import meetmanager.utils.dao.Page;


public interface UnitsService {

	public List<Units> getUnitsByType(Integer i);

	public List<Units> getAllUnits();

	public void addInstance(Units units);

	public Units updateInstance(Units units);

	public List<UnitsType> getAllUnitsType();

	public Units getUnitsById(Integer id);

	public List<Units> findPageUnitsForSeach(Page page, Integer typeId,
			String unitName);
}
