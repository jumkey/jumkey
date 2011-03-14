package meetmanager.dao;

import java.util.List;

import meetmanager.model.Price;
import meetmanager.model.Units;
import meetmanager.utils.dao.GenericDAO;


public interface PriceDAO extends GenericDAO<Price,Integer> {

	List<Price> findByUnits(Units units);

}
