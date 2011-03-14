package meetmanager.dao;


import java.util.List;

import meetmanager.model.MeetingInfo;
import meetmanager.utils.dao.GenericDAO;


public interface MeetingInfoDAO extends GenericDAO<MeetingInfo,Integer> {
	List<MeetingInfo> findByMeetings();
}
