package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Price;
import com.onegrid.meetmanager.model.Units;

public interface PriceDAO extends GenericDAO<Price,Integer> {

	List<Price> findByUnits(Units units);

}
