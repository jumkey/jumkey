package meetmanager.dao;

import meetmanager.model.Outlay;
import meetmanager.utils.dao.GenericDAO;

public interface OutlayDAO extends GenericDAO<Outlay,Integer> {

	public Double getAllOutlay(Integer meetingid);
	
}
