package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Agreement;

public interface AgreementDAO extends GenericDAO<Agreement,Integer> {
	public List<Agreement> findAgreement();
}
