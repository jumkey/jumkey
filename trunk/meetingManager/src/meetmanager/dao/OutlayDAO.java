package meetmanager.dao;

import meetmanager.model.Outlay;

public interface OutlayDAO extends GenericDAO<Outlay,Integer> {

	public Double getAllOutlay(Integer meetingid);
	
}
