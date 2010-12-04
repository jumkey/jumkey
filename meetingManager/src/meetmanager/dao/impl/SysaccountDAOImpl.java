package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.GenericDAOHibernate;
import meetmanager.dao.SysaccountDAO;
import meetmanager.model.Sysaccount;


public class SysaccountDAOImpl extends GenericDAOHibernate<Sysaccount,Integer> implements SysaccountDAO {

	@SuppressWarnings("unchecked")
	public Sysaccount findByAP(String account, String password) {
		// TODO Auto-generated method stub
		List<Sysaccount> list=findByNamedParam("from Sysaccount where account=:account and password=:password",new String[]{"account","password"},new Object[]{account, password});
		Sysaccount sysaccount=null;
		if(list!=null&&list.size()!=0){
			sysaccount=list.get(0);
		}
		return sysaccount;
	}
}
