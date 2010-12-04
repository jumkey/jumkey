package meetmanager.service;

import java.util.List;

import meetmanager.model.Awards;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Units;


public interface AwardsService {
	public void addInstance(Awards awards);
	public List<Awards> findAwardsByMeetingId(Integer meetingid);
	public Awards findAwardsById(Integer awardsid);
	public void deleteInstance(Awards awards) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public Awards updateInstance(Awards awards) throws Exception;
	public String dochoujiang(Integer meetingId,Integer[] id);
	public MeetingInfo findMeetingInfoById(Integer id);
	public List<Units> findAllUnits();
}
