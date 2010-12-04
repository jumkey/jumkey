package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Limit;
import meetmanager.model.Role;
import meetmanager.model.Sysaccount;
import meetmanager.service.SysaccountService;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private SysaccountService sysaccountService;
	private String account;
	private String password;
	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SysaccountService getSysaccountService() {
		return sysaccountService;
	}

	public void setSysaccountService(SysaccountService sysaccountService) {
		this.sysaccountService = sysaccountService;
	}
	
	public String login(){
		Sysaccount sysaccount = sysaccountService.checkAccount(account, password);
		if(sysaccount!=null){
	        Role role=sysaccount.getRole();
	        List<Limit> llist=sysaccountService.findLimitByRoleId(role.getId());
	        
			//添加session
			ActionContext.getContext().getSession().put("account", sysaccount);
			ActionContext.getContext().getSession().put("llist", llist);
			return "success";
		}
		return "login";
	}
	public String logout(){
		Sysaccount sysaccount = (Sysaccount) ActionContext.getContext().getSession().get("account");
		if(sysaccount!=null){
			//删除session
			ActionContext.getContext().getSession().put("account", null);
		}
		return "login";
	}

}
