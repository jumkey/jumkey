package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.GenericDAOHibernate;
import meetmanager.dao.PriceDAO;
import meetmanager.model.Price;
import meetmanager.model.Units;


public class PriceDAOImpl extends GenericDAOHibernate<Price,Integer> implements PriceDAO {

	public List<Price> findByUnits(Units units) {
		// TODO Auto-generated method stub
		return find("from Price where units.id="+units.getId());
	}
	
}
