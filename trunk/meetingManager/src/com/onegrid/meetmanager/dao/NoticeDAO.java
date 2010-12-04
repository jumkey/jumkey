package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Notice;

public interface NoticeDAO extends GenericDAO<Notice,Integer> {

	public List<Notice> findNotice();
	
}
