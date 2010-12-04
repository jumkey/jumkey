package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Fete;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Page;
import meetmanager.model.Units;
import meetmanager.service.FeteService;
import meetmanager.service.UnitsService;

import com.opensymphony.xwork2.ActionSupport;

public class FeteAction extends ActionSupport {
	private FeteService feteService;
	private UnitsService unitsService;
	private List<Fete> list;
	private List<Units> ulist;
	private MeetingInfo meetinginfo;
	private String result;// 返回ajax 结果
	private Fete fete;
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
			feteService.deleteInstance(fete);
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
			feteService.deleteSelectInstance(selected);
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
			feteService.updateInstance(fete);
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
			feteService.addInstance(fete);
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

	public String list() {
		ulist = unitsService.getAllUnits();
		if (page == null) {
			page = new Page();
		}
		list = feteService.findPageFeteByMeetingId(page, meetinginfo.getId());
		return "listfete";
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

	public List<Fete> getList() {
		return list;
	}

	public void setList(List<Fete> list) {
		this.list = list;
	}

	public List<Units> getUlist() {
		return ulist;
	}

	public void setUnitsService(UnitsService unitsService) {
		this.unitsService = unitsService;
	}

	public Fete getFete() {
		return fete;
	}

	public void setFete(Fete fete) {
		this.fete = fete;
	}

	public void setFeteService(FeteService feteService) {
		this.feteService = feteService;
	}

}
