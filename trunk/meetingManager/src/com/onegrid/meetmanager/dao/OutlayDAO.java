package com.onegrid.meetmanager.dao;

import com.onegrid.meetmanager.model.Outlay;

public interface OutlayDAO extends GenericDAO<Outlay,Integer> {

	public Double getAllOutlay(Integer meetingid);
	
}
