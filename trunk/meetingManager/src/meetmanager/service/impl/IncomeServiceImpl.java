package meetmanager.service.impl;

import java.util.List;

import meetmanager.dao.IncomeDAO;
import meetmanager.dao.MeetingFeeItemDAO;
import meetmanager.model.Income;
import meetmanager.model.MeetingFeeItem;
import meetmanager.service.IncomeService;


public class IncomeServiceImpl implements IncomeService {
	private IncomeDAO incomeDAO;
	private MeetingFeeItemDAO meetingFeeItemDAO;

	public IncomeDAO getIncomeDAO() {
		return incomeDAO;
	}

	public void setIncomeDAO(IncomeDAO incomeDAO) {
		this.incomeDAO = incomeDAO;
	}

	public MeetingFeeItemDAO getMeetingFeeItemDAO() {
		return meetingFeeItemDAO;
	}

	public void setMeetingFeeItemDAO(MeetingFeeItemDAO meetingFeeItemDAO) {
		this.meetingFeeItemDAO = meetingFeeItemDAO;
	}

	public List<Income> getAllIncomeByMeetingFeeItem(MeetingFeeItem meetingFeeItem) {
		meetingFeeItem=meetingFeeItemDAO.get(meetingFeeItem.getId());
		return incomeDAO.findByMeetingFeeItem(meetingFeeItem);
	}

}
