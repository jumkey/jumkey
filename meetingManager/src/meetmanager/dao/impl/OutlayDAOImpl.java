package meetmanager.dao.impl;

import meetmanager.dao.OutlayDAO;
import meetmanager.model.Outlay;
import meetmanager.utils.dao.GenericDAOHibernate;


public class OutlayDAOImpl extends GenericDAOHibernate<Outlay,Integer> implements OutlayDAO {

	public Double getAllOutlay(Integer meetingid) {
		Double Count = (Double) getSession().createQuery("select sum(money) from Outlay where meetingFeeItem.meetingInfo.id="+meetingid).iterate().next();
		return Count;
	}
	
}
