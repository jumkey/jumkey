package com.onegrid.meetmanager.service;

import java.util.List;
import com.onegrid.meetmanager.model.Fete;
import com.onegrid.meetmanager.model.Page;


public interface FeteService {
	public List<Fete> findPageFeteByMeetingId(Page page,Integer id);
	public void addInstance(Fete fete);
	public List<Fete> findFetesByMeetingId(Integer meetinfid);
	public void deleteInstance(Fete meetinginfo) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public Fete updateInstance(Fete fete) throws Exception;

}
