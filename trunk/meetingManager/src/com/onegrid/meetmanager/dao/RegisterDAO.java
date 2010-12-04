package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Reach;
import com.onegrid.meetmanager.model.Register;

public interface RegisterDAO extends GenericDAO<Register,Integer> {

	public void saveOrUpdate(Register register);

	public List<Reach> findReachs(String string);
	
}
