package com.onegrid.meetmanager.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.onegrid.meetmanager.dao.SysaccountDAO;
import com.onegrid.meetmanager.model.Sysaccount;

public class SysaccountDAOImpl extends HibernateDaoSupport implements SysaccountDAO {

	public Sysaccount findByAP(String account, String password) {
		// TODO Auto-generated method stub
		List<Sysaccount> list=this.getHibernateTemplate().find("from Sysaccount where account='"+account+"' and password='"+password+"'");
		Sysaccount sysaccount=null;
		if(list!=null&&list.size()!=0){
			sysaccount=list.get(0);
		}
		return sysaccount;
	}

	public void update(Sysaccount account) throws Exception {
		this.getHibernateTemplate().update(account);
	}

	public Sysaccount findById(int id) {
		return (Sysaccount) this.getHibernateTemplate().get(Sysaccount.class, id);
	}

	public List<Sysaccount> findAllAccount() {
		return this.getHibernateTemplate().find("from Sysaccount");
	}


}
