package com.onegrid.meetmanager.web.action;

import java.util.List;

import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.User;
import com.onegrid.meetmanager.service.UserService;

public class UserAction {
	private UserService userservice;
	private List<User> list;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Page page;

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String list(){
		if(page==null){
			page=new Page();
		}
		//dlist=departmentservice.getAllDepartment();
		list=userservice.getPageUser(page);
		return "listuser";
	}
}
