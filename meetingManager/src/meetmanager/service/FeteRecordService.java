package meetmanager.service;

import java.util.List;

import meetmanager.model.FeteRecord;
import meetmanager.utils.dao.Page;



public interface FeteRecordService {

	public void addInstance(FeteRecord feterecord);
	public List<FeteRecord> findByFeteRecord(Integer id);
	public List<FeteRecord> findPageByFeteRecord(Page page,Integer id);
	public void deleteInstance(FeteRecord feterecord) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public String checkUser(Integer id, String username);

}
