package com.onegrid.meetmanager.web.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.onegrid.meetmanager.model.ArrangementsSeminars;
import com.onegrid.meetmanager.model.Lecture;
import com.onegrid.meetmanager.model.MeetingArrangements;
import com.onegrid.meetmanager.model.MeetingRoom;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.service.ArrangementsSeminarsService;
import com.onegrid.meetmanager.service.LectureService;
import com.onegrid.meetmanager.service.MeetingArrangementsService;
import com.onegrid.meetmanager.service.MeetingRoomService;
import com.opensymphony.xwork2.ActionSupport;

public class ArrangementsSeminarsAction extends ActionSupport {
	private ArrangementsSeminarsService arrangementsSeminarsService;
	private LectureService lectureService;
	private List<ArrangementsSeminars> list;
	private List<Lecture> lecturelist;
	private ArrangementsSeminars arrangementsSeminars;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Integer arrangementsId;
	private Integer meetingId;
	private Page page;

	public ArrangementsSeminars getArrangementsSeminars() {
		return arrangementsSeminars;
	}

	public void setArrangementsSeminars(ArrangementsSeminars arrangementsSeminars) {
		this.arrangementsSeminars = arrangementsSeminars;
	}

	@JSON(serialize = false)
	public ArrangementsSeminarsService getArrangementsSeminarsService() {
		return arrangementsSeminarsService;
	}

	public void setArrangementsSeminarsService(
			ArrangementsSeminarsService arrangementsSeminarsService) {
		this.arrangementsSeminarsService = arrangementsSeminarsService;
	}

	public List<ArrangementsSeminars> getList() {
		return list;
	}

	public void setList(List<ArrangementsSeminars> list) {
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

	public String add() {
		try {
			arrangementsSeminarsService.addInstance(arrangementsSeminars);
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
			arrangementsSeminarsService.deleteInstance(arrangementsSeminars);
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
			arrangementsSeminarsService.deleteSelectInstance(selected);
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
			arrangementsSeminarsService.updateInstance(arrangementsSeminars);
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
		list = arrangementsSeminarsService.findArrangementsSeminarsByArrangementId(arrangementsId);
		lecturelist = lectureService.findLectureByMeetingId(meetingId);
		return "listarrangementsSeminars";
	}

	public Integer getArrangementsId() {
		return arrangementsId;
	}

	public void setArrangementsId(Integer arrangementsId) {
		this.arrangementsId = arrangementsId;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public List<Lecture> getLecturelist() {
		return lecturelist;
	}

	public void setLecturelist(List<Lecture> lecturelist) {
		this.lecturelist = lecturelist;
	}

	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}



}
