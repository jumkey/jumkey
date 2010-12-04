package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.ArrangementsSeminars;

public interface ArrangementsSeminarsService {

	public void addInstance(ArrangementsSeminars arrangementsSeminars);
	public List<ArrangementsSeminars> findArrangementsSeminarsByArrangementId(Integer arrangementsId);
	public void deleteInstance(ArrangementsSeminars arrangementsSeminars) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public ArrangementsSeminars updateInstance(ArrangementsSeminars arrangementsSeminars) throws Exception;

}
