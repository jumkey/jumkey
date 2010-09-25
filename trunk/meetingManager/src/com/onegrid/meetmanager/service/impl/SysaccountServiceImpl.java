package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.SysaccountDAO;
import com.onegrid.meetmanager.model.Page;
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
		Sysaccount sysa=sysaccountDAO.get(account.getId());
		//PropertyUtils.copyProperties
		//BeanUtils.copyProperties(sysa, account);
		if(account.getPassword()!=null){//null没有修改密码
			sysa.setPassword(account.getPassword());
		}
		sysa.setAddress(account.getAddress());
		sysa.setPhone(account.getPhone());
		sysa.setSex(account.getSex());
		sysa.setUsername(account.getUsername());
		sysa.setZip(account.getZip());
		//部门暂时不能修改
		//if(account.getPassword()!=null){//null没有修改部门
		//	sysa.setDepartment(department);
		//}
		return sysa;
	}

	public List<Sysaccount> getAllAccount() {
		return sysaccountDAO.findAll();
	}

	public void deleteAccount(Sysaccount account) {
		account=sysaccountDAO.get(account.getId());
		sysaccountDAO.delete(account);
	}
	public void addAccount(Sysaccount account) {
		sysaccountDAO.save(account);
	}

	public void deleteSelectAccount(Integer[] selected) {
		for(int id:selected){
			sysaccountDAO.delete(sysaccountDAO.get(id));
		}
	}

	public List<Sysaccount> getPageAccount(Page page) {
		page.setTotalNum(sysaccountDAO.getCountByQuery("from Sysaccount"));
		return sysaccountDAO.findByPagination("from Sysaccount", page);
	}

	public int getPageCount() {
		//sysaccountDAO.find
		return 0;
	}
}
