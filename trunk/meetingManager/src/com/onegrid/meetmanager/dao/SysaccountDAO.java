package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.Sysaccount;

public interface SysaccountDAO {
	public Sysaccount findByAP(String account,String password);
	public void update(Sysaccount account) throws Exception;
	public Sysaccount findById(int id);
	public List<Sysaccount> findAllAccount();
}