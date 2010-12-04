package com.onegrid.meetmanager.dao;


import java.util.List;

import com.onegrid.meetmanager.model.MeetingInfo;

public interface MeetingInfoDAO extends GenericDAO<MeetingInfo,Integer> {
	List<MeetingInfo> findByMeetings();
}
