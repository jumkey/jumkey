package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Sysaccount;

public interface SysaccountService {
	public Sysaccount checkAccount(String account,String password);
	public Sysaccount updateAccount(Sysaccount account) throws Exception;
	public List<Sysaccount> getAllAccount();
}
