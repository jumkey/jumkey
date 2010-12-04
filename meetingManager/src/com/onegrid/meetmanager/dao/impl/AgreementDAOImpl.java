package com.onegrid.meetmanager.dao.impl;

import java.util.Date;
import java.util.List;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.AgreementDAO;
import com.onegrid.meetmanager.model.Agreement;

public class AgreementDAOImpl extends GenericDAOHibernate<Agreement,Integer> implements AgreementDAO {

	public List<Agreement> findAgreement() {
		return find("from Agreement where meetingInfo.notices.size=0 and date>"+new Date().getTime());
	}

}
