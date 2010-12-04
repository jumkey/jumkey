package com.onegrid.meetmanager.dao.impl;

import java.util.Date;
import java.util.List;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.NoticeDAO;
import com.onegrid.meetmanager.model.Notice;

public class NoticeDAOImpl extends GenericDAOHibernate<Notice,Integer> implements NoticeDAO {

	public List<Notice> findNotice() {
		// TODO Auto-generated method stub
		return find("from Notice where date>"+new Date().getTime());
	}

}
