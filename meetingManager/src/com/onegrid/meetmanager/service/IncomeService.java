package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Income;
import com.onegrid.meetmanager.model.MeetingFeeItem;

public interface IncomeService {
	public List<Income> getAllIncomeByMeetingFeeItem(MeetingFeeItem meetingFeeItem);
}
