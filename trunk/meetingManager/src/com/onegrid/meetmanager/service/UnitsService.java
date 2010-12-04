package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.model.UnitsType;

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
