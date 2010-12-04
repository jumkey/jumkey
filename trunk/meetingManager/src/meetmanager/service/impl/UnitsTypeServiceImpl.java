package meetmanager.service.impl;

import meetmanager.dao.UnitsTypeDAO;
import meetmanager.model.UnitsType;
import meetmanager.service.UnitsTypeService;


public class UnitsTypeServiceImpl implements UnitsTypeService {
	private UnitsTypeDAO unitsTypeDAO;

	public void setUnitsTypeDAO(UnitsTypeDAO unitsTypeDAO) {
		this.unitsTypeDAO = unitsTypeDAO;
	}

	public UnitsType getUnitsTypeById(Integer id) {
		return unitsTypeDAO.get(id);
	}

}
