package com.onegrid.meetmanager.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.onegrid.meetmanager.model.Lecture;
import com.onegrid.meetmanager.model.MeetingRoom;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.model.User;
import com.onegrid.meetmanager.service.LectureService;
import com.onegrid.meetmanager.service.MeetingRoomService;
import com.onegrid.meetmanager.service.UnitsService;
import com.onegrid.meetmanager.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LectureAction extends ActionSupport {
	private UserService userService;
	private LectureService lectureService;
	private UnitsService unitsService;
	private List<Units> unitslist;
	private List<Lecture> list;
	private List<User> userlist;
	private Lecture lecture;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Integer meetingId;
	private Page page;
	private Integer unitsId;
	private String[][] alluser;

	@JSON(serialize = false)
	public LectureService getLectureService() {
		return lectureService;
	}

	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	@JSON(serialize = false)
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Lecture> getList() {
		return list;
	}

	public void setList(List<Lecture> list) {
		this.list = list;
	}
	@JSON(serialize = false)
	public UnitsService getUnitsService() {
		return unitsService;
	}
	public void setUnitsService(UnitsService unitsService) {
		this.unitsService = unitsService;
	}

	public List<Units> getUnitslist() {
		return unitslist;
	}

	public void setUnitslist(List<Units> unitslist) {
		this.unitslist = unitslist;
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

	public String add() {
		try {
			lectureService.addInstance(lecture);
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
		// 要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			lectureService.deleteInstance(lecture);
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

	public String delselect() {
		// 要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			lectureService.deleteSelectInstance(selected);
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
		// 要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			System.out.println(lecture.getAgreement()+"------------------");
			lectureService.updateInstance(lecture);
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
		unitslist = unitsService.getAllUnits();
		list = lectureService.findLectureByMeetingId(meetingId);
		return "listlecture";
	}
	public String userlist() {
		try {
			userlist = userService.findUserByUnits(unitsId);
			alluser = new String[userlist.size()][2];
			for(int i=0;i<userlist.size();i++){
				User user = userlist.get(i);
				alluser[i][0]=user.getName();
				alluser[i][1]=user.getId().toString();
			}
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"操作成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"操作失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public Integer getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(Integer unitsId) {
		this.unitsId = unitsId;
	}

	public String[][] getAlluser() {
		return alluser;
	}

	public void setAlluser(String[][] alluser) {
		this.alluser = alluser;
	}
}
