package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Limit;
import com.onegrid.meetmanager.model.Page;

public interface LimitService {
	public List<Limit> getPageUser(Page page);

	public void addInstance(Limit limit);

	public Limit updateInstance(Limit limit);

	public void deleteInstance(Limit limit);

	public void deleteSelectInstance(Integer[] selected);
	
	public List<Limit> getAllLimit();
}
