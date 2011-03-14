package meetmanager.service;

import java.util.List;

import meetmanager.model.JoinActivitiesRecord;
import meetmanager.utils.dao.Page;


public interface JoinActivitiesRecordService {

	public void addInstance(JoinActivitiesRecord activities);

	public List<JoinActivitiesRecord> findByJoinActivitiesRecord(Integer id);

	public List<JoinActivitiesRecord> findPageByJoinActivitiesRecordByActivitiesId(
			Page page, Integer id);

	public void deleteInstance(JoinActivitiesRecord meetinginfo)
			throws Exception;

	public void deleteSelectInstance(Integer[] selected) throws Exception;

	public JoinActivitiesRecord updateInstance(JoinActivitiesRecord fete)
			throws Exception;

	public String checkUser(Integer id, String username);

}
