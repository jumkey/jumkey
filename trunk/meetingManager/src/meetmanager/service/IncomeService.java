package meetmanager.service;

import java.util.List;

import meetmanager.model.Income;
import meetmanager.model.MeetingFeeItem;


public interface IncomeService {
	public List<Income> getAllIncomeByMeetingFeeItem(MeetingFeeItem meetingFeeItem);
}
