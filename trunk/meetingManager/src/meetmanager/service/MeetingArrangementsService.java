package meetmanager.service;

import java.util.List;

import meetmanager.model.MeetingArrangements;




public interface MeetingArrangementsService {

	public void addInstance(MeetingArrangements meetingArrangements);
	public List<MeetingArrangements> findMeetingArrangementsByMeetingId(Integer meetingid);
	public void deleteInstance(MeetingArrangements meetingArrangements) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public MeetingArrangements updateInstance(MeetingArrangements meetingArrangements) throws Exception;

}
