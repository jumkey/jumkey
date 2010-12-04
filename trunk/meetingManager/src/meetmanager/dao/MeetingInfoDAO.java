package meetmanager.dao;


import java.util.List;

import meetmanager.model.MeetingInfo;


public interface MeetingInfoDAO extends GenericDAO<MeetingInfo,Integer> {
	List<MeetingInfo> findByMeetings();
}
