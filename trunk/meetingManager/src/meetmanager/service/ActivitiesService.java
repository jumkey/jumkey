package meetmanager.service;

import java.util.List;

import meetmanager.model.Activities;
import meetmanager.model.Page;


public interface ActivitiesService {

	public void addInstance(Activities activities);

	public List<Activities> findActivitiesByMeetingId(Integer meetingid);

	public List<Activities> findPageActivitiesByMeetingId(Page page,
			Integer meetingid);

	public void deleteInstance(Activities meetinginfo) throws Exception;

	public void deleteSelectInstance(Integer[] selected) throws Exception;

	public Activities updateInstance(Activities fete) throws Exception;

}
