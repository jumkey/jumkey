package com.onegrid.meetmanager.web.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.onegrid.meetmanager.model.Income;
import com.onegrid.meetmanager.model.MeetingFeeItem;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.service.IncomeService;
import com.opensymphony.xwork2.ActionSupport;

public class IncomeAction extends ActionSupport {
	private IncomeService incomeService;
	private List<Income> list;
	private MeetingFeeItem meetingFeeItem;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Page page;

	@JSON(serialize = false)
	public IncomeService getIncomeService() {
		return incomeService;
	}

	public void setIncomeService(IncomeService incomeService) {
		this.incomeService = incomeService;
	}

	public MeetingFeeItem getMeetingFeeItem() {
		return meetingFeeItem;
	}

	public void setMeetingFeeItem(MeetingFeeItem meetingFeeItem) {
		this.meetingFeeItem = meetingFeeItem;
	}

	public List<Income> getList() {
		return list;
	}

	public void setList(List<Income> list) {
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

	public String list() {
		list = incomeService.getAllIncomeByMeetingFeeItem(meetingFeeItem);
		return "listincome";
	}
}
