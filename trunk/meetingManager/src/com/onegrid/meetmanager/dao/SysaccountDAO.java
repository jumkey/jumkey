package com.onegrid.meetmanager.dao;

import com.onegrid.meetmanager.model.Sysaccount;

public interface SysaccountDAO extends GenericDAO<Sysaccount,Integer> {
	public Sysaccount findByAP(String account,String password);
}