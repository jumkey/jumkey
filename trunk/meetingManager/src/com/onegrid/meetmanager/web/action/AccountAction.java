package com.onegrid.meetmanager.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.onegrid.meetmanager.model.Sysaccount;
import com.onegrid.meetmanager.service.SysaccountService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	private SysaccountService sysaccountservice;
	private Sysaccount sysaccount;
	private List<Sysaccount> list;

	public List<Sysaccount> getList() {
		return list;
	}

	public void setList(List<Sysaccount> list) {
		this.list = list;
	}
	@JSON(serialize=false)
	public SysaccountService getSysaccountservice() {
		return sysaccountservice;
	}

	public void setSysaccountservice(SysaccountService sysaccountservice) {
		this.sysaccountservice = sysaccountservice;
	}

	public Sysaccount getSysaccount() {
		return sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public String edit(){
		return "editpage";
	}
	public String doedit(){
		try {
			//更新session
			ActionContext.getContext().getSession().put("account", sysaccountservice.updateAccount(sysaccount));
			//添加成功信息
			this.addActionMessage("修改成功！");
		} catch (Exception e) {
			//添加失败信息
			this.addActionMessage("修改失败！");
			e.printStackTrace();
		}
		return "editpage";
	}
	public String modify(){
		try {
			//更新session
			ActionContext.getContext().getSession().put("account", sysaccountservice.updateAccount(sysaccount));
			//添加成功信息
		} catch (Exception e) {
			//添加失败信息
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String list(){
		list=sysaccountservice.getAllAccount();
		return "listaccount";
	}
}
