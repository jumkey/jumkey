package meetmanager.service.impl;

import java.util.List;

import meetmanager.dao.UnitsDAO;
import meetmanager.dao.UnitsTypeDAO;
import meetmanager.model.Page;
import meetmanager.model.Units;
import meetmanager.model.UnitsType;
import meetmanager.service.UnitsService;


public class UnitsServiceImpl implements UnitsService {
	private UnitsDAO unitsDAO;
	private UnitsTypeDAO unitsTypeDAO;

	public UnitsTypeDAO getUnitsTypeDAO() {
		return unitsTypeDAO;
	}

	public void setUnitsTypeDAO(UnitsTypeDAO unitsTypeDAO) {
		this.unitsTypeDAO = unitsTypeDAO;
	}

	public UnitsDAO getUnitsDAO() {
		return unitsDAO;
	}

	public void setUnitsDAO(UnitsDAO unitsDAO) {
		this.unitsDAO = unitsDAO;
	}

	public List<Units> getUnitsByType(Integer typeid) {
		return unitsDAO.findUnitsByType(typeid);
	}

	public List<Units> getAllUnits() {
		return unitsDAO.findAll();
	}

	public void addInstance(Units units) {
		unitsDAO.save(units);
	}

	public Units updateInstance(Units units) {
		Units u = unitsDAO.get(units.getId());
		u.setName(units.getName());
		u.setAddress(units.getAddress());
		u.setZip(units.getZip());
		u.setSite(units.getSite());
		u.setUnitsType(units.getUnitsType());
		u.setTradetype(units.getTradetype());
		return u;
	}

	public List<UnitsType> getAllUnitsType() {
		return unitsTypeDAO.findAll();
	}

	public Units getUnitsById(Integer id) {
		return unitsDAO.get(id);
	}

	public List<Units> findPageUnitsForSeach(Page page, Integer typeId,
			String unitName) {
		String sql = "from Units where 1=1";
		if (typeId != null && typeId > 0) {
			sql += " and unitsType.id=" + typeId;
		}
		if (unitName != null && !unitName.equals("")) {
			sql += " and name like '%" + unitName + "%'";
		}
		page.setTotalNum(unitsDAO.getCountByQuery(sql));
		return unitsDAO.findByPagination(sql, page);
	}

}
