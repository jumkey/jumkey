package meetmanager.web.action;

import java.util.List;

import meetmanager.model.MeetingRoom;
import meetmanager.model.Page;
import meetmanager.model.Units;
import meetmanager.service.MeetingRoomService;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingRoomAction extends ActionSupport {
	private MeetingRoomService meetingRoomService;
	private List<MeetingRoom> list;
	private MeetingRoom meetingRoom;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Integer meetingId;
	private Page page;

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	@JSON(serialize = false)
	public MeetingRoomService getMeetingRoomService() {
		return meetingRoomService;
	}

	public void setMeetingRoomService(MeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}

	public List<MeetingRoom> getList() {
		return list;
	}

	public void setList(List<MeetingRoom> list) {
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
			meetingRoomService.addInstance(meetingRoom);
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
			meetingRoomService.deleteInstance(meetingRoom);
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
			meetingRoomService.deleteSelectInstance(selected);
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
			meetingRoomService.updateInstance(meetingRoom);
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
		list = meetingRoomService.findFetesByMeetingId(meetingId);
		return "listmeetingroom";
	}

}
