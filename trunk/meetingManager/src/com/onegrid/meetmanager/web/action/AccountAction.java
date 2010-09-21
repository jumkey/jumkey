package com.onegrid.meetmanager.web.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.Sysaccount;
import com.onegrid.meetmanager.service.SysaccountService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	private SysaccountService sysaccountservice;
	private Sysaccount sysaccount;
	private List<Sysaccount> list;
	private String result;//返回ajax 结果
	private Integer[] selected;//选择项
	
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

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
			sysaccountservice.deleteAccount(sysaccount);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"删除成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"删除失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String add(){
		try {
			sysaccountservice.addAccount(sysaccount);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"添加成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"添加失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String list(){
		list=sysaccountservice.getPageAccount(page);
		return "listaccount";
	}
	public String delselect(){
		try {
			sysaccountservice.deleteSelectAccount(selected);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"批量删除成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"批量删除失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
