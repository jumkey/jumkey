package com.onegrid.meetmanager.dao.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.IncomeDAO;
import com.onegrid.meetmanager.model.Income;
import com.onegrid.meetmanager.model.MeetingFeeItem;

public class IncomeDAOImpl extends GenericDAOHibernate<Income,Integer> implements IncomeDAO {

	public List<Income> findByMeetingFeeItem(MeetingFeeItem meetingFeeItem) {
		return this.find("from Income where meetingFeeItem.meetingInfo.id=" + meetingFeeItem.getMeetingInfo().getId());
	}

	public Double getAllIncome(Integer meetingid) {
		Double Count = (Double) getSession().createQuery("select sum(money) from Income where meetingFeeItem.meetingInfo.id="+meetingid).iterate().next();
		return Count;
	}

    public void saveOrUpdate1(Income income1) {
        saveOrUpdate(income1);
    }
	
}
