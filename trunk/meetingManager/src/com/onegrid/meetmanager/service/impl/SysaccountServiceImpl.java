package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.SysaccountDAO;
import com.onegrid.meetmanager.model.Sysaccount;
import com.onegrid.meetmanager.service.SysaccountService;

public class SysaccountServiceImpl implements SysaccountService {
	private SysaccountDAO sysaccountDAO;

	public SysaccountDAO getSysaccountDAO() {
		return sysaccountDAO;
	}

	public void setSysaccountDAO(SysaccountDAO sysaccountDAO) {
		this.sysaccountDAO = sysaccountDAO;
	}

	public Sysaccount checkAccount(String account, String password) {
		// TODO Auto-generated method stub
		return sysaccountDAO.findByAP(account, password);
	}

	public Sysaccount updateAccount(Sysaccount account) throws Exception {
		Sysaccount sysa=sysaccountDAO.findById(account.getId());
		//PropertyUtils.copyProperties
		//BeanUtils.copyProperties
		sysa.setPassword(account.getPassword());
		sysa.setAddress(account.getAddress());
		sysa.setPhone(account.getPhone());
		sysa.setSex(account.getSex());
		sysa.setUsername(account.getUsername());
		sysa.setZip(account.getZip());
		return sysa;
	}

	public List<Sysaccount> getAllAccount() {
		return sysaccountDAO.findAllAccount();
	}
}
