package meetmanager.dao;

import java.util.List;

import meetmanager.model.Income;
import meetmanager.model.MeetingFeeItem;
import meetmanager.utils.dao.GenericDAO;


public interface IncomeDAO extends GenericDAO<Income,Integer> {

	public List<Income> findByMeetingFeeItem(MeetingFeeItem meetingFeeItem);

	public Double getAllIncome(Integer meetingid);
	
	public void saveOrUpdate1(Income income1);
}
