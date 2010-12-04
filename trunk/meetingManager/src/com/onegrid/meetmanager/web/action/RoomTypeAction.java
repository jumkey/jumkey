package com.onegrid.meetmanager.web.action;

import java.util.Date;
import java.util.List;

import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.RoomType;
import com.onegrid.meetmanager.model.Sysaccount;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.service.RoomTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoomTypeAction extends ActionSupport {
	private RoomTypeService roomTypeService;
	private List<RoomType> list;
	private RoomType roomtype;
	private String result;// 返回ajax 结果
	private Integer[] selected;// 选择项
	private Page page;
	private List<RoomType> plist;

	public void setRoomTypeService(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	@SuppressWarnings("deprecation")
	public String add() {
		try {
			Sysaccount sysa = (Sysaccount) ActionContext.getContext()
					.getSession().get("account");
			Sysaccount sysa1 = new Sysaccount();
			sysa1.setId(sysa.getId());
			roomtype.setSysaccount(sysa1);
			roomtype.setCreatetime(new Date());
			roomTypeService.addInstance(roomtype);
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

	public String delete() {
		try {
			roomTypeService.deleteInstance(roomtype);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"删除成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"删除失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public String delselect() {
		// 要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			roomTypeService.deleteSelectInstance(selected);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"批量删除成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"批量删除失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String modify() {
		try {
			roomTypeService.updateInstance(roomtype);
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
		list = roomTypeService.getPageRoomType(page);
		return "listroomtype";
	}

	public RoomType getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}

	public List<RoomType> getList() {
		return list;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Page getPage() {
		return page;
	}

	public String getResult() {
		return result;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

}
