package com.onegrid.meetmanager.service.impl;

import com.onegrid.meetmanager.dao.UnitsTypeDAO;
import com.onegrid.meetmanager.model.UnitsType;
import com.onegrid.meetmanager.service.UnitsTypeService;

public class UnitsTypeServiceImpl implements UnitsTypeService {
	private UnitsTypeDAO unitsTypeDAO;

	public void setUnitsTypeDAO(UnitsTypeDAO unitsTypeDAO) {
		this.unitsTypeDAO = unitsTypeDAO;
	}

	public UnitsType getUnitsTypeById(Integer id) {
		return unitsTypeDAO.get(id);
	}

}
