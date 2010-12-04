package meetmanager.dao;

import java.util.List;

import meetmanager.model.Price;
import meetmanager.model.Units;


public interface PriceDAO extends GenericDAO<Price,Integer> {

	List<Price> findByUnits(Units units);

}
