package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Awards;
import meetmanager.model.MeetingArrangements;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Units;
import meetmanager.service.AwardsService;
import meetmanager.service.MeetingArrangementsService;

import com.opensymphony.xwork2.ActionSupport;

public class AwardsAction extends ActionSupport {
	private AwardsService awardsService;
	private MeetingArrangementsService meetingArrangementsService;
	private List<Awards> list;
	private List<MeetingArrangements> meetingArrangementslist;
	private MeetingInfo meetinginfo;
	private String result;// 返回ajax 结果
	private Awards awards;
	private Integer[] selected;// 选择项
	private List<Units> units;
	private Integer meetingId;

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public List<Units> getUnits() {
		return units;
	}

	public void setUnitss(List<Units> units) {
		this.units = units;
	}

	public MeetingInfo getMeetinginfo() {
		return meetinginfo;
	}

	public void setMeetinginfo(MeetingInfo meetinginfo) {
		this.meetinginfo = meetinginfo;
	}

	public String delete() {
		// 要判断是不是次单位或个人创建
		try {
			awardsService.deleteInstance(awards);
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
			awardsService.deleteSelectInstance(selected);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"批量删除成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"批量删除失败"
					+ selected.length + e.getMessage() + "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String modify() {
		// 要判断是不是次单位或个人创建
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			awardsService.updateInstance(awards);
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
			awardsService.addInstance(awards);
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
		units = awardsService.findAllUnits();
		meetingArrangementslist = meetingArrangementsService.findMeetingArrangementsByMeetingId(meetinginfo.getId());
		meetinginfo = awardsService.findMeetingInfoById(meetinginfo.getId());
		list = awardsService.findAwardsByMeetingId(meetinginfo.getId());
		return "listawards";
	}

	public String lotterylist() {
		awards = awardsService.findAwardsById(awards.getId());
		return "listlottery";
	}

	public String choujiang() {
		try {
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"抽奖成功"
					+"\",\"zhongjiang\":\""
					+  awardsService.dochoujiang(meetingId, selected) +"\"}";

		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"抽奖失败" + e.getMessage()
					+ "\"}";
			// e.printStackTrace();
		}
		return SUCCESS;
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

	public List<Awards> getList() {
		return list;
	}

	public void setList(List<Awards> list) {
		this.list = list;
	}

	public Awards getAwards() {
		return awards;
	}

	public void setAwards(Awards awards) {
		this.awards = awards;
	}

	public void setAwardsService(AwardsService awardsService) {
		this.awardsService = awardsService;
	}

	public List<MeetingArrangements> getMeetingArrangementslist() {
		return meetingArrangementslist;
	}

	public void setMeetingArrangementslist(
			List<MeetingArrangements> meetingArrangementslist) {
		this.meetingArrangementslist = meetingArrangementslist;
	}

	public void setMeetingArrangementsService(
			MeetingArrangementsService meetingArrangementsService) {
		this.meetingArrangementsService = meetingArrangementsService;
	}

	public void setUnits(List<Units> units) {
		this.units = units;
	}
}
