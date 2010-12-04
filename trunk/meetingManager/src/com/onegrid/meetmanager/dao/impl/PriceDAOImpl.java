package com.onegrid.meetmanager.dao.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.PriceDAO;
import com.onegrid.meetmanager.model.Price;
import com.onegrid.meetmanager.model.Units;

public class PriceDAOImpl extends GenericDAOHibernate<Price,Integer> implements PriceDAO {

	public List<Price> findByUnits(Units units) {
		// TODO Auto-generated method stub
		return find("from Price where units.id="+units.getId());
	}
	
}
