package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Income;
import com.onegrid.meetmanager.model.MeetingFeeItem;
import com.onegrid.meetmanager.model.MeetingInfo;
import com.onegrid.meetmanager.model.Outlay;

public interface PaymentService {

	public MeetingInfo getMeetingInfoById(Integer id);

	public List<MeetingFeeItem> getAllMeetingFeeItem();

	public void addOutlay(Outlay outlay);

	public void addIncome(Income income);

	public String getStatistics(Integer id);

	public Income updateIncome(Income income);

	public Outlay updateOutlay(Outlay outlay);

	public String checkunitsname(String username);

	public String checkusername(String username);

	public void deleteIncome(Income income);

	public void deleteOutlay(Outlay outlay);

}
