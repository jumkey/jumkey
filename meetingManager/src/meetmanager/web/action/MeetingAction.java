package meetmanager.web.action;

import java.util.List;

import meetmanager.model.MeetingInfo;
import meetmanager.model.Register;
import meetmanager.service.MeetingService;
import meetmanager.service.PriceService;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingAction extends ActionSupport {
	private MeetingService meetingService;
	private List<MeetingInfo> list;
	private List<Register> rlist;
	private String result;// 返回ajax 结果
	private MeetingInfo meetinginfo;
	private Integer[] selected;// 选择项


	public List<Register> getRlist() {
		return rlist;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public MeetingInfo getMeetinginfo() {
		return meetinginfo;
	}

	public void setMeetinginfo(MeetingInfo meetinginfo) {
		this.meetinginfo = meetinginfo;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

	public List<MeetingInfo> getList() {
		return list;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public void setPriceService(PriceService priceService) {
	}
	
	public String delete() {
		//要判断是不是次单位或个人创建
		try {
			meetingService.deleteInstance(meetinginfo);
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
		//要判断是不是次单位或个人创建
		try {
			meetingService.deleteSelectInstance(selected);
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
		//要判断是不是次单位或个人创建
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			meetingService.updateInstance(meetinginfo);
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
		list = meetingService.findByMeetings();
		return "listmeeting";
	}
	
	public String single(){
		meetinginfo=meetingService.getMeetingInfo(meetinginfo.getId());
		rlist=meetingService.getRegisterByMeetingInfo(meetinginfo);
		return "single";
	}

}
