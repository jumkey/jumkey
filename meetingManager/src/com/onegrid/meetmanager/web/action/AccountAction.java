package com.onegrid.meetmanager.web.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.onegrid.meetmanager.model.Sysaccount;
import com.onegrid.meetmanager.service.SysaccountService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	private SysaccountService sysaccountservice;
	private Sysaccount sysaccount;
	private List<Sysaccount> list;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

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
			sysaccount=sysaccountservice.updateAccount(sysaccount);
			ActionContext.getContext().getSession().put("account", sysaccount);
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
			sysaccount=sysaccountservice.updateAccount(sysaccount);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"修改成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"修改失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String delete(){
		try {
			sysaccountservice.delete(sysaccount);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"删除成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"删除失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String list(){
		list=sysaccountservice.getAllAccount();
		return "listaccount";
	}
}
