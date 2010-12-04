package meetmanager.web.action;

import java.util.List;

import meetmanager.model.FeeItem;
import meetmanager.model.MeetingFeeItem;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Page;
import meetmanager.model.Units;
import meetmanager.service.MeetingFeeItemService;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingFeeItemAction extends ActionSupport{
	private MeetingFeeItemService meetingFeeItemService;
	private MeetingFeeItem meetingfeeitem;
	private List<FeeItem> list;
	private MeetingInfo meetinginfo;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Page page;
	
	@JSON(serialize = false)
	public MeetingFeeItemService getMeetingFeeItemService() {
		return meetingFeeItemService;
	}

	public void setMeetingFeeItemService(MeetingFeeItemService meetingFeeItemService) {
		this.meetingFeeItemService = meetingFeeItemService;
	}

	public List<FeeItem> getList() {
		return list;
	}

	public void setList(List<FeeItem> list) {
		this.list = list;
	}

	public MeetingFeeItem getMeetingfeeitem() {
		return meetingfeeitem;
	}

	public void setMeetingfeeitem(MeetingFeeItem meetingfeeitem) {
		this.meetingfeeitem = meetingfeeitem;
	}

	public MeetingInfo getMeetinginfo() {
		return meetinginfo;
	}

	public void setMeetinginfo(MeetingInfo meetinginfo) {
		this.meetinginfo = meetinginfo;
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
			meetingFeeItemService.addInstance(meetingfeeitem);
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
		//要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			meetingFeeItemService.deleteInstance(meetingfeeitem);
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
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			meetingFeeItemService.deleteSelectInstance(selected);
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
			// System.out.println(sysaccount.getDepartment().getId());
			meetingfeeitem = meetingFeeItemService.updateInstance(meetingfeeitem);
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

	public String list(){
		meetinginfo=meetingFeeItemService.getMeetingInfo(meetinginfo.getId());
		list=meetingFeeItemService.getAllFeeItem();
		return "listmeetingfeeitem";
	}

//	public String list(){
//		list=meetingFeeItemService.getAllMeetingFeeItem();
//		return "listmeetingfeeitem";
//	}
}
