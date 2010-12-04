package com.onegrid.meetmanager.dao.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.MeetingInfoDAO;
import com.onegrid.meetmanager.model.MeetingInfo;

public class MeetingInfoDAOImpl extends GenericDAOHibernate<MeetingInfo,Integer> implements MeetingInfoDAO {


	public List<MeetingInfo> findByMeetings() {
		// TODO Auto-generated method stub
		return find("from MeetingInfo");
	}

}
