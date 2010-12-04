package com.onegrid.meetmanager.web.action;

import java.util.List;

import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.model.User;
import com.onegrid.meetmanager.service.UnitsService;
import com.onegrid.meetmanager.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService userService;
	private UnitsService unitsService;
	private List<Units> unitslist;
	private List<User> list;
	private User user;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Page page;
	private Integer unitsId = 0;
	private String name = "";

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String add() {
		try {
			userService.addInstance(user);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"添加成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"添加失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// public String delete() {
	// try {
	// userService.deleteInstance(user);
	// // 添加成功信息
	// result = "{\"success\":\"true\",\"msg\":\"删除成功\"}";
	// } catch (Exception e) {
	// // 添加失败信息
	// result = "{\"success\":\"false\",\"msg\":\"删除失败" + e.getMessage()
	// + "\"}";
	// e.printStackTrace();
	// }
	// return SUCCESS;
	// }
	//
	// public String delselect() {
	// try {
	// userService.deleteSelectInstance(selected);
	// // 添加成功信息
	// result = "{\"success\":\"true\",\"msg\":\"批量删除成功\"}";
	// } catch (Exception e) {
	// // 添加失败信息
	// result = "{\"success\":\"false\",\"msg\":\"批量删除失败" + e.getMessage()
	// + "\"}";
	// e.printStackTrace();
	// }
	// return SUCCESS;
	// }

	public String modify() {
		try {
			userService.updateInstance(user);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"修改成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"修改失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String list() {
		if (page == null) {
			page = new Page();
		}
		list = userService.findUserForSeach(page, unitsId, name);
		unitslist = unitsService.getAllUnits();
		return "listuser";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnitsService(UnitsService unitsService) {
		this.unitsService = unitsService;
	}

	public Integer getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(Integer unitsId) {
		this.unitsId = unitsId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Units> getUnitslist() {
		return unitslist;
	}
	
}
