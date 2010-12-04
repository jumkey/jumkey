package com.onegrid.meetmanager.dao.impl;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.OutlayDAO;
import com.onegrid.meetmanager.model.Outlay;

public class OutlayDAOImpl extends GenericDAOHibernate<Outlay,Integer> implements OutlayDAO {

	public Double getAllOutlay(Integer meetingid) {
		Double Count = (Double) getSession().createQuery("select sum(money) from Outlay where meetingFeeItem.meetingInfo.id="+meetingid).iterate().next();
		return Count;
	}
	
}
