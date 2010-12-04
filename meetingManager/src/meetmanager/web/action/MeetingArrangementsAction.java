package meetmanager.web.action;

import java.util.List;

import meetmanager.model.MeetingArrangements;
import meetmanager.model.MeetingRoom;
import meetmanager.model.Page;
import meetmanager.model.Units;
import meetmanager.service.MeetingArrangementsService;
import meetmanager.service.MeetingRoomService;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingArrangementsAction extends ActionSupport {
	private MeetingArrangementsService meetingArrangementsService;
	private MeetingRoomService meetingRoomService;
	private List<MeetingArrangements> list;
	private List<MeetingRoom> meetingroomlist;
	private MeetingArrangements meetingArrangements;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Integer meetingId;
	private Page page;

	public MeetingArrangements getMeetingArrangements() {
		return meetingArrangements;
	}

	public void setMeetingArrangements(MeetingArrangements meetingArrangements) {
		this.meetingArrangements = meetingArrangements;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	@JSON(serialize = false)
	public MeetingArrangementsService getMeetingArrangementsService() {
		return meetingArrangementsService;
	}

	public void setMeetingArrangementsService(
			MeetingArrangementsService meetingArrangementsService) {
		this.meetingArrangementsService = meetingArrangementsService;
	}

	public List<MeetingArrangements> getList() {
		return list;
	}

	public void setList(List<MeetingArrangements> list) {
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
			meetingArrangementsService.addInstance(meetingArrangements);
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
			meetingArrangementsService.deleteInstance(meetingArrangements);
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
			meetingArrangementsService.deleteSelectInstance(selected);
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
			meetingArrangementsService.updateInstance(meetingArrangements);
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
		meetingroomlist = meetingRoomService.findFetesByMeetingId(meetingId);
		list = meetingArrangementsService.findMeetingArrangementsByMeetingId(meetingId);
		return "listmeetingarrangements";
	}

	public List<MeetingRoom> getMeetingroomlist() {
		return meetingroomlist;
	}

	public void setMeetingroomlist(List<MeetingRoom> meetingroomlist) {
		this.meetingroomlist = meetingroomlist;
	}

	public void setMeetingRoomService(MeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}

}
