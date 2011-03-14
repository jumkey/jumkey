package meetmanager.service;

import java.util.List;

import meetmanager.model.Limit;
import meetmanager.model.Sysaccount;
import meetmanager.utils.dao.Page;


public interface SysaccountService {
	public Sysaccount checkAccount(String account,String password);
	public Sysaccount updateAccount(Sysaccount account) throws Exception;
	public List<Sysaccount> getAllAccount();
	public void deleteAccount(Sysaccount account);
	public void addAccount(Sysaccount account);
	public void deleteSelectAccount(Integer[] selected);
	public List<Sysaccount> getPageAccount(Page page);
	public int getPageCount();
	public List<Limit> findLimitByRoleId(Integer roleid);
}
