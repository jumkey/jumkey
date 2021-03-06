package meetmanager.service;

import java.util.List;

import meetmanager.model.MeetingInfo;
import meetmanager.model.Register;


public interface MeetingService {

	public void addInstance(MeetingInfo price);
	public List<MeetingInfo> findByMeetings();
	public void deleteInstance(MeetingInfo meetinginfo) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public MeetingInfo updateInstance(MeetingInfo meetinginfo) throws Exception;
	public List<Register> getRegisterByMeetingInfo(MeetingInfo meetinginfo);
	public MeetingInfo getMeetingInfo(Integer id);

}
