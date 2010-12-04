package meetmanager.dao;

import meetmanager.model.Sysaccount;

public interface SysaccountDAO extends GenericDAO<Sysaccount,Integer> {
	public Sysaccount findByAP(String account,String password);
}