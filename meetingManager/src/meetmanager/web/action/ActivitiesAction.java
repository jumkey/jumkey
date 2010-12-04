package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Activities;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Page;
import meetmanager.service.ActivitiesService;

import com.opensymphony.xwork2.ActionSupport;

public class ActivitiesAction extends ActionSupport {
	private ActivitiesService activitiesService;
	private List<Activities> list;
	private String result;// 返回ajax 结果
	private Activities activities;
	private MeetingInfo meetinginfo;
	private Integer[] selected;// 选择项
	private Page page;

	public MeetingInfo getMeetinginfo() {
		return meetinginfo;
	}

	public void setMeetinginfo(MeetingInfo meetinginfo) {
		this.meetinginfo = meetinginfo;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String delete() {
		// 要判断是不是次单位或个人创建
		try {
			activitiesService.deleteInstance(activities);
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
		try {
			activitiesService.deleteSelectInstance(selected);
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
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			activitiesService.updateInstance(activities);
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
	
	public String add() {
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			activitiesService.addInstance(activities);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"添加成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"添加失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		System.out.println(result);
		return SUCCESS;
	}

	public String list() {
		if (page == null) {
			page = new Page();
		}
		list = activitiesService.findPageActivitiesByMeetingId(page,
				meetinginfo.getId());
		return "listactivities";
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

	public List<Activities> getList() {
		return list;
	}

	public void setList(List<Activities> list) {
		this.list = list;
	}

	public Activities getActivities() {
		return activities;
	}

	public void setActivities(Activities activities) {
		this.activities = activities;
	}

	public void setActivitiesService(ActivitiesService activitiesService) {
		this.activitiesService = activitiesService;
	}

}
