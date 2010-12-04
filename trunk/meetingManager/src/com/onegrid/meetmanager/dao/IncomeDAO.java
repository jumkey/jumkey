package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Income;
import com.onegrid.meetmanager.model.MeetingFeeItem;

public interface IncomeDAO extends GenericDAO<Income,Integer> {

	public List<Income> findByMeetingFeeItem(MeetingFeeItem meetingFeeItem);

	public Double getAllIncome(Integer meetingid);
	
	public void saveOrUpdate1(Income income1);
}
