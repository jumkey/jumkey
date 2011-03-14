package meetmanager.dao;

import meetmanager.model.Sysaccount;
import meetmanager.utils.dao.GenericDAO;

public interface SysaccountDAO extends GenericDAO<Sysaccount,Integer> {
	public Sysaccount findByAP(String account,String password);
}