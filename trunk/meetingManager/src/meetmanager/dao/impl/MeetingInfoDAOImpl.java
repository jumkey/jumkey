package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.MeetingInfoDAO;
import meetmanager.model.MeetingInfo;
import meetmanager.utils.dao.GenericDAOHibernate;


public class MeetingInfoDAOImpl extends GenericDAOHibernate<MeetingInfo,Integer> implements MeetingInfoDAO {


	public List<MeetingInfo> findByMeetings() {
		// TODO Auto-generated method stub
		return find("from MeetingInfo");
	}

}
