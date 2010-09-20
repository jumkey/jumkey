package com.onegrid.meetmanager.dao.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.GenericDAOHibernate;
import com.onegrid.meetmanager.dao.SysaccountDAO;
import com.onegrid.meetmanager.model.Sysaccount;

public class SysaccountDAOImpl extends GenericDAOHibernate<Sysaccount,Integer> implements SysaccountDAO {

	@SuppressWarnings("unchecked")
	public Sysaccount findByAP(String account, String password) {
		// TODO Auto-generated method stub
		List<Sysaccount> list=this.getHibernateTemplate().find("from Sysaccount where account='"+account+"' and password='"+password+"'");
		Sysaccount sysaccount=null;
		if(list!=null&&list.size()!=0){
			sysaccount=list.get(0);
		}
		return sysaccount;
	}
}
